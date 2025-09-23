import java.util.*;
public class CalculatorApp
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Boolean run = true;
        while(run)            
        {
            System.out.print("Enter the number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter the number: ");
            double num2 = sc.nextDouble();
            System.out.println();
            String arr[] = {" Addition", " Subtraction", " Division", " Multiplication"};
            for(int i = 0; i < arr.length; i++)
            {
                System.out.println((i+1) + ")"+ arr[i]);
            }
            System.out.println();
            System.out.print("Enter the serial number of the operation which you want to perform: " );
            double operation = 0;
            Boolean oppcheck = true;
            while(oppcheck)
            {
                operation = sc.nextDouble();
                if(operation <= 0  || operation >= 5)
                {
                    oppcheck = true;
                    System.out.print("Please enter the correct serial number of the operation which you want to perform: ");
                }
                else
                    oppcheck = false;
            }
            System.out.println();
            Calculator calc = new Calculator();
            if(operation == 1)
                System.out.println("The Addition of two numbers is "+output(calc.addition(num1, num2)));
            else if(operation == 2)
                System.out.println("The Subraction of two numbers is "+ output(calc.subraction(num1, num2)));
            else if(operation == 3)
            {
                String ans = output(calc.division(num1, num2));
                if(ans.equals("0"))
                    System.out.println("The Division of two numbers is "+ans);   
            }
            else
                System.out.println("The Multiplication of two numbers is "+output(calc.multiplication(num1, num2)));
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.print("Do you want to continue or end the program if continue enter 1 : else enter 2: ");
            double power = 0;
            oppcheck = true;
            while(oppcheck)
            {
                power = sc.nextDouble();
                if(!(power ==1 || power == 2))
                {
                    oppcheck = true;
                    System.out.print("Please enter the correct number do you want to continue or end the program if continue enter 1 : else enter 2: ");
                    
                }
                else
                    oppcheck = false;
            }
            if(power == 1)
                run = true;
            else
                run = false;
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }
    public static String output(double value)
    {
        if(value == (long)value)
            return String.valueOf((long)value);
        return String.valueOf(value);
    }
}
class Calculator
{
    public static double addition(double num1, double num2)
    {
        return num1 + num2;
    }
    public static double subraction(double num1, double num2)
    {
        return num1 - num2;
    }
    public static double division(double num1, double num2)
    {
        if(num2 == 0 )
        { 
            System.out.print("It is not possibile to divide by zero");
            return 0;
        }
        return num1 / num2;
    }
    public static double multiplication(double num1, double num2)
    {
        return num1 * num2;
    }

}
