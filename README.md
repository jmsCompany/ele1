# ELE

服务器 : 118.178.94.7:9997/ele
测试用户 user1 密码123123

移动端： 除了页面01,02,，其他页面调用均需家用JMS-TOKEN到header
页面01：
1) /m/login post方法  传入参数 {username,password}, 传出参数{valid,msg,token,username,idUser,name}

页面02：
2） /m/updateUser post方法  传入参数 {username,newPassword, email}, 传出参数{valid,msg}

页面03:
3)/m/projList post方法 传入参数 无 ，传出参数列表 [
   {
	 id,          //id
     address,   //地址
	 pic,       //照片地址
	 zjrl,       //整机容量
	 fdgl,       //发电功率
	 rfd,      //当日发电
	 jfd,       //累计发电
	 drsy,        //当日收益
	 jsy      //累计收益
	}
	]
4)得到图片/getImage/{pic}/	

页面04
无

页面05
5) 得到设置: /m/getsetting post方法 传入参数 无 ，传出参数
{
	ts,       //推送 0，不接收 1 接收
	ycts,   //异常推送
	fd    //每日发电信息
}
6)保存设置
/m/savesetting post方法 传入参数
{
	ts,       //推送 0，不接收 1 接收
	ycts,   //异常推送
	fd    //每日发电信息
}
传出参数{
valid,
msg
}
 
 页面06
 无
 
页面07 
7） 获得项目详情 /m/proj GET方法 传入参数id (项目id)，传出参数

{
	private Long id;          //id
	private String address;   //地址
	private Float bfb;       //百分比
	private Float fdgl;       //发电功率
	private String yxzt;      //运行状态
	private Float zjrl;       //整机容量
	private String cjsj;       //创建时间
	private Float drdl;       //当日电量
	private Float ljdl;       //累计电量
	private Float drsy;        //当日收益
	private Float ljsy;       //累计收益
	private Float drjp;        //当日减排
	private Float ljjp;       //累计减排
	private Float drzz;        //当日种植
	private Float ljzz;       //累计种植
}


页面12

8） 获得采集器列表  /m/datacollect GET方法 传入参数id (项目id)，传出参数
{address：, data: [
{

	private String sn; //序列号
	private Float fdgl; //发电功率
	private String zt; // 状态
	private Float drfd; //当日发电
	private Float ljfd; //累计发电
	private String cwxx; //错误信息
	private String pic; //图片

}
,
...
]
}# ele1
