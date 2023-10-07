public class BankAccount {

    private double total;
    private String accountNumber;
    private String accountHolder;

    public BankAccount(String accountNumber,String accountHolder,double s){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.total=s;
    }

    public double deposit(double d){
        total=total+d;
        return total;
    }

    public void withdraw(double w){
        if(total<w){
            System.out.println("Not enough balance.");
        }else{
            total=total-w;
        }
    }

    public void displayAccountDetails(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Balance: "+total);
    }

    public static void main(String[] args) {
        BankAccount account1=new BankAccount("12345","John Doe",1000);
        BankAccount account2=new BankAccount("67890","Jane Smith",500);

        account1.deposit(500);
        account2.withdraw(200);
        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}
