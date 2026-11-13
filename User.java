import java.util.*;
import java.io.Serializable;

abstract class User implements HasMenu, Serializable{
  String userName;
  String PIN;

  boolean login(){
    Scanner userInterface = new Scanner(System.in);

    System.out.print("Enter username: ");
    String user = userInterface.nextLine();
    System.out.print("Enter PIN: ");
    String pass = userInterface.nextLine();
    return login(user, pass);
  } // end login

  boolean login(String userName, String PIN){
    return this.userName.equals(userName) && this.PIN.equals(PIN);
  } // end login(userName, PIN)

  void setUserName(String userName){
    this.userName = userName;
  }

  String getUserName(){
    return this.userName;
  }

  void setPIN(String PIN){
    this.PIN = PIN;
  }

  String getPIN(){
    return this.PIN;
  }

  abstract String getReport();
}
