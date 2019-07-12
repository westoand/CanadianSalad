import java.util.LinkedList;

public class Trick {
    protected LinkedList<Card> trick;
    protected Card led;
    protected Card losing;
    protected Player taker;

    public Trick(Player firstPlayer, Card led) {
        taker = firstPlayer;
        trick = new LinkedList<>();
        trick.add(led);
        this.led = led;
        this.losing = led;
    }

    public void add(Card newCard, Player p) {
        trick.add(newCard);
        //if the card is the trump suit and higher than the losing card, the new card is the new loser
        if ((led.suit==newCard.suit) && (newCard.compareTo(losing) > 0)) {
            losing = newCard;
            taker = p;
        }
    }

    public Player getTaker() {
        return taker;
    }
    
    public LinkedList<Card> getTrickList() {
    	return trick;
    }

    @Override
    public String toString() {
        return "Trick{" +
                "trick=" + trick +
                ", led=" + led +
                ", losing=" + losing +
                ", taker=" + taker.name +
                '}';
    }
}
