<%@ page language="java"  import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="org.xml.sax.SAXException"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="javax.xml.xpath.*"%>
<jsp:useBean id="autocheckpayload" scope="session" class="foundit.bpel.autocheck.AutoCheckPayload" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head> 
    <title>Testing the AutoCheckPayload BPEL</title>
	
	<script>

		function validate() 
	    {
			/*if (document.form_search.search_info.value=="")
	    	{
	    		alert("Please enter search content.");
	    		document.form_search.search_info.focus();
	    	return false ;
	    	}
	    	*/
	    	return true;
	    }

</script>
  </head>
 
 <body>
 <center>
 

 	
 	<table  border="1" width="80%">
 	
 		<tr>
 			<td colspan="2"><h2>Please enter the parameters</h2></td>
 		</tr>
 		<tr>
 			<td  align="center">
 			 <form action="AutoCheckPayloadTest.jsp" method="post" name="input" onsubmit="return validate()">
 				DriverLicence:<input type="text" name="driverLicence" value="123" size="20">
 				Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addr" value="" size="20">
 				FullName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fullName" value="albert" size="50">
				<input type="submit" value="Submit">
			 </form>
 			</td>
 		</tr>
 	</table>

 

 <%  
    //Document doc = domparser.getDocument(request.getRealPath("/") + "dblp.xml");
    //domparser.traverseTree(doc);
    String driverLicence = request.getParameter("driverLicence");
    String addr = request.getParameter("addr");
    String fullName = request.getParameter("fullName");
    out.print("The result is: " + autocheckpayload.AutoCheckPayload(driverLicence, addr, fullName));
 %>
 
</center>
 </body>
 </html> 
 

