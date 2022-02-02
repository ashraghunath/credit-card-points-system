package CapitalOne.model;

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
        List<Integer> scores = new ArrayList<>();
        if(sportcheckAmountDollars>=75 && tim_hortonsAmountDollars>=25 && subwayAmountDollars>=25)
            scores.add(applyRule1() + applyRule7(temp));
        if(sportcheckAmountDollars>=75 && tim_hortonsAmountDollars>=25)
            scores.add(applyRule2() + applyRule7(temp));
        if(sportcheckAmountDollars>=75)
            scores.add(applyRule3() + applyRule7(temp));
        if(sportcheckAmountDollars>=25 && tim_hortonsAmountDollars>=10 && subwayAmountDollars>=10)
            scores.add(applyRule4() + applyRule7(temp));
        if(sportcheckAmountDollars>=25 && tim_hortonsAmountDollars>=10)
            scores.add(applyRule5() + applyRule7(temp));
        if(sportcheckAmountDollars>=20)
            scores.add(applyRule6() + applyRule7(temp));
        if(scores.size()==0)
            scores.add(applyRule7(totalAmountDollars));

        score = scores.stream().mapToInt(i -> i).max().orElse(0);

        System.out.println("Credit card points : "+score);
    }

    public int applyRule1()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;
        int timHortons=tim_hortonsAmountDollars;
        int subway=subwayAmountDollars;
        while (sportCheck>=75 && timHortons>=25 && subway>=25)
        {
            points+=500;
            sportCheck-=75;
            timHortons-=25;
            subway-=25;
        }
        temp=totalAmountDollars-(sportcheckAmountDollars+tim_hortonsAmountDollars+subwayAmountDollars)+sportCheck+subway+timHortons;
        return points;
    }

    public int applyRule2()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;
        int timHortons=tim_hortonsAmountDollars;
        while (sportCheck>=75 && timHortons>=25)
        {
            points+=300;
            sportCheck-=75;
            timHortons-=25;
        }
        temp=totalAmountDollars-(sportcheckAmountDollars+tim_hortonsAmountDollars)+sportCheck+timHortons;
        return points;
    }

    public int applyRule3()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;
        while (sportCheck>=75)
        {
            points+=200;
            sportCheck-=75;
        }
        temp=totalAmountDollars-(sportcheckAmountDollars)+sportCheck;
        return points;
    }

    public int applyRule4()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;
        int timHortons=tim_hortonsAmountDollars;
        int subway=subwayAmountDollars;
        while (sportCheck>=25 && timHortons>=10 && subway>=10)
        {
            points+=150;
            sportCheck-=25;
            timHortons-=10;
            subway-=10;
        }
        temp=totalAmountDollars-(sportcheckAmountDollars+tim_hortonsAmountDollars+subwayAmountDollars)+sportCheck+timHortons+subway;
        return points;
    }

    public int applyRule5()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;
        int timHortons=tim_hortonsAmountDollars;
        while (sportCheck>=25 && timHortons>=10)
        {
            points+=75;
            sportCheck-=25;
            timHortons-=10;
        }
        temp=totalAmountDollars-(sportcheckAmountDollars+tim_hortonsAmountDollars)+sportCheck+timHortons;
        return points;
    }

    public int applyRule6()
    {
        int points=0;
        int sportCheck=sportcheckAmountDollars;

        while (sportCheck>=20 )
        {
            points+=75;
            sportCheck-=20;

        }
        temp=totalAmountDollars-(sportcheckAmountDollars)+sportCheck;
        return points;
    }

    public int applyRule7(int remainingAmount)
    {
        int points=0;

        while (remainingAmount>=1 )
        {
            points+=1;
            remainingAmount-=1;

        }
        return points;
    }

}
