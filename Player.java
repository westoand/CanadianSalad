import java.util.LinkedList;

public class Player {
    protected String name;
    protected LinkedList<Card> hand;
    protected LinkedList<Trick> tricks;
    protected int score;

    Player(String name) {
        this(name, new LinkedList<>(), 0, new LinkedList<>());
    }

    Player(String name, LinkedList<Card> hand, int score, LinkedList<Trick> tricks) {
        this.name = name;
        this.hand = hand;
        this.score = score;
        this.tricks = tricks;
    }

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
    
    public void emptyHand() {
    	while (hand.size() > 0) {
    		hand.remove();
    	}
    }

    public void takeTrick(Trick trick) {
        this.tricks.add(trick);
    }
    public void printScore() {
        System.out.println(name + "'s score is: " + score);
    }
}
