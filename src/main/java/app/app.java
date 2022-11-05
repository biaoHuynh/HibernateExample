package app;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import Entity.Employee;
import Entity.Project;
import dao.EmployeeDAO;
import dao.ProjectDAO;
import dao.impl.EmployeeDaoImpl;
import dao.impl.ProjectDaoImpl;

public class app {

	@SuppressWarnings("null")
	public static void main(String[] args) throws RemoteException {
		
		EmployeeDAO employeeDAO = new EmployeeDaoImpl();
		
		Employee employee = new Employee();
		employee.setFistName("Ha Thi Nhan");
		employee.setLastName("Hau");
		
		ProjectDAO projectDAO = new ProjectDaoImpl();
		
		Project project = new Project();
		project.setTitle("Do an thuc hanh phan tan");
		
		Set<Project> projects = new HashSet<Project>() ;
		projects.add(project);
		
		employee.setProjects(projects);
		
//		projectDAO.createProject(project);
		
		employeeDAO.createEmployee(employee);
		
//		employee.setId(1);
		
		
//		employeeDAO.createEmployee(employee);
//		employeeDAO.updateEmployee(employee);
//		employeeDAO.delete(1);
		
//		System.out.println(employeeDAO.getEmployee(1).getLastName());
		
	}

}
