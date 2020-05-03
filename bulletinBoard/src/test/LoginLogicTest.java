package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[]args) {
		Test1();
		Test2();
	}
	public static void Test1() {
		Login lo=new Login("tamaki","tthh");
		LoginLogic ll=new LoginLogic();
		boolean result =ll.execute(lo);
		if(result) {
			System.out.println("test1は成功");
		}else {
			System.out.println("test1は失敗");
		}
	}
	public static void Test2() {
		Login lo=new Login("tamak","tthh");
		LoginLogic ll=new LoginLogic();
		boolean result =ll.execute(lo);
		if(!result) {
			System.out.println("test2は成功");
		}else {
			System.out.println("test2は失敗");
		}
	}
}
