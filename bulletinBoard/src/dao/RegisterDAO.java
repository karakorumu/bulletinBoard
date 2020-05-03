package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Account;

public class RegisterDAO {
	private final String url="jdbc:postgresql://localhost:5432/board";
	private final String user="postgres";
	private final String pass="postgres";

	public boolean insert(Account account) {
		try(Connection conn=DriverManager.getConnection(url,user,pass)){

				String sql="insert into account values(?,?,?,?,?)";
				PreparedStatement pStmt=conn.prepareStatement(sql);

				pStmt.setString(1,account.getId());
				pStmt.setString(2,account.getPass());
				pStmt.setString(3,account.getMail());
				pStmt.setString(4,account.getName());
				pStmt.setInt(5,account.getAge());

				int result=pStmt.executeUpdate();
				if(result !=1) {
					return false;
				}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
