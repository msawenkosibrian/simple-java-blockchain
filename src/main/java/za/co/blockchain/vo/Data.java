package za.co.blockchain.vo;

import org.json.simple.JSONObject;

/**
 * @author Msawenkosi Ntuli
 *
 */
public class Data {

	private String from;
	private String to;
	private float amount;
	private float balance;
	
	public String getFrom() {
		
		return from;
	}
	public void setFrom(String from) {
		
		this.from = from;
	}
	
	public String getTo() {
		
		return to;
	}
	
	public void setTo(String to) {
		
		this.to = to;
	}
	
	public float getAmount() {
		
		return amount;
	}
	
	public void setAmount(float amount) {
		
		this.amount = amount;
	}
	
	public float getBalance() {
		
		return balance;
	}
	
	public void setBalance(float balance) {
		
		this.balance = balance;
	}	
	
	@Override
	public String toString() {
		
		JSONObject obj = new JSONObject();
		obj.put("from", from);
		obj.put("to", to);
		obj.put("amount", new Float(amount));
		obj.put("balance", new Float(balance));
		return obj.toJSONString();
	}
}
