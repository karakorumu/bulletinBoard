package sevlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.Account;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		d.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String mail=request.getParameter("mail");
		String name=request.getParameter("name");
		String age=request.getParameter("age");

		int Age = Integer.parseInt(age);
		Account account=new Account(id,pass,mail,name,Age);
		HttpSession session=request.getSession();
		session.setAttribute("account",account);

		RegisterDAO registerdao=new RegisterDAO();
		boolean result=registerdao.insert(account);
		if(result) {
			RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/registerOK.jsp");
			d.forward(request,response);
		}else {
			RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/registerFalse.jsp");
			d.forward(request,response);
		}
	}

}
