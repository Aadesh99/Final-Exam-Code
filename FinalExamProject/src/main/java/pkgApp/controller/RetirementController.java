package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.poi.ss.formula.functions.FinanceLib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturnWorking;
	
	@FXML
	private Label lblWhatYouNeedToSave;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtAnnualReturnRetired;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	
	
	
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		lblSaveEachMonth.setText("$");
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		lblWhatYouNeedToSave.setText("$");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		
		
	}
	
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		System.out.println("calculating");

		lblSaveEachMonth.setDisable(false);
		lblWhatYouNeedToSave.setDisable(false);
		
		double whatToSave = (FinanceLib.pv(Double.parseDouble(txtAnnualReturnRetired.getText())/12, Double.parseDouble(txtYearsRetired.getText())*12, Integer.parseInt(txtMonthlySSI.getText())-Integer.parseInt(txtRequiredIncome.getText()) , 0 , false)*100);
		lblWhatYouNeedToSave.setText(Double.toString(Math.abs(whatToSave)/100));
		
		double saveMonthly = ((FinanceLib.pmt(Double.parseDouble(txtAnnualReturnWorking.getText())/12, Double.parseDouble(txtYearsToWork.getText())*12, 0, whatToSave , false)*100));
		lblSaveEachMonth.setText(Double.toString((Math.abs(saveMonthly/100))));

		
		
	} 
	
}
