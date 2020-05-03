package test;

import static java.lang.System.*;

import dao.RegisterDAO;
import model.Account;

public class AccountDAOTest {
	public static void main(String[]args) {
		test1();
		test2();
	}
	public static  void test1() {
		Account a=new Account("katuto","passworD","abcde@gmail.com","勝又久義",34);
		RegisterDAO r=new RegisterDAO();
		boolean result=r.insert(a);
		if(result) {
			out.println("test1は成功");
		}else {
			out.println("test1は失敗");
		}
	}

	public static void test2() {
		Account a=new Account("katuto","passworD","abcde@gmail.com","勝又久義",35);
		RegisterDAO r=new RegisterDAO();
		boolean result=r.insert(a);
		if(result) {
			out.println("test2は失敗");
		}else {
			out.println("test2は成功");
		}
	}
}
