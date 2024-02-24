/**
 * Author: Daniel Lebedev - dalebedev 
 * Description: XXX
 * CIS 175 - Spring 2024
 * Feb 22, 2024
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="USERNAME")
	private String userName;
	
	public User() {
		super();
	}
	
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public User(String userName) {
		super();
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", userName=" + userName + "]";
	}
	
}
