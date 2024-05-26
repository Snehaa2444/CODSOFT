import java.util.Random;
import java.util.Scanner;

public class Game
{
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner (System.in);
        Random random = new Random();
        int numb = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;
        System.out.println ("*** Number Guessing Game ***");
        System.out.println("You have to guess a no. between 1 to 100 and see if it matches the no. that the system guessed!");
        System.out.println("Note: you only have 5 attempts!");
        System.out.println("Lets get started!! All the best!!!....");
        while (attempts<5)
        {
            System.out.print("What is your guess?");
            guess = scanner.nextInt();
            attempts ++;
            if (guess > numb)
            {
             System.out.println("Your guess is too high!");
            }
            else if (guess < numb)
            {
                System.out.println("Your guess it too low!");
            }
            else
            {
                System.out.println("Yay! your guess is correct! You figured it!");
                System.out.println("You took " +attempts+ " attempts!");
            }
        }
        if(attempts == 5)
        {
            System.out.println("Sorry! you have reached the maximum number of attempts! ");
        }
        scanner.close();
    }
}
