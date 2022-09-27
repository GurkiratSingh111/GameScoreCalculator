package com.example.ModelPackage;

public class playerScore {
    private int numberOfWagercards;
    private int sumOfPoints;
    private int numberOfCards;

    public int getNumberOfWagercards(){
        return numberOfWagercards;
    }
    public int getSumOfPoints(){
        return sumOfPoints;
    }
    public int getNumberOfCards() {
        return numberOfCards;
    }
    public void setNumberOfCards(int numberOfCards)
    {
        if(numberOfCards<0)
        {
            throw new IllegalArgumentException("Number of Cards must be non-negative");
        }
        else
            this.numberOfCards= numberOfCards;
    }
    public void setSumOfPoints(int sumOfPoints)
    {
        if(sumOfPoints<0)
        {
            throw new IllegalArgumentException("Sum of Points must be non-negative");
        }
        this.sumOfPoints= sumOfPoints;
    }
    public void setNumberOfWagercards(int numberOfWagercards)
    {
        if(numberOfWagercards < 0)
        {
            throw new IllegalArgumentException("Number of WagerCards must be non-negative");
        }
        else
            this.numberOfWagercards= numberOfWagercards;
    }
    public playerScore(int cards, int points, int wagecards)
    {
        if(cards==0)
        {
            numberOfCards=0;
            numberOfWagercards=0;
            sumOfPoints=0;
        }
        else
        {
            setNumberOfCards(cards);
            setSumOfPoints(points);
            setNumberOfWagercards(wagecards);
        }
    }
    public int totalScore()
    {
        if(numberOfCards==0)
            return 0;
        int sum= sumOfPoints-20;
        sum = sum * (numberOfWagercards+1);
        if(numberOfCards >=8)
            sum=sum+20;
        return sum;
    }

}
