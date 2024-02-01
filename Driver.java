package MakeupProduct;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


//**********driver class
public class Driver {
	//static block
	static {
		System.out.println("\n ------------------  Welcome to Beauty Makeup System --------------------------");
		
		System.out.println("\n ------------------- No Credit Only Cash ----------------------------- \n ");
	}
	//non static block
	{
		System.out.println("\n********************   Thank you for Visiting , have a good day !!! ***************************");
	}
	//static method 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> a=new ArrayList<>();//homo arraylist
		a.add("Foundations");
		a.add("Serum");
		a.add("Lipstics");
		a.add("Lip Liner");
		a.add("Mascara");
		a.add("Eye shadow");
		System.out.println("Products : " +a);
		
		System.out.println("Press 1 for Signup");
		System.out.println("Press 2 for Login");
		System.out.println("Press 3 for Exit");
		Makeup m = new Makeup();
		try{
			int x = sc.nextInt();
		
		switch(x) {
		case 1:
			m.signup();
			break;
		case 2:
			m.login();
			break;
		case 3:
			System.out.println("Thank You for Visiting");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid Input!! Please Try Again");
			main(null);
		}
		
		
		}catch(InputMismatchException e) {
			main(null);
		}
		
		
			
		Bill p=new Bill();
		p.payment();
		
		
		Driver v=new Driver();
		
		
		sc.close();
	
		
	
	}
		
		
		
	}

interface pay{
	void payment();
}

class Bill implements pay{
	@Override
	public void payment() {
		System.out.println("\n            Bill is :           " +Makeup.totalBill);
		double GST=Makeup.totalBill*0.18;
		System.out.println("\n           GST :            " + GST);
		double totalCharges=Makeup.totalBill+GST;
		System.out.println("\n           Your total Bill amount is :            " + totalCharges);
		System.out.println("\n  YOUR PAYMENT DONE SUCCESSFULLY      ");
	}

}
//interface
interface Register {
	void signup();
	void login();
}


//main Makeup
class Makeup implements Register{
	
	private String name;
	private long contact=9876543210L;
	private String email="user@gmail.com";
	private String address;
	private String password="12345";

	static double totalBill;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your number");
		contact=sc.nextLong();
		if(contact>999999999 && contact<10000000000L) {
			System.out.println("contact number is valid");
		}else {
			System.out.println("please enter 10 digits!!Try again");
			setContact();
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//signup
	public void signup()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name : ");
		try {
		name=sc.nextLine();
		
		setContact();//contact number
		System.out.println("enter your email : ");
		email=sc.nextLine();
		System.out.println("enter your address :");
		address=sc.nextLine();
		System.out.println("Enter Password :");
		password=sc.nextLine();
	
		
		System.out.println("signup successfully");
		System.out.println("please proceed for login ");
//		makeup();
		
		}catch(Exception e) {
			signup();
		}
		login();
		sc.close();
		

		
	}
	
	//login
	public void login() {

		Scanner sc= new Scanner(System.in);
		System.out.println("press 1 to use contact for login");
		System.out.println("press 2 to use email for login");
		try {
		int n=sc.nextInt();
		
		if(n==1) {
			System.out.println("Enter the contact");
			long contact = sc.nextLong();
			sc.nextLine();//read the leftover new line 
			System.out.println("Enter the password");
			String pass = sc.nextLine();
			if (this.contact == contact && this.password.equals(pass)) {
				System.out.println("Login Successful");
				makeup();
			} else {
				System.err.println("User Credentials Incorrect");
				login();
			}
			

		} 
		else if (n == 2) {
			System.out.println("Enter the Email");
			sc.nextLine();
			String Email = sc.nextLine();
			System.out.println("Enter the password");
			String pass = sc.nextLine();
			if (email.equals(Email) && password.equals(pass)) {
				System.out.println("Login Successful");
			} else {
				System.err.println("User Credentials Incorrect");
				login();
			}
		} 
		else {
			System.err.println("Wrong Choice!!! Please try again");
			login();
		
		}
		
	}
		catch(Exception e) {
			login();
		}
	}
	// beauty makeup
	public void makeup() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Everyday");
		System.out.println("Press 2 for Eyes");
		System.out.println("Press 3 for lips");
		System.out.println("Press 4 for Exit");
		int x = sc.nextInt();
		switch(x) {
		case 1:
			Everyday e = new Everyday();
			e.everydayMakeup();
			break;
		case 2:
			Eye i= new Eye();
		    i.eyeMakeup();
			break;
		case 3: 
			Lips l=new Lips();
    		l.lipsMakeup();
			break;
		
		case 4:
			System.out.println("Thank You for visiting");
			System.exit(0);
			break;
		default:
			System.err.println("Try Again!!!");
			makeup();//call itself again
			break;
		}
		
		sc.close();
	}
	
			
}

//Everyday
class Everyday extends Makeup{
	
	
	public void everydayMakeup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Foundations");
		System.out.println("press 2 for Blushes");
		System.out.println("Press 3 to go back");
		try {
		int x = sc.nextInt();
		switch (x) 
		{
		case 1:
			Faundations f = new Faundations();
			f.faundations();
			break;
		
		case 2:
			Blushes b=new Blushes();
			b.blushes();
			break;
		case 3:
			makeup();
			break;
		default:
			System.err.println("Please Try Again!!!");
			everydayMakeup();
			break;

	  }
		}catch(Exception E) {
			everydayMakeup();
		}
		sc.close();
}
	
}
	
//foundation extends everyday
class Faundations extends Everyday{
	
	

	public void faundations() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Liquid Faundations");
		System.out.println("Press 2 for Cream faundations");
		System.out.println("Press 3 for Serum faundations");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
			liquidFaundations();
			break;
		case 2:
			creamFaundations();
			break;
		case 3:
			serumFaundations();
			break;
		case 4:
			everydayMakeup();;
			break;
		default:
			System.err.println("Please choose correct option");
			faundations();
			break;
		}
		}catch(Exception e) {
			faundations();
		}
		sc.close();
	}
	
	public void liquidFaundations() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Lakme Perfecting Liquid Marble faundation(27ml)");
		System.out.println("Press 2 for Maybelline new york fit me Matte+Poreless liquid faundation(18ml)");
		System.out.println("Press 3 for Daily LifeForever52 water liquid faundation(30ml)");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of Lakme Perfecting Liquid Marble faundation(27ml) is Rs 350");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 350;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						liquidFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					liquidFaundations();
				} else {
					System.err.println("Please choose correct option");
					liquidFaundations();
				}
				break;
			case 2:
				System.out.println("Price of Maybelline new york fit me Matte+Poreless liquid faundation(18ml) is Rs 250");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 250;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						liquidFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					liquidFaundations();
				} else {
					System.err.println("Please choose correct option");
					liquidFaundations();
				}
				break;
			case 3:
				System.out.println("Price of Daily LifeForever52 water liquid faundation(30ml) is Rs 950");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 950;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						liquidFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					liquidFaundations();
				} else {
					System.err.println("Please choose correct option");
					liquidFaundations();
				}
				break;
			case 4:
				faundations();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				liquidFaundations();
			}
		}catch(Exception e) {
			liquidFaundations();
		}
		sc.close();

		}
	
	public void creamFaundations() {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 for Face It cream foundation(8ml)");
			System.out.println("Press 2 for Mars Lightweight BB cream faundation(30ml)");
			System.out.println("Press 3 for MyGlamm total makeover FF cream faundation palatte-Honey(5ml)");
			System.out.println("Press 4 to go back");
			try {
			int n = sc.nextInt();
			switch (n) {
			case 1:
					System.out.println("Price of Face It cream foundation(8ml) is Rs 2630");
					System.out.println("Choose Y to order or N to go back");
					char ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						totalBill = totalBill + 2630;
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Makeup");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							creamFaundations();
							break;
						case 2:
							makeup();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						creamFaundations();
					} else {
						System.err.println("Please choose correct option");
						creamFaundations();
					}
					break;
				case 2:
					System.out.println("Price of Mars Lightweight BB cream faundation(30ml) is Rs 300");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						totalBill = totalBill + 300;
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Makeup");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							creamFaundations();
							break;
						case 2:
							makeup();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						creamFaundations();
					} else {
						System.err.println("Please choose correct option");
						creamFaundations();
					}
					break;
				case 3:
					System.out.println("Price of MyGlamm total makeover FF cream faundation palatte-Honey(5ml) is Rs 725");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						totalBill = totalBill + 725;
						System.out.println("Do you want to order more?");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Makeup");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							creamFaundations();
							break;
						case 2:
							makeup();
							break;
						case 3:
							System.out.println("Please pay the amount");
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						creamFaundations();
					} else {
						System.err.println("Please choose correct option");
						creamFaundations();
					}
					break;
				case 4:
					faundations();
					break;
				default:
					System.err.println("Sahi sahi choose kar");
					creamFaundations();
				}
			}catch(Exception e) {
				creamFaundations();
				
			}
			sc.close();

		}
	
	public void serumFaundations() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Mamaearth Glow serum faundation with vitamin C & turmeric(30ml)");
		System.out.println("Press 2 for Kaynat Glow Serum Faundation Lotion with Vitamin C Cinnamon And Turmeric (30ml)");
		System.out.println("Press 3 for MyGlamm Super serum faundation-401W Toffe ");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of  Mamaearth Glow serum faundation with vitamin C & turmeric(30ml) is Rs 508");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 508;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						serumFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					serumFaundations();
				} else {
					System.err.println("Please choose correct option");
					serumFaundations();
				}
				break;
			case 2:
				System.out.println("Price of Kaynat Glow Serum Faundation Lotion with Vitamin C Cinnamon And Turmeric (30ml) is Rs 999");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 999;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						serumFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					serumFaundations();
				} else {
					System.err.println("Please choose correct option");
					serumFaundations();
				}
				break;
			case 3:
				System.out.println("Price of MyGlamm Super serum faundation-401W Toffe is Rs 419");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 725;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						serumFaundations();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					serumFaundations();
				} 
				else {
					System.err.println("Please choose correct option");
					serumFaundations();
				}
				break;
			case 4:
				faundations();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				serumFaundations();
			}
		}catch(Exception e) {
			serumFaundations();	
		}
		sc.close();
	}

}

//blushes extends everyday

class Blushes extends Everyday{
	

	

	public void blushes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Powder blushes");
		System.out.println("Press 2 for Gel blushes");
		System.out.println("Press 3 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
			powderBlush();
			break;
		case 2:
			gelBlush();
			break;
		
		case 3:
			everydayMakeup();;
			break;
		default:
			System.err.println("Please choose correct option");
			blushes();
			break;
		}
		}catch(Exception e) {
			blushes();
		}
		sc.close();
	}
	
	public void powderBlush() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Faces canada powder berry blush ");
		System.out.println("Press 2 for Blue heaven shimmer matte powder blush ");
		System.out.println("Press 3 for SUGAR POP powder blush 249");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of Faces canada powder berry blush is Rs 262");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 262;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						powderBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					powderBlush();
				} else {
					System.err.println("Please choose correct option");
					powderBlush();
				}
				break;
			case 2:
				System.out.println("Price of Blue heaven shimmer matte powder blush is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 150;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						powderBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					powderBlush();
				} else {
					System.err.println("Please choose correct option");
					powderBlush();
				}
				break;
			case 3:
				System.out.println("Price of SUGAR POP powder blush is Rs 249");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 249;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						powderBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					powderBlush();
				} else {
					System.err.println("Please choose correct option");
					powderBlush();
				}
				break;
			case 4:
				blushes();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				powderBlush();
			}
		}catch(Exception e) {
			powderBlush();
			
		}
		sc.close();
	}

	public void gelBlush() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for RENEE summer slush jelly blush ");
		System.out.println("Press 2 for REVLON PINCH Me sheer gel blush ");
		System.out.println("Press 3 for SWISS BEAUTY gel blush palatte");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of RENEE summer slush jelly blush Rs 199");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 199;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						gelBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					powderBlush();
				} else {
					System.err.println("Please choose correct option");
					gelBlush();
				}
				break;
			case 2:
				System.out.println("Price of REVLON PINCH Me sheer gel blush is Rs 3446");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 3446;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						gelBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					gelBlush();
				} else {
					System.err.println("Please choose correct option");
					gelBlush();
				}
				break;
			case 3:
				System.out.println("Price of SWISS BEAUTY gel blush palatte is Rs 389");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 389;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						gelBlush();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					gelBlush();
				} else {
					System.err.println("Please choose correct option");
					gelBlush();
				}
				break;
			case 4:
				blushes();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				gelBlush();
			}
		}catch(Exception e) {
			gelBlush();
		
		}
		sc.close();
	}

}

class Eye extends Makeup{
	

	public void eyeMakeup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for eyeshadow");
		System.out.println("Press 2 for mascara");
		System.out.println("Press 3 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
			eyeshadow();
			break;
		
		case 2:
			mascara();
			
			break;
		case 3:
			makeup();
			break;
		default:
			System.err.println("Please choose correct option");
			eyeMakeup();
			break;
		}
		}catch(Exception e) {
			eyeMakeup();
		}
		sc.close();
	}

	
	public void eyeshadow() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for MAC Eyeshadow palatte ");
		System.out.println("Press 2 for Mamaearth brown shimmary Eyeshadow ");
		System.out.println("Press 3 for Lakme pink glittery Eyeshadow");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of  MAC Eyeshadow palatte is Rs 350");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 350;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 2:
				System.out.println("Price of Mamaearth brown shimmary Eyeshadow is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 150;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 3:
				System.out.println("Price of Lakme pink glittery Eyeshadow is Rs 250");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 250;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 4:
				eyeMakeup();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				eyeshadow();
			}
		}catch(Exception e){
			eyeshadow();
			
		}
		
		sc.close();
		
	}

	
	public void mascara() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Lakme   ");
		System.out.println("Press 2 for Blue heven  ");
		System.out.println("Press 3 for Lakme eyeconic volume muscara");
		System.out.println("Press 4 to go back");
		try {
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of  MAC Eyeshadow palatte is Rs 350");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 350;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 2:
				System.out.println("Price of Mamaearth brown shimmary Eyeshadow is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 150;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 3:
				System.out.println("Price of Lakme pink glittery Eyeshadow is Rs 250");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 250;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						eyeshadow();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					eyeshadow();
				} else {
					System.err.println("Please choose correct option");
					eyeshadow();
				}
				break;
			case 4:
				eyeMakeup();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				eyeshadow();
			}
		}catch(Exception e) {
			eyeshadow();
		}
		
		
		
		sc.close();
	
	

		
		
	
		
		
	}

	
	
	
	
}


class Lips extends Makeup{
	
	public void lipsMakeup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for lipstics");
		System.out.println("Press 2 for lip liner");
		System.out.println("Press 3 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			lipstics();
			break;
		
		case 2:
			lipLiner();
			
			break;
		case 3:
			makeup();
			break;
		default:
			System.err.println("Please choose correct option");
			lipsMakeup();
			break;
		}
		sc.close();
	}
	
	public void lipstics() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for MAC Hot red lipstic ");
		System.out.println("Press 2 for Mamaearth nude brown lipstic ");
		System.out.println("Press 3 for Lakme pink lipstic");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of MAC Hot red lipstic is Rs 250");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 250;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipstics();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipstics();
				} else {
					System.err.println("Please choose correct option");
					lipstics();
				}
				break;
			case 2:
				System.out.println("Price of Mamaearth nude brown lipstic is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 150;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipstics();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipstics();
				} else {
					System.err.println("Please choose correct option");
					lipstics();
				}
				break;
			case 3:
				System.out.println("Price of Lakme pink lipstic is Rs 300");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 300;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipstics();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipstics();
				} else {
					System.err.println("Please choose correct option");
					lipstics();
				}
				break;
			case 4:
				lipsMakeup();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				lipstics();
			}
		sc.close();
	
		
	}

	public void lipLiner() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Swiss Beauty Bold Matt Lip Liner ");
		System.out.println("Press 2 for Insight Cosmetics Glide On Lip Liner-03,0.3 gm ");
		System.out.println("Press 3 for SUGAR POP Velvet Matte Lip Liner - 03 Beige Vibes (Nude Brown)");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
				System.out.println("Price of Swiss Beauty Bold Matt Lip Liner is Rs 70");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 70;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipLiner();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipLiner();
				} else {
					System.err.println("Please choose correct option");
					lipLiner();
				}
				break;
			case 2:
				System.out.println("Price of Insight Cosmetics Glide On Lip Liner-03,0.3 gmc is Rs 95");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 150;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipLiner();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipLiner();
				} else {
					System.err.println("Please choose correct option");
					lipLiner();
				}
				break;
			case 3:
				System.out.println("Price of SUGAR POP Velvet Matte Lip Liner - 03 Beige Vibes (Nude Brown) is Rs 250");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					totalBill = totalBill + 250;
					System.out.println("Do you want to order more?");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Makeup");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						lipLiner();
						break;
					case 2:
						makeup();
						break;
					case 3:
						System.out.println("Please pay the amount");
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					lipstics();
				} else {
					System.err.println("Please choose correct option");
					lipstics();
				}
				break;
			case 4:
				lipsMakeup();
				break;
			default:
				System.err.println("Sahi sahi choose kar");
				lipLiner();
			}
		sc.close();
	
	}
	
		
}

