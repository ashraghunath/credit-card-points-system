package CapitalOne.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class representing a single transaction with its attributes
 * @author Ashwin Raghunath
 */
public class Transaction {

    private String id;
    private String date;
    private Merchant_Code merchant_code;
    private int amount_cents;
    private int transactionScore;

    static int idCount=0;

    /**
     * Default constructor
     */
    public Transaction() {
    }

    /**
     * Constructor to use in case of using sample transactions
     * @param id unique ID of each transaction
     * @param date date of transaction entry
     * @param merchant_code merhcant name
     * @param amount_cents amount spent in cents
     */
    public Transaction(String id, String date, Merchant_Code merchant_code, int amount_cents) {
        this.id = id;
        this.date = date;
        this.merchant_code = merchant_code;
        this.amount_cents = amount_cents;
    }

    /**
     * Constructor to be used in case of user input
     * @param merchant_code merhcant name
     * @param amount_cents amount spent in cents
     */
    public Transaction(Merchant_Code merchant_code, int amount_cents) {
        this.id = "T"+(++idCount);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = LocalDate.now().format(formatter);
        this.merchant_code = merchant_code;
        this.amount_cents = amount_cents;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Merchant_Code getMerchant_code() {
        return merchant_code;
    }

    public int getAmount_cents() {
        return amount_cents;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMerchant_code(Merchant_Code merchant_code) {
        this.merchant_code = merchant_code;
    }

    public void setAmount_cents(int amount_cents) {
        this.amount_cents = amount_cents;
    }

    public int getTransactionScore() {
        return transactionScore;
    }

    public void setTransactionScore(int transactionScore) {
        this.transactionScore = transactionScore;
    }

    @Override
    public String toString() {
        return
                "\""+id+"\"" + ":"+ "{"+
                        "\"date\":" +"\""+date+"\""+","+
                        "\"merchant_code\":" +"\""+merchant_code+"\""+","+
                        "\"amount_cents\":" +amount_cents+
                        "}";
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = (37*hash+this.amount_cents);
        hash = (37*hash+this.transactionScore);
        hash = 37*hash+id.hashCode();
        hash = 37*hash+merchant_code.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this)
            return true;
        if(!(obj instanceof Transaction))
            return false;
        Transaction vaccine = (Transaction) obj;
        return vaccine.id==this.id && vaccine.merchant_code==this.merchant_code;
    }
}

