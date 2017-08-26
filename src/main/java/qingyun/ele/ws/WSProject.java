package qingyun.ele.ws;


public class WSProject{

	private Long id;          //id
	private String address;   //地址
	private String pic;       //照片地址
	private Float zjrl;       //整机容量
	private Float fdgl;       //发电功率
	private Float drfd;       //当日发电
	private Float ljfd;       //累计发电
	private Float drsy;        //当日收益
	private Float ljsy;       //累计收益
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Float getZjrl() {
		return zjrl;
	}
	public void setZjrl(Float zjrl) {
		this.zjrl = zjrl;
	}
	public Float getFdgl() {
		return fdgl;
	}
	public void setFdgl(Float fdgl) {
		this.fdgl = fdgl;
	}
	public Float getDrfd() {
		return drfd;
	}
	public void setDrfd(Float drfd) {
		this.drfd = drfd;
	}
	public Float getLjfd() {
		return ljfd;
	}
	public void setLjfd(Float ljfd) {
		this.ljfd = ljfd;
	}
	public Float getDrsy() {
		return drsy;
	}
	public void setDrsy(Float drsy) {
		this.drsy = drsy;
	}
	public Float getLjsy() {
		return ljsy;
	}
	public void setLjsy(Float ljsy) {
		this.ljsy = ljsy;
	}
	
}
