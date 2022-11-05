package dao.impl;

import java.rmi.RemoteException;

import Entity.Employee;
import Util.HibernateUtil;
import dao.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDaoImpl implements EmployeeDAO {
	private EntityManager entityManager;
	EntityTransaction entityTransaction;

	public EmployeeDaoImpl() {
		this.entityManager = HibernateUtil.getInstance().getEntityManager();
	}

	public boolean createEmployee(Employee employee) throws RemoteException {
		entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws RemoteException {
		entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Employee temp = entityManager.find(Employee.class, employee.getId());
			temp.setFistName(employee.getFistName());
			temp.setLastName(employee.getLastName());
			entityManager.merge(temp);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}

		return false;

	}

	@Override
	public Employee getEmployee(int id) throws RemoteException {
		entityTransaction = entityManager.getTransaction();
		Employee employee = null;
		try {
			entityTransaction.begin();
			employee = entityManager.find(Employee.class, id);
			entityTransaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			entityTransaction.rollback();
		}
		return employee;
	}

	@Override
	public boolean delete(int id) throws RemoteException {
		entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			Employee emp = entityManager.find(Employee.class, id);
			entityManager.remove(emp);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		} finally {
			entityManager.close();
		}

		return false;
	}

}
