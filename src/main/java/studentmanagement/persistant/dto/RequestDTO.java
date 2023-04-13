package studentmanagement.persistant.dto;

public class RequestDTO {
	private String stuName;
	private String stuEmail;
	private int stuAge;
	private String stuAddress;
	private String stuPh;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getStuPh() {
		return stuPh;
	}
	public void setStuPh(String stuPh) {
		this.stuPh = stuPh;
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
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
}
