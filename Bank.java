import java.util.*;
import java.io.*;

class Bank implements HasMenu{

  Admin admin = new Admin();
  CustomerList customers = new CustomerList();

  public Bank(){
    // uncomment the next two lines to refresh data

    this.loadSampleCustomers();
    this.saveCustomers();
    this.loadCustomers();
    this.start();
    this.saveCustomers();
  } // end constructor

  void main(){

  } // end main

  void loadSampleCustomers(){
    customers.add(new Customer("Alice", "0000"));
    customers.get(0).checking.setBalance(1000);
    customers.get(0).savings.setBalance(1000);
    customers.add(new Customer("Bob", "2222"));
    customers.add(new Customer("Cindy", "3333"));
  } // end loadSampleCustomers

  void saveCustomers(){
    try {
      FileOutputStream customerFile = new FileOutputStream("customers.dat");
      ObjectOutputStream output = new ObjectOutputStream(customerFile);

      output.writeObject(customers);
      output.close();
      customerFile.close();
    } // end try
    catch(IOException e) {
      System.out.println("Error Involving Save");
    } // end catch
  } // end saveCustomers

  void loadCustomers(){
    try{
      FileInputStream customerFile = new FileInputStream("customers.dat");
      ObjectInputStream input = new ObjectInputStream(customerFile);
      
      customers = (CustomerList)input.readObject();
      input.close();
      customerFile.close();
    } // end try
    catch(IOException e) {
      System.out.println("Error Involving Load");
    } // end catch
    catch(ClassNotFoundException e) {
      System.out.println("Error Involving Class");
    } // end catch
  } // end loadCustomers

  void reportAllUsers(){
    for(int i = 0; i < customers.size(); i++){
      System.out.print(customers.get(i).getReport());
    } // end for
  } // end reportAllUsers

  void addUser(){
    String existingUser = null;
    Scanner userInterface = new Scanner(System.in);

    System.out.print("Enter username: ");
    String user = userInterface.nextLine();
    System.out.print("Enter PIN: ");
    String pass = userInterface.nextLine();
    
    for(int i = 0; i < customers.size(); i++){
      if(customers.get(i).userName.equals(user)){
        existingUser = customers.get(i).getUserName();
        System.out.println("\nUSER ALREADY EXISTS\n");
        i = customers.size() + 1;
      } // end if
    } // end for
    if(existingUser == null){
      customers.add(new Customer(user, pass));
      System.out.println("\nUSER CREATED SUCCESSFULLY\n");
    } // end if
  } // end addUser

  void applyInterest(){
    for(int i = 0; i < customers.size(); i++){
      customers.get(i).savings.calcInterest();
    } // end for
    System.out.println("\nINTEREST APPLIED\n");
  } // end 

  void loginAsCustomer(){
    Customer currentCustomer = null;
    Scanner userInterface = new Scanner(System.in);

    System.out.print("Enter username: ");
    String user = userInterface.nextLine();
    System.out.print("Enter PIN: ");
    String pass = userInterface.nextLine();
    for(int i = 0; i < customers.size(); i++){
      if(customers.get(i).login(user, pass)){
        currentCustomer = customers.get(i);
        currentCustomer.start();
        i = customers.size() + 1;
      } // end if
    } // end for
    if(currentCustomer == null){
      System.out.print("Customer not Found\n");
    } // end if
  } // end loginAsCustomer

  public String menu(){
    return "Bank Menu\n\n0) Exit System\n1) Login as Admin\n2) Login as Customer\n\nAction: ";
  } // end 

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
        startAdmin();
      } // end else if
      else if(input == 2){
        loginAsCustomer();
      } // end else if
    } // end while
  } // end start

  void startAdmin(){
    if(admin.login()){
      Scanner userInterface = new Scanner(System.in);
      boolean adminKeepGoing = true;

      while(adminKeepGoing){
        System.out.print(admin.menu());
        int input = userInterface.nextInt();
        if(input == 0){
          System.out.print("Quitting\n");
          adminKeepGoing = false;
        } // end if
        else if(input == 1){
          reportAllUsers();
        } // end else if
        else if(input == 2){
          addUser();
        } // end else if
        else if(input == 3){
          applyInterest();
        } // end else if
      } // end while
    } // end if
  } // end startAdmin
} // end Bank

class CustomerList extends ArrayList<Customer>{}
