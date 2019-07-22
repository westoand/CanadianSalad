package cis.project1;

import java.util.LinkedList;
import javax.swing.JFrame;

/**********************************************************************
 * This class is the "driver" class of a Model-View-Controller program.
 * The program simulates the trick-taking card game Canadian Salad.
 * This CanadianSaladGUI class establishes a collection of players and
 * invokes other classes representing the model, view, and controller.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public final class CanadianSaladGUI {
	
	
	 /*****************************************************************
     * This private ensures the CanadianSaladGUI class functions
     * as a utility class.
     *
     *****************************************************************/
	private CanadianSaladGUI() {
	}
	
	
	
	/******************************************************************
     * This method is the "driver" of a Model-View-Controller program.
     * The program simulates the trick-taking card game Canadian Salad.
     * 
     * @param args represents optional command line arguments.
     *****************************************************************/
    public static void main(final String[] args) {
        LinkedList<Player> players = new LinkedList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));
        players.add(new Player("Player 4"));
        players.add(new Player("User"));

        CanadianSaladModel theGame = new CanadianSaladModel(players);

        JFrame frame = new JFrame("Canadian Salad Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel(theGame);
        frame.getContentPane().add(panel);

        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);

        panel.autoPlay();
    }
}

