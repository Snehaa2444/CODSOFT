import java.util.Scanner;

public class grade
{
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner (System.in);
        int subjects = 5;
        int marks = 0;
        for(int i=1;i<6;i++)
        {
            System.out.print("Enter marks for subject " +i+" :");
            marks+=scanner.nextInt();
        }
        int percentage = marks/5;

        System.out.println("Total marks obtained:" +marks);
        System.out.println("Percentage:" +percentage);

        if(percentage>= 85)
        {
            System.out.println("You have scored an A grade! Well Done!!");
        }
        else if(84>= percentage || percentage>=70)
        {
            System.out.println("You have scored a B grade! Well Done!!");
        }
        else if(69>= percentage || percentage>=45)
        {
            System.out.println("You have scored a C grade! Do better next time");
        }
        else if(44>= percentage || percentage>= 30)
        {
            System.out.println("You have scored a D grade! Do better next time");
        }
        else
        {
            System.out.println("You have scored an E grade!");
        }
    }
}
