import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card> {

    protected Suit suit;
    protected Rank rank;
    protected static final Map<Rank, Integer> map = new HashMap<>();
    static{
        map.put(Rank.Two, 2);
        map.put(Rank.Three, 3);
        map.put(Rank.Four, 4);
        map.put(Rank.Five, 5);
        map.put(Rank.Six, 6);
        map.put(Rank.Seven, 7);
        map.put(Rank.Eight, 8);
        map.put(Rank.Nine, 9);
        map.put(Rank.Ten, 10);
        map.put(Rank.Jack, 11);
        map.put(Rank.Queen, 12);
        map.put(Rank.King, 13);
        map.put(Rank.Ace, 14);
    }


    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    @Override
    public int compareTo(Card comparison) {
        return Card.map.get(this.rank).compareTo(Card.map.get(comparison.rank));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o instanceof Card)
        return ((suit == ((Card) o).suit) && (rank == ((Card) o).rank));
        else return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = (int) (map.get(this.rank) / 17);
        return result;
    }
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result =prime
//
//    }

    @Override
    public String toString() {
        return rank + " of " + suit + "\n";
    }



    public static void main(String[] args) {
        Card c =new Card(Suit.Clubs, Rank.Two);
        Card c2 =new Card(Suit.Clubs, Rank.Five);

        System.out.println(c.compareTo(c2));
    }
}
