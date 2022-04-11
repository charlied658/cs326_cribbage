package edu.skidmore.cs326.spring2022.skribbage.persistence;

import java.util.ArrayList;


import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;




public class UsernameProxy {
	
 	
 
 private static final String PROPERTY_FILE_NAME = "database.properties";


	
	private static final UsernameProxy INSTANCE;
	
	static {
		INSTANCE = new UsernameProxy();
	}
	
	
	public static UsernameProxy getInstance() {
		return INSTANCE;
	}

	
	//temporary method to parse usernames from file
	private ArrayList parseString() {
		String path = "/students/home/tmawocha/eclipse-workspace/SkribbageBattleRoyale/src/java/edu/skidmore/cs326/spring2022/skribbage/persistence/BadNicknames";
				
		File file = new File(path);
		Scanner sc = null;
		String tempbadname = "";
		int lastUsed = 0;
		
		String pattern = "(\\$)(\\d+).*";
		String emptySpace = "^\\s+(.*)";
		
		Pattern p = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Pattern emp = Pattern.compile(emptySpace, Pattern.CASE_INSENSITIVE);
		
		ArrayList toPrint = new ArrayList();
		
		
		try {
			
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	 
		toPrint.clear();
		
	    while (sc.hasNextLine()) {
	    
	     tempbadname = sc.nextLine();
	    		
	    if(tempbadname.contains("$") == true ) {
	    	
	    	System.out.println(tempbadname);
	    	Matcher matcher = p.matcher(tempbadname);
	    	matcher.find();
	    	lastUsed = Integer.parseInt( matcher.group(2));  	
	    	toPrint.add(tempbadname); 	
	    	
	    } else {
	    	
	    	Matcher matcher = emp.matcher(tempbadname);
	    	
	    	if(matcher.find()) {    	
		    	tempbadname = matcher.group(1);	    		
	    	}  	
	    	    	
	    	lastUsed += 1;
	    	String process = "$" + lastUsed + " = " + tempbadname;
	    	toPrint.add(process);
	        	
	    }
		
	    }
		
		
		return toPrint;
	}
	

	//must be generalized to accept any number of banned words
	private boolean usernameCheck(String username) {
		
		   Boolean usernameIsGood = true;
		   FileInputStream file = null;
		   Properties prop = null;
		   String filePath = "/students/home/tmawocha/eclipse-workspace/SkribbageBattleRoyale/src/java/edu/skidmore/cs326/spring2022/skribbage/persistence/badnicknames.properties";
		 try  {

			   
			   file = new FileInputStream(filePath);
			   prop = new Properties();
			 

	            if (file == null) {
	                System.out.println("Sorry, unable to find config.properties");
	                return false;
	            }

	          
	           
	            prop.load(file);
	            //get the property value and print it out
	          
	            for (int i = 1; i < 452; i++) {
	            	String altProp = "$" + i;   
	            	
	            	String tempban = prop.getProperty(altProp);
	            	tempban = tempban.trim();
	            	
	    			if(username.contains(tempban) ) {
	    				usernameIsGood  = false;
	    			}
	    		}
	          
	  

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
		
		return usernameIsGood;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		
		UsernameProxy instance = new UsernameProxy();
		
		System.out.println(instance.usernameCheck("naughtynicknam"));
		System.out.println(instance.usernameCheck("fuck"));
		
	
		
		
		 
	}
}
