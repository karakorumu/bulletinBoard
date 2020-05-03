package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class LoginDAO {
	private final String url="jdbc:postgresql://localhost:5432/board";
	private final String user="postgres";
	private final String pass="postgres";

	public Account find(Login login) {
		Account account=null;
		try(Connection conn=DriverManager.getConnection(url,user,pass)){

				String sql="select trim(id)as id,trim(pass)as pass,trim(mail)as mail,trim(name)as name,age from account where id=? and pass=?";
				PreparedStatement pStmt=conn.prepareStatement(sql);

				pStmt.setString(1,login.getId());
				pStmt.setString(2,login.getPass());

				ResultSet rs=pStmt.executeQuery();

				if(rs.next()) {
					String id=rs.getString("id");
					String pass=rs.getString("pass");
					String mail=rs.getString("mail");
					String name=rs.getString("name");
					int age=rs.getInt("age");
					 account=new Account(id,pass,mail,name,age);
				}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
}
