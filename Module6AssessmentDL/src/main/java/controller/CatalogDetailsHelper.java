/**
 * Author: Daniel Lebedev - dalebedev 
 * Description: XXX
 * CIS 175 - Spring 2024
 * Feb 22, 2024
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CatalogDetails;

public class CatalogDetailsHelper {

	static EntityManagerFactory emfactory = 
	Persistence.createEntityManagerFactory("Module6AssessmentDL");
	
	public void insertNewCatalogDetails(CatalogDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CatalogDetails> getCatalogs() {
		EntityManager em = emfactory.createEntityManager();
		List<CatalogDetails> allDetails = em.createQuery
				("SELECT d FROM CatalogDetails d").getResultList();
		return allDetails;
	}
	
	public CatalogDetails searchForCatalogDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CatalogDetails found = em.find(CatalogDetails.class, tempId);
		return found;
	}
	
	public void deleteCatalog(CatalogDetails toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CatalogDetails> typedQuery = em.createQuery
				("SELECT detail FROM CatalogDetails detail WHERE detail.id = :selectedId", CatalogDetails.class);
		
		// Substitute parameter with actual data from listToDelete
		typedQuery.setParameter("selectedId", toDelete.getId());
		
		// Only one result allowed
		typedQuery.setMaxResults(1);
		
		// Gets query result and saves it to new list item
		CatalogDetails result = typedQuery.getSingleResult();
		
		// Remove list
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public void updateCatalog(CatalogDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
