package dao.impl;

import java.rmi.RemoteException;

import Entity.Project;
import Util.HibernateUtil;
import dao.ProjectDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProjectDaoImpl implements ProjectDAO{
	private EntityManager entityManager;
	EntityTransaction entityTransaction;
	
	

	public ProjectDaoImpl() {
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	@Override
	public boolean createProject(Project project) throws RemoteException {
		entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(project);
			entityTransaction.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTransaction.rollback();
		}
		return false;
	}

}
