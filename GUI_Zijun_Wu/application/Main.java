package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	
	Label lbScore;
	Label lbNumberCorrect;
	Label lbPercentage;
	Label lbOutOf;
	Button btExit;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			lbScore = new Label("Score");
			lbScore.setFont(new Font("Arial", 30));
			lbNumberCorrect = new Label("Number Correct:");
			lbPercentage = new Label("Percentage:");
			lbOutOf = new Label("Out Of:");
			btExit = new Button("Exit");

			VBox center = new VBox();
			VBox top = new VBox();
			VBox bottom = new VBox();
			
			center.setAlignment(Pos.CENTER);
			center.getChildren().add(lbNumberCorrect);
			center.getChildren().add(lbOutOf);
			center.getChildren().add(lbPercentage);
			
			top.setAlignment(Pos.CENTER);
			top.getChildren().add(lbScore);
			
			bottom.setAlignment(Pos.CENTER);
			bottom.getChildren().add(btExit);
			
			root.setTop(top);
			root.setCenter(center);
			root.setBottom(bottom);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("GUIapp");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
