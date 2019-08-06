package cis.project1;

import java.util.LinkedList;
import java.util.Random;


/**********************************************************************
 * This class represents a standard playing card deck.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class Deck {


    /******************************************************************
     * The deck object is composed of a LinkedList of Card objects.
     *****************************************************************/
    private LinkedList<Card> deck;


    /*****************************************************************
     * This constructor creates a Deck object representing a deck of
     * standard playing cards.
     *****************************************************************/
    public Deck() {
        createDeck();
    }


    /*****************************************************************
     * This method shuffles the deck's cards into a random order.
     *****************************************************************/
    public void randomize() {
        LinkedList<Card> newDeck = new LinkedList<>();
        while (!deck.isEmpty()) {
            Random rand = new Random();
            newDeck.add(deck.remove(rand.nextInt(deck.size())));
        }
        deck = newDeck;
    }


    

    /*****************************************************************
     * This method removes the specified Card object from "this" 
     * Deck object.
     *
     *@param c is the card to be removed from the Deck.
     * @return is a boolean representing whether the specified Card
     * was successfully removed.
     *****************************************************************/
    public boolean remove(final Card c) {
        if (c == null) {
            return false;
        } else {
        	return deck.remove(c);
        	}
    }


    /*****************************************************************
     * This method returns whether the LinkedList representing the
     * deck is empty.
     *
     * @return is true if the LinkedList has no Card objects.
     *****************************************************************/
    public boolean isEmpty() {
        return deck.isEmpty();
    }


    /*****************************************************************
     * This method removes a Card object from "this" Deck object.
     *
     * @return is a Card object representing the card removed from
     * the deck.
     *****************************************************************/
    public Card pop() {
        return deck.pop();
    }


    /*****************************************************************
     * This helper method builds a standard playing card deck.
     *
     * @return is a LinkedList<Card> representing the complete deck.
     *****************************************************************/
    private LinkedList<Card> createDeck() {
        deck = new LinkedList<>();
        deck.add(new Card(Suit.Diamonds, Rank.Two));
        deck.add(new Card(Suit.Diamonds, Rank.Three));
        deck.add(new Card(Suit.Diamonds, Rank.Four));
        deck.add(new Card(Suit.Diamonds, Rank.Five));
        deck.add(new Card(Suit.Diamonds, Rank.Six));
        deck.add(new Card(Suit.Diamonds, Rank.Seven));
        deck.add(new Card(Suit.Diamonds, Rank.Eight));
        deck.add(new Card(Suit.Diamonds, Rank.Nine));
        deck.add(new Card(Suit.Diamonds, Rank.Ten));
        deck.add(new Card(Suit.Diamonds, Rank.Jack));
        deck.add(new Card(Suit.Diamonds, Rank.Queen));
        deck.add(new Card(Suit.Diamonds, Rank.King));
        deck.add(new Card(Suit.Diamonds, Rank.Ace));

        deck.add(new Card(Suit.Hearts, Rank.Two));
        deck.add(new Card(Suit.Hearts, Rank.Three));
        deck.add(new Card(Suit.Hearts, Rank.Four));
        deck.add(new Card(Suit.Hearts, Rank.Five));
        deck.add(new Card(Suit.Hearts, Rank.Six));
        deck.add(new Card(Suit.Hearts, Rank.Seven));
        deck.add(new Card(Suit.Hearts, Rank.Eight));
        deck.add(new Card(Suit.Hearts, Rank.Nine));
        deck.add(new Card(Suit.Hearts, Rank.Ten));
        deck.add(new Card(Suit.Hearts, Rank.Jack));
        deck.add(new Card(Suit.Hearts, Rank.Queen));
        deck.add(new Card(Suit.Hearts, Rank.King));
        deck.add(new Card(Suit.Hearts, Rank.Ace));

        deck.add(new Card(Suit.Spades, Rank.Two));
        deck.add(new Card(Suit.Spades, Rank.Three));
        deck.add(new Card(Suit.Spades, Rank.Four));
        deck.add(new Card(Suit.Spades, Rank.Five));
        deck.add(new Card(Suit.Spades, Rank.Six));
        deck.add(new Card(Suit.Spades, Rank.Seven));
        deck.add(new Card(Suit.Spades, Rank.Eight));
        deck.add(new Card(Suit.Spades, Rank.Nine));
        deck.add(new Card(Suit.Spades, Rank.Ten));
        deck.add(new Card(Suit.Spades, Rank.Jack));
        deck.add(new Card(Suit.Spades, Rank.Queen));
        deck.add(new Card(Suit.Spades, Rank.King));
        deck.add(new Card(Suit.Spades, Rank.Ace));

        deck.add(new Card(Suit.Clubs, Rank.Two));
        deck.add(new Card(Suit.Clubs, Rank.Three));
        deck.add(new Card(Suit.Clubs, Rank.Four));
        deck.add(new Card(Suit.Clubs, Rank.Five));
        deck.add(new Card(Suit.Clubs, Rank.Six));
        deck.add(new Card(Suit.Clubs, Rank.Seven));
        deck.add(new Card(Suit.Clubs, Rank.Eight));
        deck.add(new Card(Suit.Clubs, Rank.Nine));
        deck.add(new Card(Suit.Clubs, Rank.Ten));
        deck.add(new Card(Suit.Clubs, Rank.Jack));
        deck.add(new Card(Suit.Clubs, Rank.Queen));
        deck.add(new Card(Suit.Clubs, Rank.King));
        deck.add(new Card(Suit.Clubs, Rank.Ace));

        return deck;
    }


    /******************************************************************
     * This getter method returns "this" Deck object's cards.
     *
     * @return is the collection of Card objects.
     *****************************************************************/
    public LinkedList<Card> getDeck() {
        return this.deck;
    }


    /*****************************************************************
     * This method overrides the Object toString() method.
     *
     * @return is a String representation of the Card's attributes.
     *****************************************************************/
    @Override
    public String toString() {
        StringBuilder deckStr = new StringBuilder();
        for (Card c : deck) {
            deckStr.append(c.toString());
        }
        return deckStr.toString();
    }
}
