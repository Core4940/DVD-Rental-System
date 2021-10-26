/**
 * Project Name: DVD Rental System
 * Student Name: Corey Barron
 * Date Submitted: 11/20/2017
 * Project description: DVD Rental System - Final Project
 * 
**/

import java.util.Scanner;

public class DVDRentalSystem {
	
	static int maxCustomer = 50, maxItem = 5;
	static String[][] customer_record = new String[maxCustomer][4];
	static String[][] rental_record = new String[maxCustomer][maxItem];
	static String[][][] dvd_cd_list = new String[2][500][4];
	
/***
 * 
 *customer_record[index][0] =  Name, 
 *customer_record[index][1] =  Address,
 *customer_record[index][2] =  Phone Number,
 *customer_record[index][3] =  Enrolling Date,
 *customer_record[index][4] =  rental_record
 *
 *rental_record[index][0] =  item 1, dvd_cd_list index
 *rental_record[index][1] =  item 2, dvd_cd_list index
 *rental_record[index][2] =  item 3, dvd_cd_list index
 *rental_record[index][3] =  item 4, dvd_cd_list index
 *rental_record[index][4] =  item 5(max) dvd_cd_list index
 *
 *dvd_cd_list[0][index][0] = dvd title,
 *dvd_cd_list[0][index][1] = company name,
 *dvd_cd_list[0][index][2] = release date,
 *dvd_cd_list[0][index][3] = borrowed date,
 *
 *dvd_cd_list[1][index][0] = cd title,
 *dvd_cd_list[1][index][1] = company name,
 *dvd_cd_list[1][index][2] = release date,
 *dvd_cd_list[1][index][3] = borrowed date,
 *
***/
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int choice;
		
		while(true){
			System.out.println("---------------------- DVD/CD Rental System ------------------------");
			System.out.println("1. Add customer ");
			System.out.println("2. Delete customer ");
			System.out.println("3. Modify customer ");
			System.out.println("4. Add DVD/CD ");
			System.out.println("5. Rental DVD/CD ");
			System.out.println("6. Return DVD/CD ");
			System.out.println("7. Report DVD/CD store information ");
			System.out.println("8. Exit ");
			
			System.out.println("Enter the number : " );
			choice =  input.nextInt();
			
			switch (choice){
				case 1: addCustomer();
				break;
				case 2: delCustomer();
				break;
				case 3: modifyCustomer();
				break;
				case 4: addDvdCd();
				break;				
				case 5: rentalDvdCd();
				break;
				case 6: returnDvdCd();
				break;
				case 7: reportDvdCd();
				break;
				case 8: exit();
				break;	
				default: invalidInput();
				break;
				
			}
			
		}
		
		
	}
	
	public static void addCustomer(){
		Scanner input = new Scanner(System.in);
		
		String name, address, phoneNumber, enrollingDate, brCode;
		
		System.out.println("Enter your information");	
		
		System.out.println("Name:  ");
		name = input.nextLine();
		
		System.out.println("Address: ");
		address = input.nextLine();
		
		System.out.println("Phone Number: ");
		phoneNumber = input.nextLine();
		
		System.out.println("Enrolling Date:");
		enrollingDate = input.nextLine();
		
		for (int i=0; i<maxCustomer; i++){
			if (customer_record[i][0] == null) {
				customer_record[i][0] = name;
				customer_record[i][1] = address;
				customer_record[i][2] = phoneNumber;
				customer_record[i][3] = enrollingDate;
				
				break;
			}
		}		
		
	}
	
	public static void delCustomer(){
		Scanner input = new Scanner(System.in);		
		String name;

		boolean tag=false;
		
		System.out.println("Name: ");
		name = input.nextLine();
		
		for (int i=0; i<maxCustomer; i++){
			if (customer_record[i][0] != null){
				if (customer_record[i][0].equals(name) && customer_record[i][4] == null) {					
					customer_record[i][0] = null;
					customer_record[i][1] = null;
					customer_record[i][2] = null;
					customer_record[i][3] = null;
					customer_record[i][4] = null;
					System.out.println(name+" information deleted successfully !");
					tag=true;
					break;
				} else if (customer_record[i][0].equals(name) && customer_record[i][4] !=null){					
					System.out.println(name + " has rented item");
					tag=true;
					break;
				}				
			}
		}
		
		if(!tag)			
			System.out.println(name + " has no record. ");		
		
	}
	
	public static void modifyCustomer(){
		Scanner input = new Scanner(System.in);
		
		String name, Address, phoneNumber, enrollingDate, modifiedName;
		System.out.println("Modify your information, information reset, "
				+ "reinitiate proper information. First, input either: "
				+ "Customer name, Address, or Phone Number");
		
		modifiedName = input.nextLine();

		for(int i = 0; i < maxCustomer; i++){
			if (customer_record[i][0].equals(name)) {
					
				customer_record[i][0] = modifiedName;
				customer_record[i][1] = Address;
				customer_record[i][2] = phoneNumber;
				customer_record[i][3] = enrollingDate;
					
				System.out.println("Name:  ");
				name = input.nextLine();
					
				System.out.println("Address: ");
				Address = input.nextLine();
					
				System.out.println("Phone Number: ");
				phoneNumber = input.nextLine();
					
				System.out.println("Date: ");
				enrollingDate = input.nextLine();
					
				System.out.println(name+ " " + Address + " " + phoneNumber + " " + enrollingDate + 
							" information modified successfully !");
				break;
			}else{
				continue;
			}	

		}
	}
		
	public static void addDvdCd(){		
		
		Scanner input = new Scanner(System.in);
		String Title, Company, Release_Date, Borrowed_Date, disk;
		
		System.out.println("Enter CD/DVD information");
		
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 500; j++){
				for(int k = 0; k < 4; k++){
					if(dvd_cd_list[i][j][k] == null)
						
						System.out.print("Title: ");
						Title = input.nextLine();
			
						System.out.println("\t Company: ");
						Company = input.nextLine();
		
						System.out.println("\t Release date: ");
						Release_Date = input.nextLine();
		
						System.out.println("\t Borrowed date: ");
						Borrowed_Date = customer_record[i][4];
		
				}
				
					System.out.println("Input DVD names: ");
					disk = input.nextLine();
			}
			
				System.out.println("DVD or CD");
		
				if(disk.equals(0)){
					System.out.println("DVD");
				} else if(disk.equals(1)){
					System.out.println("CD");
				}
		}
	}
	
	public static void rentalDvdCd(){
		Scanner input = new Scanner(System.in);
		String name, DVD, CD, Rental_Date; 

		name = input.nextLine();
		
		System.out.println("Are you an existing customer ? ");

		for(int i = 0; i < 500; i++){
			if(customer_record[i][4] != null)
				System.out.println(name + ", Customer exists !!");
		
			System.out.println("DVD title ");
			DVD = input.nextLine();
		
			System.out.println("CD title ");
			CD = input.nextLine();
		
			System.out.println("rental date by Day:");
			Rental_Date = customer_record[i][4];
		
			System.out.println("return date by Day:" + returnDvdCd(Time, Title));
		
		}
	}
	
	public static void returnDvdCd(){
		
		Scanner input = new Scanner(System.in);
		String name;
		int Borrowed, Overdue, Rental_Fee;
		
		System.out.println("Return DVD/CD - Enter Customer Name: ");
		name = input.nextLine();
		if (customer_record[i][0].equals(name) && Return_Date != null) {
			for(int i = 0; i < 50; i++){		
				System.out.println(customer_record[i][0] + " " + customer_record[i][4]);
			
				for(int j = 0; j < 5; j++){
					Borrowed = customer_record[i][j];
					System.out.println(customer_record[i][j]);
			
					System.out.println("How much is each one: " + customer_record[i][j] + " Overdue?")
					Overdue = input.nextInt();
				}
			}
		}
		
		System.out.print("Title \t Number of Days Borrowed \t Number of Days Overdue \t Rental Fee");
		System.out.print(customer_record[i][4] + "\t " + Overdue + "\t " + );
		
		}
	
	public static void reportDvdCd(){
		Scanner input = new Scanner(System.in);
		String name, code, title;
		int index, indexNum;

		System.out.println("Report DVD/CD rental store information ");
		
		System.out.println(" Video Code "+"\t"+" Title "+"\t"+" Borrowed by ");
		// Add code here !!
				
		
	}
	
	public static void exit(){
		System.exit(1);
	}
	
	public void invalidInput(){
		System.out.println("Invalid inuput!!!");
	}
	
}
