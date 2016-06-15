package bg.jwd.entities;

public class Client {
	private String clientId;
	private Double balance;
	
	public Client(String clientId, Double balance) {
		this.setBalance(balance);
		this.setClientId(clientId);
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("Client with id: %s has balance of %.2f", this.getClientId(), this.getBalance());
	}
	
	
}
