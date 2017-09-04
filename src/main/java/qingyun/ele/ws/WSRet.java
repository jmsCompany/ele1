package qingyun.ele.ws;

public class WSRet {
	
	private Long ID_DEVICE;  //deviceId
	private Integer RET; //return code 0: no such device， 1: login
	
	public Long getID_DEVICE() {
		return ID_DEVICE;
	}
	public void setID_DEVICE(Long iD_DEVICE) {
		this.ID_DEVICE = iD_DEVICE;
	}
	public Integer getRET() {
		return RET;
	}
	public void setRET(Integer rET) {
		this.RET = rET;
	}
	


}
