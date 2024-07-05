package banksystem;

import java.util.Scanner;

public class BankMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter Your Account Number");
		String account = sc.nextLine();
		
		System.out.println("Enter Your PIN : ");
		int pin = sc.nextInt();
		
		Bank bank = new Bank(name, account, pin);
		bank.authorization();
		sc.close();
	}
}
