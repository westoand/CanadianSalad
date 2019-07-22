package cis.project1;

import java.util.Collections;
import java.util.LinkedList;


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
	
	/** Players is a collection of the game players (user and AI). */
	private LinkedList<Player> players;
	
	/** This collection maintains the game "tricks" or one play of
	 * each player. */
	private LinkedList<Trick> tricks;
	
	/** CurrentPlayer represents the player whose turn it is. */
	private Player currentPlayer;

	
	/** Points scored for taking a trick in an ordinary hand. */
	private static final int TRICK_PTS = 10;
	
	/*Planned variables for version 2 */
//    private final int HEART_PTS = 10;
//    private final int QUEEN_PTS = 25;
//    private final int KING_SPADES_PTS = 100;
//    private final int LAST_TRICK_PTS = 100;
	
	/** The game is complete when all players have played all hands. */
	private boolean gameComplete;

	
	
	 /*****************************************************************
     * This constructor creates a CanadianSaladModel object that
     * simulates the trick-taking card game Canadian Salad.
     * The class provides game logic, supervised AI representing
     * other players, and scoring.
     *
     * @param players the collection of game players
     *****************************************************************/
	public CanadianSaladModel(final LinkedList<Player> players) {
		this.players = players;
		currentPlayer = players.getLast();
		tricks = new LinkedList<>();
		gameComplete = false;
		this.deal();
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
		for (int p = 0; p < players.size(); p++) {
			if (players.get(p).getHand().size() > 0) {
				gameComplete = false;
			}
		}
		return gameComplete;
	}

	
	 /*****************************************************************
     * This method returns whether the trick is finished.
     *
     * @return is true when all players have played a card.
     *****************************************************************/
	public boolean isTrickComplete() {
		if (tricks.isEmpty()) {
			return false;
		} else {
			return trickCards().size() == players.size();
		}
	}

	
	 /*****************************************************************
     * This method is a simple AI that represents other (non-user)
     * players.  It calls other helper methods to adjust its response.
     *****************************************************************/
	public void computerPlay() {
		if (getCurrentTrick() == null) {
			// cards sorted, return highest
			playCard(getLead());
		} else if (trickCards().size() == players.size()) {
			playCard(getLead());
		} else {
			// if the first move has been
			if (canFollowSuit()) {
				playCard(getOptimalFollow());
			} else {
				playCard(getThrowOffSuit());
			}
		}
	}

	
	 /*****************************************************************
     * This getter method returns the current trick.
     *
     * @return is the Trick object representing the most recent trick.
     *****************************************************************/
	public Trick getCurrentTrick() {
		if (tricks.isEmpty()) {
			return null;
		} else {
			return tricks.getLast();
		}
	}

	
	 /*****************************************************************
     * This getter method returns the cards in the current trick.
     *
     * @return is the LinkedList of Card objects played in the current
     * trick.
     *****************************************************************/
	public LinkedList<Card> trickCards() {
		return tricks.getLast().getTrick();
	}

	
	 /*****************************************************************
     * This method models the passing of the current player's turn.
     *****************************************************************/
	public void nextTurn() {
		if ((!isUsersTurn()) && (!isGameComplete())) {
			computerPlay();
			// System.out.println(getCurrentTrick());
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
		Suit whatWasLed = getCurrentTrick().getLed().getSuit();
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
	public Card getLead() {
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
		if (isFirstTurn()) {
			playHelper(card);
		} else {
			// if last trick is complete then create new trick
			if (isTrickComplete()) {
				// if user then play the card they specified
				if (isUsersTurn()) {
					playHelper(card);
					} else {
				playHelper(card);
				}
			} else {
				getCurrentTrick().add(getCurrentPlayer().
						getHand()
						.remove(getCurrentPlayer().
								getHand().
								indexOf(card)),
						getCurrentPlayer());
			}
		}
		passTurn();
	}

	
	 /*****************************************************************
     * This helper method adds a card to the current trick and passes 
     * the turn to the next player.
     * 
     * @param card represents the card the player is playing into the
     * trick.
     *****************************************************************/
	private void playHelper(final Card card) {
		tricks.add(new Trick(getCurrentPlayer(),
				getCurrentPlayer()
				.getHand().remove(
						getCurrentPlayer(
								).
						getHand().indexOf(card))));
	}

	
	 /*****************************************************************
     * This method checks whether it is the user's (not a simulated
     * player) turn.
     * 
     * @return  is true when it is the user's turn.
     *****************************************************************/
	protected boolean isUsersTurn() {
		return (getCurrentPlayer() == players.get(players.size() - 1));
	}

	
	 /*****************************************************************
     * This method checks whether it is the first turn of the game.
     * 
     * @return  is true when no player has played a card.
     *****************************************************************/
	protected boolean isFirstTurn() {
		return tricks.isEmpty();
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
	public Card getOptimalFollow() {
		Suit whatWasLed = getCurrentTrick().getLed().getSuit();
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
						getCurrentTrick().
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
	public Card getThrowOffSuit() {
		return 
				getCurrentPlayer()
				.getHand().get(0); 	
	}

	
	 /*****************************************************************
     * This helper method models the dealing of the deck and the
     * players sorting their hands.
     *****************************************************************/
	public void deal() {
		Deck d = new Deck(players.size());
		// deal to the left of the dealer
		passTurn();

		while (!d.isEmpty()) {
			getCurrentPlayer().getHand().add(d.pop());
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
	public void scoreHandNoTricks() {
		players.get(players.indexOf(getCurrentTrick().getTaker())).
		setScore(TRICK_PTS);
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
		setCurrentPlayer(getCurrentTrick().getTaker());
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

}
//  Draft for version 2
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
