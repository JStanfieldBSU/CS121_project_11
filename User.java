import java.util.*;
import java.io.*;

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
  } // end setUserName

  String getUserName(){
    return this.userName;
  } // end getUserName

  void setPIN(String PIN){
    this.PIN = PIN;
  } // end setPIN

  String getPIN(){
    return this.PIN;
  } // end getPIN

  abstract String getReport();
} // end User
