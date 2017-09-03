package qingyun.ele.ws;

public class WSDevice extends Valid implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
    private String MAC;
    private String IP;
    private String DEVICE_KEY;
    private Integer RET;
    private Integer ID_DEVICE;
    
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getDEVICE_KEY() {
		return DEVICE_KEY;
	}
	public void setDEVICE_KEY(String dEVICE_KEY) {
		DEVICE_KEY = dEVICE_KEY;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getID_DEVICE() {
		return ID_DEVICE;
	}
	public void setID_DEVICE(Integer iD_DEVICE) {
		ID_DEVICE = iD_DEVICE;
	}
	public Integer getRET() {
		return RET;
	}
	public void setRET(Integer rET) {
		RET = rET;
	}



}
