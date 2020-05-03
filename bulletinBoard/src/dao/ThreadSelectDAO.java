package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Threadd;

public class ThreadSelectDAO {
	private final String url="jdbc:postgresql://localhost:5432/threadd";
	private final String user="postgres";
	private final String pass="postgres";

	public List<Threadd> find() {
		List<Threadd> threaddList=new ArrayList<>();
		try(Connection conn=DriverManager.getConnection(url,user,pass)){

//			String sql="select tablename from pg_tables where schemaname not like 'pg_%' and tablename not like 'sql_%'";
			String sql="select relname,oid from pg_class where relname not like 'pg_%'and relname not like 'sql_%' and relkind='r'";
				PreparedStatement pStmt=conn.prepareStatement(sql);
				ResultSet rs=pStmt.executeQuery();

				while(rs.next()) {
					String tablename=rs.getString("relname");
					int oid=rs.getInt("oid");
					Threadd threadd=new Threadd(tablename,oid);
					threaddList.add(threadd);
				}

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return threaddList;
	}
}
