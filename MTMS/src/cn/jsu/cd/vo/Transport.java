package cn.jsu.cd.vo;

public class Transport {
	private int t_id;
	private String t_color;
	private float t_carry;
	private String t_brand;
	private String t_license;
	private float t_tonnage;
	private int t_flag;
	private String t_time;
	public Transport() {
		super();
	}
	public Transport(int t_id, String t_color, float t_carry, String t_brand, String t_license, float t_tonnage,
			int t_flag, String t_time) {
		super();
		this.t_id = t_id;
		this.t_color = t_color;
		this.t_carry = t_carry;
		this.t_brand = t_brand;
		this.t_license = t_license;
		this.t_tonnage = t_tonnage;
		this.t_flag = t_flag;
		this.t_time = t_time;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_color() {
		return t_color;
	}
	public void setT_color(String t_color) {
		this.t_color = t_color;
	}
	public float getT_carry() {
		return t_carry;
	}
	public void setT_carry(float t_carry) {
		this.t_carry = t_carry;
	}
	public String getT_brand() {
		return t_brand;
	}
	public void setT_brand(String t_brand) {
		this.t_brand = t_brand;
	}
	public String getT_license() {
		return t_license;
	}
	public void setT_license(String t_license) {
		this.t_license = t_license;
	}
	public float getT_tonnage() {
		return t_tonnage;
	}
	public void setT_tonnage(float t_tonnage) {
		this.t_tonnage = t_tonnage;
	}
	public int getT_flag() {
		return t_flag;
	}
	public void setT_flag(int t_flag) {
		this.t_flag = t_flag;
	}
	public String getT_time() {
		return t_time;
	}
	public void setT_time(String t_time) {
		this.t_time = t_time;
	}
	@Override
	public String toString() {
		return "Transport [t_id=" + t_id + ", t_color=" + t_color + ", t_carry=" + t_carry + ", t_brand=" + t_brand
				+ ", t_license=" + t_license + ", t_tonnage=" + t_tonnage + ", t_flag=" + t_flag + ", t_time=" + t_time
				+ "]";
	}
	
	
}
