package cn.jsu.cd.vo;

public class Mechanics {
	private int m_id;
	private String m_name;
	private float m_weight;
	private float m_area;
	private String m_function;
	private String m_time;
	private int ty_id;
	private String t_id;
	public Mechanics() {
		super();
	}
	public Mechanics(int m_id, String m_name, float m_weight, float m_area, String m_function, String m_time, int ty_id,
			String t_id) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_weight = m_weight;
		this.m_area = m_area;
		this.m_function = m_function;
		this.m_time = m_time;
		this.ty_id = ty_id;
		this.t_id = t_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public float getM_weight() {
		return m_weight;
	}
	public void setM_weight(float m_weight) {
		this.m_weight = m_weight;
	}
	public float getM_area() {
		return m_area;
	}
	public void setM_area(float m_area) {
		this.m_area = m_area;
	}
	public String getM_function() {
		return m_function;
	}
	public void setM_function(String m_function) {
		this.m_function = m_function;
	}
	public String getM_time() {
		return m_time;
	}
	public void setM_time(String m_time) {
		this.m_time = m_time;
	}
	public int getTy_id() {
		return ty_id;
	}
	public void setTy_id(int ty_id) {
		this.ty_id = ty_id;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	@Override
	public String toString() {
		return "Mechanics [m_id=" + m_id + ", m_name=" + m_name + ", m_weight=" + m_weight + ", m_area=" + m_area
				+ ", m_function=" + m_function + ", m_time=" + m_time + ", ty_id=" + ty_id + ", t_id=" + t_id + "]";
	}
	
}
