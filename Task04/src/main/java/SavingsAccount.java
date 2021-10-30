public class SavingsAccount {
	
	private String Name = new String();
	private String Address = new String();
	private int Phone_num;
	private int Account_num;
	private double Balance;
	private String Date_created = new String();
	private double Zakaat;
	private double Interest_rate;
	
	public SavingsAccount()
	{
		Name = "";
		Address = "";
		Phone_num = 0;
		Account_num = 0;
		Balance = 0;
		Date_created = "";
		Zakaat = 0;
		Interest_rate = 0;
	}
	
	public SavingsAccount(String N, String Ad, int num, int acc_num, double bal, String date, double IR)
	{
		Name = N;
		Address = Ad;
		Phone_num = num;
		Account_num = acc_num;
		Balance = bal;
		Date_created = date;
		Zakaat = 0;
		Interest_rate=IR;
	}
	
	public void checkBalance()
	{
		System.out.printf("\nNAME: "+Name);
		System.out.printf("\nBALANCE: "+Balance+"\n");
	}
	
	public void printStatement()
	{
		System.out.printf("\nSTATEMENT");
		System.out.printf("\nNAME: "+Name);
		System.out.printf("\nADDRESS: "+Address);
		System.out.printf("\nPHONE NO: "+Phone_num);
		System.out.printf("\nACCOUNT NO: "+Account_num);
		System.out.printf("\nBALANCE: "+Balance+"\n");
		System.out.printf("\nDATE CREATED: "+Date_created);
	}
	
	public void makeDeposit(double amount)
	{
		Balance += amount;

	}
	
	public void makeWithdrawal(double amount)
	{
		if(amount <= Balance)
		{
			Balance-=amount;
		}
		else
		{
			System.out.printf("\nINVALID TRANSACTION! INSUFFICIENT BALANCE!\n");
		}

	}
	
	public boolean transferAmount(SavingsAccount account, double amount)
	{
		if(amount<=Balance)
		{
			this.Balance-=amount;
			account.Balance +=amount;
			System.out.printf("\nTRANSFER SUCCESSFUL!\n");
			return true;
		}
		else
		{
			System.out.printf("\nTRANSFER FAILED! INSUFFICIENT BALANCE!\n");
			return false;
		}
	}
	
	public double CalculateZakaat()
	{
		if(Balance>=20000)
		{
			Zakaat = (Balance*2.5)/100;
			return Zakaat;
		}
		return 0;
	}

	public double calculateInterest()
	{
		 return Balance*Interest_rate;
	}
	
	public void displayAllDeductions()
	{
		System.out.printf("\nINITIAL BALANCE = "+Balance);
		System.out.printf("\nZAKAAT DEDUCTION = "+Zakaat);
		Balance-=Zakaat;
		System.out.printf("\nREMAINING BALANCE = "+Balance);
	}
	
	public void setInterestRate(double rate)
	{
		Interest_rate = rate;
	}
	
	public int getAcc_num()
	{
		return Account_num;
	}
	
	public double getBalance()
	{
		return Balance;
	}

}