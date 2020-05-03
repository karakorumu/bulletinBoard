package sevlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		d.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		Login login=new Login(id,pass);
		HttpSession session=request.getSession();
		session.setAttribute("login",login);
		LoginLogic ll=new LoginLogic();
		boolean result=ll.execute(login);


		if(result) {
			RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/loginOK.jsp");
			d.forward(request,response);
			}else {
				RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/loginFalse.jsp");
				d.forward(request,response);
			}
	}
}
