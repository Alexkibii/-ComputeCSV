package com.csv.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComputeCsvApplicationTests {

	List<String[]> columnValues = new ArrayList<String[]>();

	@Before
	public void init(){
	    try {
	        Scanner scanner = new Scanner(new File("data.csv"));
	        while(scanner.hasNextLine()) {
	            String[] values = scanner.nextLine().split(",");
	            columnValues.add(values);
	        }
	    }catch(Exception e) {
	        //whatever
	    }
	}
	@Test
	public void myTest(){
	    //set x to 1 to avoid columns
	    for(int x = 1; x < columnValues.size(); x++) {
	        String col1 = columnValues.get(x)[0];
	        String col2 = columnValues.get(x)[1];
	        double col3 = Double.parseDouble(columnValues.get(x)[2]);
	       
	      System.out.println("Col1 :"+col1+", Col2 :"+col2+", Col3 :"+col3);
	    }
	}
	@Test
	void contextLoads() {
	}
	

}
