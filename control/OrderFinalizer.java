package control;
import java.sql.*;
import java.util.Calendar;
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
import java.util.ArrayList;
public class OrderFinalizer extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address = "/OrderPendingView.jsp";
		//Order order = req.getAttribute("order");
		HttpSession s=req.getSession();
		ArrayList<Food_Order> FO = (ArrayList<Food_Order>)s.getAttribute("FO");
		
		if(req.getParameter("restart")!=null) {
			address="/OrderView.jsp";
		}
		if(req.getParameter("checkout")!=null) {
			Order order = new Order();
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			java.sql.Time time = new Time(System.currentTimeMillis());
			String temp = (String)req.getParameter("id");
			System.out.println("temp"+temp);
			int customerID =Integer.valueOf((String)req.getParameter("id"));
			order.newOrder(date, time, customerID);
			order.setStatus("online-pending",order.getorderID());
			for(Food_Order f: FO) {
				f.setorderID(order.getorderID());
				System.out.println("menuitemID "+f.getmenuitemID()+" orderid "+f.getorderID()+" quantity "+f.getQuantity());
				f.newFoodOrder(f.getmenuitemID(), f.getorderID(), f.getQuantity());
			}
			order.calculatePrice(order.getorderID());
			
			s.setAttribute("order", order);
			address="/OrderPendingView.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(address);
		rd.forward(req, resp);
		
	}
}