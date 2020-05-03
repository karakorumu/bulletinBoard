package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Threadd;

public class ThreadTableNumberDAO {

	Threadd tablenameee=new Threadd(null);

	private final String url="jdbc:postgresql://localhost:5432/threadd";
	private final String user="postgres";
	private final String pass="postgres";

	public Threadd find(String tablenumber) {
		try(Connection conn=DriverManager.getConnection(url,user,pass)){

			String sql="select relname from pg_class where oid=?";
				PreparedStatement pStmt=conn.prepareStatement(sql);
				int number = Integer.parseInt(tablenumber);
				pStmt.setInt(1,number);
				ResultSet rs=pStmt.executeQuery();
				while(rs.next()) {
					String tablenamee=rs.getString("relname");
					tablenameee=new Threadd(tablenamee);
				}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return tablenameee;
	}
}
