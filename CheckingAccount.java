import java.util.*;
import java.io.*;

class CheckingAccount implements HasMenu, Serializable{
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
    return String.format("$%.2f", balance);
  } // end getBalanceString

  void setBalance(double balance){
    this.balance = balance;
  } // end setBalance

  void checkBalance(){
    System.out.println("Checking balance...\nCurrent Balance: " + getBalanceString());
  } // end checkBalance

  private double getDouble(){
    Scanner userInterface = new Scanner(System.in);
    double output = 0.0;
    
    try{
      output = userInterface.nextDouble();
    } // end try 
    catch (InputMismatchException mme) {
      output = 0;
    } // end catch
    return output;
  } // end getDouble

  void makeDeposit(){
    System.out.print("Making a deposit...\nHow much to deposit?\n");
    double depositAmount = getDouble();
    this.balance += depositAmount;
    System.out.println("New balance: " + getBalanceString() + '\n');
  } // end makeDeposit

  void makeWithdrawal(){
    System.out.print("Making a withdrawal...\nHow much to withdraw?\n");
    double withdrawalAmount = getDouble();
    if(withdrawalAmount < this.balance){
      this.balance -= withdrawalAmount;
      System.out.println("New balance: " + getBalanceString() + '\n');
    } // end if
    else{
      System.out.println("\nINSUFFICIENT FUNDS\n");
    } // end else
  } // end makeWithdrawal
} // end CheckingAccount
