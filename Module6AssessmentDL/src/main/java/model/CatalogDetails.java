/**
 * Author: Daniel Lebedev - dalebedev 
 * Description: XXX
 * CIS 175 - Spring 2024
 * Feb 22, 2024
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CatalogDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	private String listName;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private User user;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<ListItem> listOfItems;
	
	public CatalogDetails() {
		super();
	}
	
	public CatalogDetails(int id, String listName, User user, List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.user = user;
		this.listOfItems = listOfItems;
	}
	
	public CatalogDetails(String listName,  User user, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.user = user;
		this.listOfItems = listOfItems;
	}
	
	public CatalogDetails(String listName,  User user) {
		super();
		this.listName = listName;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ListItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	@Override
	public String toString() {
		return "CatalogDetails [id=" + id + ", listName=" + listName + ", user=" + user + ", listOfItems=" + listOfItems + "]";
	}
	
}