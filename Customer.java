import java.util.*;

class Customer extends User{
  CheckingAccount checking;
  SavingsAccount savings;

  void main(){
    start();
  }

  Customer(){
    checking = new CheckingAccount();
    savings = new SavingsAccount();

    setUserName("Alice");
    setPIN("0000");
  } // end constructor

  Customer(String userName, String PIN){
    checking = new CheckingAccount();
    savings = new SavingsAccount();

    setUserName(userName);
    setPIN(PIN);
  } // end overloaded constructor

  public void start(){
    login();
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
        System.out.println("Checking Account\n");
        checking.start();
      } // end else if
      else if(input == 2){
        System.out.println("Savings Account\n");
        savings.start();
      } // end else if
      else if(input == 3){
        System.out.println("Change PIN\n");
      } // end else if
    } // end while
  }

  public String menu(){
    return "Customer Menu\n\n0) Quit\n1) Manage Checking Account\n2) Manage Savings Account\n3) Change PIN\n\nAction (0-3): ";
  }

  void changePin(){
    // placeholder
  }

  String getReport(){
    return "Placeholder";
  } // end getReport
} // end Customer
