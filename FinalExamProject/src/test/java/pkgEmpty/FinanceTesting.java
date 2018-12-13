package pkgEmpty;

import static org.junit.Assert.*;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import pkgCore.Retirement;


public class FinanceTesting {

	@Test
	public void AmountToSaveTest() {
		Retirement rt = new Retirement();
		rt.setiYearsToWork(40);
		rt.setdAnnualReturnRetired(0.02);
		rt.setdAnnualReturnWorking(0.07);
		rt.setdRequiredIncome(10000);
		rt.setdMonthlySSI(2642);
		rt.setiYearsRetired(20);	
		assertEquals(rt.AmountToSave(),554.13,0.01);
	}
	
	@Test
	public void TotalAmountToSaveTest() {
		Retirement rt = new Retirement();
		rt.setiYearsToWork(40);
		rt.setdAnnualReturnRetired(0.02);
		rt.setdAnnualReturnWorking(0.07);
		rt.setdRequiredIncome(10000);
		rt.setdMonthlySSI(2642);
		rt.setiYearsRetired(20);
		assertEquals(rt.TotalAmountSaved(),1454485.55,0.02);
	}

	
}

