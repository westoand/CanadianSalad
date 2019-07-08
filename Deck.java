import java.util.*;

public class Deck {
    LinkedList<Card> deck;

    public Deck(int numPlayers) {
        deck = new LinkedList<>();
        initializeDeck(numPlayers);
    }

    private void initializeDeck(int numPlayers) {
        LinkedList<Card> tempDeck = makeEvenHands(numPlayers, createDeck());

        while (!tempDeck.isEmpty()) {
            Random rand = new Random();
            deck.add(tempDeck.remove(rand.nextInt(tempDeck.size())));
        }
    }

    private LinkedList<Card> makeEvenHands(int numPlayers, LinkedList<Card> buildDeck) {
        if (numPlayers == 3)
            buildDeck.remove(new Card(Suit.Clubs, Rank.Two));

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

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public Card add() {
        return deck.pop();
    }

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


    @Override
    public String toString() {
        StringBuilder deckStr = new StringBuilder();
        for (Card c : deck)
            deckStr.append(c.toString());
        return deckStr.toString();
    }

    public static void main(String[] args) {
        Deck myD = new Deck(3);
        System.out.println(myD.toString());
    }
}
