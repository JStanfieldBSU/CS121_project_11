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
currently, nothing is different than in CheckingAccount
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
login - prompt user for two inputs, username and PIN, then pass them to overloaded login

login(user, pin) - return the value of the comparison of user and username as well as pass and PIN

getters and setters
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
    Customer(usernName, PIN)
    void start()
    string menu()
    void changePin()
    string getReport()
  ====================
```
algorithm
```
main - call start

Constructor - instantiate the checking and saving accounts and set the user and pin to placeholders

Constructor(user, pin) - instantiate the checking and saving accounts and set the user and pin to the provided values

start - call login(). while keep going, show the menu, accept input to the menu. input 0, keepgoing false. input 1, call the start of checking. input 2, call the start of savings. input 3, call changePin.

menu - returns the text for the menu.

changePin - currently nonfunctional. will prompt user for new input of pin and change the pin to the new value.

getReport - non functional.
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



