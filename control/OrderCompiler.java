package control;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import objects.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.BusinessLayer;


public class OrderCompiler extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String address="OrderCheckout.jsp";
		BusinessLayer bl = BusinessLayer.getInstance();
		ArrayList<MenuItem> foods = new ArrayList<MenuItem>();
		try {
			foods = bl.getMenu();
		}
		catch(SQLException e) {
			req.setAttribute("error","SQLException occured");
		}catch (ClassNotFoundException e) {
			req.setAttribute("error","ClassNotFoundException occured");
		}
		req.setAttribute("foods",foods);
		//try this
		//req.getAttribute("foods");
		System.out.println(req.getParameter("id")+ "   yaya");
		req.setAttribute("customerID",req.getParameter("id"));
		double total = 0;
		
		for(int i=0;i<foods.size();i++) {
				if(req.getParameter("quantity"+i).equals("")) {
					continue;
				}
				if(Integer.parseInt(req.getParameter("quantity"+i))<0) {
					req.setAttribute("error", "no negative quantities");
					address="/OrderView.jsp";
					break;
				}
				total+= Integer.parseInt(req.getParameter("quantity"+i))*foods.get(i).getPrice();
				req.setAttribute("quantity"+i, req.getParameter("quantity"+i));
			}
		if(total==0) {
			req.setAttribute("error", "Please order something");
			address="/OrderView.jsp";
		}
		
		HttpSession s=req.getSession();
		Customer customer =(Customer) s.getAttribute("customer");
		total=total - total*customer.getDiscount();
		total=Math.floor(total*100)/100;
		req.setAttribute("total", total);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher(address);
		rd.forward(req, resp);
	}
}
