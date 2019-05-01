package application;

import java.io.File;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      primaryStage.setTitle("Quiz Generator");

      BorderPane root = new BorderPane();
      Scene scene = new Scene(root, 1000, 800);
      Label blankLabel = new Label(" ");
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      HBox screenTop = new HBox();
      screenTop.setSpacing(20);
      ComboBox<String> quizTypes = new ComboBox<String>();
      quizTypes.getItems().addAll("Data structures quiz", "class and objects", "Trees",
          "Recursion");
      quizTypes.setPromptText("Select Quiz Type:");
      Insets padding = new Insets(15);
      TextField typeName = new TextField("Enter New Quiz Type: (OPTIONAL)");
      typeName.setMinWidth(400);
      // root.setTop(typeName);

      Button newQuiz = new Button("Add this quiz");

      screenTop.getChildren().addAll(quizTypes, typeName, newQuiz);
      root.setTop(screenTop);
      root.setPadding(padding);



      TextArea questionArea = new TextArea("ENTER QUESTIONS HERE: ");
      // textArea.setPrefHeight(20);
      // textArea.setPrefWidth(100);
      HBox questionBox = new HBox(); // could use VBox
      questionBox.setPadding(padding);
      // vb.setPrefHeight(20);
      // vb.setPrefWidth(100);
      questionBox.getChildren().add(questionArea);
      root.setCenter(questionBox);

      // OPTIONS BOX
      VBox optionsBox = new VBox();

      // IMAGE
      File file = new File("G:\\Workspace 3.0\\GUI\\Project\\application\\quest.jpg");
      Image questionMan = new Image(file.toURI().toString());
      ImageView questionImage = new ImageView(questionMan);
      questionImage.setFitHeight(200);
      questionImage.setFitWidth(200);
      questionImage.setImage(questionMan);
      optionsBox.getChildren().add(questionImage);
      optionsBox.getChildren().add(new Label(" "));
      // OPTIONS BOX CONTINUED
      questionBox.getChildren().add(optionsBox);
      TextField correctOption = new TextField("CORRECT OPTION");
      correctOption.setPrefWidth(500);
      optionsBox.getChildren().add(correctOption);
      TextField incorrectOption1 = new TextField("INCORRECT OPTION 1");
      optionsBox.getChildren().add(incorrectOption1);
      TextField incorrectOption2 = new TextField("INCORRECT OPTION 2");
      optionsBox.getChildren().add(incorrectOption2);
      TextField incorrectOption3 = new TextField("INCORRECT OPTION 3");
      optionsBox.getChildren().add(incorrectOption3);
      optionsBox.setPadding(padding);
      Label imageLabel = new Label("Add image URL:");

      TextField urlField = new TextField();
      optionsBox.getChildren().addAll(blankLabel, imageLabel, urlField);


      // BUTTONS
      HBox buttonBox = new HBox();
      Button back = new Button("Back");
      back.setMinWidth(100);
      Button add = new Button("Add");
      add.setMinWidth(100);
      Button save = new Button("Save");
      save.setMinWidth(100);
      Button load = new Button("Load Data");
      load.setMinWidth(100);
      Button generate = new Button("Generate Quiz");
      generate.setMinWidth(100);
      buttonBox.setSpacing(10);
      buttonBox.getChildren().addAll(back, add, save, load, generate);
      root.setBottom(buttonBox);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
