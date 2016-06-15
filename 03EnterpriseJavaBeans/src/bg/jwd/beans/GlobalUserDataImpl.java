package bg.jwd.beans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import bg.jwd.entities.Client;

@Startup
@Singleton
@LocalBean
public class GlobalUserDataImpl implements GlobalUserData {
	private Map<String, Client> usersData;

	@PostConstruct
	public void init() {
		this.usersData = new LinkedHashMap<String, Client>();
	}

	@Override
	public String addClient(String id, Double initialAmount) {
		if (!this.usersData.containsKey(id)) {
			if (initialAmount < 0) {
				return String.format("Initial amount cannot be negative number.%n");
			} else {
				Client newClient = new Client(id, initialAmount);
				this.usersData.put(id, newClient);
				return String.format("Client with ID %s and bank amount of %.2f has been added successfully.%n", id,
						initialAmount);
			}
		} else {
			return String.format("Welcome back %s!%n", id);
		}
	}

	@Override
	public String displayClients() {
		StringBuilder builder = new StringBuilder();
		this.usersData.keySet().stream().forEach(
				x -> builder.append(toString().format("Client with id %s has %.2f.%n", x, this.usersData.get(x).getBalance())));

		return builder.toString();
	}

	@Override
	public String deposit(String id, Double amount) {
		if (!this.usersData.containsKey(id)) {
			return String.format("Client with ID %s does not exist.%n", id);
		}

		if (amount < 0) {
			return String.format("Amount cannot be negative number.%n");
		}

		double currentAmount = this.usersData.get(id).getBalance();
		this.usersData.get(id).setBalance(currentAmount + amount);

		return String.format("%.2f was successfully deposited to client %s.%n", amount, id);
	}

	@Override
	public String withdraw(String id, Double amount) {
		if (!this.usersData.containsKey(id)) {
			return String.format("Client with ID %s does not exist.%n", id);
		}

		if (amount < 0) {
			return String.format("Amount cannot be negative number.%n");
		}

		double currentAmount = this.usersData.get(id).getBalance();
		if (currentAmount - amount < 0) {
			return String.format("Insufficient bank balance.%n");
		}

		if (amount > currentAmount / 2) {
			return String.format("You cannot withdraw more than the half of you current balance (%.2f).%n", currentAmount);
		}

		this.usersData.get(id).setBalance(currentAmount - amount);
		
		return String.format("Withdraw was successful.%n");
	}
	
	@Override
	public boolean hasAccount(String id) {
		return this.usersData.containsKey(id);
	}
	
	@Override
	public String getCurrentClient(String id) {
		if(this.usersData.containsKey(id)) {
			return this.usersData.get(id).toString();
		} else {
			return "No logged in user";
		}
	}
}