package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CatalogDetails;

/**
 * Servlet implementation class ViewAllCatalogsServlet
 */
@WebServlet("/ViewAllCatalogsServlet")
public class ViewAllCatalogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCatalogsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogDetailsHelper slh = new CatalogDetailsHelper();
		List<CatalogDetails> abc = slh.getCatalogs();
		
		request.setAttribute("allCatalogs", abc);
		
		if(abc.isEmpty()) {
			request.setAttribute("allCatalogs", " ");
		}
		
		getServletContext().getRequestDispatcher("/user-catalogs.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
