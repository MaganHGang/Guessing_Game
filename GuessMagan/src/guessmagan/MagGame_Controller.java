/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmagan;

/**
 *
 * @author Magan
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.util.Random;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
public class MagGame_Controller implements Initializable
{
    // instance variables for the game's GUI
    @FXML
    Button gameButton;
    
    @FXML
    Button submitB;
    
    @FXML
    Button quitB;
    
    @FXML
    RadioButton choiceButton1;
    
    @FXML
    RadioButton choiceButton2;
    
    @FXML
    RadioButton choiceButton3;
    
    @FXML
    TextField UserGuess;
    
    @FXML
    Label UserGuessN;
    
    @FXML
    Label NumGuessVal;
    
    
    
    // declare variables to store the computer's guess & highest value it can guess
    private static int GuessNum;
    
    private static int HighNum;
    
    private static int NumGuess;
    
    
    private static int numval; //user's guess 
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        Random r = new Random(); // computer thinks the number randomly.
        /* 
            Game starts when user picks the guessing game level = beginner, intermediate & advanced level
            Number range i.e. how many numbers the computer thinks of for the user to guess with  changes per level.
            
        */
        
        gameButton.setOnMouseReleased(e1 -> {
                                                // reset the game by removing old data
                                                NumGuess = 0;
                                                NumGuessVal.setText(Integer.toString(NumGuess));
                                                if(choiceButton1.isSelected())
                                                {

                                                     GuessNum = r.nextInt(10)+1;
                                                     HighNum = 10; // Highest number to guess.
                                                    
                                                    
                                                    // provent the radio buttons from being touched by accident
                                                    gameButton.setDisable(true);
                                                    choiceButton1.setDisable(true);
                                                    choiceButton2.setDisable(true);
                                                    choiceButton3.setDisable(true);
                                                    
                                                    // enable these GUI elements in case they were disabled
                                                    submitB.setDisable(false);
                                                    UserGuess.setDisable(false);
                                                    
                                                    
                                                }

                                                else if (choiceButton2.isSelected())
                                                {

                                                    GuessNum = r.nextInt(50)+1;
                                                    HighNum = 50;// Highest number to guess.
                                                    
                                                    
                                                    // provent the radio buttons from being touched by accident
                                                    gameButton.setDisable(true); 
                                                    choiceButton1.setDisable(true);
                                                    choiceButton2.setDisable(true);
                                                    choiceButton3.setDisable(true);
                                                    
                                                    // enable these GUI elements in case they were disabled
                                                    submitB.setDisable(false);
                                                    UserGuess.setDisable(false);
                                                    
                                                    
                                                    
                                                }
                                                else if (choiceButton3.isSelected())
                                                {

                                                    GuessNum = r.nextInt(100)+1;
                                                    HighNum = 100; // Highest number to guess.
                                                   
                                                    
                                                    // provent the radio buttons from being touched by accident
                                                    gameButton.setDisable(true);
                                                    choiceButton1.setDisable(true);
                                                    choiceButton2.setDisable(true);
                                                    choiceButton3.setDisable(true);
                                                    
                                                    // enable these GUI elements in case they were disabled
                                                    submitB.setDisable(false);
                                                    UserGuess.setDisable(false);
                                                    
                                                }
                                                else
                                                {
                                                    JOptionPane.showMessageDialog(null,"Press something!!");
                                                }
                                                
                                                
                                            });
        
       // Play the guessing game 
       
       submitB.setOnMouseReleased(e2 -> {
           
                                        // Check if the user type anything as their guess
                                        
                                        if (!UserGuess.getText().equals(""))
                                        {
                                            try
                                            {
                                                NumGuess++;
                                                NumGuessVal.setText(Integer.toString(NumGuess)); 

                                                //get the user's guess & check if it's correct
                                                numval = Integer.parseInt(UserGuess.getText());
                                                
                                                if (numval == GuessNum)
                                                {
                                                    JOptionPane.showMessageDialog(null, "Congrats!! You won in " + NumGuess + " guess(es)!!");
                                                    // Disable these GUI elements since the game is finished by that time
                                                    NumGuess = 0;
                                                    NumGuessVal.setText(Integer.toString(NumGuess)); 
                                                    submitB.setDisable(true);
                                                    UserGuess.setDisable(true);
                                                    UserGuessN.setText("You Guessed it!");
                                                    // reset number of guesses because the game ended
                                                    NumGuess = 0;
                                                    NumGuessVal.setText(Integer.toString(NumGuess)); 
                                                    
                                                    // Enable these GUI elements to play the game again 
                                                    gameButton.setDisable(false);
                                                    choiceButton1.setDisable(false);
                                                    choiceButton2.setDisable(false);
                                                    choiceButton3.setDisable(false);  
                                                }
                                                
                                                // if user's guess is incorrect then check how far they are from the correct answer & also check if their number is within the range
                                                
                                                else if (numval > GuessNum)
                                                {
                                                    UserGuessN.setText("Number too high");                                                   
                                                    if (numval > HighNum)
                                                    {
                                                        UserGuessN.setText("Number out of range");
                                                        
                                                    }
                                                    UserGuess.setFocusTraversable(true); // type the guess again.
                                                    
                                                }
                                                
                                                else if (numval < GuessNum)
                                                {
                                                    // if users' guess is close to the computer's number let the user know they are close
                                                    if(numval <= GuessNum -1 && numval >= GuessNum -3)
                                                    {
                                                        UserGuessN.setText("You're getting warmer!!");
                                                        UserGuess.setFocusTraversable(true); // type the guess again.
                                                        
                                                    }
                                                    else
                                                    {
                                                        UserGuessN.setText("Number too low");
                                                        if (numval < 1) 
                                                        {
                                                            JOptionPane.showMessageDialog(null, "you can't type numbers less than 1!!");
                                                        }
                                                        UserGuess.setFocusTraversable(true); // type the guess again.
                                                    }    
                                                }
                                            }

                                            catch (NumberFormatException e )
                                            {
                                                  JOptionPane.showMessageDialog(null,"Enter a number!!");
                                                  UserGuess.setFocusTraversable(true); // type the guess again.
                                                  
                                            }


                                        }
                                        
                                        else 
                                        {
                                            JOptionPane.showMessageDialog(null,"Make sure you type in your guess!!");
                                        }
       
                                     });
       // if the user quits the current game they can start again
        quitB.setOnMouseReleased(e3 -> {
                                            
                                            NumGuess = 0;
                                            NumGuessVal.setText(Integer.toString(NumGuess)); 
                                            UserGuess.setDisable(true);
                                            submitB.setDisable(true);
                                            // Enable these GUI elements to play the game again 
                                            gameButton.setDisable(false);
                                            choiceButton1.setDisable(false);
                                            choiceButton2.setDisable(false);
                                            choiceButton3.setDisable(false);
                                            
                                        });
        
    }

}