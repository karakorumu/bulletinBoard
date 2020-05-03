package test;

import dao.LoginDAO;
import model.Account;
import model.Login;

public class LoginDAOTest {
public static void main(String[]args) {
	Test1();
	Test2();
}
public static void Test1() {
	Login login=new Login("tamaki","tthh");
	LoginDAO dao=new LoginDAO();
	Account result=dao.find(login);
	if(result!=null&&
			result.getId().contentEquals("tamaki")&&
			result.getPass().equals("tthh")&&
			result.getMail().equals("tamaki@gmail.com")&&
			result.getName().equals("玉木泰平")&&
			result.getAge()==21) {
			System.out.println("test1成功");
	}else {
		System.out.println("test1失敗");
	}
}
public static void Test2() {
	Login login=new Login("tamaki","tthhh");
	LoginDAO dao=new LoginDAO();
	Account result=dao.find(login);
	if(result==null) {
		System.out.println("test2成功");
		System.out.println("test2成功");
		System.out.println("test2成功");
		System.out.println("test2成功");
	}else {
		System.out.println("test2失敗");
		System.out.println("test2失敗");
		System.out.println("test2失敗");
		System.out.println("test2失敗");
		System.out.println("test2失敗");
		System.out.println("test2失敗");
	}
}
}
