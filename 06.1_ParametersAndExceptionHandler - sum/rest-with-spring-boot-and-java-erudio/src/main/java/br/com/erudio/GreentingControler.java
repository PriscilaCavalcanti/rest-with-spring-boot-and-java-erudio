package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class GreentingControler {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); //Mock um ID
	
	@RequestMapping("/greenting")
	public Greenting greenting(@RequestParam(value = "name", defaultValue = "World")String name) {
		
		return new Greenting(counter.incrementAndGet(),String.format(template, name));
	}
	
	//Url de Teste Postman : http://localhost:8080/greenting?name=Pri
}
