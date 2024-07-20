package studentfolder;


public class student_mod {

	private int id;
	private String name;	
	private String dob;
	private String email;
	private int age;
	private long phone;
	private String address;

	
	
	
	public student_mod(int id, String name, String dob, String email, int age, long phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.address = address;
		
	}
	public student_mod(String name, String dob, String email, int age, long phone, String address) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.age = age;
		this.phone = phone;
		this.address = address;
	
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString()
	{
		return "student_mod [id=" + id + ", name=" + name + ", dob=" + dob + ", email="
				+ email + ", age=" + age +", phone="+ phone + ", address=" + address  + "]";
		
	}



	
	
	

}
