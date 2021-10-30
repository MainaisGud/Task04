import static org.junit.Assert.*;

import org.junit.Test;

public class testclass {

	@Test
	public void makeDepositTest() 
	{
		CheckingAccount t1=new CheckingAccount();
		t1.makeDeposit(10000);
		double store = t1.getBalance();
		assertEquals(store,10000,0.1);
	}
	
	@Test
	public void makeDepositTest2() 
	{
		CheckingAccount t1 = new CheckingAccount();
		t1.makeDeposit(5000);
		double store = t1.getBalance();
		assertNotEquals(store,10000);
	}
	
	@Test
	public void makeDepositTest3() 
	{
		SavingsAccount t1= new SavingsAccount();
		t1.makeDeposit(10000);
		double store = t1.getBalance();
		assertEquals(store,10000,0.1);
	}

	@Test
	public void makeDepositTest4() 
	{
		SavingsAccount t1 = new SavingsAccount();
		t1.makeDeposit(5000);
		double store = t1.getBalance();
		assertNotEquals(store,10000);
	}
	
	@Test
	public void TransferAmountTest() 
	{
		CheckingAccount t1 = new CheckingAccount();
		CheckingAccount t2 = new CheckingAccount();
		t1.makeDeposit(25000);
		boolean store = t1.transferAmount(t2, 15000);
		assertEquals(true,store);
	}
	
	@Test
	public void TransferAmountTest2() 
	{
		CheckingAccount t1=new CheckingAccount();
		CheckingAccount t2=new CheckingAccount();
		t1.makeDeposit(3500);
		boolean store=t1.transferAmount(t2, 5000);
		assertEquals(false,store);
	}
	
	@Test
	public void AmountTransferTest3() 
	{
		SavingsAccount t1 = new SavingsAccount();
		SavingsAccount t2 = new SavingsAccount();
		t1.makeDeposit(25000);
		boolean store = t1.transferAmount(t2, 15000);
		assertEquals(true,store);
	}
	
	@Test
	public void AmountTransferTest4() 
	{
		SavingsAccount t1 = new SavingsAccount();
		SavingsAccount t2 = new SavingsAccount();
		t1.makeDeposit(3500);
		boolean store = t1.transferAmount(t2, 5000);
		assertEquals(false,store);
	}

	@Test
	public void ZakaatTest1() 
	{
		SavingsAccount t1=new SavingsAccount();
		t1.makeDeposit(500000);
		double temp=t1.CalculateZakaat();
		double result=t1.getBalance()*(2.5/100);
		assertEquals(result,temp,0.1);
	}

	@Test
	public void ZakaatTest2() 
	{
		SavingsAccount t1=new SavingsAccount();
		t1.makeDeposit(500);
		double temp=t1.CalculateZakaat();
		double result=t1.getBalance()*(2.5/100);
		assertNotEquals(result,temp);
	}
	
	@Test
	public void makeWithdrawalTest() 
	{
		CheckingAccount t1=new CheckingAccount();
		t1.makeDeposit(10000);
		t1.makeWithdrawal(9000);
		double store = t1.getBalance();
		assertEquals(store,1000,0.1);
	}
	
	@Test
	public void makeWithdrawalTest2() 
	{
		SavingsAccount t1=new SavingsAccount();
		t1.makeDeposit(10000);
		t1.makeWithdrawal(9000);
		double store = t1.getBalance();
		assertEquals(store,1000,0.1);
	}

}
