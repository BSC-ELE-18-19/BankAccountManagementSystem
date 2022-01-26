/*bsc-ele-18-19, Danford Yankho Mponda
 * Lab group: Monday afternoon
 * Lab work: Bank account management system
 * Date submitted: 26/01/22
 */

import java.util.*;
class BankAccount {  
    private int accNo;  
    private String fName;
    private String sName;
    private String accountType;
    private String regNumber;
    private String residence;
    private long balance;  
    public int choice;
    Scanner scan = new Scanner(System.in);  

    //method to open new account  
    public void openAccount() {  
    	System.out.print("Select The Bank Account Type");
    	System.out.println();
    	System.out.println(" 1. Students \n 2. Current \n 3. Savings \n 4. Checking/Business");
    	choice = scan.nextInt();
    	System.out.print("Enter First name: ");  
        fName = scan.next(); 
        System.out.print("Enter Surname: ");  
        sName = scan.next();  
    	
        System.out.print("Enter residence: ");  
        residence = scan.next();  
    	
        //account id number generator
        accNo = (int)(Math.random() * 100000 + 10000);   
        if(choice == 1){
        	System.out.print("Enter Student Registration Number: ");  
            regNumber = scan.next(); 
            accountType = "Students "; 
            balance = 200;

        }
        else if(choice ==2){ 
        	accountType = "Current ";
        	balance = 0;

        }
        else if(choice ==3){
        	accountType = "Savings "; 
        	balance = 0;
        }
        else if(choice ==4){
        	accountType = "Checking/Business";
        	balance = 20000;

        }
        System.out.print("Enter Balance: ");  
        balance += scan.nextLong(); 
        
    }  
  
   
    //method to display account details  
    public void showAccount() {  
        System.out.println();
        System.out.println("Name of account holder: " + fName + " " + sName);  
        System.out.println("Account no.: " + accNo); 
        if(choice == 1){
        	 System.out.println("Student Registraion #: " + regNumber);
        }
        else{
       
        }
        System.out.println("Account type: " + accountType); 
        System.out.println("Account holders residence: " + residence);
        System.out.println("Balance: MWK" + balance);  
        System.out.println(); 
    }  
    
    //method to deposit money  
    public void deposit() {  
        long amt;  
        System.out.println("Enter the amount you want to deposit: ");  
        amt = scan.nextLong();  
        balance = balance + amt;
        System.out.println("Balance after deposit: MWK" + balance);  
        
    }  
   
    //method to withdraw money  
    public void withdrawal() {  
        long amt;  
        System.out.println("Enter the amount you want to withdraw: ");  
        amt = scan.nextLong();  
        if (balance >= amt) {  
            balance = balance - amt;  
            System.out.println("Balance after withdrawal: MWK" + balance);  
        } else {  
            System.out.println("Your balance is less than MWK" + amt + "\tTransaction failed...!!" );  
        }  
    }  
  
    //method to search an account number  
    public boolean search(int ac_no) {  
        if (accNo == ac_no)  {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    
}  
  
    public static void main(String arg[]) {  
        Scanner scan = new Scanner(System.in);  
        //create initial accounts  
        System.out.print("How many accounts do you want to create?");   
        int num = scan.nextInt();  
       
        BankAccount BankObject[] = new BankAccount[num];  
       
        for (int i = 0; i < BankObject.length; i++) {  
            BankObject[i] = new BankAccount();
            BankObject[i].openAccount();
           
        }  
        // loop runs until number 5 is not pressed to exit 
        // loop used for displaying user interface
        int ch;  
        do {  
            System.out.println("\n ***Welcome To Bank Management System***");  
            System.out.println(" 1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");  
            System.out.println("Enter your choice: ");  
            ch = scan.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (int i = 0; i < BankObject.length; i++) {  
                            BankObject[i].showAccount();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        int accountNo = scan.nextInt();  
                        boolean found = false;  
                        for (int i = 0; i < BankObject.length; i++) {  
                            found = BankObject[i].search(accountNo);  
                            if (accountNo == BankObject[i].accNo) {  
                                break;  
                            }  
                         
                            else if (accountNo != BankObject[i].accNo) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;
                        }
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        accountNo = scan.nextInt();  
                        found = false;  
                        for (int i = 0; i < BankObject.length; i++) {  
                            found = BankObject[i].search(accountNo);  
                            if (found) {  
                                BankObject[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        accountNo = scan.nextInt();  
                        found = false;  
                        for (int i = 0; i < BankObject.length; i++) {  
                            found = BankObject[i].search(accountNo);  
                            if (found) {  
                                BankObject[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 5:  
                        System.out.println("Goodbye...");  
                        break;  
                }  
            }  
            while (ch != 5);  
        }  
    }  

