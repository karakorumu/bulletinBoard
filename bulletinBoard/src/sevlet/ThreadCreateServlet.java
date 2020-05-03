package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetThreaddListLogic;
import model.ThreadLogic;
import model.Threadd;

@WebServlet("/ThreadCreateServlet")
public class ThreadCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");

		HttpSession session2=request.getSession();
		session2.removeAttribute("errorMsg");

		Threadd threadd=new Threadd(name);
		HttpSession session=request.getSession();
		session.setAttribute("threadd",threadd);
		ThreadLogic ll=new ThreadLogic();
		boolean result=ll.execute(threadd);

		GetThreaddListLogic getThreaddListLogic = new GetThreaddListLogic();
		List<Threadd> threadList =getThreaddListLogic.execute();
		request.setAttribute("threadList",threadList);

		if(result) {
			RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/intro.jsp");
			d.forward(request,response);
		}else {
			session2.setAttribute("errorMsg","既に同じスレッドがあります");
			RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/intro.jsp");
			d.forward(request,response);
		}
	}
}
