package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ReservationManagerService;


@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    private ReservationManagerService reservationService;
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String result;
    	String clientName = request.getParameter("clientName");
    	String tableNumberStr = request.getParameter("tableNumber");
    	if(clientName == null || clientName.equals("") || tableNumberStr == null || tableNumberStr.equals("")){
    		result = "Pleas enter your name and the table-number!";
    	}
    	else{
	    	Integer tableNumber = Integer.valueOf(request.getParameter("tableNumber"));
	    	
	    	result = reservationService.reserveTable(clientName, tableNumber);
    	}
	    request.setAttribute("reservations", reservationService.getReservations());
	    request.setAttribute("numbers",reservationService.getTableNumbers());
	    request.setAttribute("resultOfReservation", result);
	    request.setAttribute("tables", reservationService.getTables());
	    	
    	
		request.getRequestDispatcher("index.jsp").forward(request, response);
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
