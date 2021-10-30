public class CheckingAccount {
	
		private String Name = new String();
		private String Address = new String();
		private int Phone_num;
		private int Account_num;
		private double Balance;
		private String Date_created = new String();
		private double Tax;
		int Transaction_count;
		int Transaction_fee;
		
		public CheckingAccount()
		{
			Name = "";
			Address = "";
			Phone_num = 0;
			Account_num = 0;
			Balance = 0;
			Date_created = "";
			Tax = 0;
			Transaction_count = 0;
			Transaction_fee = 0;
		}
		
		public CheckingAccount(String N, String Ad, int num, int acc_num, double bal, String date)
		{
			Name = N;
			Address = Ad;
			Phone_num = num;
			Account_num = acc_num;
			Balance = bal;
			Date_created = date;
			Tax = 0;
			Transaction_count = 0;
			Transaction_fee = 0;
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
			Transaction_count ++;
		}
		
		public void makeWithdrawal(double amount)
		{
			if(amount <= Balance ||(amount-Balance)<=5000)
			{
				Balance-=amount;
			}
			else
			{
				System.out.printf("\nINVALID TRANSACTION! ENTERED AMOUNT EXCEEDS THE EXCESS TRANSACTION LIMIT OF 5000 PKR!\n");
			}
			Transaction_count ++;
		}
		
		public boolean transferAmount(CheckingAccount account, double amount)
		{
			if(amount<=Balance)
			{
				this.makeWithdrawal(amount);
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
		
		public int calculateTransactionFee()
		{
			if(Transaction_count<2)
			{
				Transaction_fee +=10;
			}
			return Transaction_fee;
		}
		
		public double calculateTax()
		{
			return Balance*1.5;
		}
		
		public void displayAllDeductions()
		{
			System.out.printf("\nINITIAL BALANCE = "+Balance);
			System.out.printf("\nTAX DEDUCTION (Factor = 1.5) = "+Tax);
			System.out.printf("\nTRANSACTION FEE = "+Transaction_fee);
			Balance-=(Tax+Transaction_fee);
			System.out.printf("\nREMAINING BALANCE = "+Balance);
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