import java.util.*;

class Customer extends User{
  CheckingAccount checking;
  SavingsAccount savings;

  void main(){
    if(login()){
      start();
    } // end if
  } // end main

  Customer(){
    checking = new CheckingAccount();
    savings = new SavingsAccount();

    setUserName("Foobar");
    setPIN("0000");
  } // end constructor

  Customer(String userName, String PIN){
    checking = new CheckingAccount();
    savings = new SavingsAccount();

    setUserName(userName);
    setPIN(PIN);
  } // end overloaded constructor

  public void start(){
    Scanner userInterface = new Scanner(System.in);
    boolean keepGoing = true;

    while(keepGoing){
      System.out.print(menu());
      int input = userInterface.nextInt();
      if(input == 0){
        System.out.print("Quitting\n");
        keepGoing = false;
      } // end if
      else if(input == 1){
        System.out.print("Checking Account\n");
        checking.start();
      } // end else if
      else if(input == 2){
        System.out.print("Savings Account\n");
        savings.start();
      } // end else if
      else if(input == 3){
        System.out.print("Change PIN\n");
        changePin();
      } // end else if
    } // end while
  } // end start

  public String menu(){
    return "Customer Menu\n\n0) Quit\n1) Manage Checking Account\n2) Manage Savings Account\n3) Change PIN\n\nAction (0-3): ";
  } // end menu

  void changePin(){
    if(login()){
      Scanner userInterface = new Scanner(System.in);
      System.out.print("Enter New PIN: ");
      String newPIN = userInterface.nextLine();
      System.out.print("Confirm PIN: ");
      String matchingPIN = userInterface.nextLine();
      if(newPIN.equals(matchingPIN)){
        this.setPIN(newPIN);
        System.out.println("\nPIN CHANGED\n");
      } // end if
      else{
        System.out.println("\nPINS DO NOT MATCH\n");
      } // end else
    } // end if
    else{
      System.out.println("\nFAILED TO LOGIN\n");
    } // end else
  } // end changePIN

  String getReport(){
    return ("User: " + this.userName + ", Checking: " + checking.getBalanceString() + ", Savings: " + savings.getBalanceString() + "\n");
  } // end getReport
} // end Customer
