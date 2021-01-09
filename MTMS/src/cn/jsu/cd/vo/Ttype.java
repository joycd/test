package cn.jsu.cd.vo;

public class Ttype {
	private int tty_id;
	  private String tty_name;
	  private int twmax;
	  private int twmin;
	  private int tamax;
	  private int tamin;
	public Ttype() {
		super();
	}
	public Ttype(int tty_id, String tty_name, int twmax, int twmin, int tamax, int tamin) {
		super();
		this.tty_id = tty_id;
		this.tty_name = tty_name;
		this.twmax = twmax;
		this.twmin = twmin;
		this.tamax = tamax;
		this.tamin = tamin;
	}
	public int getTty_id() {
		return tty_id;
	}
	public void setTty_id(int tty_id) {
		this.tty_id = tty_id;
	}
	public String getTty_name() {
		return tty_name;
	}
	public void setTty_name(String tty_name) {
		this.tty_name = tty_name;
	}
	public int getTwmax() {
		return twmax;
	}
	public void setTwmax(int twmax) {
		this.twmax = twmax;
	}
	public int getTwmin() {
		return twmin;
	}
	public void setTwmin(int twmin) {
		this.twmin = twmin;
	}
	public int getTamax() {
		return tamax;
	}
	public void setTamax(int tamax) {
		this.tamax = tamax;
	}
	public int getTamin() {
		return tamin;
	}
	public void setTamin(int tamin) {
		this.tamin = tamin;
	}
	@Override
	public String toString() {
		return "Ttype [tty_id=" + tty_id + ", tty_name=" + tty_name + ", twmax=" + twmax + ", twmin=" + twmin
				+ ", tamax=" + tamax + ", tamin=" + tamin + "]";
	}
	
}
