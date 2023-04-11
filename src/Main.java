import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Browser browser = new Browser();

        browser.setTitle("Browser");
        browser.setSize(300, 400);
        browser.setVisible(true);
        browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}