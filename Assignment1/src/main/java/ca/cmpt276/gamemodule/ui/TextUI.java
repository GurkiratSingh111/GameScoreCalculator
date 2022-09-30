package ca.cmpt276.gamemodule.ui;

import ca.cmpt276.gamemodule.model.Game;
import ca.cmpt276.gamemodule.model.GameManager;
import ca.cmpt276.gamemodule.model.playerScore;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class TextUI {
    private final GameManager gameManager;
    private Scanner sc = new Scanner(System.in);

    public TextUI(GameManager gameManager) {
        this.gameManager = gameManager;
    }
    public void print_menu() {
        System.out.println("Menu:");
        System.out.println("--------------");
        System.out.println("1. List games");
        System.out.println("2. New game ");
        System.out.println("3. Delete game ");
        System.out.println("0. Exit ");
        System.out.print(":   ");
    }
    public int checkPlayerInput()
    {
        int num;
        do {
            System.out.print("How many players? ");
            num=sc.nextInt();
            if(num<=0)
            {
                System.out.println("Invalid value.");
                System.out.println("Please enter a value that is 1 or greater. ");
            }
            else if(num>4)
            {
                System.out.println("Invalid value. ");
                System.out.println("Please enter a number that is 4 or less.");
            }
        }while(num<=0 || num>4);
        return num;
    }
    public void checkInput(int value)
    {
        if(value<0)
        {
            System.out.println("Invalid value.");
            System.out.println("Please enter a value that is 0 or greater. ");
        }
    }
    public void printAllPlayerFinalScore(Game g)
    {
        for(int j=0;j<g.player.size()-1;j++)
        {
            System.out.print(g.player.get(j).totalScore());
            System.out.print(" vs ");
        }
        System.out.print(g.player.get(g.player.size()-1).totalScore());
    }
    public void printWinners(Game g)
    {
        System.out.print(", winner player(s): ");
        ArrayList<Integer>winners= g.calculatewinner();
        int k=0;
        while(k<winners.size()-1)
        {
            System.out.print(winners.get(k) +", ");
            k++;
        }
        System.out.print((winners.get(winners.size()-1)) +" ");
    }
    public void printDateTime(Game g)
    {
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm");
        System.out.println("(@" + g.getDate().format(formatter) +")");
    }
    public void showMenu()
    {
        int user_input;
        do {
            print_menu();
            user_input = sc.nextInt();
            if (user_input==1) {
                System.out.println("Games: ");
                System.out.println("------------");
                if(this.gameManager.game.size()==0) {
                    System.out.println("  No games");
                    System.out.print("\n");
                }
                else {
                    int i=0;
                    while(i<this.gameManager.game.size()) {
                        Game g= this.gameManager.retrieve(i);
                        System.out.print((i+1)+". ");
                        printAllPlayerFinalScore(g);
                        printWinners(g);
                        printDateTime(g);
                        i++;
                    }
                }
            }
            else if(user_input==2)
            {
                int num= checkPlayerInput();
                Game g= new Game(num);
                for(int i=1;i<=num;i++) {
                    int cards;
                    System.out.println("Player "+ i);
                    do {
                        System.out.print(" How many cards? ");
                        cards=sc.nextInt();
                        checkInput(cards);
                    }while(cards<0);
                    if(cards==0) {
                        playerScore temp=new playerScore(0,0,0);
                        g.player.add(temp);
                    }
                    else {
                        int sum;
                        do {
                            System.out.print(" Sum of cards? ");
                            sum = sc.nextInt();
                            checkInput(sum);
                        }while(sum<0);
                        int wagers;
                        do {
                            System.out.print(" How many wagers? ");
                            wagers = sc.nextInt();
                            checkInput(wagers);
                        }while(wagers<0);
                        playerScore temp = new playerScore(cards, sum, wagers);
                        g.player.add(temp);
                    }
                }
                System.out.println("\nAdding game: ");
                System.out.print(" ");
                for(int i=1;i<num;i++)
                {
                    System.out.print(g.player.get(i-1).totalScore());
                    System.out.print(" vs ");
                }
                System.out.print(g.player.get(num-1).totalScore());
                printWinners(g);
                printDateTime(g);
                this.gameManager.insert(g);
            }
            else if(user_input==3)
            {
                System.out.println("Games: ");
                System.out.println("-----------------");
                int i=0;
                while(i<gameManager.game.size())
                {
                    Game g= gameManager.retrieve(i);
                    System.out.print((i+1) +". ");
                    printAllPlayerFinalScore(g);
                    printWinners(g);
                    printDateTime(g);
                    i++;
                }
                System.out.print("\n");
                int x;
                do {
                    System.out.print("Which game to delete (0 for none)? ");
                    x= sc.nextInt();
                    checkInput(x);
                    if(x>this.gameManager.game.size())
                    {
                        System.out.println("Invalid value.");
                        System.out.println("Please enter a value that is "+this.gameManager.game.size() +" or less" );
                    }
                }while(x<0 || x>this.gameManager.game.size());
                if(x==0)
                    System.out.println("None deleted");
                else {
                    this.gameManager.remove(x);
                    System.out.println("Game deleted.");
                }
            }
            else if(user_input<0) {
                System.out.println("Invalid value.");
                System.out.println("Please enter a value that is 0 or greater.");
            }
            else if(user_input>3) {
                System.out.println("Invalid value.");
                System.out.println("Please enter a value that is 3 or less. ");
            }

        } while (user_input!=0);
        System.out.println("\n");
        System.out.println("DONE! ");
    }
}
