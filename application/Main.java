package application;
	



import javafx.application.Application;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			//Be sure to include labels, status messages, and or instructions to the user as may be required.
			
			
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

		
		HBox icons = new HBox(); //holds icons
		Button addQ = new Button("Add Question");
		Button genQ = new Button("Generate Quiz");
		icons.getChildren().addAll(addQ,genQ);
		icons.setSpacing(390);
		addQ.setOnAction(click -> addQuestionScreen());
		root.setBottom(icons);
		
		return root;
		
	}
	
	private BorderPane addQuestionScreen() {
		BorderPane root = new BorderPane();
		return root;
	}
	
	public static void main(String[] args) {
		//use command-line here before calling launch
		//ex: reading files 
		launch(args);
	}
}
