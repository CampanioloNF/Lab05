package it.polito.tdp.anagrammi.model;


import java.util.LinkedList;
import java.util.List;


public class Parola {

	private int size;
	private List<Integer> mappaCaratteri;
	
	public Parola(int size) {
		
		this.size=size;
        this.mappaCaratteri = new LinkedList <Integer>();
		
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(Integer n) {
		mappaCaratteri.add(n);
	}
	

	public void remove(int i) {
		this.mappaCaratteri.remove(new Integer(i)) ;
	}
	
	public boolean contains(int i) {
		return this.mappaCaratteri.contains(i);
	}
	
	public List<Integer> getParola(){
		return this.mappaCaratteri;
	}

}
