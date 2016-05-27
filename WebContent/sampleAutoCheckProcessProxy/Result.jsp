<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAutoCheckProcessProxyid" scope="session" class="foundit.bpel.autocheck.AutoCheckProcessProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAutoCheckProcessProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAutoCheckProcessProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAutoCheckProcessProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        foundit.bpel.autocheck.AutoCheckProcess getAutoCheckProcess10mtemp = sampleAutoCheckProcessProxyid.getAutoCheckProcess();
if(getAutoCheckProcess10mtemp == null){
%>
<%=getAutoCheckProcess10mtemp %>
<%
}else{
        if(getAutoCheckProcess10mtemp!= null){
        String tempreturnp11 = getAutoCheckProcess10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String driverLicence_1id=  request.getParameter("driverLicence16");
            java.lang.String driverLicence_1idTemp = null;
        if(!driverLicence_1id.equals("")){
         driverLicence_1idTemp  = driverLicence_1id;
        }
        String addr_2id=  request.getParameter("addr18");
            java.lang.String addr_2idTemp = null;
        if(!addr_2id.equals("")){
         addr_2idTemp  = addr_2id;
        }
        String fullName_3id=  request.getParameter("fullName20");
            java.lang.String fullName_3idTemp = null;
        if(!fullName_3id.equals("")){
         fullName_3idTemp  = fullName_3id;
        }
        java.lang.String autoCheckProcessRequest13mtemp = sampleAutoCheckProcessProxyid.autoCheckProcessRequest(driverLicence_1idTemp,addr_2idTemp,fullName_3idTemp);
if(autoCheckProcessRequest13mtemp == null){
%>
<%=autoCheckProcessRequest13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(autoCheckProcessRequest13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>