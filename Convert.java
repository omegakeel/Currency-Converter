import java.util.Scanner;
    
public class Convert{

    private static final double[][] exchangeRates=
    {   //Use of 2D Array to use exchange rates
        //USD, EUR,  JPY,  GBP,  AUD
        {1.0, 0.91, 144.91, 0.79, 1.54}, //1 USD
        {1.10, 1.00, 158.87, 0.86, 1.69}, //1 EUR
        {0.0069, 0.0063, 1.00, 0.0054, 0.011}, //1 JPY
        {1.27, 1.16, 183.90, 1.00, 1.95}, //1 GBP
        {0.65, 0.59, 94.20, 0.51, 1.00} //1 AUD
    };
    // This will return the index values to select within the 2D array so that we can use the proper exchange rates
    public static int getIndex(String currency){
        switch(currency){
            case "USD":
                return 0;

            case "EUR":
                return 1;
            
            case "JPY":
                return 2;
            
            case "GBP":
                return 3;
            
            case "AUD":
                return 4;
            
            default:
            throw new IllegalArgumentException("Unknown Currency: " + currency);
        }
    }
    //This uses the int getIndex above which uses the switch statement to declare the 2D array's index values we want to use
    //Once it declares the indexes we need to use, it returns the product of the amount the user wants to exchange and the exchange rate
    public static double convert(double amount, String exchangeFrom, String exchangeTo){
        int sourceIndex = getIndex(exchangeFrom);
        int targetIndex = getIndex(exchangeTo);
        return amount * exchangeRates[sourceIndex][targetIndex];

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Program asks user for the currency they want to exchange and how much of it they want to exchange
        System.out.println("Which currency would you like to exchange?:");
        System.out.println("-USD (United States Dollar)\n-EUR (Euro)\n-JPY (Japanese Yen)\n-GBP (Great Britain Pound)\n-AUD (Australian Dollar)");
        /*The following lines make the program more user friendly by automatically capitalizing the letters in their currency selection 
        as well as letting them know if they chose an invalid currency*/ 
        String exchangeFrom = input.nextLine().toUpperCase();
        while(!exchangeFrom.equals( "USD") && !exchangeFrom.equals( "EUR") && !exchangeFrom.equals( "JPY") && !exchangeFrom.equals( "GBP") && !exchangeFrom.equals( "AUD")){
            System.out.println("Invalid currency. Please try again.");
            exchangeFrom = input.nextLine();
        }
        System.out.println("\nHow much " + exchangeFrom + " would you like to exchange?");
        double amount = input.nextDouble();
        input.nextLine();
        while(amount <=0){
            System.out.println("Invalid amount. Please try again.");
            amount = input.nextDouble();
            input.nextLine();
        }
        
        //Program asks user which currency they want to exchange to and proceeds to output the final conversion of currency x to currency y
        System.out.println("\nWhich currency would you like to exchange your " + exchangeFrom + " to?:");
        System.out.println("-USD (United States Dollar)\n-EUR (Euro)\n-JPY (Japanese Yen)\n-GBP (Great Britain Pound)\n-AUD (Australian Dollar)");
        String exchangeTo = input.nextLine().toUpperCase();
        while(!exchangeTo.equals( "USD") && !exchangeTo.equals( "EUR") && !exchangeTo.equals( "JPY") && !exchangeTo.equals( "GBP") && !exchangeTo.equals( "AUD")){
            System.out.println("Invalid currency. Please try again.");
            exchangeTo = input.nextLine();
        }

        double finalAmount = (convert(amount, exchangeFrom, exchangeTo));
        System.out.println("\n" + amount + " " + exchangeFrom + " is equal to " + finalAmount + " " + exchangeTo);
        input.close();
    }
}