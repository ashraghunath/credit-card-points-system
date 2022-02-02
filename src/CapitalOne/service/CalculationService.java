package CapitalOne.service;

import CapitalOne.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CalculationService {

    Customer customer;

    public CalculationService(Customer customer) {
        this.customer = customer;
    }

    public void calculateScore()
    {
        List<Integer> scores = new ArrayList<>();
        if(customer.getSportcheckAmountDollars()>=75 && customer.getTim_hortonsAmountDollars()>=25 && customer.getSubwayAmountDollars()>=25)
            scores.add(applyRule1() + applyRule7(customer.getRemainingAmount()));
        if(customer.getSportcheckAmountDollars()>=75 && customer.getTim_hortonsAmountDollars()>=25)
            scores.add(applyRule2() + applyRule7(customer.getRemainingAmount()));
        if(customer.getSportcheckAmountDollars()>=75)
            scores.add(applyRule3() + applyRule7(customer.getRemainingAmount()));
        if(customer.getSportcheckAmountDollars()>=25 && customer.getTim_hortonsAmountDollars()>=10 && customer.getSubwayAmountDollars()>=10)
            scores.add(applyRule4() + applyRule7(customer.getRemainingAmount()));
        if(customer.getSportcheckAmountDollars()>=25 && customer.getTim_hortonsAmountDollars()>=10)
            scores.add(applyRule5() + applyRule7(customer.getRemainingAmount()));
        if(customer.getSportcheckAmountDollars()>=20)
            scores.add(applyRule6() + applyRule7(customer.getRemainingAmount()));
        if(scores.size()==0)
            scores.add(applyRule7(customer.getTotalAmountDollars()));

        customer.setScore(scores.stream().mapToInt(i -> i).max().orElse(0));

        System.out.println("Credit card points : "+customer.getScore());
    }

    public int applyRule1()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();
        int timHortons=customer.getTim_hortonsAmountDollars();
        int subway=customer.getSubwayAmountDollars();
        while (sportCheck>=75 && timHortons>=25 && subway>=25)
        {
            points+=500;
            sportCheck-=75;
            timHortons-=25;
            subway-=25;
        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars()+customer.getTim_hortonsAmountDollars()+customer.getSubwayAmountDollars())+sportCheck+subway+timHortons);
        return points;
    }

    public int applyRule2()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();
        int timHortons=customer.getTim_hortonsAmountDollars();
        while (sportCheck>=75 && timHortons>=25)
        {
            points+=300;
            sportCheck-=75;
            timHortons-=25;
        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars()+customer.getTim_hortonsAmountDollars())+sportCheck+timHortons);
        return points;
    }

    public int applyRule3()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();
        while (sportCheck>=75)
        {
            points+=200;
            sportCheck-=75;
        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars())+sportCheck);
        return points;
    }

    public int applyRule4()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();
        int timHortons=customer.getTim_hortonsAmountDollars();
        int subway=customer.getSubwayAmountDollars();
        while (sportCheck>=25 && timHortons>=10 && subway>=10)
        {
            points+=150;
            sportCheck-=25;
            timHortons-=10;
            subway-=10;
        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars()+customer.getTim_hortonsAmountDollars()+customer.getSubwayAmountDollars())+sportCheck+timHortons+subway);
        return points;
    }

    public int applyRule5()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();
        int timHortons=customer.getTim_hortonsAmountDollars();
        while (sportCheck>=25 && timHortons>=10)
        {
            points+=75;
            sportCheck-=25;
            timHortons-=10;
        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars()+customer.getTim_hortonsAmountDollars())+sportCheck+timHortons);
        return points;
    }

    public int applyRule6()
    {
        int points=0;
        int sportCheck=customer.getSportcheckAmountDollars();

        while (sportCheck>=20 )
        {
            points+=75;
            sportCheck-=20;

        }
        customer.setRemainingAmount(customer.getTotalAmountDollars()-(customer.getSportcheckAmountDollars())+sportCheck);
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
