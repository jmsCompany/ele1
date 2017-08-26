package qingyun.ele.ws;

import java.util.ArrayList;
import java.util.List;

public class WSDataCollects{
	
	private String address;
    private List<WSDataCollect> data = new ArrayList<WSDataCollect>();
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<WSDataCollect> getData() {
		return data;
	}
	public void setData(List<WSDataCollect> data) {
		this.data = data;
	}

	
}
