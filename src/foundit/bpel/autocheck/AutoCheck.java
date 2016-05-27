package foundit.bpel.autocheck;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AutoCheck {

    private String driverLicence = "";
    private String addr = "";
    private String fullName = "";

    public AutoCheck(){

    }
    public AutoCheck (String driverLicence, String addr, String fullName){

    	this.driverLicence=driverLicence;
        this.addr = addr;
        this.fullName = fullName;
    }

    public String getDriverLicence() {
        return driverLicence;
    }
    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
}