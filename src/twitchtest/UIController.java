/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author 2
 */
public class UIController implements Initializable {

    @FXML
    private Label timeLbl;
    private static int SecondsPassed;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //TODO
     
    }
    
    public void setTimeTxt(String s){
        timeLbl.setText(s);
    }



 
    
}
