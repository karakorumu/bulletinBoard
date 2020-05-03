package model;

import dao.LoginDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		LoginDAO logindao=new LoginDAO();
		Account account=logindao.find(login);
		return account !=null;
	}
}
