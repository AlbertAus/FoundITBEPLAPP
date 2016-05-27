package foundit.bpel.autocheck;

public class AutoCheckProcessProxy implements foundit.bpel.autocheck.AutoCheckProcess {
  private String _endpoint = null;
  private foundit.bpel.autocheck.AutoCheckProcess autoCheckProcess = null;
  
  public AutoCheckProcessProxy() {
    _initAutoCheckProcessProxy();
  }
  
  public AutoCheckProcessProxy(String endpoint) {
    _endpoint = endpoint;
    _initAutoCheckProcessProxy();
  }
  
  private void _initAutoCheckProcessProxy() {
    try {
      autoCheckProcess = (new foundit.bpel.autocheck.AutoCheckProcessServiceLocator()).getAutoCheckProcess();
      if (autoCheckProcess != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)autoCheckProcess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)autoCheckProcess)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (autoCheckProcess != null)
      ((javax.xml.rpc.Stub)autoCheckProcess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public foundit.bpel.autocheck.AutoCheckProcess getAutoCheckProcess() {
    if (autoCheckProcess == null)
      _initAutoCheckProcessProxy();
    return autoCheckProcess;
  }
  
  public java.lang.String autoCheckProcessRequest(java.lang.String driverLicence, java.lang.String addr, java.lang.String fullName) throws java.rmi.RemoteException{
    if (autoCheckProcess == null)
      _initAutoCheckProcessProxy();
    return autoCheckProcess.autoCheckProcessRequest(driverLicence, addr, fullName);
  }
  
  
}