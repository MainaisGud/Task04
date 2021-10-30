import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MAIN 
{
	private static ArrayList<CheckingAccount> CheckingAccList; 
	private static ArrayList<SavingsAccount> SavingsAccList; 

	public MAIN() 
	{
		CheckingAccList = new ArrayList<CheckingAccount>();
		SavingsAccList = new ArrayList<SavingsAccount>();
	}
	
	public static int generateAccNum()
	{
		boolean validity_check=false;
		Random rand = new Random();
		int num = rand.nextInt(100000);
		
		while(validity_check==false)
		{ 
			for (CheckingAccount t1 : CheckingAccList)
			{
				if(t1.getAcc_num() == num)
				{
					validity_check = false;
					break;
				}
				else
					validity_check = true;
			}
			for (SavingsAccount t2 : SavingsAccList)
			{
				if(t2.getAcc_num() == num)
				{
					validity_check = false;
					break;
				}
				else
					validity_check = true;
			}
			if(validity_check==false)
			{
				num = rand.nextInt(100000);
			}
		}
		
		return num;
	}
	
	
	public static void main(String [] args)
	{
		@SuppressWarnings("resource")
        Scanner read = new Scanner(System.in);
		double Interest_rate = 0.0;
		int choice = 0;
		do
		{
			System.out.printf("\n*************************************************************"
					         +"\n                          MAIN MENU"  
					         +"\n*************************************************************"
					         +"\n1.CREATE A NEW ACCOUNT"
					         +"\n2.CLOSE AN ACCOUNT"
					         +"\n3.LOGIN INTO YOUR ACCOUNT"
					         +"\n4.SPECIFY THE INTEREST RATE"
					         +"\n5.DISPLAY ACCOUNT DETAILS"
					         +"\n6.DISPLAY ACCOUNT DEDUCTIONS"
		                     +"\n7.EXIT\n");
	
			System.out.printf("CHOICE : ");
			choice = read.nextInt();
			
			if(choice==1)
			{
	    		String Name;
	    		String Address;
	    		int AccountNum;
	    		double Balance;
	    		int PhoneNum;
	    		String Date;
	    		int day,month,year;
	    		int choice2;
	 
	    		System.out.println("ENTER YOUR NAME : ");
	    		Name=read.next();
	    		
	    		System.out.println("ENTER YOUR ADDRESS : ");
	    		Address=read.next();
	    		
	    		System.out.println("ENTER YOUR PHONE NUMBER : ");
	    		PhoneNum=read.nextInt();
	    		
	    		System.out.println("ENTER YOUR BALANCE : ");
	    		Balance=read.nextDouble(); 
	    		
	    		System.out.printf("ENTER DAY (1 - 30/31 only) : ");
	    		day=read.nextInt(); 
	    		
	    		System.out.printf("ENTER MONTH (1-12 only) : ");
	    		month=read.nextInt(); 
	    		
	    		System.out.printf("ENTER YEAR : ");
	    		year=read.nextInt(); 
	    		
	    		Date = day+"/"+month+"/"+year;
	    		System.out.printf("YOUR ACCOUNT IS CREAETED ON: "+Date);
	    		
	    		AccountNum=generateAccNum();
	    		System.out.printf("YOUR ACCOUNT NUMBER IS: "+AccountNum);
	    		
	    		System.out.printf("PRESS 1 TO OPEN CHECKING ACCOUNT"
	    				         +"PRESS 2 TO OPEN SAVINGS ACCOUNT");
	    		
	    		choice2=read.nextInt();
	    		while (choice2<1 || choice2>2)
	    		{
	    			System.out.printf("INAVLID ENTRY! CHOOSE FROM 1 OR 2 ONLY\n.");
	    			choice2=read.nextInt();
	    		}
	    		if(choice2==1)
	    		{
	    			CheckingAccount Acc_1 = new CheckingAccount(Name,Address,PhoneNum,AccountNum,Balance,Date);
	    			CheckingAccList.add(Acc_1);
	    		}
	    		else if (choice2==2)
	    		{
	    			SavingsAccount Acc_2 = new SavingsAccount(Name,Address,PhoneNum,AccountNum,Balance,Date,Interest_rate);
	    			SavingsAccList.add(Acc_2);
	    		}
			}
			else if(choice==2)
			{
				int choice2=0;
				System.out.printf("\nPRESS 1 TO CLOSE CHECKING ACCOUNT"
				         +"\nPRESS 2 TO CLOSE SAVINGS ACCOUNT");
		
				choice2 = read.nextInt();
				while (choice2<1 || choice2>2)
				{
					System.out.printf("\nINAVLID ENTRY! CHOOSE FROM 1 OR 2 ONLY\n.");
					choice2=read.nextInt();
				}
	    		
	    		int acc_num = 0;
	    		
	    		System.out.printf("\nENTER THE ACCOUNT NUMBER TO CLOSE : ");
	    		
	    		acc_num=read.nextInt();
	    		
	    		if(choice2 == 1)
	    		{
	    			for (CheckingAccount t1 : CheckingAccList)
	    			{
	    				if(t1.getAcc_num()==acc_num)
	    				{
	    					CheckingAccList.remove(t1);
	    					System.out.println("\nACCOUNT CLOSED SUCCESFULLY!");
	    					break;
	    				}
	    			}
	    		}	    	
	    		else if (choice2==2)
	    		{
	    			for (SavingsAccount t2 : SavingsAccList)
	    			{
	    				if(t2.getAcc_num()==acc_num)
	    				{
	    					SavingsAccList.remove(t2);
	    					System.out.println("\nACCOUNT CLOSED SUCCESSFULLY!");
	    					break;
	    				}
	    			}
	    		}
			}
			else if(choice==3)
			{
				
			}
			else if(choice==4)
			{
	    		System.out.printf("\nEnter the Interest Rate : ");
	    		Interest_rate = read.nextDouble();   		
			}
			else if(choice==5)
			{
				System.out.printf("\nCHECKING ACCOUNTS : \n");
	    		for (CheckingAccount t1 : CheckingAccList)
	    		{
	    			t1.printStatement();
	    		}
	    		
	    		System.out.printf("\nSAVINGS ACCOUNTS : \n");
	    		for (SavingsAccount t2 : SavingsAccList)
    			{
    				t2.printStatement();
    			}
			}
			else if(choice==6)
			{
				System.out.printf("\nCHECKING ACCOUNTS : \n");
	    		for (CheckingAccount t1 : CheckingAccList)
	    		{
	    			t1.displayAllDeductions();
	    		}
	    		
	    		System.out.printf("\nSAVINGS ACCOUNTS : \n");
	    		for (SavingsAccount t2 : SavingsAccList)
    			{
    				t2.displayAllDeductions();
    			}
			}
			
		}
		while(choice!=7);
	}

}