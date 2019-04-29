//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
// Title: P5 Project JavaFX
// Files: Main.java, Application
// Course: CS-400, Spring 2019
//
// Author: Yaseen Najeeb
// Email: ynajeeb@wisc.edu
// Lecturer's Name: Debra Deppeler
// Other Source Credits: Stack Overflow input
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
package application;
    
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This is the main method-runs JavaFX app
 * @author Yaseen Najeeb
 *
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try { 
            
            //Border Pane
            BorderPane root = new BorderPane();
            
            //Button
            Button button_One = new Button("Finish");
            button_One.setOnAction(event -> {
                Platform.exit();
            });
     
            
            //Multiple choice 
            
            
            Label labelQuestion= new Label("Question #1");
            Label labelfirst= new Label("What type of dinosaur is this?");
            Label labelresponse= new Label();
                    

            Button button= new Button("Submit");

            RadioButton radio1, radio2, radio3, radio4;
            radio1=new RadioButton("Tyranasaurus Rex");
            radio2= new RadioButton("T-Mex");
            radio3= new RadioButton("Saurus X");
            radio4= new RadioButton("Velociraptor");

            
          //Image
            ImageView newImage_One = new ImageView("image2.png");
            newImage_One.setFitHeight(500);
            newImage_One.setFitWidth(400);
            
           
            
          //TextArea
            TextArea textArea_One = new TextArea();
            textArea_One.setPrefHeight(300); //sets height of TextArea to 300  
            textArea_One.setPrefWidth(10);    //sets width of TextArea to 10
            textArea_One.setText("To destroy is still the strongest instinct in nature.\n" + 
                "Max Beerbohm\r\n");
            String text= textArea_One.getText();
                  
           
            
            //VBOX
            VBox someBox = new VBox();
            //someBox.setSpacing(20);
            //someBox.setPadding(new Insets(15,20,20,10));
            root.setCenter(someBox);
            BorderPane.setAlignment(someBox, Pos.CENTER);
            someBox.getChildren().addAll(newImage_One, labelQuestion);
            someBox.getChildren().addAll(labelfirst, radio1, radio2, radio3, radio4, button, labelresponse);
            
            
            Scene scene = new Scene(root,1000,900);
            
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Yaseen's First JavaFX program");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
