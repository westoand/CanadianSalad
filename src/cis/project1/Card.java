package cis.project1;

import java.util.HashMap;
import java.util.Map;

/**********************************************************************
 * This class represents a card in a standard deck.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class Card implements Comparable<Card> {

    /******************************************************************
     * This Suit member represents the card's suit.
     *****************************************************************/
    private Suit suit;

    /******************************************************************
     * This Rank member represents the card's rank.
     *****************************************************************/
    private Rank rank;

    /******************************************************************
     * This map represents cards' relative ranking.
     *****************************************************************/
    private static final Map<Rank, Integer> MAP = new HashMap<>();
    static {
        MAP.put(Rank.Two, 2);
        MAP.put(Rank.Three, 3);
        MAP.put(Rank.Four, 4);
        MAP.put(Rank.Five, 5);
        MAP.put(Rank.Six, 6);
        MAP.put(Rank.Seven, 7);
        MAP.put(Rank.Eight, 8);
        MAP.put(Rank.Nine, 9);
        MAP.put(Rank.Ten, 10);
        MAP.put(Rank.Jack, 11);
        MAP.put(Rank.Queen, 12);
        MAP.put(Rank.King, 13);
        MAP.put(Rank.Ace, 14);
    }


    /*****************************************************************
     * This constructor creates a Card object.
     *
     * @param s is a Suit representing the card's suit.
     * @param r is a Rank representing the card's rank.
     *****************************************************************/
    public Card(final Suit s, final Rank r) {
        suit = s;
        rank = r;
    }


    /******************************************************************
     * This method defines the relative ranking of cards.  A card's
     * size is determined by its rank attribute.
     *
     * @param comparison is the card for comparison to "this" card.
     * board.
     * @return a negative integer, zero, or a positive integer as this
     * object is less than, equal to, or greater than the specified
     * object.
     *****************************************************************/
    public int compareTo(final Card comparison) {
        return Card.MAP.get(this.rank).
                compareTo(Card.MAP.get(comparison.rank));
    }


    /****************************************************************
     * This method overrides the Object equals() method.  Cards are
     * considered equal if their ranks and suits are both the same.
     *
     * @param o is the object for comparison to "this" Card object.
     * board.
     * @return is true when ranks and suits are both the same.
     *****************************************************************/
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Card) {
            return ((suit == ((Card) o).suit)
                    && (rank == ((Card) o).rank));
        } else {
            return false;
        }
    }


    /*****************************************************************
     * This method overrides the Object hashCode() method.
     *
     * @return is the integer representing a hash value.
     *****************************************************************/
    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (MAP.get(this.rank) / 17);
        return result;
    }


    /*****************************************************************
     * This method overrides the Object toString() method.
     *
     * @return is a String representation of the Card's attributes.
     *****************************************************************/
    @Override
    public String toString() {
        return rank + " of " + suit + "\n";
    }


    /*****************************************************************
     * This getter method returns "this" Card object's suit.
     *
     * @return is the Card object's Suit.
     *****************************************************************/
    public Suit getSuit() {
        return this.suit;
    }


    /*****************************************************************
     * This getter method returns "this" Card object's rank.
     *
     * @return is the Card object's Rank.
     *****************************************************************/
    public Rank getRank() {
        return this.rank;
    }
}
