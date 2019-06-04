package it.polito.tdp.anagrammi.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	private Map<String, Boolean> soluzioni = new HashMap<String, Boolean>();
	private AnagrammaDAO dao = new AnagrammaDAO();
	
	
	public Map<String, Boolean> calcolaAnagramma(List<Character> listIn) {
		
		Parola parziale = new Parola(listIn.size());
		
		cerca(parziale, 0, listIn);
		
		return soluzioni;
	}
    /*
     * Una possibile alternativa consiste nel mandare al DAO una lista di parole,
     * Corrispondente agli anagrammi che verranno controllati in un unica connessione (?)
     * 
     */
	
	private void cerca(Parola parziale, int L, List<Character> listIn) {
		
	    //Condizioni terminali 
		
		/*
		 * La ricorsione termina nel caso in cui si raggiumga 
		 * il livello L pari al numero di Character contenuti nella parola (m) 
		 */
		
		if(L==parziale.getSize()) {
			
			String s ="";
			
			for(Integer i : parziale.getParola())
				s+=listIn.get(i);
			
			
			if(!soluzioni.containsKey(s)) {
				soluzioni.put(s,dao.isCorrect(s));
			   // System.out.println(s);
			}
			    
		
			
		}
		
		//Caso generico
		
		/*
		 * Uso il for per generare una permutazione
		 */
		
		for(int i=0; i<parziale.getSize(); i++) {
			
			if(!parziale.contains(i)) {
				
				
				// aggiungo
				
				parziale.add(i);
				
				// ricorsione
				
				this.cerca(parziale, L+1, listIn);
				
				// rimuovo
				
			    parziale.remove(i);
			}
			
		}
	}


	
}
