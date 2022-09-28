package ca.cmpt276.gamemodule.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class playerScoreTest {
    @Test
    public void checkTotalScore()
    {
        playerScore ps= new playerScore(0,0,0);
        ps.setNumberOfCards(5);
        ps.setSumOfPoints(40);
        ps.setNumberOfWagercards(2);
        Assertions.assertEquals(60,ps.totalScore());
    }
    @Test
    public void checkSumOfPoints()
    {
        playerScore ps= new playerScore(0,40,2);
        Assertions.assertEquals(0,ps.getSumOfPoints());
    }

    @Test
    public void checkWageCards()
    {
        playerScore ps= new playerScore(0,40,2);
        Assertions.assertEquals(0,ps.getNumberOfWagercards());
    }
    @Test
    public void checkTotalScore_when_cards0()
    {
        playerScore ps = new playerScore(0,50,2);
        Assertions.assertEquals(0,ps.totalScore());
    }
    @Test
    public void checkNumberOfCards()
    {
        playerScore ps = new playerScore(5,40,2);
        Assertions.assertEquals(5, ps.getNumberOfCards());
    }

    @Test
    public void checktotalScore_when_cardsgreaterthanorequalto8()
    {
        playerScore ps = new playerScore(8,40,2);
        Assertions.assertEquals(80,ps.totalScore());
    }
    @Test
    public void throwExceptionForNumberOfCards()
    {
        playerScore ps = new playerScore(5,40,2);
        Assertions.assertThrows(IllegalArgumentException.class,()-> ps.setNumberOfCards(-5));
    }

    @Test
    public void throwExceptionForSumOfPoints()
    {
        playerScore ps = new playerScore(5,40,2);
        Assertions.assertThrows(IllegalArgumentException.class,()-> ps.setSumOfPoints(-40));
    }

    @Test
    public void throwExceptionForNumberOfWageCards()
    {
        playerScore ps = new playerScore(5,40,2);
        Assertions.assertThrows(IllegalArgumentException.class,()-> ps.setNumberOfWagercards(-3));
    }
}