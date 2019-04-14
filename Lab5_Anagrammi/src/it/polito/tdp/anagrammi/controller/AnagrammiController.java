package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtScorretti;

    @FXML
    private Button btnReset;

	private Model model;

    @FXML
    void doCalcola(ActionEvent event) {

    this.txtCorretti.clear();
    this.txtScorretti.clear();
    	
    String input = this.txtInput.getText().trim().toLowerCase();
    
    boolean ok = true;
    
    List <Character> listIn = new ArrayList <Character>(); 
    
    for(Character c : input.toCharArray() ) {
    	if(c>='a' && c<='z') {
    		listIn.add(c);
    	}
    	else {
    		ok=false;
    		break;
    	}
    }
    
    if(!ok) {
    	this.txtCorretti.setText("ERRORE! Inserire una parola, priva di caratteri numerici e speciali.");
    }
    
    else {
    	
         Map <String, Boolean> anagrammi = this.model.calcolaAnagramma(listIn);
         
         for( String s : anagrammi.keySet()) {
        	
        	 if(anagrammi.get(s))
        		 this.txtCorretti.appendText(s+"\n");
        	 
        	 else
        		 this.txtScorretti.appendText(s+"\n");
        	 
         }
         
         anagrammi.clear();
    	
    }
    
    }

    @FXML
    void doReset(ActionEvent event) {

    this.txtInput.clear();
    this.txtCorretti.clear();
    this.txtScorretti.clear();
    
    
    }

    @FXML
    void initialize() {
    	
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtScorretti != null : "fx:id=\"txtScorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;		
	}
}
