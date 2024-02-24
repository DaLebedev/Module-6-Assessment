package controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class EditCatalogDetailsServlet
 */
@WebServlet("/EditCatalogDetailsServlet")
public class EditCatalogDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCatalogDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogDetailsHelper dao = new CatalogDetailsHelper();
		ListItemHelper lih = new ListItemHelper();
		UserHelper uh = new UserHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		CatalogDetails catalogToUpdate = dao.searchForCatalogDetailsById(tempId);
		
		String newListName = request.getParameter("listName");

		String userName = request.getParameter("userName");
		User newUser =uh.findUser(userName);
		
		try {
			String[] selectedMovies = request.getParameterValues("allItemsToAdd");
			List<ListItem> selectedMoviesInList = new ArrayList<ListItem>();
			
			for(int i = 0; i < selectedMovies.length; i++ ) {
				System.out.println(selectedMovies[i]);
				ListItem c = lih.searchMovieById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(c);
			}
			
			catalogToUpdate.setListOfItems(selectedMoviesInList);
			
		} 
		catch (NullPointerException ex) {
			List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
			catalogToUpdate.setListOfItems(selectedItemsInList);
		}
		
		catalogToUpdate.setListName(newListName);
		catalogToUpdate.setUser(newUser);
		
		dao.updateCatalog(catalogToUpdate);
		
		getServletContext().getRequestDispatcher("/ViewAllCatalogsServlet").forward(request, response);

	}

}
