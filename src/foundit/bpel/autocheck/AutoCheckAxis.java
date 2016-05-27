package foundit.bpel.autocheck;

import java.util.Date;

import java.text.DateFormat;

import org.apache.axis.client.Call;

import org.apache.axis.client.Service;

import javax.xml.namespace.QName;

import java.lang.Integer;

import javax.xml.rpc.ParameterMode;


public class AutoCheckAxis {



public static String AutoCheckAxis(String driverLicence,String addr,String fullName) {
	
//		String result="";

		try {
		

//			String endpoint = "http://localhost:6060/ode/processes/BPEL_FoundIT/services/autocheck";
			
			String endpoint = "http://localhost:6060/ode/processes/BPEL_FoundIT/services/AutoCheckProcess?wsdl";
			String namespace = "http://autocheck.bpel.foundit";
			String methodName="AutoCheckProcessRequest";
			String soapActionURI = "http://autocheck.bpel.foundit/AutoCheckProcessRequest";
			
			
//			String endpoint = "http://localhost:8080/FoundIT_BPEL/services/DlCheck?wsdl";
//			String namespace = "http://dlcheck.bpel.foundit";
//			String methodName="dl";
//			String soapActionURI = "http://dlcheck.bpel.foundit/dl";
			
			
			Service service = new Service();
			
			Call call = (Call) service.createCall();
			
//			call.setTargetEndpointAddress(endpoint);
//			call.setOperationName("autoCheck");
			call.setTargetEndpointAddress(new java.net.URL(endpoint));
//			call.setOperationName("autoCheck");
			call.setOperationName(new QName(namespace,methodName));
			
			System.out.println("The first step in here before the initializing the properly.");
//			call.addParameter("driverLicence", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
//			call.addParameter("fullName", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
//			call.addParameter("addr", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			System.out.println("The second step in here after the initializing the properly.");
			
			
			call.addParameter(new QName(namespace,"driverLicence"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			call.addParameter(new QName(namespace,"addr"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
			call.addParameter(new QName(namespace,"fullName"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);


//			call.addParameter(new QName(namespace,"driverLicence"), org.apache.axis.encoding.XMLType.SOAP_STRING,javax.xml.rpc.ParameterMode.IN);
//			call.addParameter(new QName(namespace,"addr"), org.apache.axis.encoding.XMLType.SOAP_STRING,javax.xml.rpc.ParameterMode.IN);
//			call.addParameter(new QName(namespace,"fullName"), org.apache.axis.encoding.XMLType.SOAP_STRING,javax.xml.rpc.ParameterMode.IN);


			
//			call.addParameter(new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "driverLicence"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), javax.xml.rpc.ParameterMode.IN);
//			call.addParameter(new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "addr"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), javax.xml.rpc.ParameterMode.IN);
//			call.addParameter(new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "fullName"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), javax.xml.rpc.ParameterMode.IN);
			
//			call.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
			
			call.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
			call.setReturnClass(java.lang.String.class);
			call.setReturnQName(new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "result"));
//			call.setStyle(org.apache.axis.constants.Style.WRAPPED);
//			call.setUse(org.apache.axis.constants.Use.LITERAL);
	        
	        
			call.setUseSOAPAction(true);
			
//			call.setSOAPActionURI("http://localhost:6060/ode/processes/BPEL_FoundIT/services/Rpc");
			call.setSOAPActionURI(soapActionURI);
			
			//Integer k = (Integer) call.invoke(new Object[] { i, j });
			
			//System.out.println("result is " + k.toString() + ".");
			
			//driverLicence = "123";
			//addr = "abc";
			//fullName = "albert";


			System.out.println("driverLicence is "+ driverLicence);
			System.out.println("addr is "+ addr);
			System.out.println("fullName is "+ fullName);
			java.lang.Object result = call.invoke(new Object[]{driverLicence,addr,fullName});
			
			System.out.println("result is "+result.toString());
			
			
			//Set the return content depending on the input text
			if(driverLicence.equals("")){
				result = "The address check result is: " + result.toString();
			}else if(addr.equals("")){
				result = "The driverLicence check result is: " + result.toString();
			}
	
	        try {
	            return (java.lang.String) result;
	        } catch (java.lang.Exception _exception) {
	            return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(result, java.lang.String.class);
	        }
	        
//			return result;

		}

		catch (Exception e) {
		
			System.err.println(e.toString());
		
		}

		return "<h2>ERROR: 1.Please only input the driverLicence or the addr<br/><p>&nbsp;&nbsp;&nbsp;2.Sever Error or Database Not connected.</h2>";


}

}