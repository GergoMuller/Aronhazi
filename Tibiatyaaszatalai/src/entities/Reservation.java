package entities;

public class Reservation {
	
	
	private String name;
	private int tableNumber;
	
	public Reservation(String name, int tableNumber){
		this.name=name;
		this.tableNumber = tableNumber;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
