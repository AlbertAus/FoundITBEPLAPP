/**
 * AutoCheckProcessServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package foundit.bpel.autocheck;

public class AutoCheckProcessServiceLocator extends org.apache.axis.client.Service implements foundit.bpel.autocheck.AutoCheckProcessService {

    public AutoCheckProcessServiceLocator() {
    }


    public AutoCheckProcessServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AutoCheckProcessServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AutoCheckProcess
    private java.lang.String AutoCheckProcess_address = "http://localhost:6060/ode/processes/BPEL_FoundIT/services/AutoCheckProcess";

    public java.lang.String getAutoCheckProcessAddress() {
        return AutoCheckProcess_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AutoCheckProcessWSDDServiceName = "AutoCheckProcess";

    public java.lang.String getAutoCheckProcessWSDDServiceName() {
        return AutoCheckProcessWSDDServiceName;
    }

    public void setAutoCheckProcessWSDDServiceName(java.lang.String name) {
        AutoCheckProcessWSDDServiceName = name;
    }

    public foundit.bpel.autocheck.AutoCheckProcess getAutoCheckProcess() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AutoCheckProcess_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAutoCheckProcess(endpoint);
    }

    public foundit.bpel.autocheck.AutoCheckProcess getAutoCheckProcess(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            foundit.bpel.autocheck.AutoCheckProcessBindingStub _stub = new foundit.bpel.autocheck.AutoCheckProcessBindingStub(portAddress, this);
            _stub.setPortName(getAutoCheckProcessWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAutoCheckProcessEndpointAddress(java.lang.String address) {
        AutoCheckProcess_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (foundit.bpel.autocheck.AutoCheckProcess.class.isAssignableFrom(serviceEndpointInterface)) {
                foundit.bpel.autocheck.AutoCheckProcessBindingStub _stub = new foundit.bpel.autocheck.AutoCheckProcessBindingStub(new java.net.URL(AutoCheckProcess_address), this);
                _stub.setPortName(getAutoCheckProcessWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AutoCheckProcess".equals(inputPortName)) {
            return getAutoCheckProcess();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "AutoCheckProcessService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://autocheck.bpel.foundit", "AutoCheckProcess"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AutoCheckProcess".equals(portName)) {
            setAutoCheckProcessEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
