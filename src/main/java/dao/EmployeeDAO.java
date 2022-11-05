package dao;

import java.rmi.RemoteException;

import Entity.Employee;

public interface EmployeeDAO {
	public boolean createEmployee(Employee employee) throws RemoteException; 
	
	public boolean updateEmployee(Employee employee) throws RemoteException;
	
	public Employee getEmployee(int id) throws RemoteException;
	
	public boolean delete(int id) throws RemoteException;
}
