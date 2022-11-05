package Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class HibernateUtil {
	
	private static HibernateUtil instance = null;
	
	private EntityManager entityManager;

	public HibernateUtil() {
		entityManager = Persistence.createEntityManagerFactory("HibernateExample").createEntityManager();
	}
	public synchronized static HibernateUtil getInstance() {
		if(instance==null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	

}
