import java.util.*;

class SavingsAccount extends CheckingAccount{
  double interestRate = 0.05;

  void main(){
    start();
  } // end main

  void calcInterest(){
    double interestValue = this.balance * interestRate;
    this.balance += interestValue;
  } // end calcInterest

  void setInterestRate(double newInterest){
    this.interestRate = newInterest;
  } // end setInterestRate

  double getInterestRate(){
    return this.interestRate;
  } // end getInterestRate
}
