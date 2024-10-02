package es.ieslosmontecillos.loancalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class LoanCalculator extends Application {

    private final GridPane pane = new GridPane();

    private final AnchorPane anchorPane = new AnchorPane();

    private final Label lblNumberOfYears = new Label("Number of Years");
    private final Label lblLoanAmount = new Label("Loan Amount");
    private final Label lblMonthlyPayments = new Label("Monthly Payments");
    private final Label lblTotalPayments = new Label("Total Payments");
    private final Label lblAnnualInterestRate = new Label("Annual Interest");
    private final Label lblError = new Label("");


    private final TextField tXAnualInterestRate = new TextField();
    private final TextField tXNumberOfYears = new TextField();
    private final TextField tXLoanAmount = new TextField();
    private final TextField tXMonthlyPayments = new TextField();
    private final TextField tXTotalPayments = new TextField();

    private final Button btnCalculate = new Button("Calculate");


    @Override
    public void start(Stage stage){

        Group root = new Group();
        Scene scene = new Scene(root, 360, 200);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);

        stage.setResizable(false);

        tXMonthlyPayments.setEditable(false);
        tXTotalPayments.setEditable(false);


        btnCalculate.setOnAction(event -> {

            calculateFunction();

        });


        settingUp();

        scene.setRoot(anchorPane);

        stage.show();
    }

    private void settingUp() {
        pane.setHgap(5);
        pane.add(lblAnnualInterestRate, 0, 0);
        pane.add(tXAnualInterestRate, 1, 0);

        pane.add(lblNumberOfYears, 0, 1);
        pane.add(tXNumberOfYears, 1, 1);

        pane.add(lblLoanAmount, 0, 2);
        pane.add(tXLoanAmount, 1, 2);

        pane.add(lblMonthlyPayments, 0, 3);
        pane.add(tXMonthlyPayments, 1, 3);

        pane.add(lblTotalPayments, 0, 4);
        pane.add(tXTotalPayments, 1, 4);

        pane.add(lblError, 0, 5);
        pane.add(btnCalculate, 1, 5);

        pane.setPadding(new Insets(20, 20, 20, 20));
        anchorPane.getChildren().add(pane);

    }

    private void calculateFunction() {

        lblError.setText("");
        lblError.setStyle("-fx-text-fill: red;");


        double h=0;
        double r=0;
        int n=0;

        try{r=Double.parseDouble(tXAnualInterestRate.getText())/1200;
            try {n=Integer.parseInt(tXNumberOfYears.getText());
                try{h = Math.floor(Double.parseDouble(tXLoanAmount.getText()) * 100) / 100;
                }catch (Exception e){lblError.setText("Bad Input in Loan Amount");}
            }catch (Exception e){lblError.setText("Bad Input in Number of Years");}
        }catch (Exception e){lblError.setText("Bad Input in Anual Interest Rate");}

            double m=h*r/(1-Math.pow(1+r,-12*n));

            if(!Double.isNaN(m)&&!Double.isInfinite(m)&& !(m ==0)){
                tXMonthlyPayments.setText(Math.floor(m*100)/100+"€");
                tXTotalPayments.setText(Math.floor(m*n*12*100)/100+"€");
            }





    }

    public static void main(String[] args) {
        launch();
    }
}