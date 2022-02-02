package CapitalOne.model;

import CapitalOne.service.CalculationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a customer whose transactions are to be processed
 * @author Ashwin Raghunath
 */
public class Customer {

    List<Transaction> transactions;

    int sportcheckAmount;
    int subwayAmount;
    int tim_hortonsAmount;
    int otherAmount;
    int otherAmountDollars;
    int totalAmount;
    int totalAmountDollars;
    int sportcheckAmountDollars;
    int subwayAmountDollars;
    int tim_hortonsAmountDollars;
    int score;
    int remainingAmount=0;

    public Customer() {
        this.transactions=new ArrayList<>();
        this.sportcheckAmount=0;
        this.subwayAmount=0;
        this.tim_hortonsAmount=0;
        this.score=0;
    }

    public Customer(List<Transaction> transactions) {
        this.transactions = transactions;

        for(Transaction transaction : transactions)
        {
            if(transaction.getMerchant_code().equals(Merchant_Code.sportcheck))
                sportcheckAmount+=transaction.getAmount_cents();
            else if(transaction.getMerchant_code().equals(Merchant_Code.subway))
                subwayAmount+=transaction.getAmount_cents();
            else if(transaction.getMerchant_code().equals(Merchant_Code.tim_hortons))
                tim_hortonsAmount+=transaction.getAmount_cents();
            else
                otherAmount+=transaction.getAmount_cents();

            totalAmount+=transaction.getAmount_cents();
        }

        totalAmountDollars=totalAmount/100;
        sportcheckAmountDollars=sportcheckAmount/100;
        subwayAmountDollars=subwayAmount/100;
        tim_hortonsAmountDollars=tim_hortonsAmount/100;
        otherAmountDollars=otherAmount/100;
    }

    /**
     * Method that calculates the points of the customer by applying proper rules and prints out the output value
     */
    public void calculateScore()
    {
        CalculationService service = new CalculationService(this);
        service.calculateScore();
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public int getSportcheckAmount() {
        return sportcheckAmount;
    }

    public void setSportcheckAmount(int sportcheckAmount) {
        this.sportcheckAmount = sportcheckAmount;
    }

    public int getSubwayAmount() {
        return subwayAmount;
    }

    public void setSubwayAmount(int subwayAmount) {
        this.subwayAmount = subwayAmount;
    }

    public int getTim_hortonsAmount() {
        return tim_hortonsAmount;
    }

    public void setTim_hortonsAmount(int tim_hortonsAmount) {
        this.tim_hortonsAmount = tim_hortonsAmount;
    }

    public int getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(int otherAmount) {
        this.otherAmount = otherAmount;
    }

    public int getOtherAmountDollars() {
        return otherAmountDollars;
    }

    public void setOtherAmountDollars(int otherAmountDollars) {
        this.otherAmountDollars = otherAmountDollars;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalAmountDollars() {
        return totalAmountDollars;
    }

    public void setTotalAmountDollars(int totalAmountDollars) {
        this.totalAmountDollars = totalAmountDollars;
    }

    public int getSportcheckAmountDollars() {
        return sportcheckAmountDollars;
    }

    public void setSportcheckAmountDollars(int sportcheckAmountDollars) {
        this.sportcheckAmountDollars = sportcheckAmountDollars;
    }

    public int getSubwayAmountDollars() {
        return subwayAmountDollars;
    }

    public void setSubwayAmountDollars(int subwayAmountDollars) {
        this.subwayAmountDollars = subwayAmountDollars;
    }

    public int getTim_hortonsAmountDollars() {
        return tim_hortonsAmountDollars;
    }

    public void setTim_hortonsAmountDollars(int tim_hortonsAmountDollars) {
        this.tim_hortonsAmountDollars = tim_hortonsAmountDollars;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(int remainingAmount) {
        this.remainingAmount = remainingAmount;
    }
}
