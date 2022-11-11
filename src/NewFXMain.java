/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author billden
 */
public class NewFXMain extends Application {
    
   
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Future Value App");
        
        primaryStage.show();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 700, 300);
        primaryStage.setScene(scene);
        
        //combobox items
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3","4");
        
        
        Label mp = new Label("Monthly Payment:");
        grid.add(mp, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        Label interest = new Label("Interest Rate:");
        grid.add(interest, 0, 2);
        TextField pwBox = new TextField();
        grid.add(pwBox, 1, 2);
        
        Label warning = new Label("Enter 11.1% as 11.1:");
        warning.setTextFill(Color.RED);
        GridPane.setHalignment(warning,HPos.RIGHT);
        grid.add(warning,1,3);
        
        Label yearLabel = new Label("Year:");
        grid.add(yearLabel,0,4);
        
        //combobox staffs
        var yearCombo = new ComboBox();
        yearCombo.setItems(list);
        grid.add(yearCombo,1,4);
        
        Button clear = new Button();
        clear.setText("Clear");
        
        //textArea
        TextArea text = new TextArea();
        grid.add(text,1,6);
        
        //Calculate
        Button calculate = new Button();
        calculate.setText("Calculate");
        
       calculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int pay = Integer.parseInt(userTextField.getText());
                
                double interest = Integer.parseInt(pwBox.getText());
                
                //combobox value
                int selectedIndex = yearCombo.getSelectionModel().getSelectedIndex();
                int data = selectedIndex + 1;
                
                double output =pay*interest * data;
                text.setText("The interest for this payment is "+String.valueOf(output));
  
                
                
                
                
            }
        });
        
       
        
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15,0,15,30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().add(clear);
        actionBtnContainer.getChildren().add(calculate);
        
        grid.add(actionBtnContainer, 1, 5);
        
        
        
        
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
