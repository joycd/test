package cn.jsu.cd.vo;

public class User {
	private int id;
	private String username;
	private String password;
	private String time;
	public User() {
		super();
	}
	public User(int id, String username, String password, String time) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
