package application;
	





import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//main greeting screen
			GridPane root =  greetingScreen(primaryStage);
			
			
			Scene scene = new Scene(root,700,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quiz Generator");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//private helper method that sets the main screen/greeting screen
	private GridPane greetingScreen(Stage primaryStage) {
		GridPane root = new GridPane();
		//screenContainer contains the main contents of the greeting screen
		VBox screenContainer = new VBox();
		//greetScreen contains the text of the greeting screen
		VBox greetScreen = new VBox();
		Label totAvailQ = new Label("out of 1000 available questions"); //displays the total amount of questions available
		TextField numQText = new TextField (); //text field for user to enter desired number of questions
		HBox qBox = new HBox(); //qBox contains the nodes related to the the screen asking for number of questions
		qBox.getChildren().addAll( new Label("Number of Questions:"), numQText, totAvailQ);
		qBox.setSpacing(20);
		
		

		VBox topicBox = new VBox();	//contains a checklist of topics
		CheckBox t0, t1, t2, t3, t4, t5;
		t0 = new CheckBox("Dinosaurs");
		t1 = new CheckBox("US History");
		t2 = new CheckBox("Science");
		t3 = new CheckBox("Computer Science");
		t4 = new CheckBox("Art");
		t5 = new CheckBox("Health");
		topicBox.setSpacing(10);
		topicBox.getChildren().addAll(new Label("Select desired topic(s):"), t0,t1,t2,t3,t4,t5);
		
		
		greetScreen.getChildren().addAll(new Label("Quiz Generator"), qBox, topicBox);
		greetScreen.setSpacing(20);
		greetScreen.setAlignment(Pos.CENTER);

		

		HBox icons = new HBox(); //holds clickable buttons 
		Button addQ = new Button("Add Question");
		Button genQ = new Button("Generate Quiz");
		icons.getChildren().addAll(addQ,genQ);
		icons.setAlignment(Pos.BOTTOM_CENTER);
		icons.setSpacing(390);
		addQ.setOnAction(e -> 
			{	//when addQ button is clicked, takes them to different screen
				//where they can fill out the appropriate form to insert a question
	            GridPane addQScreen =  addQuestionScreen();
	            Scene scene = new Scene(addQScreen,700,500);
	            final Stage dialog = new Stage();
	            dialog.initModality(Modality.APPLICATION_MODAL);
	            dialog.initOwner(primaryStage);
	            dialog.setTitle("Add Question");
	            dialog.setScene(scene);
	            dialog.show();
	        });
		
		
		//placing all contents of the greeting screen into screenContainer 
		screenContainer.getChildren().addAll( greetScreen, icons);
		screenContainer.setSpacing(80);
				
		root.add(screenContainer, 1,1);
		root.setAlignment(Pos.CENTER);
		
		
		return root;
		
	}
	//helper method for adding question screen
	private GridPane addQuestionScreen() {
		GridPane root = new GridPane();
		//text field for user to type in their question
		TextField question = new TextField("Enter Question Here:");
		Button submit = new Button("Submit");
		

		//button to select correct choice
		RadioButton radio1, radio2, radio3, radio4, radio5;
		radio1=new RadioButton("Choice 1: ");
		radio2= new RadioButton("Choice 2: ");
		radio3= new RadioButton("Choice 3: ");
		radio4= new RadioButton("Choice 4: ");
		radio5= new RadioButton("Choice 5: ");
		
		//text field for user to input answers
		TextField choice1, choice2, choice3, choice4, choice5;
		choice1 = new TextField("");
		choice2 = new TextField("");
		choice3 = new TextField("");
		choice4 = new TextField("");
		choice5 = new TextField("");

		// creates a set of all the radioButtons in order for only one correct option to be chosen
		ToggleGroup question1= new ToggleGroup();
		radio1.setToggleGroup(question1);
		radio2.setToggleGroup(question1);
		radio3.setToggleGroup(question1);
		radio4.setToggleGroup(question1);
		radio5.setToggleGroup(question1);

		// can't click the submit button if no correct choice was selected
		submit.setDisable(true);
		// can click on the submit button once a correct choice is selected
		radio1.setOnAction(e -> submit.setDisable(false) );
		radio2.setOnAction(e -> submit.setDisable(false) );
		radio3.setOnAction(e -> submit.setDisable(false) );
		radio4.setOnAction(e -> submit.setDisable(false) );
		radio5.setOnAction(e -> submit.setDisable(false) );


		// makes a combobox of topics that contains all the current topics, and the ability to create a new topic by typing
		// into the combobox the new topic name
		ComboBox<String> comboBox = new ComboBox<String>();
		Label topicPrompt = new Label("Select Topic: ");
		HBox topicBox = new HBox();
		comboBox.getItems().addAll("Dinosaurs", "US History", "Science","Computer Science","Art","Health", "Create New Topic");
		comboBox.setEditable(true);
		// adds to the hBox the label and the topics
		topicBox.getChildren().addAll(topicPrompt, comboBox);
		topicBox.setSpacing(100);
		topicBox.setAlignment(Pos.CENTER);
		
		

		// contains the HBox choices and the TextField for the Question itself and the Topic list
		VBox container = new VBox();
		// contains the RadioBoxes which indicate the correct choice of the question 
		VBox correct = new VBox();
		// contains the textFields that the user can input choices into
		VBox answer = new VBox();
		// the HBox which contains the correct RadioBoxes, and the answer TextFields
		HBox choices = new HBox();
		// contains the two buttons that either save the current question or allow the user to add more questions
		HBox saveOption = new HBox();
		Button addMoreQ = new Button("Add More Questions");
		Button save = new Button("Save");
		
		saveOption.getChildren().addAll(save, addMoreQ);
		choices.getChildren().addAll(correct, answer);
		correct.getChildren().addAll(new Label("Correct Choice? "), radio1,radio2,radio3,radio4,radio5);
		answer.getChildren().addAll(new Label("Answer:"), choice1,choice2,choice3,choice4,choice5);
		answer.setSpacing(20);
		correct.setSpacing(26);
		choices.setSpacing(100);
		choices.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		saveOption.setSpacing(403);
		
		//Adding all the nodes to the observable list 
		container.getChildren().addAll(topicBox, question, choices, saveOption); 
		container.setSpacing(40);
		container.setAlignment(Pos.CENTER);
		saveOption.setAlignment(Pos.BOTTOM_CENTER);
	
		
		root.add(container, 1,1);
		root.setAlignment(Pos.CENTER);
		


		return root;
	}
	
	public static void main(String[] args) {
		//use command-line here before calling launch
		//ex: reading files 
		launch(args);
	}
}
