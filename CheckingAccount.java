import java.util.*;

class CheckingAccount implements HasMenu{
  double balance;

  CheckingAccount(){
    this.balance = 0.0;
  } // end constructor

  CheckingAccount(double balance){
    this.balance = balance;
  } // end overloaded constructor

  void main(){
    start();
  } // end main

  public String menu(){
    return "Account Menu\n\n0) Quit\n1) Check Balance\n2) Make a Deposit\n3) Make a Withdrawal\n\nAction (0-3): ";
  } // end menu

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
        checkBalance();
      } // end else if
      else if(input == 2){
        makeDeposit();
      } // end else if
      else if(input == 3){
        makeWithdrawal();
      } // end else if
    } // end while
  } // end start

  double getBalance(){
    return balance;
  } // end getBalance

  String getBalanceString(){
    return String.format("$%.2f%n", balance);
  } // end getBalanceString

  void setBalance(double balance){
    this.balance = balance;
  } // end setBalance

  void checkBalance(){
    System.out.println("Checking balance...\nCurrent Balance: " + getBalanceString());
  } // end checkBalance

  private double getDouble(){
    Scanner userInterface = new Scanner(System.in);
    return userInterface.nextDouble();
  } // end getDouble

  void makeDeposit(){
    System.out.print("Making a deposit...\nHow much to deposit?\n");
    this.balance += getDouble();
    System.out.println("New balance: " + getBalanceString());
  } // end makeDeposit

  void makeWithdrawal(){
    System.out.print("Making a withdrawal...\nHow much to withdraw?\n");
    this.balance -= getDouble();
    System.out.println("New balance: " + getBalanceString());
  } // end makeWithdrawal
}
