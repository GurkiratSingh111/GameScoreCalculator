package ca.cmpt276.gamemodule;

import ca.cmpt276.gamemodule.ui.TextUI;
import ca.cmpt276.gamemodule.model.GameManager;

public class MyClass {
    public static void main(String[] args) {
        GameManager manager= new GameManager();
        TextUI ui= new TextUI(manager);
        ui.showMenu();

    }

}