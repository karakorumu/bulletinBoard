package model;

import java.util.List;

import dao.ThreadInSelectDAO;


public class ThreadInSelectLogic {
	public List<Comment> execute(String Commnettablename) {
		ThreadInSelectDAO dao=new ThreadInSelectDAO();
		List<Comment> commentList=dao.find(Commnettablename);
		return commentList;
	}
}
