import java.util.Scanner;

public class ATM
{
    private static double balance = 10000.00;
    public static double DepAmount;
    public static double WitAmount;
    private static void checkBalance()
    {
        System.out.println("Your current balance is Rs."+balance);
    }

    private static void Deposit()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much amount do you want to deposit?");
        DepAmount = scanner.nextInt();
        balance += DepAmount;
        System.out.println("Deposition Successful!");
        System.out.println("Updated balance amount is: "+balance);
    }

    private static void Withdrawal()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much do you want to Withdraw?");
        WitAmount = scanner.nextInt();
        if(WitAmount > balance)
        {
            System.out.println("Insufficient balance! Sorry withdrawal not possible..");
            System.out.println("Balance amount available: "+balance);
        }
        else
        {
            balance -= WitAmount;
            System.out.println("Withdrawal was successful!");
            System.out.println("Updated balance amount is: " + balance);
        }
    }

    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice!=4)
        {
            System.out.println("Welcome to your Bank! How can we help you?");
            System.out.println("1.) Check Balance");
            System.out.println("2.) Deposit Amount");
            System.out.println("3.) Withdraw Amount");
            System.out.println("4.) Exit");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1: checkBalance();
                        break;
                case 2: Deposit();
                        break;
                case 3: Withdrawal();
                        break;
                case 4: System.out.println("Exiting..");
                        break;
                default: System.out.println("Wrong option selected");
            }
            System.out.println("Thank you!");
        }
    }
}
