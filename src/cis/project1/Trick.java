package cis.project1;

import java.util.LinkedList;


/**********************************************************************
 * This class represents a standard playing card "trick" or one card
 * play from each game player.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class Trick {

    /**
     * This is collection of cards the player's have played.
     */
    private LinkedList<Card> trick;

    /**
     * This is the first card played.
     */
    private Card led;

    /**
     * This is the highest trump card played.
     */
    private Card losing;

    /**
     * This is the player who played the losing card.
     */
    private Player taker;

    /**
     * This is the player who played the first card.
     */
    private Player starter;

    
    /**
     * This is the Trick completion state.
     */
    private boolean complete;


    /*****************************************************************
     * This constructor creates a Trick object with the specified
     * first player, and leading card.
     *
     * @param firstPlayer is the player who "led" the trick.
     * @param led is the card that the player played.
     *****************************************************************/
    public Trick(final Player firstPlayer, final Card led) {
        taker = firstPlayer;
        starter = firstPlayer;
        trick = new LinkedList<>();
        trick.add(led);
        this.led = led;
        this.losing = led;
        complete = false;
    }

    
    /*****************************************************************
     * This constructor creates a Trick object with the specified
     * first player, and leading card.
     *
     * @param firstPlayer is the player who "led" the trick.
     *****************************************************************/
    public Trick(final Player firstPlayer) {
        taker = firstPlayer;
        starter = firstPlayer;
        trick = new LinkedList<>();
        complete = false;
    }


    /******************************************************************
     * This method adds the specified card to the trick on behalf
     * of the specified player.
     *
     * @param newCard is the card that the player played.
     * @param p is the player who played the card.
     *****************************************************************/
    public void add(final Card newCard, final Player p) {
        if (trick.isEmpty()) {
            trick.add(newCard);
            this.led = newCard;
            this.losing = newCard;
            this.taker = p;
        } else {
            trick.add(newCard);
            // if new card is higher trump
            if ((led.getSuit() == newCard.getSuit())
                    && (newCard.compareTo(losing) > 0)) {
                losing = newCard;
                taker = p;
            }
        }
    }


    /******************************************************************
     * This getter method returns "this" Trick object.
     *
     * @return is the collection of Card object's representing the
     * Trick.
     *****************************************************************/
    public LinkedList<Card> getTrick() {
        return this.trick;
    }


    /******************************************************************
     * This getter method returns the player who is losing "this"
     * Trick object.
     *
     * @return is the player with the highest trump suit card in the
     * trick.
     *****************************************************************/
    public Player getTaker() {
        return taker;
    }


    /******************************************************************
     * This getter method returns the Player who started "this"
     * Trick object by playing the first card.
     *
     * @return is the first player for "this" Trick.
     *****************************************************************/
    public Player getStarter() {
        return starter;
    }


    /******************************************************************
     * This getter method returns the card that was led (or played
     * first).
     *
     * @return is the first Card added to the Trick.
     *****************************************************************/
    public Card getLed() {
        return this.led;
    }


    /******************************************************************
     * This getter method returns the Card that is losing "this"
     * Trick object.
     *
     * @return is the Card with the highest rank of trump suit in the
     * trick.
     *****************************************************************/
    public Card getLosing() {
        return this.led;
    }

    
    /******************************************************************
     * This getter method returns whether "this" Trick is complete.
     *
     * @return is true when the Trick is complete.
     *****************************************************************/
    public boolean isComplete() {
        return complete;
    }

    
    /******************************************************************
     * This setter method modifies the Trick completion state.
     *
     * @param completeness is whether the Trick is complete.
     *****************************************************************/
    public void setComplete(final boolean completeness) {
        this.complete = completeness;
    }


    /*****************************************************************
     * This method overrides the Object toString() method.
     *
     * @return is a String representation of the Trick's attributes.
     *****************************************************************/
    @Override
    public String toString() {
        return "Trick{"
                + "trick=" + trick
                + ", led=" + led
                + ", losing=" + losing
                + ", taker=" + taker.getName()
                + '}';
    }
}
