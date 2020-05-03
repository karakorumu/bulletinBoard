package test;

import java.util.List;

import dao.ThreadInSelectDAO;
import model.Comment;

public class ThreadInSelectDAOTest {
	public static void main(String[]args) {
		String t=("hello");
		ThreadInSelectDAO td=new ThreadInSelectDAO();
		List<Comment> result=td.find(t);
		for(Comment a:result) {
			System.out.println(a.getId());
			System.out.println(a.getText());
	}
	}
}
