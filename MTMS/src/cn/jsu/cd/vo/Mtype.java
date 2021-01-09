package cn.jsu.cd.vo;

public class Mtype {
  private int ty_id;
  private String ty_name;
  private int wmax;
  private int wmin;
  private int amax;
  private int amin;
public Mtype() {
	super();
}
public Mtype(int ty_id, String ty_name, int wmax, int wmin, int amax, int amin) {
	super();
	this.ty_id = ty_id;
	this.ty_name = ty_name;
	this.wmax = wmax;
	this.wmin = wmin;
	this.amax = amax;
	this.amin = amin;
}
public int getTy_id() {
	return ty_id;
}
public void setTy_id(int ty_id) {
	this.ty_id = ty_id;
}
public String getTy_name() {
	return ty_name;
}
public void setTy_name(String ty_name) {
	this.ty_name = ty_name;
}
public int getWmax() {
	return wmax;
}
public void setWmax(int wmax) {
	this.wmax = wmax;
}
public int getWmin() {
	return wmin;
}
public void setWmin(int wmin) {
	this.wmin = wmin;
}
public int getAmax() {
	return amax;
}
public void setAmax(int amax) {
	this.amax = amax;
}
public int getAmin() {
	return amin;
}
public void setAmin(int amin) {
	this.amin = amin;
}
@Override
public String toString() {
	return "Mtype [ty_id=" + ty_id + ", ty_name=" + ty_name + ", wmax=" + wmax + ", wmin=" + wmin + ", amax=" + amax
			+ ", amin=" + amin + "]";
}
  
}
