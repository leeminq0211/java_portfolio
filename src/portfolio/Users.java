package portfolio;

public class Users {
	private String id; private String pass; private int age; private String email; private String address;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String pass, int age, String email, String address) {
		super();
		this.id = id;
		this.pass = pass;
		this.age = age;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", pass=" + pass + ", age=" + age + ", email=" + email + ", address=" + address
				+ "]";
	}
}
