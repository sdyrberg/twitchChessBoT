/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitchtest;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.jibble.pircbot.PircBot;


/**
 *
 * @author 2
 */
public class bo extends PircBot implements Initializable{
    
   
    private static final String channelName = "#mastershake5";
    private final String botName = "Does It Matter?";
    public String first,second,third,fourth;
    public ArrayList<String> ar = new ArrayList<String>();
    public int voteCount=0;
    public String currentHighMove=" No moves entered";
    public int secondsPassed;
    public int timeToMove = 30;
    int counter;
    public int A = 500, B = 590, C = 670, D = 760, E = 840, F = 930,G = 1010,H = 1100, newGameY = 1210, newGameX = 730,n1 = 840,n2 = 740,n3 = 650,n4 = 580,n5 = 490,n6 = 400,n7 = 330,n8 = 240;
    @FXML
    private Label timeLeft;
    @FXML
    private Label currentMove;
    public boolean firstMove=false;
    public boolean playingLichess = true;
    public boolean playingBlack = false;
    public boolean waitForNew = false;
    int timeLeft2v;
    public int streamDelay = 8;
    int timerMinusDelay;
    Map <String, String> playerMove = new HashMap<String,String>();
    Map <String, Integer> moveMap = new HashMap<String,Integer>();
    
    
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask(){
    
        
        
       
        
        public void run(){
            if(firstMove){
            secondsPassed++;
            int secondsPassedSince=0;
            if (secondsPassed > secondsPassedSince){
                timeLeft2v = timeToMove - secondsPassed;
                secondsPassedSince = secondsPassed;
                openFile();
                addToFile();
                closeFile();
                
            }
            
            
         if(waitForNew && secondsPassed == 1){
                try {
                    Robot robot = new Robot();
                    Random move = new Random();
                    
                   
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        waitForNew = false;
                    
                } catch (AWTException ex) {
                    Logger.getLogger(bo.class.getName()).log(Level.SEVERE, null, ex);
                }
            
         }
            if(secondsPassed == 25){
                if(currentHighMove.length() == 4 || currentHighMove.equals("!NEWGAME")) {
                sendMessage(getchannelName(),"Moving "+currentHighMove+" in 5 seconds");
                }
            }
            if(secondsPassed >= timeToMove){
                if(currentHighMove.length()!=0 && !currentHighMove.equals(" No moves entered")){
                    
                sendMessage(getchannelName(),"Move is " + currentHighMove + " with " + voteCount + " votes.");
                    try {
                        makeMove();
                        firstMove = false;
                    } catch (AWTException ex) {
                        Logger.getLogger(bo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                        playerMove.clear();
                        ar.clear();
                        secondsPassed = 0;
                        voteCount = 0;
                        currentHighMove = " No moves entered";
                        moveMap.clear();
                        timeLeft2v = 0;
                        openFile();
                        addToFile();
                        closeFile();
                
                        
                        
                    }
            }
        }
    };
            

    
    
   public void sendOutput(){
       timeLeft.setText(""+secondsPassed);
   }
    
    public void makeMove() throws AWTException{
        
        Robot robot = new Robot();
        Random move = new Random();
        int moveCounter = 0;
        if(playingBlack){
            
            n1 = 240;
            n2 = 330;
            n3 = 400;
            n4 = 490;
            n5 = 580;
            n6 = 650;
            n7 = 740;
            n8 = 840;
            H = 500; 
            G = 590;
            F = 670;
            E = 760;
            D = 840;
            C = 930;
            B = 1010;
            A = 1100;
        }
        if(playingLichess){
            newGameY = 1453; 
            newGameX = 567;
            if(playingBlack){
                n8 = 810;
                n7 = 710;
                n6 = 630;
                n5 = 540;
                n4 = 460;
                n3 = 370;
                n2 = 280;
                n1 = 190;
                H = 610;
                G = 700;
                F = 790;
                E = 880;
                D = 970;
                C = 1060;
                B = 1150;
                A = 1240;
                
            } else {
            
            n1 = 819;
            n2 = 710;
            n3 = 630;
            n4 = 540;
            n5 = 460;
            n6 = 370;
            n7 = 280;
            n8 = 190;
            A = 610;
            B = 700;
            C = 790;
            D = 880;
            E = 970;
            F = 1060;
            G = 1150;
            H = 1240;
            }
            
        }
        
        first = ""+currentHighMove.charAt(0);
        second = ""+currentHighMove.charAt(1);
        third = ""+currentHighMove.charAt(2);
        fourth = ""+currentHighMove.charAt(3);
        int moveLocation1=0,moveLocation2=0,moveLocation3=0,moveLocation4=0;
        
        if(currentHighMove.contains("!NEWGAME")){
            if(playingLichess){
                robot.mouseMove(newGameY, newGameX);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.mouseMove(newGameY+5, newGameX+5);
                secondsPassed = 0;
                waitForNew = true;
                if(playingBlack) {
                    playingBlack = false;
                    return;
                } else {
                    playingBlack = true;
                }
                return;
            }
                robot.mouseMove(newGameY, newGameX);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                robot.mouseMove(E, n4-20);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
      
        
         if(first.contains("A") || first.contains("a")){
           moveLocation1 = A;
       }
         if(first.contains("B")|| first.contains("b")){
           moveLocation1 = B;
       }
           if(first.contains("C")|| first.contains("c")){
           moveLocation1 = C;
       }
             if(first.contains("D")|| first.contains("d")){
           moveLocation1 = D;
       }
               if(first.contains("E")|| first.contains("e")){
           moveLocation1 = E;
       }
                 if(first.contains("F")|| first.contains("f")){
           moveLocation1 = F;
       }
                   if(first.contains("G")|| first.contains("g")){
           moveLocation1 = G;
       }
                     if(first.contains("H")|| first.contains("h")){
           moveLocation1 = H;
       }
                     
        if(third.contains("A")|| third.contains("a")){
           moveLocation3 = A;
       }
        if(third.contains("B")|| third.contains("b")){
           moveLocation3 = B;
       }
        if(third.contains("C")|| third.contains("c")){
           moveLocation3 = C;
       }
        if(third.contains("D")|| third.contains("d")){
           moveLocation3 = D;
       }
        if(third.contains("E")|| third.contains("e")){
           moveLocation3 = E;
       }
        if(third.contains("F")|| third.contains("f")){
           moveLocation3 = F;
       }
        if(third.contains("G")|| third.contains("g")){
           moveLocation3 = G;
       }
        if(third.contains("H")|| third.contains("h")){
           moveLocation3 = H;
       }
        
        
        if(fourth.contains("1")){
            moveLocation4 = n1;
        }
        if(fourth.contains("2")){
            moveLocation4 = n2;
        }
        if(fourth.contains("3")){
            moveLocation4 = n3;
        }
        if(fourth.contains("4")){
            moveLocation4 = n4;
        }
        if(fourth.contains("5")){
            moveLocation4 = n5;
        }
        if(fourth.contains("6")){
            moveLocation4 = n6;
        }
        if(fourth.contains("7")){
            moveLocation4 = n7;
        }
        if(fourth.contains("8")){
            moveLocation4 = n8;
        }
        if(second.contains("1")){
            moveLocation2 = n1;
        }
        if(second.contains("2")){
            moveLocation2 = n2;
        }
        if(second.contains("3")){
            moveLocation2 = n3;
        }
        if(second.contains("4")){
            moveLocation2 = n4;
        }
        if(second.contains("5")){
            moveLocation2 = n5;
        }
        if(second.contains("6")){
            moveLocation2 = n6;
        }
        if(second.contains("7")){
            moveLocation2 = n7;
        }
        if(second.contains("8")){
            moveLocation2 = n8;
        }

        
        robot.mouseMove(moveLocation1, moveLocation2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(moveLocation3, moveLocation4);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(moveLocation1, moveLocation2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(50,350);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        
    }

    public bo(){
        this.setName("UserName");
        this.isConnected();
        
    }
    
    public String getchannelName(){
        return channelName;
    }
    
    
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        
        if(message.length()==4 || message.contains("!newgame")){
        first = ""+message.charAt(0);
        second = ""+message.charAt(1);
        third = ""+message.charAt(2);
        fourth = ""+message.charAt(3);
        
        message = message.toUpperCase();
           if(message.matches("[A-H][1-8][A-H][1-8]") || message.matches("!NEWGAME")){
           
           if(!firstMove){
               secondsPassed = 0;
               firstMove = true;
               timeLeft2v = timeToMove - secondsPassed;
                
           }
           
           
          
           if(playerMove.containsKey(sender)) {
               
             if(playerMove.get(sender).matches(message)) {
                   int timeLeft2v = timeToMove - secondsPassed;
                   sendMessage(channel,sender + " Already voted for: "+message + " Time left to vote: " + timeLeft2v + " Seconds.");
                   
                   return;
               }
               
               String oldVote = playerMove.get(sender);
               int oldVoteCount = moveMap.get(oldVote);
               oldVoteCount--;
               moveMap.put(oldVote, oldVoteCount);
               
               if(moveMap.containsKey(message)) {
                   int newVoteCount = moveMap.get(message);
                   newVoteCount++;
                   moveMap.put(message, newVoteCount);
               } else {
                   moveMap.put(message, 1);
               }
               
               playerMove.put(sender,message);
               
               String winningMove ="ERROR";
               int tempVoteMaxCount = 0;
               
               for(String key: moveMap.keySet()){
                                      
                   int tempVoteCount  = moveMap.get(key);
                   if(tempVoteCount == tempVoteMaxCount){
                       Random rand = new Random();
                       int n = rand.nextInt(2)+1;
                       if(n==1){
                           tempVoteMaxCount = tempVoteCount;
                           winningMove = key;
                       }
                   }
                   if(tempVoteCount > tempVoteMaxCount){
                       tempVoteMaxCount = tempVoteCount;
                       winningMove = key;
                       
                   }
                   
               }
               currentHighMove = winningMove;
               voteCount = tempVoteMaxCount;
               openFile();
               addToFile();
               closeFile();

               timeLeft2v = timeToMove - secondsPassed;
                 sendMessage(channel,sender + " Changed vote to: "+message + ". " + " Time left to vote: " + timeLeft2v + " Seconds."/*+Collections.frequency(playerMove.values(),message) +" votes for " +
                     message + ". Current move is: "+currentHighMove + " With "  +voteCount+ " votes." + " Time left to vote: " + timeLeft2v + " Seconds."*/);
                 System.out.println(playerMove);
                 
           } else {
               
              /* if(playerMove.containsValue(message) && playerMove.containsKey(sender)){
                   int timeLeft2v = timeToMove - secondsPassed;
                   sendMessage(channel,sender + " Already voted for: "+message + " Time left to vote: " + timeLeft2v + " Seconds.");
                   
                   return;
               }
               */
               playerMove.put(sender, message);
               
               if(moveMap.containsKey(message)){
                   int voteInc = moveMap.get(message);
                   voteInc++;
                   moveMap.put(message, voteInc);
               } else {
                   moveMap.put(message, 1);
               }
               
              /* if(Collections.frequency(playerMove.values(),message)>voteCount){
                   voteCount = Collections.frequency(playerMove.values(),message);
                   currentHighMove = message; 
               }*/
              
              String winningMove ="ERROR";
               int tempVoteMaxCount = 0;
               
               for(String key: moveMap.keySet()){
                                      
                   int tempVoteCount  = moveMap.get(key);
                   if(tempVoteCount == tempVoteMaxCount){
                       Random rand = new Random();
                       int n = rand.nextInt(2)+1;
                       if(n==1){
                           tempVoteMaxCount = tempVoteCount;
                           winningMove = key;
                       }
                   }
                   if(tempVoteCount > tempVoteMaxCount){
                       tempVoteMaxCount = tempVoteCount;
                       winningMove = key;
                       
                   }
                   
               }
               currentHighMove = winningMove;
               voteCount = tempVoteMaxCount;
               openFile();
               addToFile();
               closeFile();
               
               
               timeLeft2v = timeToMove - secondsPassed;
                 sendMessage(channel,sender + " Voted for: "+message + ". " + " Time left to vote: " + timeLeft2v + " Seconds."/*+Collections.frequency(playerMove.values(),message) +" votes for " +
                     message + ". Winning move is: "+currentHighMove + " With "  +voteCount+ " votes." + " Time left to vote: " + timeLeft2v + " Seconds."*/);
                  System.out.println(playerMove);
           }
        } 
             
      
    }
        if(message.equalsIgnoreCase("!time")){
            String time = new java.util.Date().toString();
            sendMessage(channel,sender + ": The time is "+ time);
        }
        
        
        
        
      
        
    }
    
    protected void onJoin(String channel, String sender, String login, String hostname) {
    
        sendMessage(channel,"Welcome - try the twitch chess overlay - type moves from starting position to where you want them. If you want to play pawn E4 you should write E2E4.");
        
    
    }
    private Formatter highScoreTXT;
    
    public void openFile(){
        try{
            highScoreTXT = new Formatter("highscore.txt");
        }
        catch(Exception e){
            System.out.println("ERROR! ABORT!");
        }
    }
    public void addToFile(){
        int timerMinusDelay = timeLeft2v-streamDelay;
        if(timerMinusDelay <=0) {
            timerMinusDelay = 0;
        }
        if(!firstMove){
            highScoreTXT.format("%s", "                                                   No votes cast.");
        System.out.println("Writing to file");
        return;
        }
        if(timerMinusDelay <=0) {
            timerMinusDelay = 0;
            highScoreTXT.format("%s", "Winning move is: " + currentHighMove + " with " + voteCount + " votes. Time left: No more votes.");
        System.out.println("Writing to file");
        return;
        }
        highScoreTXT.format("%s", "Winning move is: " + currentHighMove + " with " + voteCount + " votes. Time left: " + timerMinusDelay);
        System.out.println("Writing to file");
    }
    public void closeFile(){
        highScoreTXT.close();
    }
    
    protected void onConnect(){
        System.out.println("Conntected");
        joinChannel(channelName);
        
        
        super.onConnect();
        sendMessage(getchannelName(),"HI, im here!");
         myTimer.scheduleAtFixedRate(task, 1000, 1000);
         
                    
    }
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
      openFile();
      addToFile();
      closeFile();
    }    

    @FXML
    private void startBtn(ActionEvent event) {
        timeLeft.setText("Hej");
    }
    
   
    
}
