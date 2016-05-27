<%@ page language="java"  import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="org.xml.sax.SAXException"%>
<%@ page import="javax.xml.parsers.*"%>
<%@ page import="javax.xml.xpath.*"%>
<jsp:useBean id="autocheck" scope="session" class="foundit.bpel.autocheck.AutoCheckAxis" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head> 
    <title>Testing the AutoCheck BPEL</title>
	
	<script>

		function validate() 
	    {
			var dl = document.input.driverLicence.value.replace(/(^s*)|(s*$)/g, "");
			var adr = document.input.addr.value.replace(/(^s*)|(s*$)/g, "");
			var fn = document.input.fullName.value.replace(/(^s*)|(s*$)/g, "");
			if ((!dl.length ==0 && !adr.length ==0))
	    	{
				document.getElementById('info').innerHTML='<h2>Please only input the driverLicence or the addr</h2>';
	    		document.form.driverLicence.focus();
	    		return false ;
	    	}
	    	
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
 			 <form action="AutoCheckTest.jsp" method="post" name="input" onsubmit="return validate()">
 				DriverLicence:<input type="text" name="driverLicence" value="" size="20">
 				Address:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="addr" value="" size="20">
 				FullName:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="fullName" value="" size="50">
				<input type="submit" value="Submit">
			 </form>
 			</td>
 		</tr>
 	</table>
				<div id="info"></div>
 

 <%  
    //Document doc = domparser.getDocument(request.getRealPath("/") + "dblp.xml");
    //domparser.traverseTree(doc);
    String driverLicence = request.getParameter("driverLicence");
    String addr = request.getParameter("addr");
    String fullName = request.getParameter("fullName");
    out.print("<h2>" + autocheck.AutoCheckAxis(driverLicence,addr,fullName).toString() + "</h2>");
 %>
 
</center>
 </body>
 </html> 
 

