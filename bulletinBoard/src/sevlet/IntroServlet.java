package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetThreaddListLogic;
import model.Threadd;

@WebServlet("/IntroServlet")
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GetThreaddListLogic getThreaddListLogic = new GetThreaddListLogic();
		List<Threadd> threadList =getThreaddListLogic.execute();
		request.setAttribute("threadList",threadList);

		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/intro.jsp");
		d.forward(request,response);
	}

}
