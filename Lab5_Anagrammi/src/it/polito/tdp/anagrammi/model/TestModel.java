package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TestModel {

    	Model model = new Model();
    	
    	List <Character> inPut = new ArrayList <Character>();
    	
    	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		TestModel test = new TestModel();
		
		test.run();
	}

	

	public void run() {
		
		this.inPut.add('e');
		this.inPut.add('g');
		this.inPut.add('g');
		
	Map <String, Boolean> ris =  model.calcolaAnagramma(this.inPut);
		
	  System.out.println(ris.keySet());

	}
	
}
