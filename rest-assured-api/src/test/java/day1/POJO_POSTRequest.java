package day1;

public class POJO_POSTRequest {
	
	//creating variables to assign the data and retrieving the data
	String name;
	String location;
	String phone;
	String courses[];

	public String getName() {
		return name;
	}
	//setters doing take one parameter and the variable to class variable
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
}
