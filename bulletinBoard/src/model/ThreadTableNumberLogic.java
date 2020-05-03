package model;

import dao.ThreadTableNumberDAO;

public class ThreadTableNumberLogic {
	public Threadd execute(String tablenumber) {
		ThreadTableNumberDAO dao=new ThreadTableNumberDAO();
		Threadd  tablename=dao.find(tablenumber);
		return tablename;
	}
}
