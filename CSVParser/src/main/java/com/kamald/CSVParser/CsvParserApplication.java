package com.kamald.CSVParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kamald.CSVParser.service.OrderService;

@SpringBootApplication
public class CsvParserApplication implements CommandLineRunner {
	
	@Autowired
	OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(CsvParserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String input ="";
		String output ="";
		if(args.length == 2) {
			input = "../../" +args[0];
			input = args[0];
			output = args[1];
		}
		
		try {
			orderService.process(input, output);
			System.out.println("Process successfully....");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to process ....");
		}
		
		//System.out.println("test CsvParserApplication  command line ");
	}

}
