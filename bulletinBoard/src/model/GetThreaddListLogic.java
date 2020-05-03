package model;

import java.util.List;

import dao.ThreadSelectDAO;

public class GetThreaddListLogic {
	public List<Threadd> execute(){
		ThreadSelectDAO th=new ThreadSelectDAO();
		List<Threadd> threaddList=th.find();
		return threaddList;
	}
}
