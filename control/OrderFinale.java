package control;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.ArrayList;
import objects.*;

public class OrderFinale extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = "/OrderCompleteView.jsp";
		HttpSession s =req.getSession();
		Order order = (Order)s.getAttribute("order");
		order.setStatus("online-complete",order.getorderID());
		
		RequestDispatcher rd = req.getRequestDispatcher(address);
		rd.forward(req, resp);
	}
}