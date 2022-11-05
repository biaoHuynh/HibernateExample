package dao;

import java.rmi.RemoteException;

import Entity.Project;

public interface ProjectDAO {
	public boolean createProject(Project project) throws RemoteException; 
}
