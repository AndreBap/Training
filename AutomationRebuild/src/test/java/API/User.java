package API;

public class User {
	private String id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
//	private String[] data;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	  
	  public User() {
		  
	  }
	  
	  public User(String id, String email, String first_name, String last_name, String avatar) {
		  this.id = id;
		  this.email = email;
		  this.first_name = first_name;
		  this.last_name = last_name;
		  this.avatar = avatar;
//		  this.data[0] = id;
//		  this.data[1] = email;
//		  this.data[2] = first_name;
//		  this.data[3] = last_name;
//		  this.data[4] = avatar;
	  }

	public String print() {
		// TODO Auto-generated method stub
		return id + email + first_name;
	}
}
