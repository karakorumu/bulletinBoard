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
import model.CommentCreateLogic;
import model.GetThreaddListLogic;
import model.Login;
import model.ThreadInSelectLogic;
import model.Threadd;

@WebServlet("/CommentCreateServlet")
public class CommentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentCreateServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetThreaddListLogic getThreaddListLogic = new GetThreaddListLogic();
		List<Threadd> threadList =getThreaddListLogic.execute();
		request.setAttribute("threadList",threadList);
		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/intro.jsp");
		d.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("text");
//ログインidの取得
		HttpSession session=request.getSession();
		Login LoginId=(Login) session.getAttribute("login");
//スレッド名の取得
		HttpSession session2=request.getSession();
		Threadd tablename=(Threadd) session2.getAttribute("tablename");
//スレッド(table)にinsert
		CommentCreateLogic commentCreateLogic =new CommentCreateLogic();
		boolean result=commentCreateLogic.execute(tablename.getName(),LoginId.getId(),id);


		if(!result) {
			session2.removeAttribute("errorMsg");
			session2.setAttribute("errorMsg","コメントが入力されませんでした");
		}
//スレッド内のコメントの呼び出し
	    ThreadInSelectLogic threadInSelectLogic=new ThreadInSelectLogic();
	    String commentTableName=tablename.getName();
	    List<Comment> commentList=threadInSelectLogic.execute(commentTableName);
		HttpSession session3=request.getSession();
		session3.removeAttribute("commentList");
	    session3.setAttribute("commentList",commentList);

		RequestDispatcher d=request.getRequestDispatcher("WEB-INF/jsp/ThreadComment.jsp");
		d.forward(request,response);
	}

}
