package Bean;

public class course {
	private String name;
	private String teacher;
	private String idc;
	private String peoplenumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getIdc() {
		return idc;
	}
	public void setIdc(String idc) {
		this.idc = idc;
	}
	public String getPeoplenumber() {
		return peoplenumber;
	}
	public void setPeoplenumber(String peoplenumber) {
		this.peoplenumber = peoplenumber;
	}
	public course(String name,String idc,String peoplenumber,String teacher)
	{
		this.teacher=teacher;
		this.name=name;
		this.idc=idc;
		this.peoplenumber=peoplenumber;
	}
}
