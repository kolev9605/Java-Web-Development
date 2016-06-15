package bg.jwd.beans;

import javax.ejb.Local;

@Local
public interface GlobalUserData {
	public String addClient(String id, Double initialAmount);
	public String displayClients();
	public String deposit(String id, Double amount);
	public String withdraw(String id, Double amount);
	public boolean hasAccount(String id);
	public String getCurrentClient(String id);
}
