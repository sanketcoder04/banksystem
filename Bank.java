package banksystem;

import java.util.Scanner;

public class Bank {
	
	private final String accountHolders[] = {"Sanjoy Saha","Anirudh Roy","Sanchita Mukherjee","Anita Sen","Rakesh Majhi"};
	private final String accountNumbers[] = {"AB123CD456", "EF789GH012", "IJ345KL678", "MN901OP234", "QR567ST890"};
	private int pins[] = {12345, 98765, 11223, 55667, 22334};
	private double balances[] = {110000.00, 230000.00, 87000.00, 560000.00, 90564.00};
	
	String name;
	String accNumber;
	int pin;
	
	public Bank(String name, String accNumber, int pin) {
		this.name = name;
		this.accNumber = accNumber;
		this.pin = pin;
	}

	public void authorization() {
		boolean checkName = false;
		for(int i=0;i<accountHolders.length;i++) {
			if(name.equals(accountHolders[i])) {
				checkName = true;
				break;
			}
		}
		boolean checkAccount = false;
		for(int i=0;i<accountNumbers.length;i++) {
			if(accNumber.equals(accountNumbers[i])) {
				checkAccount = true;
				break;
			}
		}
		boolean checkPin = false;
		for(int i=0;i<pins.length;i++) {
			if(pins[i] == pin) {
				checkPin = true;
				break;
			}
		}
		if(checkName && checkPin && checkAccount) {
			System.out.println("User Verification Successful..");
			selectOperation();
		}
		else {
			System.out.println("User Verification Unsuccessful. Please provide proper Information..");
		}
	}
	
	private void selectOperation() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter What Operation You wants to perform... ");
			System.out.println("    1. Debit   2. Credit   3. Check Account Statement  4. Change PIN   5. Exit");
			String operation = sc.nextLine();
			
			switch(operation) {
				case "Debit" : 
					System.out.println("Enter the Amount You want to Debit : ");
					double debitAmount = sc.nextDouble();
					sc.nextLine();
					debit(debitAmount);
					break;
					
				case "Credit" :
					System.out.println("Enter the Amount You want to Credit : ");
					double creditAmount = sc.nextDouble();
					sc.nextLine();
					credit(creditAmount);
					break;
					
				case "Statement" :
					System.out.println("Getting Your Details");
					statement();
					break;
					
				case "PIN" :
					System.out.println("Enter Your new PIN : ");
					int pin = sc.nextInt();
					sc.nextLine();
					changePin(pin);
					break;
					
				case "Exit" : 
					System.out.println("Operations terminated...");
					return;
					
				default :
					System.out.println("Invalid Option Choosen, Try Again....");
					break;
			}
		}
	}
	
	private void debit(double amount) {
		int index = getDataIndex();
		double balance = balances[index];
		if(amount > balance) {
			System.out.println("Debit Not Possible..Not enough Money");
			return;
		}
		balances[index] = balance - amount;
		System.out.println("Your Account is Debited with " + amount + " Rupees");
	}
	
	private void credit(double amount) {
		int index = getDataIndex();
		double balance = balances[index];
		balances[index] = balance + amount;
		System.out.println("Your Account is Credited with " + amount + " Rupees");
	}
	
	private void statement() {
		System.out.println("Account Holder : " + name);
		System.out.println("Account Number : " + accNumber);
		System.out.println("PIN : " + pins[getDataIndex()]);
		System.out.println("Total Amount : " + balances[getDataIndex()]);
	}
	
	private void changePin(int newPin) {
		pins[getDataIndex()] = newPin;
		pin = newPin;
		System.out.println("Change of PIN Number is Successful...");
	}
	
	private int getDataIndex() {
		int index = 0;
		for(int i=0;i<pins.length;i++) {
			if(pin == pins[i]) {
				index = i;
				break;
			}
		}
		return index;
	}
}
