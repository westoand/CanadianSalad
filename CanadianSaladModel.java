import java.util.*;

public class CanadianSaladModel {
    protected LinkedList<Player> players;
    protected Player currentPlayer;
    protected Trick currentTrick;
    private final int TRICK_PTS = 10;
    private final int HEART_PTS = 10;
    private final int QUEEN_PTS = 25;
    private final int KING_SPADES_PTS = 100;
    private final int LAST_TRICK_PTS = 100;


    public CanadianSaladModel(LinkedList<Player> players) {
        this.players = players;
        currentPlayer = players.getFirst();
        currentTrick = null;
        this.deal();

//        playHand();
//        scoreHandNoTricks();

    }


    public void playHand() {
        while (getCurrentPlayer().hand.size() > 0)
            playTrick();
    }

    public void playTrick() {
        for (int i = 0; i < players.size() - 1; i++) {
            System.out.println(getCurrentPlayer());
            System.out.println();
            nextTurn();
        }
        System.out.println(currentTrick);
        //player who lost this trick will lead the next trick
        setCurrentPlayer(currentTrick.getTaker());
        currentTrick.getTaker().takeTrick(currentTrick);

        currentTrick = null;
    }

    public void nextTurn() {
        if (currentTrick == null) {
            //cards already sorted (descending) after deal, just return first/highest card
            currentTrick = new Trick(getCurrentPlayer(), getCurrentPlayer().hand.remove(getCurrentPlayer().hand.size() - 1));
            setCurrentPlayer(players.get((players.indexOf(getCurrentPlayer()) + 1) % players.size()));
        } else {
            //if the first move has been
            if (canFollowSuit()) {
                playCard(getOptimalFollow());
            } else {
                playCard(throwOff());
            }
        }
    }

    public boolean canFollowSuit() {
        boolean canFollow = false;
        Suit whatWasLed = currentTrick.led.suit;                                                                           //FIXME may be able tof refactor and always get first element of LL as "what was led"
        for (Card c : getCurrentPlayer().hand)
            if (c.suit == whatWasLed) {
                canFollow = true;
                break;
            }
        return canFollow;
    }

    public void playCard(Card card) {
        currentTrick.add(getCurrentPlayer().hand.remove(getCurrentPlayer().hand.indexOf(card)), getCurrentPlayer());
        setCurrentPlayer(players.get((players.indexOf(getCurrentPlayer()) + 1) % players.size()));
    }

    public Card getOptimalFollow() {
        Suit whatWasLed = currentTrick.led.suit;
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().hand) {
            if (c.suit == whatWasLed)
                options.add(c);
        }
        if (options.size() == 1)
            return getCurrentPlayer().hand.get(getCurrentPlayer().hand.indexOf(options.get(0)));
        else {
            //try to find a card low enough to avoid taking the trick
            for (Card z : options) {
                if (z.compareTo(currentTrick.losing) < 0)
                    return z;
            }
            //if you have to lose throw your highest losing card
            return options.get(0);
        }
    }

    public Card throwOff() {
        return getCurrentPlayer().hand.get(0);                                           //FIXME make me more sophisticated if you only have one off suit card then get rid of it
    }


    public void deal() {
        Deck d = new Deck(players.size());
        setCurrentPlayer(players.get((players.indexOf(getCurrentPlayer()) + 1) % players.size()));

        while (!d.isEmpty()) {
            getCurrentPlayer().hand.add(d.add());
            setCurrentPlayer(players.get((players.indexOf(getCurrentPlayer()) + 1) % players.size()));
        }
        for (Player p : players)
            Collections.sort(p.hand, Collections.reverseOrder());
    }

    public Player getCurrentPlayer() {
        return currentPlayer;

    }

    public void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    public void scoreHandNoTricks() {
        for (Player p : players) {
            p.score += (p.tricks.size() * TRICK_PTS);
            p.tricks = new LinkedList<>();
            p.printScore();
        }
    }

    public LinkedList<Card> getUsersHand() {
        return players.get(players.size() - 1).hand;
    }
}
//  The following code is commented because it is non-essential to the version 1 release
//    public void scoreHandNoHearts() {
//        for (Player p : players) {
//            for (Trick t : p.tricks)
//                for (Card c : t.trick)
//                    if (c.suit == Suit.Hearts)
//                        p.score += HEART_PTS;
//            p.tricks = new LinkedList<>();
//            p.printScore();
//        }
//    }
//
//    public void scoreHandNoQueens() {
//        for (Player p : players) {
//            for (Trick t : p.tricks)
//                for (Card c : t.trick)
//                    if (c.rank == Rank.Queen)
//                        p.score += QUEEN_PTS;
//            p.tricks = new LinkedList<>();
//            p.printScore();
//        }
//    }
//
//    public void scoreHandNoKingOfSpades() {
//        for (Player p : players) {
//            for (Trick t : p.tricks)
//                for (Card c : t.trick)
//                    if ((c.rank == Rank.King) && (c.suit == Suit.Spades)) {
//                        p.score += KING_SPADES_PTS;
//                    }
//            p.tricks = new LinkedList<>();
//            p.printScore();
//        }
//    }
//
//    public void scoreHandNoLastTrick() {
//        //the currentPlayer is the player who lost the last trick
//        getCurrentPlayer().score += LAST_TRICK_PTS;
//    }
//
//    public void scoreHandNoneOfTheAbove() {
//        scoreHandNoTricks();
//        scoreHandNoHearts();
//        scoreHandNoQueens();
//        scoreHandNoKingOfSpades();
//        scoreHandNoLastTrick();
//    }
//
//    private void playGame() {
//        playHand();
//        scoreHandNoTricks();
//        playHand();
//        scoreHandNoHearts();
//        playHand();
//        scoreHandNoQueens();
//        playHand();
//        scoreHandNoKingOfSpades();
//        playHand();
//        scoreHandNoLastTrick();
//        playHand();
//        scoreHandNoneOfTheAbove();
//    }
//public void selectDealer() {
//    Random rand = new Random();
//    setCurrentPlayer(players.get(rand.nextInt(players.size())));
//}
