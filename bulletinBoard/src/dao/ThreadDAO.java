package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import model.Threadd;

public class ThreadDAO {
	private final String url="jdbc:postgresql://localhost:5432/threadd";
	private final String user="postgres";
	private final String pass="postgres";

	public boolean create(Threadd threadd) {
		try(Connection conn=DriverManager.getConnection(url,user,pass)){
			String tableName=threadd.getName();
			String sql="CREATE TABLE " + tableName + "(id varchar(20) not null,text text not null)";
			Statement createTable = conn.createStatement ();
            createTable.executeUpdate (sql);

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
