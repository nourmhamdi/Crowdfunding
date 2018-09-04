package funding.cofunding.mBeans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * implementation class test
 */
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Cookie[] cookies = request.getCookies();
	        if (cookies != null) {
	            for (Cookie cookie : cookies) {
	                if (cookie.getName().equals("login")) {
	                    request.setAttribute("login", cookie.getValue());
	                }
	            }
	        }
	        this.getServletContext().getRequestDispatcher("login.jsf").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 String login = request.getParameter("login");
	        String password = request.getParameter("password");
	        
	        Cookie cookie = new Cookie("login", login);
	        cookie.setMaxAge(60 * 60 * 24 * 30);
	        response.addCookie(cookie);
	        
	        this.getServletContext().getRequestDispatcher("login.jsf").forward(request, response);
	    }
		//doGet(request, response);
	}


