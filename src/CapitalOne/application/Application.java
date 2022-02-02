package CapitalOne.application;

import CapitalOne.model.Customer;
import CapitalOne.model.Merchant_Code;
import CapitalOne.model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Driver class which takes in the transactions to be processed.
 * @author Ashwin Raghunath
 */
public class Application {

    public static void main(String[] args) {

        List<Transaction> transactionList = null;
        Scanner scanner = new Scanner(System.in);

        int choice=0;

        while(true) {

            try {
                System.out.println("Choose input option\n" +
                        "1.Use sample transactions from PDF\n" +
                        "2.Enter own transactions");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 2)
                    break;
                else {
                    System.out.println("Please enter valid choice");
                }
            }catch (NumberFormatException e)
            {
                System.out.println("Please enter valid choice");
            }
        }

        if(choice==1)
        {
            transactionList=sampleTransactions();
        }
        else {

            int size = 0;
            System.out.println("Enter number of Transactions to be processed");
            size = Integer.parseInt(scanner.nextLine());
            transactionList = new ArrayList<>();
            while (size-- > 0) {
                int option = 0;
                while (true) {
                    System.out.println("\nChoose merchant\n" +
                            "1. sportcheck\n" +
                            "2. tim_hotons\n" +
                            "3.subway\n");

                    option = Integer.parseInt(scanner.nextLine());
                    if (option >= 1 && option <= 3)
                        break;
                    else {
                        System.out.println("\nPlease enter valid number\n");
                        continue;
                    }
                }

                int amount = -1;
                while (true) {
                    System.out.println("\nEnter amount in cents\n");
                    try {
                        amount = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid amount, please try again\n");
                    }
                }

                Merchant_Code merchantCode = null;
                if (option == 1)
                    merchantCode = Merchant_Code.sportcheck;
                else if (option == 2)
                    merchantCode = Merchant_Code.tim_hortons;
                else if (option == 3)
                    merchantCode = Merchant_Code.subway;

                transactionList.add(new Transaction(merchantCode, amount));
            }
        }

        System.out.println("\nThe transactions are : \n"+transactionList+"\n");

        Customer customer = new Customer(transactionList);
        customer.calculateScore();
    }

    /**
     * Sample transactions given in the PDF
     * @return list of transaction objects of customer
     */
    public static List<Transaction> sampleTransactions()
    {
        Transaction t01 = new Transaction("T01","2021-05-01", Merchant_Code.sportcheck,21000);
        Transaction t02 = new Transaction("T02","2021-05-02", Merchant_Code.sportcheck,8700);
        Transaction t03 = new Transaction("T03","2021-05-03", Merchant_Code.tim_hortons,323);
        Transaction t04 = new Transaction("T04","2021-05-04", Merchant_Code.tim_hortons,1267);
        Transaction t05 = new Transaction("T05","2021-05-05", Merchant_Code.tim_hortons,2116);
        Transaction t06 = new Transaction("T06","2021-05-06", Merchant_Code.tim_hortons,2211);
        Transaction t07 = new Transaction("T07","2021-05-07", Merchant_Code.subway,1853);
        Transaction t08 = new Transaction("T08","2021-05-08", Merchant_Code.subway,2153);
        Transaction t09 = new Transaction("T09","2021-05-09", Merchant_Code.sportcheck,7326);
        Transaction t10 = new Transaction("T10","2021-05-10", Merchant_Code.tim_hortons,1321);

        List<Transaction> transactions = Arrays.asList(t01, t02, t03, t04, t05, t06, t07, t08, t09, t10);
        return transactions;
    }


}
