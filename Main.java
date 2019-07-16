import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 15;
        float monthlyInterest = -1;
        byte period = -1;
        int numberOfPayments = 1;

        Scanner scanner = new Scanner(System.in);

        // Principle:
        while (true) {
            System.out.print("Principle ($1K - $1M): "); 
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;    
            System.out.println("Enter a number between 1,000 & 1,000,000");
        }

        // Annual Interest Rate:
        while(true) {
            System.out.print("Annual Interest Rate: "); 
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 0 && annualInterest <= 9.9) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;   
                break;            
            }
            System.out.println("Enter a value greater than 0 & less than 9.9"); 
        }
        
        // Period (Years):
        while(true) {
            System.out.print("Period (Years): "); 
            period = scanner.nextByte();
            if (period >= 1 && period <= 30) {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }    
            System.out.println("Enter a value between 1 & 30");                
        }
        
        // Mortgage: 
        double mortgage = principal 
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String morgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + morgageFormatted);

    }
}