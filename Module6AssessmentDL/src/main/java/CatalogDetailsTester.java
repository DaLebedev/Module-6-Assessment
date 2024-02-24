import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CatalogDetailsHelper;
import controller.UserHelper;
import model.CatalogDetails;
import model.ListItem;
import model.User;

/**
 * Author: Daniel Lebedev - dalebedev 
 * CIS 175 - Spring 2024
 * Feb 22, 2024
 */

public class CatalogDetailsTester {
	public static void main(String[] args) {	
		
		User daniel = new User("Daniel");
		CatalogDetailsHelper cdh = new CatalogDetailsHelper();
	    ListItem johnWick = new ListItem("John Wick", "Chad Stahelski", "Action");
	    ListItem godfather = new ListItem("The Godfather", "Francis Ford Coppola", "Crime/Drama");
	    List<ListItem> cameronsItems = new ArrayList<ListItem>();
	    cameronsItems.add(johnWick);
	    cameronsItems.add(godfather);
	    
	    CatalogDetails cameronsList = new CatalogDetails("Daniel's Favorite Movies!", daniel);
	    cameronsList.setListOfItems(cameronsItems);
	    
	    cdh.insertNewCatalogDetails(cameronsList);
	    
	    List<CatalogDetails> allCatalogs = cdh.getCatalogs();
	    
	    for (CatalogDetails a : allCatalogs) {
	        System.out.println(a.toString());
	    }
	}
}
