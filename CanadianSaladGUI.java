import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;

public class CanadianSaladGUI {
    public static void main(String[] args) {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("Andrew"));
        players.add(new Player("Abbie"));
        players.add(new Player("Kassie"));
        players.add(new Player("David"));
        players.add(new Player("Jacob"));

        CanadianSaladModel theGame = new CanadianSaladModel(players);

        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel(theGame);
        frame.getContentPane().add(panel);

        frame.setResizable(true);
        frame.setPreferredSize(new Dimension(800, 637));
        frame.pack();
        frame.setVisible(true);
    }
}
