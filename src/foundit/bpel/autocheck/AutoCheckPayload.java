package foundit.bpel.autocheck;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.util.Date;
import java.text.DateFormat;

import org.apache.axis.client.Call;
import org.apache.tomcat.jni.User;

import java.lang.Integer;

import javax.xml.rpc.ParameterMode;

import org.junit.Test;
import org.w3c.dom.NodeList;

public class AutoCheckPayload {

	/**
	 * 消息的传递和处理（PAYLOAD）
	 * 通过负载来传递
	 */
	@Test
	public String AutoCheckPayload(String driverLicence,String addr,String fullName) {
		
		String result="";
		
		try {
			//1.创建服务(Service)
//			String endpoint = "http://localhost:6060/ode/processes/BPEL_FoundIT/services/autocheck";
			
			String endpoint = "http://localhost:6060/ode/processes/BPEL_FoundIT/services/AutoCheckProcess?wsdl";
			String namespace = "http://autocheck.bpel.foundit";
			String methodName="BPEL_FoundIT/services/AutoCheckProcess";
			String servicePort = "AutoCheckProcess";
//			String soapActionURI = "http://autocheck.bpel.foundit/";
			
//			String endpoint = "http://localhost:8080/FoundIT_BPEL/services/DlCheck?wsdl";
//			String namespace = "http://dlcheck.bpel.foundit";
//			String methodName="DlCheckService";
//			String servicePort = "DlCheck";
//			String soapActionURI = "http://localhost:8080/FoundIT_BPEL/services/DlCheck";
			
			URL url = new URL(endpoint);
			QName sName = new QName(namespace, methodName);
			Service service = Service.create(url, sName);
			
			//2.创建Dispatch(通过源数据的方式传递)
			Dispatch<Source> dispatch = service.createDispatch(new QName(namespace, servicePort),
					Source.class, Service.Mode.PAYLOAD);
			
			//3.根据用户对象创建相应的xml
			driverLicence = "123";
			addr = "";
			fullName = "albert";
			
			System.out.println("driverLicence is "+ driverLicence);
			System.out.println("addr is "+ addr);
			System.out.println("fullName is "+ fullName);
			
			AutoCheck AutoCheckProcessRequest = new AutoCheck(driverLicence,addr,fullName);
			JAXBContext ctx = JAXBContext.newInstance(AutoCheck.class);
			Marshaller mar = ctx.createMarshaller();
			//是否省略xml头信息（<?xml version="1.0" encoding="UTF-8" standalone="yes"?>）
			mar.setProperty(Marshaller.JAXB_FRAGMENT, true);
			StringWriter writer = new StringWriter();
			mar.marshal(AutoCheckProcessRequest, writer);
			System.out.println(writer);
			/*
			 * 上面操作为把用户对象转换为xml（marshal），打印结果为：
			 * <user>
			 * 	<id>3</id>
			 * 	<nickName>张三</nickName>
			 * 	<password>111111</password>
			 * 	<userName>zs</userName>
			 * </user>
			 * 
			 * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:aut="http://autocheck.bpel.foundit">
				   <soapenv:Header/>
				   <soapenv:Body>
				      <aut:AutoCheckProcessRequest>
				         <aut:driverLicence>123</aut:driverLicence>
				         <aut:addr></aut:addr>
				         <aut:fullName>albert</aut:fullName>
				      </aut:AutoCheckProcessRequest>
				   </soapenv:Body>
				</soapenv:Envelope>

			 */
			
			//4.封装相应的part addUser
			String payLoad = "<aut:AutoCheckProcessRequest xmlns:aut=\"" + namespace + "\">" + writer.toString() + "</aut:AutoCheckProcessRequest>";
			System.out.println("PayLoad is: " + payLoad);
			/*
			 * 上面步骤3、4为封装相应的part
			 * 打印结果为：
			 * <nn:addUser xmlns:nn="http://service.soap.org/">
			 * 	<user>
			 * 		<id>3</id>
			 * 		<nickName>张三</nickName>
			 * 		<password>111111</password>
			 * 		<userName>zs</userName>
			 * 	</user>
			 * </nn:addUser>
			 */
			
			//5.通过dispatch传递payLoad
			StreamSource ss = new StreamSource(new StringReader(payLoad));
			System.out.println("Test to here 0.");	
			Source response = (Source)dispatch.invoke(ss);
			
			System.out.println("Test to here 1.");			
			
			
			//6.将Source转换为DOM进行操作，使用Transformer对象转换
			Transformer tran = TransformerFactory.newInstance().newTransformer();
			DOMResult res = new DOMResult();
			tran.transform(response, res);
			System.out.println("Test to here 2.");			
			//7.处理响应信息(通过xpath处理)
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nl = (NodeList)xPath.evaluate("//result", res.getNode(), XPathConstants.NODESET);
			System.out.println(nl.item(0).getNodeName());	//打印节点名称
			/*
			 * 打印结果为：user
			 */
			
			//反编排
			AutoCheck ru = (AutoCheck)ctx.createUnmarshaller().unmarshal(nl.item(0));
			System.out.println(ru.getFullName());
			/*
			 * 上面步骤6、7为处理返回的消息，将Source转换为DOM，然后通过XPath处理xml，最后unmarshal为java信息
			 * 打印结果为：张三
			 */
			result = nl.item(0).getNodeName();

			
			System.out.println("driverLicence is "+ driverLicence);
			System.out.println("addr is "+ addr);
			System.out.println("fullName is "+ fullName);
			System.out.println("The result is:" + result);
			
			return result;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}