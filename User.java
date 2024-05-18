package day6;


//mark :- this is user class for user management
public abstract class User {
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	
	//DESC :- constructor for the user class
	public User(int id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	//Mark :- abstract methods for user class
	//DESC :- this methods need to be implemented by diff users
	public abstract void register();
	public abstract void updateDetails();
	
	
	// setter and getter 
	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
