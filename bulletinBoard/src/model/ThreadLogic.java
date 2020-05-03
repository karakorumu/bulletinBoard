package model;

import dao.ThreadDAO;

public class ThreadLogic {
	public boolean execute(Threadd threadd) {
		ThreadDAO dao=new ThreadDAO();
		boolean result=dao.create(threadd);
		if(result) {
		return true;
	}else {
		return false;
	}
	}
}
