package ca.cmpt276.gamemodule.model;
import java.util.ArrayList;

public class GameManager {
    public ArrayList<Game> game;

    public GameManager()
    {

        game= new ArrayList<>();
    }
    //This function inserts a game in the game manager
    public void insert(Game g)
    {

        game.add(g);
    }

    //This function return a game at a given index
    public Game retrieve(int index)
    {
        return game.get(index);
    }

    //This function removes the game at a given index
    public void remove(int index)
    {

        game.remove(index-1);
    }

}
