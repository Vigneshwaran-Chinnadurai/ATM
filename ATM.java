package atmmachine;
import java.util.Scanner;
public class ATM 
{
		//Check Balance, Deposit, Withdraw, Change Pin , Exit
		private int balance;
		private int pin;
		
		public ATM(int balance, int pin)
		{ 
			this.balance = balance;
			this.pin = pin;
		}
		
		public void menuDisplay() 
		{
			System.out.println(" ");
			System.out.println("1.Check Balance");
			System.out.println("2.Deposit");
			System.out.println("3.Withdrawal");
			System.out.println("4.Change Pin");
			System.out.println("5.Exit ");
			System.out.println("Please select any of the below options: ");
		}

		public int balanceInquiry() 
		{
			return balance;
		}
		
		public void deposit(int amount) 
		{
			//Deposit is adding of money to balance
			balance=balance+amount; 
		}
		
		public void withdrawal(int amount) 
		{   
			//withdrawal is subtracting of money from balance
			if(balance<amount) 
			{		
				System.out.println("Insufficient Balance" );
				return; 
			}
			else
			{
				balance=balance-amount;
			}
		}	
		
		public boolean isPinvalid(int pin) 
		{
			//returns true or false depending upon entering of pin
			return this.pin==pin;
		}
		
		public void changePin(int newPin) 
		{
			//changing of pin by assigning this.pin to new pin
			pin = newPin;    
			System.out.println("New Pin is changed ");
			System.out.println("  ");
		}
		public static void main(String[] args) 
		{
			ATM atm = new ATM(1000,1234);
			System.out.print("Enter the Pin: ");
			Scanner scn = new Scanner(System.in);
			int pin = scn.nextInt();
			
			if(atm.isPinvalid(pin))
			{
				int option = 0;
				while(option!=5) 
				{
					atm.menuDisplay();
					
					option = scn.nextInt();
					switch(option) 
					{
					case 1: 
						System.out.println("Current Balance is : "+ atm.balanceInquiry());
						break;
					case 2: 
						System.out.println("Enter the deposit amount : ");
						int amount= scn.nextInt();
						atm.deposit(amount);
						break;
					case 3: 
						System.out.println("Enter the withdrawal amount : ");
						amount= scn.nextInt();
						atm.withdrawal(amount);
						break;
					case 4: 
						System.out.println("Enter the new Pin : ");
						int newPin = scn.nextInt();
						atm.changePin(newPin);
						break;
					case 5: 
						System.out.println("Thank You for using ATM ,Have a Nice Day!!");
						break;
					default:
						System.out.println("Only enter number within 1 to 5");
						break;
					}
				}
			}
			else 
			{
				System.out.println("You have entered Incorrect Pin");
			}
		}
}
