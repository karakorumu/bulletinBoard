package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentCreateDAO {
	private final String url="jdbc:postgresql://localhost:5432/threadd";
	private final String user="postgres";
	private final String pass="postgres";

	public boolean insert (String tablename,String id,String text){
		try(Connection conn=DriverManager.getConnection(url,user,pass)){
			String sql1="insert into "+tablename;
			String sql2=sql1+" values(?,?)";
				PreparedStatement pStmt=conn.prepareStatement(sql2);
				pStmt.setString(1,id);
				pStmt.setString(2,text);
				int result=pStmt.executeUpdate();
				if(result!=1) {
					return false;
				}

		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
