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

import model.Comment;
import model.ThreadInSelectLogic;
import model.ThreadTableNumberLogic;
import model.Threadd;

@WebServlet("/ThreadCommentServlet")
public class ThreadCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		session.removeAttribute("threaddd");

		ThreadTableNumberLogic tt=new ThreadTableNumberLogic();
		Threadd tablename=tt.execute(action);

		HttpSession session2=request.getSession();
		session2.removeAttribute("tablename");
	    session2.setAttribute("tablename",tablename);




	    ThreadInSelectLogic threadInSelectLogic=new ThreadInSelectLogic();
	    String commentTableName=tablename.getName();
	    List<Comment> commentList=threadInSelectLogic.execute(commentTableName);
		HttpSession session3=request.getSession();
		session3.removeAttribute("commentList");
	    session3.setAttribute("commentList",commentList);

		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/ThreadComment.jsp");
		d.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
