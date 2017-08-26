package qingyun.ele.ws;


public class WSMset{

	private Long ts;       //推送 0，不接收 1 接收
	private Long ycts;   //异常推送
	private Long fd;       //每日发电信息
	
	public Long getTs() {
		return ts;
	}
	public void setTs(Long ts) {
		this.ts = ts;
	}
	public Long getFd() {
		return fd;
	}
	public void setFd(Long fd) {
		this.fd = fd;
	}
	public Long getYcts() {
		return ycts;
	}
	public void setYcts(Long ycts) {
		this.ycts = ycts;
	}

	
}
