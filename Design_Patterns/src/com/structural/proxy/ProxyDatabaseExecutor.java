package com.structural.proxy;

public class ProxyDatabaseExecutor implements DatabaseExecutor{

	boolean ifAdmin;
	DatabaseExecutor dataExecutor;
		
	public ProxyDatabaseExecutor(String userName, String password) {
		if(getUserRole(userName,password)) {
			ifAdmin=true;
			dataExecutor= new DatabaseExecutorIml();
		}		
	}

	private boolean getUserRole(String userName, String password) {
		// DB call to fetch the role
		return true;
	}

	@Override
	public void executeDbQuery(String query) throws Exception {
		if(ifAdmin) {
			dataExecutor.executeDbQuery(query);
		} else {
			if(query.startsWith("delete")) {
				throw new Exception("Only Admin user is permitted to execute delete query");
			}
		}
		
	}

}

interface DatabaseExecutor{
	public void executeDbQuery(String query) throws Exception;
}

class DatabaseExecutorIml implements DatabaseExecutor{

	@Override
	public void executeDbQuery(String query) {
		System.out.println("Executing the query " + query);		
	}
	
}