package cis.project1;

import java.util.LinkedList;


/**********************************************************************
 * This class represents a card game player.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class Player {

    /**
     * This is the name of the player.
     */
    private String name;

    /**
     * This is collection representing the player's hand.
     */
    private LinkedList<Card> hand;

    /**
     * This represents the player's game score.
     */
    private int score;


    /******************************************************************
     * This constructor creates a Player object with the specified
     * name attribute.
     *
     * @param name is the name of the game player.
     *****************************************************************/
    public Player(final String name) {
        this(name, new LinkedList<>(), 0);
    }


    /******************************************************************
     * This constructor creates a Player object with the specified
     * name attribute, hand of cards, and score.
     *
     * @param name is the name of the game player.
     * @param hand is the hand of cards of the game player.
     * @param score is the game score of the game player.
     *****************************************************************/
    public Player(final String name,
                  final LinkedList<Card> hand, final int score) {
        this.name = name;
        this.hand = hand;
        this.score = score;
    }


    /******************************************************************
     * This method overrides the Object toString() method.
     *
     * @return is a String representation of the Player's attributes.
     *****************************************************************/
    @Override
    public String toString() {
        StringBuilder playerStr = new StringBuilder("Player: " + name + "\n");
        playerStr.append("Hand Size: " + hand.size() + "\n");
        int counter = 1;
        for (Card e : hand) {
            playerStr.append(counter + ". " + e.toString());
            counter++;
        }
        return playerStr.toString();
    }


    /******************************************************************
     * This getter method returns "this" Player object's name.
     *
     * @return is the String representation of the Player's name.
     *****************************************************************/
    public String getName() {
        return this.name;
    }


    /******************************************************************
     * This getter method returns "this" Player object's score.
     *
     * @return is the integer representation of the Player's score.
     *****************************************************************/
    public int getScore() {
        return this.score;
    }


    /******************************************************************
     * This setter method sets "this" Player object's score.
     *
     * @param amountToAdd is the player's updated score.
     *****************************************************************/
    public void addToScore(final int amountToAdd) {
        this.score += amountToAdd;
    }


    /******************************************************************
     * This getter method returns "this" Player object's hand of cards.
     *
     * @return is the collection of card objects representing the
     * Player's hand.
     *****************************************************************/
    public LinkedList<Card> getHand() {
        return this.hand;
    }


    /******************************************************************
     * This method prints "this" Player object's name and score.
     *****************************************************************/
    public void printScore() {
        System.out.println(name + "'s score is: " + score);
    }
}
