package cis.project1;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**********************************************************************
 * This class is the test class for all methods in the program.
 *
 * @author Andrew Weston, Christian Thompson
 * @version Summer 2019
 *********************************************************************/
public class CanadianSaladTest {
	
	
	
    /*****************************************************************
     * This method sets up a game with 3 players and adds specific 
     * set of cards into their hands.
     * 
     * @return CanadianSaladModel representing the test game.
     *****************************************************************/
	public CanadianSaladModel game() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		//empties hands after constructor deals cards
		john.getHand().clear();
		chris.getHand().clear();
		andrew.getHand().clear(); 
		andrew.getHand().add(new Card(Suit.Diamonds, Rank.Ace));
		andrew.getHand().add(new Card(Suit.Diamonds, Rank.Two));
		andrew.getHand().add(new Card(Suit.Diamonds, Rank.Five));
		andrew.getHand().add(new Card(Suit.Diamonds, Rank.Eight));
		andrew.getHand().add(new Card(Suit.Diamonds, Rank.Jack));
		andrew.getHand().add(new Card(Suit.Hearts, Rank.Two));
		andrew.getHand().add(new Card(Suit.Hearts, Rank.Five));
		andrew.getHand().add(new Card(Suit.Hearts, Rank.Eight));
		andrew.getHand().add(new Card(Suit.Hearts, Rank.Jack));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Two));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Five));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Eight));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Jack));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Ace));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Five));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Eight));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Jack));
		chris.getHand().add(new Card(Suit.Diamonds, Rank.Three));
		chris.getHand().add(new Card(Suit.Diamonds, Rank.Six));
		chris.getHand().add(new Card(Suit.Diamonds, Rank.Nine));
		chris.getHand().add(new Card(Suit.Diamonds, Rank.Queen));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Three));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Six));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Nine));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Queen));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Ace));
		chris.getHand().add(new Card(Suit.Spades, Rank.Three));
		chris.getHand().add(new Card(Suit.Spades, Rank.Six));
		chris.getHand().add(new Card(Suit.Spades, Rank.Nine));
		chris.getHand().add(new Card(Suit.Spades, Rank.Queen));
		chris.getHand().add(new Card(Suit.Clubs, Rank.Three));
		chris.getHand().add(new Card(Suit.Clubs, Rank.Six));
		chris.getHand().add(new Card(Suit.Clubs, Rank.Nine));
		chris.getHand().add(new Card(Suit.Clubs, Rank.Queen));
		john.getHand().add(new Card(Suit.Diamonds, Rank.Four));
		john.getHand().add(new Card(Suit.Diamonds, Rank.Seven));
		john.getHand().add(new Card(Suit.Diamonds, Rank.Ten));
		john.getHand().add(new Card(Suit.Diamonds, Rank.King));
		john.getHand().add(new Card(Suit.Hearts, Rank.Four));
		john.getHand().add(new Card(Suit.Hearts, Rank.Seven));
		john.getHand().add(new Card(Suit.Hearts, Rank.Ten));
		john.getHand().add(new Card(Suit.Hearts, Rank.King));
		john.getHand().add(new Card(Suit.Spades, Rank.Ace));
		john.getHand().add(new Card(Suit.Spades, Rank.Four));
		john.getHand().add(new Card(Suit.Spades, Rank.Seven));
		john.getHand().add(new Card(Suit.Spades, Rank.Ten));
		john.getHand().add(new Card(Suit.Spades, Rank.King));
		john.getHand().add(new Card(Suit.Clubs, Rank.Four));
		john.getHand().add(new Card(Suit.Clubs, Rank.Seven));
		john.getHand().add(new Card(Suit.Clubs, Rank.Ten));
		john.getHand().add(new Card(Suit.Clubs, Rank.King));
		return game;
	}
	
    /*****************************************************************
     * This method tests for the game to create the right sized deck
     * for 3 players in the game.
     *****************************************************************/
	@Test
	public void deckOf3() {
		Deck d = new Deck();
		CanadianSaladModel game = game();
		Assert.assertTrue(51 == game.makeEvenHands(3, d).getDeck()
				.size());
	}
	
    /*****************************************************************
     * This method tests for the game to create the right sized deck
     * for 4 players in the game.
     *****************************************************************/
	@Test
	public void deckOf4() {
		Deck d = new Deck();
		CanadianSaladModel game = game();
		Assert.assertTrue(52 == game.makeEvenHands(4, d).getDeck()
				.size());
	}
	
    /*****************************************************************
     * This method tests for the game to create the right sized deck
     * for 5 players in the game.
     *****************************************************************/
	@Test
	public void deckOf5() {
		Deck d = new Deck();
		CanadianSaladModel game = game();
		Assert.assertTrue(50 == game.makeEvenHands(5, d).getDeck()
				.size());
	}
	
    /*****************************************************************
     * This method tests for the game to create the right sized deck
     * for 6 players in the game.
     *****************************************************************/
	@Test
	public void deckOf6() {
		Deck d = new Deck();
		CanadianSaladModel game = game();
		Assert.assertTrue(48 == game.makeEvenHands(6, d).getDeck()
				.size());
	}
	
    /*****************************************************************
     * This method tests for the game to throw an illegal argument
     * once an invalid amount of players are added to the game.
     * 
     * @throws Exception for an illegal argument.
     *****************************************************************/
	@Test (expected = IllegalArgumentException.class)
	public void testGameNotCreated() throws Exception {
	    Player chris = new Player("Chris");
	    LinkedList<Player> players = new LinkedList<>();
	    players.push(chris); //only one player added to linked list
	    CanadianSaladModel newGame = new CanadianSaladModel(players);
	    newGame.deal();
	}


    /*****************************************************************
     * This method tests that the empty method in the deck class
     * to prove the deck is empty.
     *****************************************************************/
	@Test
	public void empty() {
		Deck test = new Deck();
		while (test.getDeck().size() > 0) {
			test.getDeck().remove(0); //removes every card
		}
		Assert.assertTrue(test.getDeck().isEmpty());
	}
	
    /*****************************************************************
     * This method tests that when the game is created, the hand 
     * number is set to 0.
     *****************************************************************/
	@Test
	public void testGetHandNumber() {
		CanadianSaladModel game = game();
		Assert.assertTrue(game.getHandNumber() == 0);
	}
	
    /*****************************************************************
     * This method tests that you can set the hand number in the 
     * model class.
     *****************************************************************/
	@Test
	public void testSetHandNumber() {
		CanadianSaladModel game = game();
		game.setHandNumber(3);
		Assert.assertTrue(game.getHandNumber() == 3);
	}

    /*****************************************************************
     * This method tests to make sure the getTaker method returns the
     * real taker.
     * 
     *****************************************************************/
	@Test
	public void testTaker() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertEquals(t.getTaker(), john);
	}

    /*****************************************************************
     * This method tests that the getTrick method returns the full
     * trick.
     *****************************************************************/
	@Test
	public void testGetTrick() {
		Player boy = new Player("boy");
		Trick t = new Trick(boy, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(t.getTrick().size() > 0);
	}


    /*****************************************************************
     * This method tests the toString method in the trick class.
     *****************************************************************/
	@Test
	public void testTrickToString() {
		Player boy = new Player("boy");
		Trick t = new Trick(boy, new Card(Suit.Clubs, Rank.Ace));
		String test = "Trick{trick=[Ace of Clubs\n], led=Ace of "
				+ "Clubs\n, losing=Ace of Clubs\n, taker=boy}";
		Assert.assertTrue(test.contentEquals(t.toString()));
	}

    /*****************************************************************
     * This method tests the toString method in the trick class.
     *****************************************************************/
	@Test
	public void testDeckToString() {
		Deck test = new Deck();
		while (test.getDeck().size() > 2) {
			test.getDeck().remove(0);
		}
		//accounts for 2 different strings to make sure the
		//order is correct
		String string = "" + test.getDeck().get(0) + test.getDeck()
		.get(1); 
		String string2 = "" + test.getDeck().get(1) + test.getDeck()
		.get(0);
		Assert.assertTrue(string.equals(test.toString()) || string2
				.equals(test.toString()));
	}

    /*****************************************************************
     * This method tests that the game deals out cards after the
     * constructor is called.
     *****************************************************************/
	@Test
	public void testDeal() {
		CanadianSaladModel game = game();
		Assert.assertFalse(game.getCurrentPlayer().getHand()
				.isEmpty());
	}

    /*****************************************************************
     * This method tests that the game is not complete after 1 turn.
     *****************************************************************/
	@Test
	public void testGameNotOver() {
		CanadianSaladModel game = game();
		game.computerPlay();
		Assert.assertFalse(game.isGameComplete());
	}

    /*****************************************************************
     * This method tests that the trick is not complete.
     *****************************************************************/
	@Test
	public void testTrickNotComplete() {
		CanadianSaladModel game = game();
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(!game.isTrickComplete());
	}
	
    /*****************************************************************
     * This method tests that the trick is not complete when its 
     * not even created yet.
     *****************************************************************/
	@Test
	public void testTrickNotCompleteNoTricks() {
		CanadianSaladModel game = game();
		Assert.assertFalse(game.isTrickComplete());
	}

    /*****************************************************************
     * This method tests that the getUserPlayer method actually
     * returns the user player.
     *****************************************************************/
	@Test
	public void testGetUser() {
		CanadianSaladModel game = game();
		Assert.assertTrue(game.getUserPlayer().equals(game.
				getPlayers().get(2)));
	}

    /*****************************************************************
     * This method tests that the getUserHand method actually
     * returns the users hand.
     *****************************************************************/
	@Test
	public void testGetUsersHand() {
		CanadianSaladModel game = game();
		Assert.assertTrue(game.getUsersHand().equals(game.getPlayers()
				.get(2).getHand()));
	}

    /*****************************************************************
     * This method tests that the isUsersTurn method correctly returns
     * true when its the users turn.
     *****************************************************************/
	@Test
	public void testIsUsersTurn() {
		CanadianSaladModel game = game();
		game.setCurrentPlayer(game.getPlayers().get(2));
		Assert.assertTrue(game.isUsersTurn());
	}

    /*****************************************************************
     * This method tests that the getSuit method correctly returns
     * a cards suit.
     *****************************************************************/
	@Test
	public void testGetSuit() {
		Card t = new Card(Suit.Hearts, Rank.Jack);
		Assert.assertTrue(t.getSuit().equals(Suit.Hearts));
	}
	
    /*****************************************************************
     * This method tests the equals method in the card class.
     *****************************************************************/
	@Test
	public void testCardsEquals() {
		Card t = new Card(Suit.Hearts, Rank.Jack);
		Card a = new Card(Suit.Hearts, Rank.Jack);
		Assert.assertTrue(t.equals(a));
	}

    /*****************************************************************
     * This method tests the toString method in the player class.
     *****************************************************************/
	@Test
	public void testPlayerToString() {
		Player chris = new Player("chris");
		chris.getHand().clear();
		chris.getHand().add(new Card(Suit.Hearts, Rank.Jack));
		String test = "Player: chris\nHand Size: 1\n1."
				+ " Jack of Hearts\n";
		Assert.assertTrue(test.equals(chris.toString()));
	}
	
    /*****************************************************************
     * This method tests that the getRank method correctly returns
     * a cards rank.
     *****************************************************************/
	@Test
	public void testGetRank() {
		Assert.assertTrue(new Card(Suit.Hearts, Rank.Nine).getRank()
				.equals(Rank.Nine));
	}

    /*****************************************************************
     * This method tests that the equals method in the card class
     * throws and error when the inputs are not the same data type.
     *****************************************************************/
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testCardNotEquals() {
		Player chris = new Player("chris");
		Assert.assertFalse(new Card(Suit.Hearts, Rank.Jack)
				.equals(chris));
	}

    /*****************************************************************
     * This method tests the setHandNumber method in practical
     * application of how the game actually would play.
     *****************************************************************/
	@Test
	public void testSetHandNumberPractically() {
		CanadianSaladModel game = game();
        game.startNewHand();
        game.startNewTrick();
		game.setHandNumber(1);
		game.computerPlay();
		game.computerPlay();
		game.computerPlay();
		game.setHandNumber(2);
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(game.getHandNumber() == 2);
	}

    /*****************************************************************
     * This method tests to make sure the third player is able to
     * follow suit.
     *****************************************************************/
	@Test
	public void testCanFollowSuit() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris); //adds 3 players to linked list
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.startNewHand();
		game.setHandNumber(1);
		game.fireStateChanged();
		game.startNewTrick();
		game.fireStateChanged();
		game.setCurrentPlayer(game.getPlayers().get(0));
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(game.canFollowSuit());
	}

    /*****************************************************************
     * This method tests that a new trick is created once the trick
     * is full.
     *****************************************************************/
	@Test
	public void testCreatesNewTrick() {
		CanadianSaladModel game = game();
		game.startNewHand();
		game.startNewTrick();
		game.setHandNumber(1);
		game.computerPlay();
		game.computerPlay();
		game.computerPlay();
		game.startNewTrick();
		game.computerPlay();
		Assert.assertTrue(game.getHands().get(0).get(1).getTrick()
				.size() == 1);
	}

    /*****************************************************************
     * This method tests that the setLoserLeads method sets the
     * current player to the loser of the last round.
     *****************************************************************/
	@Test
	public void testSetLoserLeads() {
		CanadianSaladModel game = game();
		game.startNewHand();
		game.startNewTrick();
		game.setHandNumber(1);
		game.computerPlay();
		game.computerPlay();
		game.computerPlay();
		game.setLoserLeadsNextTrick();
		Assert.assertTrue(game.getCurrentPlayer().equals(game
				.getPlayers().get(0)));
	}

    /*****************************************************************
     * This method tests that it is the first turn of the game.
     *****************************************************************/
	@Test
	public void testIsFirstTurn() {
		CanadianSaladModel game = game();
		Assert.assertTrue(game.isFirstTurn());
	}
	
    /*****************************************************************
     * This method tests when the hand is complete with 3 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandComplete3() {
		CanadianSaladModel game = game();
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		//fills up hand linked list
		while (game.getHands().size() != 6) {
			game.getHands().add(nice);
		}
		//fills up the last linked list in the last position
		while (game.getHands().getLast().size() != 17) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(game.isHandComplete());
		Assert.assertTrue(!game.isFirstTurn());
	}
	
    /*****************************************************************
     * This method tests that the remove method in the
     * deck class returns false when the data type is null.
     *****************************************************************/
	@Test
	public void testRemove() {
		Deck deck = new Deck();
		Assert.assertTrue(!deck.remove(null));
	}
	
    /*****************************************************************
     * This method tests that trickCards doesnt exist when the game
     * is first created.
     *****************************************************************/
	@Test
	public void testTrickCards() {
		CanadianSaladModel game = game();
		Assert.assertTrue(game.trickCards() == null);
	}
	
    /*****************************************************************
     * This method tests when the hand is complete with 4 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandComplete4() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		Player jim = new Player("jim");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew); //adds 4 players to linked list
		newPlayers.push(jim);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		while (game.getHands().size() != 6) {
			game.getHands().add(nice);
		}
		while (game.getHands().getLast().size() != 13) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(game.isHandComplete());
	}
	
    /*****************************************************************
     * This method tests when the hand is complete with 6 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandComplete6() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		Player jim = new Player("jim");
		Player kyle = new Player("kyle");
		Player bob = new Player("bob");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		newPlayers.push(jim);
		newPlayers.push(kyle);
		newPlayers.push(bob);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		while (game.getHands().size() != 6) {
			game.getHands().add(nice);
		}
		while (game.getHands().getLast().size() != 8) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(game.isHandComplete());
	}
	
    /*****************************************************************
     * This method tests when the hand is not complete with 3 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandComplete3No() {
		CanadianSaladModel game = game();
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		while (game.getHands().size() != 1) {
			game.getHands().add(nice);
		}
		while (game.getHands().getLast().size() != 1) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(!game.isHandComplete());
	}
	
    /*****************************************************************
     * This method tests when the hand is not complete with 4 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandCompleteNo4() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		Player jim = new Player("jim");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		newPlayers.push(jim);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		while (game.getHands().size() != 1) {
			game.getHands().add(nice);
		}
		while (game.getHands().getLast().size() != 1) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(!game.isHandComplete());
	}
	
    /*****************************************************************
     * This method tests when the hand is not complete with 6 players
     * in the game.
     *****************************************************************/
	@Test
	public void testIsHandCompleteNo6() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		Player jim = new Player("jim");
		Player kyle = new Player("kyle");
		Player bob = new Player("bob");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		newPlayers.push(jim);
		newPlayers.push(kyle);
		newPlayers.push(bob);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		LinkedList<Trick> nice = new LinkedList<>();
		Trick cool = new Trick(game.getPlayers().get(0), new 
				Card(Suit.Hearts, Rank.Nine));
		while (game.getHands().size() != 1) {
			game.getHands().add(nice);
		}
		while (game.getHands().getLast().size() != 1) {
			game.getHands().getLast().add(cool);
		}
		Assert.assertTrue(!game.isHandComplete());
	}

}
