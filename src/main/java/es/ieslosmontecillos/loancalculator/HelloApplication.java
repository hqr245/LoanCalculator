package es.ieslosmontecillos.loancalculator;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){

        Group root = new Group();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        GridPane pane = new GridPane();

        Label annualInterestRate = new Label("Annual Interest Rate");
        Label numberOfYears = new Label("Number of Years");
        Label loanAmount = new Label("Loan Amount");
        Label monthlyPayments = new Label("Monthly Payments");
        Label totalPayments = new Label("Total Payments");
        Label error = new Label("");


        TextField tXAnualInterestRate = new TextField();
        TextField tXNumberOfYears = new TextField();
        TextField tXLoanAmount = new TextField();
        TextField tXMonthlyPayments = new TextField();
        TextField tXTotalPayments = new TextField();


        tXMonthlyPayments.setEditable(false);
        tXTotalPayments.setEditable(false);

        Button calculate = new Button("Calculate");

        calculate.setOnAction(event -> {

                try{
                    error.setText("");
                    double h = Math.floor(Double.parseDouble(tXLoanAmount.getText())*100)/100;

                    double r=Double.parseDouble(tXAnualInterestRate.getText())/1200;

                    int n=Integer.parseInt(tXNumberOfYears.getText());

                    double m=h*r/(1-Math.pow(1+r,-12*n));

                    tXMonthlyPayments.setText(Math.floor(m*100)/100+"€");
                    tXTotalPayments.setText(Math.floor(m*n*12*100)/100+"€");

                }catch (Exception e){
                    error.setText("Error.");
                    error.setStyle("-fx-text-fill: red");

                    System.err.println("error");
                }


        });


        pane.add(annualInterestRate, 0, 0);
        pane.add(tXAnualInterestRate, 1, 0);

        pane.add(numberOfYears, 0, 1);
        pane.add(tXNumberOfYears, 1, 1);

        pane.add(loanAmount, 0, 2);
        pane.add(tXLoanAmount, 1, 2);

        pane.add(monthlyPayments, 0, 3);
        pane.add(tXMonthlyPayments, 1, 3);

        pane.add(totalPayments, 0, 4);
        pane.add(tXTotalPayments, 1, 4);

        pane.add(error, 0, 5);
        pane.add(calculate, 1, 5);

        scene.setRoot(pane);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}