package com.example.ModelPackage;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Game {
    private int numberOfPlayers;
    private LocalDateTime date;

    public LocalDateTime getDate()
    {
        return date;
    }
    public ArrayList<playerScore> player;
    public  int getNumberOfPlayers()
    {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers)
    {
        this.numberOfPlayers= numberOfPlayers;
    }
    public Game(int num)
    {
        numberOfPlayers=num;
        date= LocalDateTime.now();
        player= new ArrayList<playerScore>();
    }
    public ArrayList<Integer> calculatewinner()
    {
        ArrayList<Integer> winner = new ArrayList<>();
        int highestScore= player.get(0).totalScore();
        for(int i=0;i<player.size();i++)
        {
            if(player.get(i).totalScore()>highestScore)
                highestScore= player.get(i).totalScore();
        }
        for(int i=0; i<player.size();i++) {
            if (player.get(i).totalScore() == highestScore)
                winner.add(i + 1);
        }
        return winner;
    }
}
