/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchtest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jibble.pircbot.IrcException;

/**
 *
 * @author 2
 */
public class TwitchTest extends Application {
    
    
    
    private static final String OAUTH = "oauth:50inr108frffwfcc11yl4ax86ui1f9";
    private static final String ADRESS = "irc.chat.twitch.tv.";
    private static final int PORT = 6667;
    
      @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {

        bo bot = new bo();

        bot.setVerbose(true);

        try {

            bot.connect(ADRESS, PORT, OAUTH);
            //  bot.onMessage(channelName, "Bot", channelName, channelName, channelName);
        } catch (IOException ex) {
            Logger.getLogger(TwitchTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IrcException ex) {
            Logger.getLogger(TwitchTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         launch(args);
        

    }

 
}
