package model;

import java.io.Serializable;

public class Threadd implements Serializable{
	private String name;
	private int oid;
	public Threadd() {}
	public Threadd(String name) {
		this.name=name;
	}
	public Threadd(String name,int oid) {
		this.name=name;
		this.oid=oid;}

	public String getName() {return this.name;}
	public void setName(String name) {this.name=name;}
	public int getOid() {return this.oid;}
	public void setOid(int oid) {this.oid=oid;}
}
