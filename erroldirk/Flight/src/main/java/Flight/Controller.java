package Flight;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	Flightmodel model = new Flightmodel();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
		Home mainpage =new Home();
		String st = mainpage.home;

    	return st;
    }
    	
    
    
    	
    	 
    
    
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
    	model.addflight("7:30 AM", "Air Canada 8099");
    	model.addflight("10:30 AM", "United Airline 6115");
    	model.addflight("12:30 PM", "WestJet 6456");
    	model.addflight("3:00 PM", "Delta 3833");
    return "Data has been added";
    }
    
    @RequestMapping(path = "/find/{departure}", method = RequestMethod.GET)
    @ResponseBody
    
    public HashMap<String, String> find(@PathVariable String departure) {
    	
    	try {
    		return model.findflight(departure);
    		
		} catch (Exception e) {
			HashMap<String, String> exception =new HashMap<String, String>();
			exception.put("Exception ",e.toString()+". Correct date format is \"hh:mm a\"");	return exception;
		}
    	
    	
    }
    /*
    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/greeting")
    public Flightmodel greetings(@RequestParam(value="name", defaultValue="World") String name) {
        return new Flightmodel(counter.incrementAndGet(),
                            String.format(template, name));
    }

*/


}
