package datastructure;
public class Department {
private int dep_id;
private String dep_name;
private Manager m=new Manager();;
private int man_id;
public int getDep_id() {
	return dep_id;
}
public void setDep_id(int dep_id) {
	this.dep_id = dep_id;
}
public String getDep_name() {
	return dep_name;
}
public void setDep_name(String dep_name) {
	this.dep_name = dep_name;
}
public Manager getM() {
	return m;
}
public void setM(Manager m) {
	this.m = m;
}
public int getMan_id() {
	return man_id;
}

public void setMan_id(int man_id) {
	this.man_id = man_id;
}
public Department(){
	
}
public Department(int dep_id, String dep_name, int man_id) {
	this.dep_id = dep_id;
	this.dep_name = dep_name;
	this.m.setMan_id(man_id);
}
}
