package test;

import java.util.List;

import dao.ThreadSelectDAO;
import model.Threadd;

public class ThreadSelectDAOTest {
public static void main(String[]args) {
	ThreadSelectDAO t=new ThreadSelectDAO();
	List<Threadd> threaddList=t.find();
}
}
