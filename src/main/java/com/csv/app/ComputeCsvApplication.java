package com.csv.app;


import java.io.BufferedWriter;
import java.io.File;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.util.HashMap;

import java.util.Map;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ComputeCsvApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ComputeCsvApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//readDataLineByLine("data.csv");
		read("data.csv");
	}
	
	public void read(String filePath) throws IOException {  Map<String, Double> map = new HashMap<String, Double>();
    try {
        Files.lines(Paths.get(filePath))
                .map(line -> line.split(",")).forEach(line -> {
                    String key = line[0];
                    String key2 = line[1];
                    String key3 = key+"-"+key2;
                    if (map.containsKey(key3)) {
                        Double oldValue = map.get(key3);
                        
                        double d = oldValue + Double.parseDouble(line[2]);
                        String str = String.format("%1.2f", d);
                        d = Double.valueOf(str);
                        map.put(key3, d);
                        writeFile(map);
                    } else {
                        map.put(key3, Double.parseDouble(line[2]));
                        writeFile(map);
                    }
                });
        
        map.forEach((k,v) -> System.out.println(k = k.replace('-', ',') + ", " +v));

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }}
	
	public void writeFile( Map<String, Double> map) {
		  final String outputFilePath  = "output.csv";
		
        // new file object
        File file = new File(outputFilePath);
  
        BufferedWriter bf = null;
  
        try {
  
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
  
            // iterate map entries
            for (Map.Entry<String, Double> entry :
                 map.entrySet()) {
  
                // put key and value separated by a colon
            	
                bf.write( entry.getKey().replace('-', ',') + ","
                         + entry.getValue());
  
                // new line
                bf.newLine();
            }
  
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
  
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }
	
	  
}
