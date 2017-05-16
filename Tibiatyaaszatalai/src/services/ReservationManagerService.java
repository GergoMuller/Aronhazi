package services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import entities.*;


@Stateful
@LocalBean
public class ReservationManagerService {

    private List<Reservation> reservations;
    private List<Table> tables;
    
    @PostConstruct
    private void init(){
    	tables = Stream.generate(Table::new).limit(15).collect(Collectors.toList());
    	int i=1;
    	for(Table t : tables){
    		t.setNumber(i++);
    	}
    }

	public List<Reservation> getReservations() {
		if(reservations == null)
			reservations = new ArrayList<>();
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public String reserveTable(String clientName, int tableNumber ){
		if(!tables.get(tableNumber-1).isBooked()){
			getReservations().add(new Reservation(clientName, tableNumber));
			tables.get(tableNumber-1).setBooked(true);
			return "Your reservation was successful";
		}
		else
			return "That table is already booked. Pleas try another one";
	}
	
	public List<Integer> getTableNumbers(){
		List<Integer> res = new ArrayList<>();
		for(Table t : tables){
			res.add(t.getNumber());
		}
		return res;
	}
	
	public List<Table> getTables(){
		return tables;
	}
    
    

}
