package cis.project1;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


/**********************************************************************
 * This class is the "model" class of a Model-View-Controller program.
 * The program simulates the trick-taking card game Canadian Salad.
 * CanadianSaladModel provides game logic, supervised AI representing
 * other players, and scoring.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class CanadianSaladModel {

    /**
     * Players is a collection of the game players (user and AI).
     */
    private LinkedList<Player> players;

    /**
     * This collection maintains the game "tricks" or one play of
     * each player.
     */
    //private LinkedList<Trick> tricks;

    private LinkedList<LinkedList<Trick>> hands;

    /**
     * CurrentPlayer represents the player whose turn it is.
     */
    private Player currentPlayer;


    /**
     * Points scored for taking a trick.
     */
    private static final int TRICK_PTS = 10;

    /**
     * Points scored for taking a card of suit Heart.
     */
    private static final int HEART_PTS = 10;

    /**
     * Points scored for taking a Queen.
     */
    private static final int QUEEN_PTS = 25;

    /**
     * Points scored for taking the King of Spades.
     */
    private static final int KING_SPADES_PTS = 100;

    /**
     * Points scored for taking the last trick.
     */
    private static final int LAST_TRICK_PTS = 100;

    /**
     * Minimum number of players in a Canadian Salad game.
     */
    private static final int MIN_PLAYERS = 3;

    /**
     * Maximum number of players in a Canadian Salad game.
     */
    private static final int MAX_PLAYERS = 6;

    /**
     * Number of Canadian Salad hands.
     */
    private static final int NUMBER_OF_HANDS = 6;

    /**
     * The number of cards at the start of a hand with three players.
     */
    private static final int THREE_PLAYERS_HANDSIZE = 17;

    /**
     * The number of cards at the start of a hand with four players.
     */
    private static final int FOUR_PLAYERS_HANDSIZE = 13;

    /**
     * The number of cards at the start of a hand with five players.
     */
    private static final int FIVE_PLAYERS_HANDSIZE = 10;

    /**
     * The number of cards at the start of a hand with six players.
     */
    private static final int SIX_PLAYERS_HANDSIZE = 8;

    /**
     * The game is complete when all players have played all hands.
     */
    private boolean gameComplete;

    /**
     * The hand is complete when all players have played a card.
     */
    private boolean handComplete;

    /**
     * The game deck.
     */
    private Deck deck;

    /**
     * The count of the six CanadianSalad hands.
     */
    private int handNumber;
    
    
    /**
     * The collection of EventListener's to report state changes.
     */
    private EventListenerList listenerList = new EventListenerList();
    
    /**
     * The current ChangEvent in the game state.
     */
    private ChangeEvent changeEvent = null;


    /*****************************************************************
     * This constructor creates a CanadianSaladModel object that
     * simulates the trick-taking card game Canadian Salad.
     * The class provides game logic, supervised AI representing
     * other players, and scoring.
     *
     * @param players the collection of game players
     *****************************************************************/
    public CanadianSaladModel(final LinkedList<Player> players) {
        if ((players.size() > MAX_PLAYERS) 
        		|| (players.size() < MIN_PLAYERS)) {
            throw new IllegalArgumentException();
        }
        this.players = players;
        currentPlayer = players.getLast();
        hands = new LinkedList<>();
        //hands.add(new LinkedList<>());
        gameComplete = false;
        this.deal();
        handNumber = 0;
    }

    
    /*****************************************************************
     * This method adds Listener objects to a collection to report
     * state changes.
     *
     * @param l is a ChangeListener to report state changes.
     *****************************************************************/
    public void addModelListener(final Panel.ModelListener l) {
        listenerList.add(Panel.ModelListener.class, l);
    }


    /*****************************************************************
     * This method reports state changes to a collection of model
     * listeners.
     *****************************************************************/
    protected void fireStateChanged() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == Panel.ModelListener.class) {
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((ChangeListener) listeners[i + 1]).stateChanged(changeEvent);
            }
        }
    }


    /*****************************************************************
     * This method begins the next hand in "this" CanadianSaladModel
     * game.
     *****************************************************************/
    protected void startNewHand() {
        hands.add(new LinkedList<>());
    }


    /*****************************************************************
     * This getter method returns the current Hand.
     *
     * @return is collection of Tricks representing the current hand.
     *****************************************************************/
    private LinkedList<Trick> getHand() {
        if (hands.isEmpty()) {
            return null;
        } else {
            return hands.getLast();
        }
    }


    /*****************************************************************
     * This getter method returns the current Trick.
     *
     * @return is the Trick representing the current game trick.
     *****************************************************************/
    public Trick getTrick() {
        if ((getHand() == null) || (getHand().isEmpty())) {
            return null;
        } else {
            return getHand().getLast();
        }
    }


    /*****************************************************************
     * This getter method returns the collection of players.
     *
     * @return is the LinkedList representing the game players.
     *****************************************************************/
    public LinkedList<Player> getPlayers() {
        return players;
    }


    /*****************************************************************
     * This method returns whether the game is finished.
     *
     * @return is true when all players have played all hands.
     *****************************************************************/
    public boolean isGameComplete() {
        gameComplete = true;
        //if all hands are not started then game is not over
        if (hands.size() != NUMBER_OF_HANDS) {
            gameComplete = false;
        } else {
            //if anyone has remaining cards then game is not over
            for (Player p : players) {
                if (!p.getHand().isEmpty()) {
                    gameComplete = false;
                    break;
                }
            }
        }
        return gameComplete;
    }

    
    /*****************************************************************
     * This method returns whether the hand is finished.
     *
     * @return is true when all players have played their hands.
     *****************************************************************/
    public boolean isHandComplete() {
        handComplete = false;
        if ((players.size() == 3) 
        		&& (hands.getLast().size() == THREE_PLAYERS_HANDSIZE)) {
            handComplete = true;
        }
        if ((players.size() == 4) 
        		&& (hands.getLast().size() == FOUR_PLAYERS_HANDSIZE)) {
            handComplete = true;
        }
        if ((players.size() == 5) 
        		&& (hands.getLast().size() == FIVE_PLAYERS_HANDSIZE)) {
            handComplete = true;
        }
        if ((players.size() == 6) 
        		&& (hands.getLast().size() == SIX_PLAYERS_HANDSIZE)) {
            handComplete = true;
        }
        return handComplete;
    }


    /*****************************************************************
     * This method returns whether the trick is finished.
     *
     * @return is true when all players have played a card.
     *****************************************************************/
    public boolean isTrickComplete() {
        if (getTrick() == null) {
            return false;
        } else {
            return getTrick().isComplete();
        }
    }


    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    protected void computerPlay() {
        switch (handNumber) {
            case 1:
                computerPlayNoTricks();
                break;
            case 2:
                computerPlayNoHearts();
                break;
            case 3:
                computerPlayNoQueens();
                break;
            case 4:
                computerPlayNoKingOfSpades();
                break;
            case 5:
                computerPlayNoLastTrick();
                break;
            case 6:
                computerPlayNoneOfTheAbove();
                break;
            default:
            	break;
        }
    }

    
    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoneOfTheAbove() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return lowest
            playCard(getLeadNoTricks());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollowNoneOfTheAbove());
            } else {
                playCard(getThrowOffSuitNoneOfTheAbove());
            }
        }
    }

    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * does not need to follow suit.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getThrowOffSuitNoneOfTheAbove() {
        //try to throw king of spades
        for (Card c : getCurrentPlayer().getHand()) {
            if ((c.getSuit() == Suit.Spades)
                    && (c.getRank() == Rank.King)) {
                return c;
            }
        }
        //try to throw queen of hearts
        for (Card c : getCurrentPlayer().getHand()) {
            if ((c.getRank() == Rank.Queen)
                    && (c.getSuit() == Suit.Hearts)) {
                return c;
            }
        }
        //try to throw any other queen
        for (Card c : getCurrentPlayer().getHand()) {
            if ((c.getRank() == Rank.Queen)) {
                return c;
            }
        }
        return getThrowOffSuit();
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * must follow suit.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getOptimalFollowNoneOfTheAbove() {
        Suit whatWasLed = getTrick().getLed().getSuit();
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                options.add(c);
            }
        }
        if (options.size() == 1) {
            return getCurrentPlayer().getHand().get(
                    getCurrentPlayer().getHand().indexOf(
                            options.get(0)));
        } else {
            // best case is to play a king of spades without losing
            for (Card z : options) {
                if ((z.compareTo(getTrick().getLosing()) < 0)
                        && (z.getRank() == Rank.King)
                        && (z.getSuit() == Suit.Spades)) {
                    return z;
                }
            }
            //next best is to play a queen without losing
            for (Card z : options) {
                if ((z.compareTo(getTrick().getLosing()) < 0)
                        && (z.getRank() == Rank.Queen)) {
                    return z;
                }
            }
            //next best case is to avoid taking the trick
            for (Card z : options) {
                if (z.compareTo(getTrick().getLosing()) < 0) {
                    return z;
                }
            }
            //if you have to lose avoid giving yourself a bunch of points
            for (Card z : options) {
                if ((z.getSuit() != Suit.Hearts)
                        && (z.getRank() != Rank.Queen)) {
                    return z;
                }
            }
            for (Card z : options) {
                if (z.getRank() != Rank.Queen) {
                    return z;
                }
            }
            // worst case if you have to lose throw your highest losing card
            return options.get(0);
        }
    }

    
    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoLastTrick() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return highest
            playCard(getLeadNoLastTrick());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollowNoLastTrick());
            } else {
                playCard(getThrowOffSuit());
            }
        }
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * is first to play a trick in the "No LAst Trick" hand.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getLeadNoLastTrick() {
        return getCurrentPlayer().getHand().get(0);
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * must follow suit.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getOptimalFollowNoLastTrick() {
        Suit whatWasLed = getTrick().getLed().getSuit();
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                options.add(c);
            }
        }
        //return largest card that follows suit
        return getCurrentPlayer().getHand().get(
        		getCurrentPlayer().getHand(
        				).indexOf(options.get(0)));
    }


    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoKingOfSpades() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return highest
            playCard(getLeadNoTricks());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollowNoKingOfSpades());
            } else {
                playCard(getThrowOffSuitNoKingOfSpades());
            }
        }
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * need not follow suit in a "No King of Spades" trick.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getThrowOffSuitNoKingOfSpades() {
        for (Card c : getCurrentPlayer().getHand()) {
            if ((c.getSuit() == Suit.Spades)
                    && (c.getRank() == Rank.King)) {
                return c;
            }
        }
        return getThrowOffSuit();
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * must follow suit.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getOptimalFollowNoKingOfSpades() {
        Suit whatWasLed = getTrick().getLed().getSuit();
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                options.add(c);
            }
        }
        if (options.size() == 1) {
            return getCurrentPlayer().getHand().get(
                    getCurrentPlayer().getHand().indexOf(
                            options.get(0)));
        } else {
            // best case is to play a king of spades without losing
            for (Card z : options) {
                if ((z.compareTo(getTrick().getLosing()) < 0)
                        && (z.getRank() == Rank.King)
                        && (z.getSuit() == Suit.Spades)) {
                    return z;
                }
            }
            //next best case is to avoid taking the trick
            for (Card z : options) {
                if (z.compareTo(getTrick().getLosing()) < 0) {
                    return z;
                }
            }
            // worst case if you have to lose throw your highest losing card
            return options.get(0);
        }
    }


    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoTricks() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return highest
            playCard(getLeadNoTricks());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollow());
            } else {
                playCard(getThrowOffSuit());
            }
        }
    }

    
    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoHearts() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return highest
            playCard(getLeadNoHearts());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollow());
            } else {
                playCard(getThrowOffSuitNoHearts());
            }
        }
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * need not follow suit in a "No Hearts" trick.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getThrowOffSuitNoHearts() {
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == Suit.Hearts) {
                return c;
            }
        }
        return getThrowOffSuit();
    }

    
    /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
    private void computerPlayNoQueens() {
        if ((getTrick() == null)
                || (getTrick().isComplete())
                || (getTrick().getTrick().isEmpty())) {
            // cards sorted, return highest
            playCard(getLeadNoTricks());
        } else {
            if (canFollowSuit()) {
                playCard(getOptimalFollowNoQueens());
            } else {
                playCard(getThrowOffSuitNoQueens());
            }
        }
    }

    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * need not follow suit in a "No Queens" trick.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getThrowOffSuitNoQueens() {
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getRank() == Rank.Queen) {
                return c;
            }
        }
        return getThrowOffSuit();
    }


    
    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * must follow suit in a "No Queens" trick.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getOptimalFollowNoQueens() {
        Suit whatWasLed = getTrick().getLed().getSuit();
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                options.add(c);
            }
        }
        if (options.size() == 1) {
            return getCurrentPlayer().getHand().get(
                    getCurrentPlayer().getHand().indexOf(
                            options.get(0)));
        } else {
            // best case is to play a queen of trump suit
            for (Card z : options) {
                if ((z.compareTo(getTrick().getLosing()) < 0)
                        && (z.getRank() == Rank.Queen)) {
                    return z;
                }
            }
            //next best case is to avoid taking the trick
            for (Card z : options) {
                if (z.compareTo(getTrick().getLosing()) < 0) {
                    return z;
                }
            }
            // worst case if you have to lose throw your highest losing card
            return options.get(0);
        }
    }


    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * will play first in a "No Hearts" trick.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getLeadNoHearts() {
        //if you have a low heart then play that
        for (int c = getCurrentPlayer().getHand().size() - 1; c >= 0; c--) {
            if (getCurrentPlayer().getHand().get(c).
            		compareTo(new Card(Suit.Hearts, Rank.Five)) < 0) {
                return getCurrentPlayer().getHand().get(c);
            }
        }
        //otherwise simply avoid taking the trick
        return getLeadNoTricks();
    }


    /*****************************************************************
     * This getter method returns the cards in the current trick.
     *
     * @return is the LinkedList of Card objects played in the current
     * trick.
     *****************************************************************/
    public LinkedList<Card> trickCards() {
        //return tricks.getLast().getTrick();
        if (getTrick() == null) {
            return null;
        } else {
            return getTrick().getTrick(); 
        }
    }

    /*****************************************************************
     * This method returns whether the current player can follow
     * trump (the Suit of the card that was led).
     *
     * @return is true when the current player has a card of the Suit
     * that was led.
     *****************************************************************/
    public boolean canFollowSuit() {
        boolean canFollow = false;
        Suit whatWasLed = getTrick().getLed().getSuit();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                canFollow = true;
                break;
            }
        }
        return canFollow;
    }


    /*****************************************************************
     * This helper method selects a suitable Card to play first in a
     * new trick.
     *
     * @return is the Card object representing the first card to play.
     *****************************************************************/
    private Card getLeadNoTricks() {
        return getCurrentPlayer().getHand().get(
                getCurrentPlayer().getHand().size() - 1);
    }


    /*****************************************************************
     * This method adds a card to the current trick and passes the
     * turn to the next player.
     *
     * @param card represents the card the player is playing into the
     * trick.
     *****************************************************************/
    public void playCard(final Card card) {
            getTrick().add(getCurrentPlayer().getHand()
            		.remove(getCurrentPlayer().getHand()
            				.indexOf(card)), getCurrentPlayer());

        //if everyone has played then set the trick to complete
        if (getTrick().getTrick().size() == players.size()) {
            getTrick().setComplete(true);
        }
        passTurn();
    }


    /*****************************************************************
     * This helper method adds a card to the current trick and passes
     * the turn to the next player.
     *
     *****************************************************************/
    protected void startNewTrick() {
        if (players.get(0).getHand().size() > 0) {
            hands.get(handNumber - 1).
            add(new Trick(getCurrentPlayer()));
        }
    }


    /*****************************************************************
     * This method checks whether it is the user's (not a simulated
     * player) turn.
     *
     * @return is true when it is the user's turn.
     *****************************************************************/
    protected boolean isUsersTurn() {
        return (getCurrentPlayer() == players.get(players.size() - 1));
    }


    /*****************************************************************
     * This method checks whether it is the first turn of the game.
     *
     * @return is true when no player has played a card.
     *****************************************************************/
    protected boolean isFirstTurn() {
        return hands.get(0).size() == 0;
    }


    /*****************************************************************
     * This method passes the turn to each player sequentially.
     *****************************************************************/
    private void passTurn() {
        setCurrentPlayer(players.get(
                (players.indexOf(getCurrentPlayer()) + 1)
                        % players.size()));
    }


    /*****************************************************************
     * This helper method selects a suitable Card to play if a player
     * must follow suit.
     *
     * @return is the Card object representing the a suitable card to
     * play.
     *****************************************************************/
    private Card getOptimalFollow() {
        Suit whatWasLed = getTrick().getLed().getSuit();
        LinkedList<Card> options = new LinkedList<>();
        for (Card c : getCurrentPlayer().getHand()) {
            if (c.getSuit() == whatWasLed) {
                options.add(c);
            }
        }
        if (options.size() == 1) {
            return getCurrentPlayer().getHand().get(
                    getCurrentPlayer().getHand().indexOf(
                            options.get(0)));
        } else {
            // try to avoid taking the trick
            for (Card z : options) {
                if (z.compareTo(
                        getTrick().
                                getLosing()) < 0) {
                    return z;
                }
            }
            // if you have to lose throw your highest losing card
            return options.get(0);
        }
    }


    /*****************************************************************
     * This helper method selects a suitable Card to play if the
     * player cannot follow suit (does not have any of the trump
     * suit in their hand).
     *
     * @return is the Card object representing the first card to play.
     *****************************************************************/
    private Card getThrowOffSuit() {
        return getCurrentPlayer().getHand().get(0);
    }


    /*****************************************************************
     * This helper method models the dealing of the deck and the
     * players sorting their hands.
     *****************************************************************/
    public void deal() {
        deck = new Deck();
        deck.randomize();
        makeEvenHands(players.size(), deck);


        setCurrentPlayer(players.get((handNumber + players.size())
        		% players.size()));

        while (!deck.isEmpty()) {
            getCurrentPlayer().getHand().add(deck.pop());
            passTurn();
        }
        for (Player p : players) {
            Collections.sort(p.getHand(),
                    Collections.reverseOrder());
        }
    }


    /*****************************************************************
     * This getter method returns the player whose turn it is.
     *
     * @return is the Player representing the current player.
     *****************************************************************/
    public Player getCurrentPlayer() {
        return currentPlayer;

    }


    /*****************************************************************
     * This setter method sets the player whose turn it is.
     *
     * @param p is the player who is assuming the turn.
     *****************************************************************/
    public void setCurrentPlayer(final Player p) {
        this.currentPlayer = p;
    }


    /*****************************************************************
     * This method updates the players' scores for a "No Tricks" hand.
     *****************************************************************/
    public void scoreNoTricks() {
        players.get(players.indexOf(getTrick().getTaker())).
                addToScore(TRICK_PTS);
    }

    
    /*****************************************************************
     * This method updates the players' scores for a "No Hearts" hand.
     *****************************************************************/
    public void scoreNoHearts() {
        for (Card c : getTrick().getTrick()) {
            if (c.getSuit() == Suit.Hearts) {
                getTrick().getTaker().addToScore(HEART_PTS);
            }
        }
    }

    
    /*****************************************************************
     * This method updates the players' scores for a "No Queens" hand.
     *****************************************************************/
    public void scoreNoQueens() {
        for (Card c : getTrick().getTrick()) {
            if (c.getRank() == Rank.Queen) {
                getTrick().getTaker().addToScore(QUEEN_PTS);
            }
        }
    }

    
    /*****************************************************************
     * This method updates the players' scores for a "No King of 
     * Spades" hand.
     *****************************************************************/
    public void scoreNoKingOfSpades() {
        for (Card c : getTrick().getTrick()) {
            if ((c.getRank() == Rank.King)
                    && (c.getSuit() == Suit.Spades)) {
                getTrick().getTaker().addToScore(KING_SPADES_PTS);
            }
        }
    }

    
    /*****************************************************************
     * This method updates the players' scores for a "No Last Trick" 
     * hand.
     *****************************************************************/
    public void scoreNoLastTrick() {
        if ((players.size() == 5)
                && (hands.get(handNumber - 1).size() 
                		== FIVE_PLAYERS_HANDSIZE)) {
            getTrick().getTaker().addToScore(LAST_TRICK_PTS);
        }
    }

    
    /*****************************************************************
     * This method updates the players' scores for a "None of the 
     * Above" hand.
     *****************************************************************/
    public void scoreNoneOfTheAbove() {
        scoreNoTricks();
        scoreNoHearts();
        scoreNoQueens();
        scoreNoKingOfSpades();
        scoreNoLastTrick();
    }

    
    /*****************************************************************
     * This method determines how to score the trick based on the 
     * type of the current hand.
     *****************************************************************/
    public void scoreTrick() {
        switch (handNumber) {
            case 1:
                scoreNoTricks();
                break;
            case 2:
                scoreNoHearts();
                break;
            case 3:
                scoreNoQueens();
                break;
            case 4:
                scoreNoKingOfSpades();
                break;
            case 5:
                scoreNoLastTrick();
                break;
            case 6:
                scoreNoneOfTheAbove();
                break;
            default:
                	break;
        }
    }


    /*****************************************************************
     * This getter method returns the collection of Card objects in
     * the current player's hand.
     *
     * @return is the LinkedList of Card objects of the current player.
     *****************************************************************/
    public LinkedList<Card> getUsersHand() {
        return players.get(players.size() - 1).getHand();
    }


    /*****************************************************************
     * This helper method sets the current player for the next trick
     * to be the loser of the last trick.
     *****************************************************************/
    protected void setLoserLeadsNextTrick() {
        // player who lost this trick will lead the next trick
        setCurrentPlayer(getTrick().getTaker());
    }


    /*****************************************************************
     * This helper method gets the player object representing the
     * user.
     *
     * @return is the Player modeling the user.
     *****************************************************************/
    protected Player getUserPlayer() {
        return players.get(players.size() - 1);
    }

    /*****************************************************************
     * This helper method builds a deck with the proper number of
     * cards for the number of players.
     *
     * @param numPlayers the number of game players
     * @param d is the original Deck to be modified.
     * @return is a Deck representing the modified deck.
     *****************************************************************/
    protected Deck makeEvenHands(final int numPlayers, final Deck d) {
        if (numPlayers == 3) {
            d.remove(new Card(Suit.Clubs, Rank.Two));
        }

        if (numPlayers == 5) {
            d.remove(new Card(Suit.Clubs, Rank.Two));
            d.remove(new Card(Suit.Diamonds, Rank.Two));
        }
        if (numPlayers == 6) {
            d.remove(new Card(Suit.Clubs, Rank.Two));
            d.remove(new Card(Suit.Clubs, Rank.Three));
            d.remove(new Card(Suit.Diamonds, Rank.Two));
            d.remove(new Card(Suit.Diamonds, Rank.Three));
        }
        return d;
    }

    /*****************************************************************
     * This helper method signals the panel should simulate game play.
     *****************************************************************/
    protected void autoPlay() {
        while (!isGameComplete()) {
            startNewHand();
            handNumber++;
            fireStateChanged();
            while (!isHandComplete()) {
                startNewTrick();
                fireStateChanged();
                while (!isTrickComplete()) {
                    if (!isUsersTurn() && (!isTrickComplete())) {
                        computerPlay();
                        sleep();
                    }
                    fireStateChanged();
                    //System.out.println(getTrick());
                }
                System.out.println("Got here B");
                scoreTrick();
                setLoserLeadsNextTrick();
                fireStateChanged();
            }
            if (handNumber <= 6) {
                deal();
            }
            System.out.println("New Hand has been dealt");
        }
    }

    
    /*****************************************************************
     * This helper method gets the player object representing the
     * user.
     *
     * @return is the index of the hand (1-6).
     *****************************************************************/
    public int getHandNumber() {
        return this.handNumber;
    }
    
    /*****************************************************************
     * This helper method sets the current hand number.
     * user.
     *
     * @param num is the number of the hand beginning with 1.
     *****************************************************************/
    public void setHandNumber(final int num) {
        this.handNumber = num;
    }
    
    /*****************************************************************
     * This helper method gets the player object representing the
     * user.
     *
     * @return is the index of the hand (1-6).
     *****************************************************************/
    public LinkedList<LinkedList<Trick>> getHands() {
        return hands;
    }

    /*****************************************************************
     * This helper method simulates delay between turns for thinking
     * and playing.
     *****************************************************************/
    protected void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {
            System.out.println("Blew up after sleep");
        }
    }
}
