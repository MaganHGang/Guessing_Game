/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessmagan;

import javafx.application.Application;
//import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Magan
 */
public class GuessMagan extends Application 
{
    // Declare GUI Window variable 
    Stage Window; 
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        
        
        // Load the MagGame GUI window
        
        Window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("MagaGuessGUI.fxml"));      
        Window.setTitle("Guessing game");
        Window.setScene(new Scene(root,600,400));
        Window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
