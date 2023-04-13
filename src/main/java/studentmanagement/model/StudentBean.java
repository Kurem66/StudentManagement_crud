package studentmanagement.model;

public class StudentBean {
	private String stuName;
	private String stuEmail;
	private String stuAge;
	private String stuAddress;
	private String stuPh;
	private int id;
	private Boolean check;
	
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuAge() {
		return stuAge;
	}
	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuPh() {
		return stuPh;
	}
	public void setStuPh(String stuPh) {
		this.stuPh = stuPh;
	}
	
}
