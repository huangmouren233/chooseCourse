package Bean;

public class Teacher {
	private String name;
	private String idc;
	private String college;
	private String sex;
	private String password;
	private String zhicheng;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdc() {
		return idc;
	}
	public void setIdc(String idc) {
		this.idc = idc;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public Teacher()
	{
	}
	public Teacher(String name,String sex,String zhicheng,String college) {
		this.college=college;
    	this.name=name;
    	this.sex=sex;
    	this.zhicheng=zhicheng;
	}
    public Teacher(String name,String idc,String password,String sex,String zhicheng,String college) {
    	this.college=college;
    	this.idc=idc;
    	this.password = password;
    	this.name=name;
    	this.sex=sex;
    	this.zhicheng=zhicheng;
    }
}
