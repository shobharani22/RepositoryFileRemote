package com;
import java.util.*;
import java.io.*;
public class VirtualKey {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// welcome Screen and developer details
		System.out.println("WELCOME to Virtual Key For Repositories");
		System.out.println("Developer's Name : Shobharani B S");

		VirtualKey obj =new VirtualKey();
		char ch;
		do {
			System.out.println("Press 0 to display all the files");
			System.out.println("Press 1 to add a files");
			System.out.println("Press 2 to delete a files");
			System.out.println("Press 3 to search a files");
			System.out.println("Press 4 to exit ");
			int choice = sc.nextInt();
			switch(choice) {
			case 0:
				try {
					List<String> al =new ArrayList();
					File f = new File("D:\\java programs");
					String[] arr =f.list();
					al=Arrays.asList(arr);
					Collections.sort(al);

					for(String st : al) {
						System.out.println(st);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 1:
				System.out.println("enter name of file you want to add");
				try {
					obj.add(sc.next());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("enter name of file you want to delete");
				try {
					obj.delete(sc.next());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("enter name of file you are looking for");
				try {
					obj.search(sc.next());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("----------***THANK YOU***--------------");
				
				break;
			default:
				System.out.println("Wrong entry!!!");
			}
			System.out.println(" Do you want to continue (Type y[yes] or n[no] ");
			ch=sc.next().charAt(0);
			if (ch=='n'||ch=='N') {
				System.out.println("Thank you for visiting");
			}

		}while(ch=='Y' || ch=='y');
	}
	// method for adding a file
	public void add(String s1) {
		try {
			File f1 = new File("D:\\java programs"+s1);
			f1.createNewFile();
			System.out.println(s1+" is created.");
		}
		catch(Exception e) {

		}
	}
	// method for deleting a file
		public void delete(String s2) throws InvalidfileNameException {
			
				File f2 = new File("D:\\java programs"+s2);
				if(f2.exists()) {
					f2.delete();
					System.out.println(s2+" is deleted");
				}
				else {
					throw new InvalidfileNameException("File not found");
				}
		}
		// method for searching a file
		public void search(String s3) {
				File f3 = new File("D:\\java programs");
				
				String a[]=f3.list();
				System.out.println(a);
				int m=0;
				for(int i=0;i<=a.length-1;i++) {
					if(a[i].equals(s3)) {
						m=i;
					}
				}
				if(m!=0) {
					System.out.println(s3+" is on number "+m);
				}
				else {
					System.out.println(s3+" not found");
				}
		}
	
}
class InvalidfileNameException extends Exception{
	InvalidfileNameException(String s){
		super(s);
	}
}

