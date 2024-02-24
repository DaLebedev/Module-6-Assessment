package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CatalogDetails;
import model.ListItem;
import model.User;

/**
 * Servlet implementation class CreateNewCatalogServlet
 */
@WebServlet("/CreateNewCatalogServlet")
public class CreateNewCatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListItemHelper lih = new ListItemHelper();
		String listName = request.getParameter("listName");
		System.out.println("Catalog Name: " + listName);
		
		String userName = request.getParameter("userName");
		
		String [] selectedMovies = request.getParameterValues("allItemsToAdd");
		List<ListItem> selectedMoviesInList = new ArrayList<ListItem>();
		
		if (selectedMovies != null && selectedMovies.length > 0) {
			
			for (int i=0; i<selectedMovies.length; i++) {
				System.out.println(selectedMovies[i]);
				
				ListItem c = lih.searchMovieById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(c);
			}
		}
		
		User user = new User(userName);
		CatalogDetails sld = new CatalogDetails(listName, user);
		
		sld.setListOfItems(selectedMoviesInList);
		CatalogDetailsHelper slh = new CatalogDetailsHelper();
		slh.insertNewCatalogDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());

		getServletContext().getRequestDispatcher("/ViewAllCatalogsServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
