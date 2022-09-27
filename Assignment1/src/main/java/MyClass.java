import com.example.ModelPackage.GameManager;

import TextUIPackage.TextUI;

public class MyClass {
    public static void main(String[] args) {
        GameManager manager= new GameManager();
        TextUI ui= new TextUI(manager);
        ui.showMenu();

    }

}