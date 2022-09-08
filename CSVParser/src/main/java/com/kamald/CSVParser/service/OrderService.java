package com.kamald.CSVParser.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.kamald.CSVParser.bean.Order;
import com.kamald.CSVParser.enums.LineProcessStatus;
import com.kamald.CSVParser.enums.OrderIndexEnum;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

@Service
public class OrderService {
	
	public void process(String fileName, String outputFileName) {
		List<Order> orderList = null;
		
		//TODO: file validation like file type, output file name
		orderList = readCsvFile(fileName);
		try {
			writeJson(orderList, outputFileName);
		} catch (JsonIOException | IOException e) {
			System.out.println("Failed in writing json file");
			e.printStackTrace();
			//logger
		}
	}
	
	public List<Order> readCsvFile(String fileName) {
		
		List<Order> orderList =  new ArrayList<Order>();
		//InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
		InputStream is = getClass().getClassLoader().getSystemResourceAsStream(fileName);
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader reader = new CSVReaderBuilder(new InputStreamReader(is)).withCSVParser(parser).build();
		
		try {
            List<String[]> entries = reader.readAll();

            for (int i = 0; i < entries.size(); i++) {
                String[] entry = entries.get(i);
                Order order = new Order();
                try {
                	int rowId = i +1;
	                order.setId(Long.valueOf(rowId + ""));
	                order.setOrderId(Long.valueOf(entry[OrderIndexEnum.ORDER_ID.getIndex()].trim()));
	                order.setAmount(Double.valueOf(entry[OrderIndexEnum.AMOUNT.getIndex()]));
	                order.setCurrency(entry[OrderIndexEnum.CURRENCY.getIndex()]);
	                order.setComment(entry[OrderIndexEnum.COMMENT.getIndex()]);
	                order.setFileName(fileName);
	                order.setResult(LineProcessStatus.OK.name());
                } catch(Exception e) {
                	order.setResult(LineProcessStatus.FAILED.name());
                	//logging
                }
                orderList.add(order);
            }
        } catch (IOException | CsvException e) {
        	System.out.println("Failed in reading csv file");
            e.printStackTrace();
        }
		
		return orderList;
	}
	
	
	public void writeJson(List<Order> orderList, String outputFileName) throws JsonIOException, IOException {
		//Gson gson = new Gson();
		//gson.toJson(orderList.toArray(new Order[orderList.size()]), new FileWriter("order.json"));
		try (Writer writer = new FileWriter(outputFileName)) {
		    Gson gson = new GsonBuilder().create();
		    gson.toJson(orderList, writer);
		}
	}
}
