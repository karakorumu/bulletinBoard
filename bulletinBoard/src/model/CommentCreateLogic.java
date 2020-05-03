package model;

import dao.CommentCreateDAO;


public class CommentCreateLogic {
	public boolean execute(String tablename,String id,String text) {
		CommentCreateDAO dao=new CommentCreateDAO();
		boolean result=dao.insert(tablename,id,text);
		return result;
}
}
