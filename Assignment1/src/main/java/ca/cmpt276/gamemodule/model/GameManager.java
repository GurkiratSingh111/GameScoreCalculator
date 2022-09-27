package ca.cmpt276.gamemodule.model;
import java.util.ArrayList;

public class GameManager {
    public ArrayList<Game> game;

    public GameManager()
    {

        game= new ArrayList<>();
    }
    public void insert(Game g)
    {

        game.add(g);
    }
    public Game retrieve(int index)
    {
        return game.get(index);
    }
    public void remove(int index)
    {

        game.remove(index-1);
    }

}
