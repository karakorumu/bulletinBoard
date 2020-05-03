package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class ThreadInSelectDAO {

	List<Comment> CommentList=new ArrayList<>();

	private final String url="jdbc:postgresql://localhost:5432/threadd";
	private final String user="postgres";
	private final String pass="postgres";

	public List<Comment> find(String commentTableName) {
		try(Connection conn=DriverManager.getConnection(url,user,pass)){

			String sql="select id,text from  "+commentTableName;
				PreparedStatement pStmt=conn.prepareStatement(sql);
//				pStmt.setString(1,commentTableName);
				ResultSet rs=pStmt.executeQuery();
				while(rs.next()) {
					String id=rs.getString("id");
					String text=rs.getString("text");
					Comment comment=new Comment(id,text);
					CommentList.add(comment);
				}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return CommentList;
	}
}
