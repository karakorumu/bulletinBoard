package model;
import java.io.Serializable;

public class Account implements Serializable{
private  String id;
private  String pass;
private  String mail;
private  String name;
private  int age;

public Account() {}
public Account(String id,String pass,String mail,String name,int age) {
	this.id=id;
	this.pass=pass;
	this.mail=mail;
	this.name=name;
	this.age=age;
}
public String getId() {return this.id;}
public String getPass() {return this.pass;}
public String getMail() {return this.mail;}
public String getName() {return this.name;}
public int getAge() {return this.age;}

public void setId(String id) {this.id=id;}
public void setPass(String pass) {this.pass=pass;}
public void setMail(String mail) {this.mail=mail;}
public void setName(String name) {this.name=name;}
public void setAge(int age) {this.age=age;}

}
