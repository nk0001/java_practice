package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("/index.jsp");
		}

		ServletContext application = this.getServletContext();
		List<Mutter> list = (List<Mutter>)application.getAttribute("list");

		if(list == null) {
			list = new ArrayList<Mutter>();
			application.setAttribute("list", list);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		ServletContext application = this.getServletContext();
		List<Mutter> list = (List<Mutter>)application.getAttribute("list");

		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		Mutter mutter = new Mutter(user.getName(), text);

		if(text == null || "".equals(text)) {
			request.setAttribute("error", "1");
		}
		else {
			PostMutterLogic logic = new PostMutterLogic();
			logic.post(list, mutter);
			application.setAttribute("list", list);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/main.jsp");
		dispatcher.forward(request, response);
	}

}
