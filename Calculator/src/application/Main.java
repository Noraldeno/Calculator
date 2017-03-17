package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	//Initialize buttons, textfields and labels used for the GUI
	TextField txtnum1, txtnum2;
	Button btnadd, btnsub, btndiv, btnmul, btnclear;
	Label answer;
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			//Add new text field to take answers
			txtnum1 = new TextField();
			txtnum2 = new TextField();
			
			//Add operation buttons to operate on numbers
			btnadd = new Button("+");
			btnsub = new Button("-");
			btnmul = new Button("x");
			btndiv = new Button("/");
			
			//Add button to clear text fields
			btnclear = new Button("Clear");
			
			//Add Answer label to display answers
			answer = new Label("Answer");
			
			answer.setAlignment(Pos.CENTER);
			
			//Apply style to label using css
			answer.setStyle("-fx-border-color: #000;"
					+ "-fx-padding: 5px;");
			
			//Add action events to buttons when clicked
			addAction();
			
			//Creates a GridPane layout
			GridPane root = new GridPane();
			
			//Set alignment to center
			root.setAlignment(Pos.CENTER);
			
			//Set gaps horizontal/vertical gaps between buttons
			root.setHgap(10);
			root.setVgap(10);
			
			//Add buttons to the GridPane layout
			root.add(btnadd, 0, 0);
			root.add(btnsub, 0, 1);
			root.add(btnmul, 1, 0);
			root.add(btndiv, 1, 1);
			root.add(txtnum1, 0, 2);
			root.add(txtnum2, 1, 2);
			root.add(answer, 0, 3, 2, 1);
			root.add(btnclear, 0, 4, 2, 1);
			
			//Set widths on the buttons
			setWidths();
			
			//Create container for all content in GUI
			Scene scene = new Scene(root,300,250);
			
			//Set name to Calculator
			primaryStage.setTitle("Calculator 0.1");
			
			// Set scene to Stage
			primaryStage.setScene(scene);
			
			//Display the stage
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets width of all buttons
	 */
	public void setWidths(){
		txtnum1.setPrefWidth(70);
		txtnum2.setPrefWidth(70);
		btnadd.setPrefWidth(70);
		btnsub.setPrefWidth(70);
		btnmul.setPrefWidth(70);
		btndiv.setPrefWidth(70);
		
		btnclear.setPrefWidth(150);
		answer.setPrefWidth(150);
	}
	
	/**
	 * Adds an action listener to buttons and
	 * calls btncode(e)
	 */
	public void addAction(){
		btnadd.setOnAction(e -> btncode(e));
		btnsub.setOnAction(e -> btncode(e));
		btnmul.setOnAction(e -> btncode(e));
		btndiv.setOnAction(e -> btncode(e));
		
		btnclear.setOnAction(e -> btncode(e));
	}
	
	/**
	 * Calculates the answer depending
	 * on the operator used
	 * 
	 * @param e  ActionEvent
	 */
	public void btncode(ActionEvent e){
		
		//Clears the text fields
		if(e.getSource() == btnclear){
			txtnum1.setText("");
			txtnum2.setText("");
			answer.setText("Answer");
			txtnum1.requestFocus();
		}
		
		else if ((txtnum1.getText() != null && !txtnum1.getText().isEmpty())
				&& (txtnum2.getText() != null && !txtnum2.getText().isEmpty())){
			
			Calculate calc = new Calculate(0 , 0);
			
			boolean nan = false;
			// Take in text from text fields
			try{
				calc = new Calculate(Integer.parseInt(txtnum1.getText()), Integer.parseInt(txtnum2.getText()));
			}
			catch (NumberFormatException nfe){
				nan = true;
			}
			
			if (!nan){
				// Add the addends to find the sum
				if(e.getSource() == btnadd){
					calc.add();
				}
				
				// Subtract the subtrahend and minuend to find the difference
				else if(e.getSource() == btnsub){
					calc.subtract();
				}
				
				// Multiply the factors to get the product
				else if(e.getSource() == btnmul){
					calc.multiply();
				}
				
				// Divide the dividend with the divisor to get the quotient
				else{
					calc.divide();
				}
				// Change the label to the answer calculated
				answer.setText(calc.toString());
			}
			
			else{
				answer.setText("Not a number");
			}
		}
		else{
			answer.setText("Please enter number");
		}
	}
	
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}