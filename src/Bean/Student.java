package Bean;

public class Student {
	private String name;
	private String idc;
	private String class1;
	private String sex;
	private String major;
	private String password;
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
	public String getClass1() {
		return class1;
	}
	public void setClass1(String class1) {
		this.class1 = class1;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student(String name,String idc,String class1,String major)
	{
		this.class1=class1;
		this.major=major;
		this.name=name;
		this.idc=idc;
	}
	public Student(String name,String class1,String major)
	{
		this.class1=class1;
		this.major=major;
		this.name=name;
	}
	public Student(String name,String idc,String password,String class1,String major,String sex)
	{
		this.class1=class1;
		this.idc=idc;
		this.password=password;
		this.major=major;
		this.name=name;
		this.sex=sex;
	}
}
