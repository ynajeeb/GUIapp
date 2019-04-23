package application;
	





import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
			BorderPane root = new BorderPane();
			
			
			
			//main screen 
			root= greetingScreen(root);
			
			
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Quiz Generator");
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//private helper method that sets the main screen/greeting screen
	private BorderPane greetingScreen(BorderPane root) {
		//screenContainer contains the main contents of the greeting screen
		HBox screenContainer = new HBox();
		//greetScreen contains the text of the greeting screen
		VBox greetScreen = new VBox();
		Label welcomeLabel = new Label("Quiz Generator");
		Label numQ = new Label("Number of Questions:");
		Label totAvailQ = new Label("out of 1000 available questions");
		TextField numQText = new TextField (); //text field for user to enter desired number of questions
		HBox qBox = new HBox(); //qBox contains the nodes related to the the screen asking for number of questions
		qBox.getChildren().addAll(numQ, numQText, totAvailQ);
		qBox.setSpacing(20);
		
		
		Label topicLabel = new Label("Select desired topic(s):");
		VBox topicBox = new VBox();	//contains a checklist of topics
		CheckBox t0 = new CheckBox("Dinosaurs");
		CheckBox t1 = new CheckBox("US History");
		CheckBox t2 = new CheckBox("Science");
		CheckBox t3 = new CheckBox("Computer Science");
		CheckBox t4 = new CheckBox("Art");
		CheckBox t5 = new CheckBox("Health");
		topicBox.setSpacing(10);
		topicBox.getChildren().addAll(topicLabel, t0,t1,t2,t3,t4,t5);
		
		
		greetScreen.getChildren().addAll(welcomeLabel, qBox, topicBox);
		greetScreen.setSpacing(20);
		greetScreen.setAlignment(Pos.CENTER);
		VBox emptyLeft = new VBox(); //to create empty white space to the left
		//placing all contents of the greeting screen into screenContainer
		screenContainer.getChildren().addAll(emptyLeft, greetScreen); 
		screenContainer.setAlignment(Pos.CENTER);
		
		root.setCenter(screenContainer);

		HBox icons = new HBox(); //holds buttons
		Button addQ = new Button("Add Question");
		Button genQ = new Button("Generate Quiz");
		icons.getChildren().addAll(addQ,genQ);
		icons.setSpacing(390);
		addQ.setOnAction(click -> 
			{	//when addQ button is clicked, takes them to different screen
				//where they can fill out the appropriate form to insert a question
	            BorderPane addQScreen = new BorderPane();
	            addQScreen = addQuestionScreen(addQScreen);
	            Scene scene = new Scene(addQScreen,600,400);
	            Stage stage = new Stage();
	            stage.initOwner(addQScreen.getScene().getWindow());
	            stage.setTitle("Add Question");
	            stage.setScene(scene);
	            stage.show();
	        });
		
		root.setBottom(icons);
		
		
		return root;
		
	}
	
	private BorderPane addQuestionScreen(BorderPane root) {
		//text field for user to type in their question
		TextField question = new TextField("Enter Question Here:");
		Button submit = new Button("Submit");
		Label choiceLabel = new Label("Correct Choice? ");

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

		
		ToggleGroup question1= new ToggleGroup();

		radio1.setToggleGroup(question1);
		radio2.setToggleGroup(question1);
		radio3.setToggleGroup(question1);
		radio4.setToggleGroup(question1);
		radio5.setToggleGroup(question1);


		submit.setDisable(true);

		radio1.setOnAction(e -> submit.setDisable(false) );
		radio2.setOnAction(e -> submit.setDisable(false) );
		radio3.setOnAction(e -> submit.setDisable(false) );
		radio4.setOnAction(e -> submit.setDisable(false) );
		radio5.setOnAction(e -> submit.setDisable(false) );


		
		ComboBox<String> comboBox = new ComboBox<String>();
		Label topicPrompt = new Label("Select Topic: ");
		HBox topicBox = new HBox();
		comboBox.getItems().addAll("Dinosaurs", "US History", "Science","Computer Science","Art","Health", "Create New Topic");
		comboBox.setEditable(true);
		topicBox.getChildren().addAll(topicPrompt, comboBox);
		topicBox.setSpacing(100);
		topicBox.setAlignment(Pos.CENTER);
		
		

		
		VBox container = new VBox();
		VBox correct = new VBox();
		VBox answer = new VBox();
		HBox choices = new HBox();
		HBox saveOption = new HBox();
		Button addMoreQ = new Button("Add More Questions");
		Button save = new Button("Save");
		Label answerLabel = new Label("Answer:");
		answerLabel.setAlignment(Pos.CENTER);
		saveOption.getChildren().addAll(save, addMoreQ);
		choices.getChildren().addAll(correct, answer);
		correct.getChildren().addAll(choiceLabel, radio1,radio2,radio3,radio4,radio5);
		answer.getChildren().addAll(answerLabel , choice1,choice2,choice3,choice4,choice5);
		answer.setSpacing(20);
		correct.setSpacing(26);
		choices.setSpacing(100);
		choices.setAlignment(Pos.CENTER);
		container.setSpacing(20);
		saveOption.setSpacing(403);
		
		//Adding all the nodes to the observable list 
		container.getChildren().addAll(topicBox, question, choices);   
		container.setAlignment(Pos.CENTER);
	
		
		root.setCenter(container);
		root.setBottom(saveOption);
		


		return root;
	}
	
	public static void main(String[] args) {
		//use command-line here before calling launch
		//ex: reading files 
		launch(args);
	}
}
