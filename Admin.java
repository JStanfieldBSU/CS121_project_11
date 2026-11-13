import java.util.*;

class Admin extends User{
  Admin(){
    setUserName("admin");
    setPIN("0000");
  } // end constructor

  public String menu(){
    return "Admin Menu\n\n0) Exit this Menu\n1) Full Customer Report\n2) Add User\n3) Apply Interest to Savings Accounts\n\nAction (0-3): ";
  } // end menu

  public void start(){
    // empty by design
  } // end start

  String getReport(){
    return (this.userName + " " + this.PIN);
  } // end getReport
} // end admin
