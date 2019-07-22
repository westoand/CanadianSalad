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
     *
     * @param numPlayers the number of game players
     *****************************************************************/
    public Deck(final int numPlayers) {
        deck = new LinkedList<>();
        initializeDeck(numPlayers);
    }

    
	 /*****************************************************************
     * This helper method builds a deck with the proper number of cards
     * for the number of players and then randomizes it.
     *
     * @param numPlayers the number of game players
     *****************************************************************/
    private void initializeDeck(final int numPlayers) {
        LinkedList<Card> tempDeck = makeEvenHands(numPlayers, createDeck());

        while (!tempDeck.isEmpty()) {
            Random rand = new Random();
            deck.add(tempDeck.remove(rand.nextInt(tempDeck.size())));
        }
    }

    
	 /*****************************************************************
     * This helper method builds a deck with the proper number of 
     * cards for the number of players.
     *
     * @param numPlayers the number of game players
     * @param buildDeck is the original (full) deck to be adjusted.
     * @return is a LinkedList<Card> representing the modified deck.
     *****************************************************************/
    private LinkedList<Card> makeEvenHands(
    		final int numPlayers, final LinkedList<Card> buildDeck) {
        if (numPlayers == 3) {
            buildDeck.remove(new Card(Suit.Clubs, Rank.Two));
        }

        if (numPlayers == 5) {
            buildDeck.remove(new Card(Suit.Clubs, Rank.Two));
            buildDeck.remove(new Card(Suit.Diamonds, Rank.Two));
        }
        if (numPlayers == 6) {
            buildDeck.remove(new Card(Suit.Clubs, Rank.Two));
            buildDeck.remove(new Card(Suit.Clubs, Rank.Three));
            buildDeck.remove(new Card(Suit.Diamonds, Rank.Two));
            buildDeck.remove(new Card(Suit.Diamonds, Rank.Three));
        }
        return buildDeck;
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
        LinkedList<Card> buildDeck = new LinkedList<>();
        buildDeck.add(new Card(Suit.Diamonds, Rank.Two));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Three));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Four));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Five));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Six));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Seven));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Eight));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Nine));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Ten));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Jack));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Queen));
        buildDeck.add(new Card(Suit.Diamonds, Rank.King));
        buildDeck.add(new Card(Suit.Diamonds, Rank.Ace));

        buildDeck.add(new Card(Suit.Hearts, Rank.Two));
        buildDeck.add(new Card(Suit.Hearts, Rank.Three));
        buildDeck.add(new Card(Suit.Hearts, Rank.Four));
        buildDeck.add(new Card(Suit.Hearts, Rank.Five));
        buildDeck.add(new Card(Suit.Hearts, Rank.Six));
        buildDeck.add(new Card(Suit.Hearts, Rank.Seven));
        buildDeck.add(new Card(Suit.Hearts, Rank.Eight));
        buildDeck.add(new Card(Suit.Hearts, Rank.Nine));
        buildDeck.add(new Card(Suit.Hearts, Rank.Ten));
        buildDeck.add(new Card(Suit.Hearts, Rank.Jack));
        buildDeck.add(new Card(Suit.Hearts, Rank.Queen));
        buildDeck.add(new Card(Suit.Hearts, Rank.King));
        buildDeck.add(new Card(Suit.Hearts, Rank.Ace));

        buildDeck.add(new Card(Suit.Spades, Rank.Two));
        buildDeck.add(new Card(Suit.Spades, Rank.Three));
        buildDeck.add(new Card(Suit.Spades, Rank.Four));
        buildDeck.add(new Card(Suit.Spades, Rank.Five));
        buildDeck.add(new Card(Suit.Spades, Rank.Six));
        buildDeck.add(new Card(Suit.Spades, Rank.Seven));
        buildDeck.add(new Card(Suit.Spades, Rank.Eight));
        buildDeck.add(new Card(Suit.Spades, Rank.Nine));
        buildDeck.add(new Card(Suit.Spades, Rank.Ten));
        buildDeck.add(new Card(Suit.Spades, Rank.Jack));
        buildDeck.add(new Card(Suit.Spades, Rank.Queen));
        buildDeck.add(new Card(Suit.Spades, Rank.King));
        buildDeck.add(new Card(Suit.Spades, Rank.Ace));

        buildDeck.add(new Card(Suit.Clubs, Rank.Two));
        buildDeck.add(new Card(Suit.Clubs, Rank.Three));
        buildDeck.add(new Card(Suit.Clubs, Rank.Four));
        buildDeck.add(new Card(Suit.Clubs, Rank.Five));
        buildDeck.add(new Card(Suit.Clubs, Rank.Six));
        buildDeck.add(new Card(Suit.Clubs, Rank.Seven));
        buildDeck.add(new Card(Suit.Clubs, Rank.Eight));
        buildDeck.add(new Card(Suit.Clubs, Rank.Nine));
        buildDeck.add(new Card(Suit.Clubs, Rank.Ten));
        buildDeck.add(new Card(Suit.Clubs, Rank.Jack));
        buildDeck.add(new Card(Suit.Clubs, Rank.Queen));
        buildDeck.add(new Card(Suit.Clubs, Rank.King));
        buildDeck.add(new Card(Suit.Clubs, Rank.Ace));

        return buildDeck;
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
