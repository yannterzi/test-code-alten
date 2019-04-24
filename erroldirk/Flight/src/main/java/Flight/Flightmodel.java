package Flight;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Flightmodel {
	private Date departure;
	private String flightname;
	private HashMap<Date, String> myDatabase = new HashMap<Date, String>(); 
	

	DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
	
	public Flightmodel () {
		myDatabase = new HashMap<Date, String>(); 
	}
	
	
	public Flightmodel (String departure, String flightname){
		this.flightname = flightname;
		
		try {
			this.departure = this.timeFormat.parse(departure);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Incorrect time format. It should be: hh:mm a");
			e.printStackTrace();
		}
	}
	
	public Date getdeparture() {
		return this.departure;
	}
	public void setdeparture(String time) {
		try {
			this.departure = this.timeFormat.parse(time);
		} catch (ParseException e) {
			System.out.println("Incorrect time format. It should be: hh:mm a");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getflightname() {
		return this.flightname;
	}
	public void setflightname(String name) {
		this.flightname = name;
	}
	
	
	public void addflight(String departure, String flightname) {
		
		
		try {
			
			this.myDatabase.put(this.timeFormat.parse(departure), flightname);
			
		} catch (ParseException e) {
			System.out.println("Incorrect time format. It should be: hh:mm a");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public HashMap<String, String> findflight(String departure) {
		long difms,diffHours; 
		HashMap<String, String> temp = new HashMap<String, String>();
		
		
		try {
			Date time = this.timeFormat.parse(departure);
			
			for (Date i : myDatabase.keySet()) {
				
				difms = Math.abs (time.getTime() - i.getTime()); 
		        diffHours = difms / (60 * 60 * 1000) % 24;
		           
		           
		       if (diffHours<=5){
		    	   temp.put(this.timeFormat.format(i) ,myDatabase.get(i));
		       }
				}
			
		} catch (Exception e) {
			HashMap<String, String> exception =new HashMap<String, String>();
			exception.put("Exception",e.toString()+". Correct date format is \"hh:mm a\"");
			return exception;
		}
		
		
	
	return temp;	
	} 
	
    
    
    
    
    
    
    
    

}
