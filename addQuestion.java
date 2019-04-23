package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class addQuestion extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			//creating a text field 
			TextField textField = new TextField();       

			
			TextField question = new TextField("");
			Label questionLabel = new Label("Question: ");
			Button button= new Button("Submit");
			Label choiceLabel = new Label("Correct Choice? ");

			RadioButton radio1, radio2, radio3, radio4, radio5;
			radio1=new RadioButton("Choice 1: ");
			radio2= new RadioButton("Choice 2: ");
			radio3= new RadioButton("Choice 3: ");
			radio4= new RadioButton("Choice 4: ");
			radio5= new RadioButton("Choice 5: ");
			
			TextField choice1, choice2, choice3, choice4, choice5;
			choice1 = new TextField("");
			choice2 = new TextField("");
			choice3 = new TextField("");
			choice4 = new TextField("");
			choice5 = new TextField("");

			ToggleGroup question1= new ToggleGroup();

			radio1.setToggleGroup(question1);
			radio2.setToggleGroup(question1);
			radio3.setToggleGroup(question1);
			radio4.setToggleGroup(question1);
			radio5.setToggleGroup(question1);


			button.setDisable(true);

			radio1.setOnAction(e -> button.setDisable(false) );
			radio2.setOnAction(e -> button.setDisable(false) );
			radio3.setOnAction(e -> button.setDisable(false) );
			radio4.setOnAction(e -> button.setDisable(false) );
			radio5.setOnAction(e -> button.setDisable(false) );


	


			//Instantiating the VBox class  
			VBox vBox = new VBox();   
			VBox vBox2 = new VBox();
			VBox vBox3 = new VBox();
			HBox hBox = new HBox();

			
			//Setting the space between the nodes of a VBox pane 
			vBox.setSpacing(10);   
			ComboBox<String> comboBox = new ComboBox<String>();
			comboBox.setPromptText("Topic: ");
			comboBox.getItems().addAll("Topic 1", "Topic 2", "Topic 3","Topic 4", "Type Topic Here");
			comboBox.setEditable(true);
//
//			//Setting the margin to the nodes 
//			vBox.setMargin(comboBox, new Insets(0, 100, 10, 100));  
//			vBox.setMargin(question, new Insets(10, 20, 20, 20)); 
////			vBox.setMargin(choiceLabel, new Insets(0, 20, 0, 20));
////			vBox.setMargin(radio1, new Insets(0, 20, 0, 20)); 
////			vBox.setMargin(radio2, new Insets(0, 20, 0, 20)); 
////			vBox.setMargin(radio3, new Insets(0, 20, 0, 20)); 
////			vBox.setMargin(radio4, new Insets(0, 20, 0, 20)); 
////			vBox.setMargin(radio5, new Insets(0, 20, 0, 20)); 

			
			root.setTop(comboBox);

			//retrieving the observable list of the VBox 
			VBox container = new VBox();
			VBox correct = new VBox();
			VBox answer = new VBox();
			HBox choices = new HBox();
			HBox saveOption = new HBox();
			Button addMoreQ = new Button("Add More Questions");
			Button save = new Button("Save");
			saveOption.getChildren().addAll(save, addMoreQ);
			choices.getChildren().addAll(correct, answer);
			correct.getChildren().addAll(radio1,radio2,radio3,radio4,radio5);
			answer.getChildren().addAll(choice1,choice2,choice3,choice4,choice5);
		correct.setMargin(radio1, new Insets(10, 20, 0, 20)); 
		correct.setMargin(radio2, new Insets(10, 20, 0, 20)); 
		correct.setMargin(radio3, new Insets(10, 20, 0, 20)); 
		correct.setMargin(radio4, new Insets(10, 20, 0, 20)); 
		correct.setMargin(radio5, new Insets(10, 20, 0, 20)); 
			//Adding all the nodes to the observable list 
			container.getChildren().addAll(comboBox, questionLabel, question, choiceLabel, choices, saveOption);    
			root.setCenter(container);
			//Creating a scene object 
			Scene scene = new Scene(root);  

			//Setting title to the Stage 
			primaryStage.setTitle("Vbox Example"); 

			//Adding scene to the stage 
			primaryStage.setScene(scene); 

			//Displaying the contents of the stage 
			primaryStage.show(); 

		} catch(Exception e) {
			e.printStackTrace();
		}

	}





	public static void main(String[] args) {
		launch(args);
	}
}
