# CS121_project_10
Bank on It part 1

## HasMenu
```
interface HasMenu 
  ====================
  ====================
  string menu()
  void start()
  ====================
```

## CheckingAccount
```
class CheckingAccount implements HasMenu
  ====================
    double balance
  ====================
    CheckingAccount()
    CheckingAccount(double balance)
    main()
    string menu()
    void start()   
    double getBalance()
    string getBalanceString()
    void setBalance(double balance)
    void checkBalance()
    private double getDouble()
    void makeDeposit()
    void makeWithdrawal
  ====================
```
algorithm
```
constructors are simple, no param set balance to 0.0, with double balance set this.balance to balance.

main - call start

menu - return the menu text

start - while keepgoing, call menu, accept input based on menu options, and call respective getter or setter.

getBalance - return the double balance

getBalanceString - turn getBalance into a string formatted in $0.00 style

setBalance - change the balance variable

checkBalance - call getBalanceString and print it

getDouble - call input for deposit/withdraw and return it

void makeDeposit -  call get double and then add it to balance, then print the new balance

void makeWithdrawal - call get double and then subtract it from balance, then print the new balance
```

## SavingsAccount
```
class SavingsAccount extends CheckingAccount
  ====================
    double interestRate
  ====================
    main()
    calcInterest()
    void setInterestRate()
    double getInterestRate()
  ====================
```
algorithm
```
calcInterest - take the balance and multiply it by the interest rate, store that in a double, then add that double to the balance.
```

## User
```
abstract class User implements HasMenu, Serializable
  ====================
    string userName
    string PIN
  ====================
    boolean login()
    boolean login(userName, PIN)
    void setUserName(userName)
    string getUserName()
    void setPIN(PIN)
    string getPIN()
    abstract string getReport()
  ====================
```
algorithm
```
login - prompt user for username and pin, then pass those to login(user, pass), which then compares them to the properties userName and PIN, which then returns true if they match.
```

## Customer
```
class Customer extends User
  ====================
    CheckingAccount checking 
    SavingsAccount savings 
  ====================
    void main()
    Customer()
    Customer(userName, PIN)
    void start()
    string menu()
    void changePin()
    string getReport()
  ====================
```
algorithm
```
main - asks the user to login. if that check passes, it calls start.

Customer - default constructor. creates the checking, savings, and fills user and pin with filler data foobar and 0000

Customer(userName, PIN) - overloaded constructor. creates the checking, savings, and fills user and pin with provided data

start - prints menu and handles the option selection

menu - returns the menu text

changePin - asks the user to verify their identity by logging in again, then asks the user to input their new pin and confirm that pin, then sets the customer's pin to the newPin

getReport - returns username, checking balance, and savings balance
```

## Admin
```
class Admin extends User
  ====================
  ====================
    Admin()
    string menu()
    void start()
    string getReport()
  ====================
```
algorithm
```
Admin - sets username and pin to default parameters

menu - returns the menu text

start - empty

getReport - returns username and pin

all actual admin tasks are done in Bank
```

## Bank
```
class Bank implements HasMenu
  ====================
    Admin admin
    ArrayList customers
  ====================
    Bank()
    void main()
    void loadSampleCustomers()
    void saveCustomers()
    void loadCustomers()
    void reportAllUsers()
    void addUser()
    void applyInterest()
    void loginAsCustomer()
    string menu()
    void start()
    void startAdmin()
  ====================
```
algorithm
```
Bank - (commented out) initialize the sample by calling loadSampleCustomers, then save the sample to ensure the file exists. Load the file by calling loadCustomers, then call start, once start exits, call saveCustomers

main - empty

loadSampleCustomers - create three sample customers and set the balance in one of them

saveCustomers - try and create a file with a fileoutputstream named customers.dat, then then create an outputStream that pushes to that fileoutputstream. write all the customers to the output stream, which writes them to the file, close the output and close the file. Catch an error.

loadCustomers - try and open the file customers.dat, and pull an input stream from it. feed that imput to customers, then close the input stream and file

reportAllUsers - go through each customer in customers and call their report function

addUser - create a temporary existingUser string, accept input relating to a new account from the user involving user and pass, then go through each existing customer and compare the username. If a user is already made with that name, inform the user and exit the loop. Else, create a new user in the arraylist with the provided values.

applyInterest - for each customer in the arraylist, call the savings account calcInterest function

loginAsCustomer - create a temporary customer and set it to null, then prompt the user for login details, for each customer in the arraylist, check if they could login with the given parameters, if they can, start and set the sentinel to size of arrayList + 1. Else, inform the user that there was no account with those details.

menu - returns the menu text for bank

start - prints the menu text and accepts and handles the input from the user regarding which option to select

startAdmin - calls the admin menu text and handles all of admin tasks and calling the methods relating to them
```
