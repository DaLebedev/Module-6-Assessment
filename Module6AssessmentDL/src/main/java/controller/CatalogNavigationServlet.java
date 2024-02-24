package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CatalogDetails;

/**
 * Servlet implementation class CatalogNavigationServlet
 */
@WebServlet("/CatalogNavigationServlet")
public class CatalogNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogDetailsHelper dao = new CatalogDetailsHelper();
		String act = request.getParameter("doThisToCatalog");
	
		if (act == null) {
			getServletContext().getRequestDispatcher("/ViewAllCatalogsServlet").forward(request, response);
		} 
		
		else if (act.equals("delete")) {
			
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CatalogDetails catalogToDelete = dao.searchForCatalogDetailsById(tempId);
				dao.deleteCatalog(catalogToDelete);
			} 
			catch(NumberFormatException e) {
				System.out.println("Forgot to click a button!");
			} 
			finally {
				getServletContext().getRequestDispatcher("/ViewAllCatalogsServlet").forward(request, response);
			}
		} 
		
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CatalogDetails listToEdit = dao.searchForCatalogDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);

				
				ListItemHelper daoForItems = new ListItemHelper();
				
				request.setAttribute("allItems", daoForItems.showAllMovies());
				
				if(daoForItems.showAllMovies().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				
				getServletContext().getRequestDispatcher("/edit-catalog.jsp").forward(request, response);
			
			} 
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllCatalogsServlet").forward(request, response);
			}
		} 
		
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/AddMoviesToCatalogServlet").forward(request, response);
		}
		
		
	}

}
