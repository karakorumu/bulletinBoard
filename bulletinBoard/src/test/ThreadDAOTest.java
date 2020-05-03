package test;

import dao.ThreadDAO;
import model.Threadd;

public class ThreadDAOTest {
public static void main(String[]args) {
	Threadd t=new Threadd("test");
	ThreadDAO td=new ThreadDAO();
	boolean result=td.create(t);
	System.out.println(result);
}
}
