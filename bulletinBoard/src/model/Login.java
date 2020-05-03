package model;

import java.io.Serializable;

public class Login implements Serializable{
	private String id;
	private String pass;

	public Login() {};
	public Login(String id,String pass) {
		this.id=id;
		this.pass=pass;
	}

	public String getId() {return this.id;}
	public void setId(String id) {this.id=id;}
	public String getPass() {return this.pass;}
	public void setPass(String pass) {this.pass=pass;}
}
