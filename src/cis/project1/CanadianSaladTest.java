package cis.project1;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import org.junit.Assert;


public class CanadianSaladTest {

	@Test
	public void deckOf4() {
		Deck four = new Deck(4);
		Assert.assertEquals(52, four.getDeck().size());
	}

	@Test
	public void deckOf3() {
		Deck three = new Deck(3);
		Assert.assertEquals(51, three.getDeck().size());
	}

	@Test
	public void deckOf5() {
		Deck five = new Deck(5);
		Assert.assertEquals(50, five.getDeck().size());
	}

	@Test
	public void deckOf6() {
		Deck six = new Deck(6);
		Assert.assertEquals(48, six.getDeck().size());
	}

	@Test
	public void testDeckCreation() {
		Deck test = new Deck(4);
		Assert.assertTrue(test.getDeck() instanceof LinkedList);
	}

	@Test
	public void empty() {
		Deck test = new Deck(4);
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Two));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Three));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Four));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Five));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Six));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.King));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Two));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Three));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Four));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Five));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Six));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.King));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Two));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Three));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Four));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Five));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Six));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Spades, Rank.King));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Two));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Three));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Four));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Five));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Six));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.King));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(test.getDeck().isEmpty());
	}

	@Test
	public void testTaker() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertEquals(t.getTaker(), john);
	}

	@Test
	public void testAddAndConstructor() {
		Player boy = new Player("boy");
		Trick t = new Trick(boy, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(t.getTrick().size() > 0);
	}

	@Test
	public void testTrickGetter() {
		Player boy = new Player("boy");
		Trick t = new Trick(boy, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(t.getTrick() instanceof LinkedList<?>);
	}

	@Test
	public void testTrickToString() {
		Player boy = new Player("boy");
		Trick t = new Trick(boy, new Card(Suit.Clubs, Rank.Ace));
		String test = "Trick{trick=[Ace of Clubs\n], led=Ace of Clubs\n, losing=Ace of Clubs\n, taker=boy}";
		Assert.assertTrue(test.contentEquals(t.toString()));
	}

	@Test
	public void testDeckToString() {
		Deck test = new Deck(4);
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Two));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Three));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Four));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Five));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Six));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.King));
		test.getDeck().remove(new Card(Suit.Diamonds, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Two));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Three));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Four));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Five));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Six));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.King));
		test.getDeck().remove(new Card(Suit.Hearts, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Two));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Three));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Four));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Five));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Six));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Queen));
		test.getDeck().remove(new Card(Suit.Spades, Rank.King));
		test.getDeck().remove(new Card(Suit.Spades, Rank.Ace));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Two));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Three));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Four));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Five));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Six));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Seven));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Eight));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Nine));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Ten));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Jack));
		test.getDeck().remove(new Card(Suit.Clubs, Rank.Queen));
		String string = "Ace of Clubs\nKing of Clubs\n";
		String string2 = "King of Clubs\nAce of Clubs\n";
		Assert.assertTrue(string.equals(test.toString()) || string2.equals(test.toString()));
	}

	@Test
	public void testDeal() {
		Player chris = new Player("chris");
		Player john = new Player("john");
		Player andrew = new Player("andrew");
		LinkedList<Player> roster = new LinkedList<>();
		roster.add(chris);
		roster.add(john);
		roster.add(andrew);
		CanadianSaladModel game = new CanadianSaladModel(roster);
		game.deal();
		Assert.assertFalse(chris.getHand().isEmpty());
	}

	@Test
	public void testTrickAdd() {
		Player chris = new Player("chris");
		Trick trick = new Trick(chris, new Card(Suit.Clubs, Rank.Queen));
		trick.add(new Card(Suit.Clubs, Rank.Jack), chris);
		Assert.assertTrue(trick.getTrick().size() == 2);
	}

	@Test
	public void testGameOver() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		john.getHand().clear();
		chris.getHand().clear();
		andrew.getHand().clear();
		Assert.assertTrue(game.isGameComplete());
	}

	@Test
	public void testGameNotOver() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		john.getHand().clear();
		chris.getHand().clear();
		Assert.assertFalse(game.isGameComplete());
	}

	@Test
	public void testTrickComplete() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.computerPlay();
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(game.isTrickComplete());
	}

	@Test
	public void testTrickNotComplete() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.getTricks().add(0, new Trick(john, new Card(Suit.Clubs, Rank.Queen)));
		game.getTricks().add(1, new Trick(chris, new Card(Suit.Clubs, Rank.King)));
		Assert.assertFalse(game.isTrickComplete());
	}

	@Test
	public void testIsFirstTurn() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		Assert.assertTrue(game.isFirstTurn());
	}

	@Test
	public void testGetThrowOffSuit() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		andrew.getHand().clear();
		andrew.getHand().add(new Card(Suit.Spades, Rank.Jack));
		game.setCurrentPlayer(andrew);
		Assert.assertTrue(game.getThrowOffSuit().equals(new Card(Suit.Spades, Rank.Jack)));
	}

	@Test
	public void testGetUser() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		Assert.assertTrue(game.getUserPlayer().equals(john));
	}

	@Test
	public void testGetUsersHand() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		Assert.assertTrue(game.getUsersHand().equals(john.getHand()));
	}

	@Test
	public void testScorehandNoTricks() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		andrew.getHand().clear();
		john.getHand().clear();
		chris.getHand().add(new Card(Suit.Spades, Rank.Jack));
		john.getHand().add(new Card(Suit.Spades, Rank.King));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Queen));
		game.computerPlay();
		game.computerPlay();
		game.playCard(new Card(Suit.Spades, Rank.King));
		game.scoreHandNoTricks();
		Assert.assertTrue(game.getCurrentTrick().getTaker().getScore() == 10);
	}

	@Test
	public void testPlayCardFirst() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.setCurrentPlayer(chris);
		chris.getHand().remove(0);
		chris.getHand().add(new Card(Suit.Spades, Rank.Jack));
		game.playCard(new Card(Suit.Spades, Rank.Jack));
		Assert.assertTrue(chris.getHand().size() < andrew.getHand().size());
	}

	@Test
	public void testCanFollowSuit() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.setCurrentPlayer(andrew);
		john.getHand().clear();
		john.getHand().add(new Card(Suit.Clubs, Rank.Queen));
		chris.getHand().add(new Card(Suit.Clubs, Rank.King));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Jack));
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(game.canFollowSuit());
	}

	@Test
	public void testCreatesNewTrick() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.setCurrentPlayer(john);
		john.getHand().clear();
		john.getHand().add(new Card(Suit.Clubs, Rank.Queen));
		john.getHand().add(new Card(Suit.Clubs, Rank.King));
		game.playCard(new Card(Suit.Clubs, Rank.Queen));
		game.computerPlay();
		game.computerPlay();
		game.playCard(new Card(Suit.Clubs, Rank.King));
		Assert.assertTrue(game.trickCards().size() == 1);
	}

	@Test
	public void testIsUsersTurn() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.setCurrentPlayer(john);
		Assert.assertTrue(game.isUsersTurn());
	}

	@Test
	public void testcomputerPlayNoTrick() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		john.getHand().clear();
		andrew.getHand().clear();
		chris.getHand().add(new Card(Suit.Clubs, Rank.Queen));
		john.getHand().add(new Card(Suit.Clubs, Rank.King));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Jack));
		game.setCurrentPlayer(andrew);
		game.computerPlay();
		Assert.assertTrue(game.getTricks().size() == 1);
	}

	@Test
	public void testUserPlayCard() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		john.getHand().clear();
		andrew.getHand().clear();
		chris.getHand().add(new Card(Suit.Clubs, Rank.Queen));
		john.getHand().add(new Card(Suit.Clubs, Rank.King));
		andrew.getHand().add(new Card(Suit.Clubs, Rank.Jack));
		chris.getHand().add(new Card(Suit.Hearts, Rank.Queen));
		john.getHand().add(new Card(Suit.Hearts, Rank.King));
		andrew.getHand().add(new Card(Suit.Hearts, Rank.Jack));
		game.setCurrentPlayer(chris);
		game.playCard(chris.getHand().get(0));
		game.setCurrentPlayer(john);
		game.playCard(john.getHand().get(0));
		game.setCurrentPlayer(andrew);
		game.playCard(andrew.getHand().get(0));
		game.setCurrentPlayer(game.getUserPlayer());
		game.playCard(game.getUserPlayer().getHand().get(0));
		Assert.assertTrue(game.getTricks().size() == 2);
	}

	@Test
	public void testSetLoserLeads() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		andrew.getHand().clear();
		john.getHand().clear();
		chris.getHand().add(new Card(Suit.Spades, Rank.Jack));
		john.getHand().add(new Card(Suit.Spades, Rank.King));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Queen));
		game.computerPlay();
		game.computerPlay();
		game.playCard(new Card(Suit.Spades, Rank.King));
		game.setLoserLeadsNextTrick();
	}

	@Test
	public void testNextTurn() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.add(john);
		newPlayers.add(chris);
		newPlayers.add(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.nextTurn();
		Assert.assertTrue(game.trickCards().size() == 1);
	}

	@Test
	public void testNotNextTurn() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.setCurrentPlayer(game.getUserPlayer());
		game.nextTurn();
		Assert.assertTrue(game.getTricks().size() == 0);
	}

	@Test
	public void testNextTurnGameComplete() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		john.getHand().clear();
		andrew.getHand().clear();
		game.nextTurn();
		Assert.assertTrue(game.getTricks().size() == 0);
	}

	@Test
	public void testcomputerPlayPlayCardTrickComplete() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.playCard(andrew.getHand().get(0));
		game.playCard(chris.getHand().get(0));
		game.playCard(john.getHand().get(0));
		game.computerPlay();
		Assert.assertTrue(game.getTricks().size() == 2);
	}

	@Test
	public void testcomputerPlayThrowOffSuit() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		chris.getHand().clear();
		andrew.getHand().clear();
		john.getHand().clear();
		chris.getHand().add(new Card(Suit.Hearts, Rank.Jack));
		john.getHand().add(new Card(Suit.Spades, Rank.King));
		andrew.getHand().add(new Card(Suit.Spades, Rank.Queen));
		game.computerPlay();
		game.computerPlay();
		Assert.assertTrue(game.trickCards().get(0).getSuit() != game.trickCards().get(1).getSuit());
	}
	
	@Test
	public void testGetStarter() {
		Player john = new Player("john");
		Player chris = new Player("chris");
		Player andrew = new Player("andrew");
		LinkedList<Player> newPlayers = new LinkedList<>();
		newPlayers.push(john);
		newPlayers.push(chris);
		newPlayers.push(andrew);
		CanadianSaladModel game = new CanadianSaladModel(newPlayers);
		game.computerPlay();
		Assert.assertTrue(game.getCurrentTrick().getStarter().equals(andrew));
	}

	@Test
	public void testPlayerToString() {
		Player chris = new Player("chris");
		chris.getHand().clear();
		chris.getHand().add(new Card(Suit.Hearts, Rank.Jack));
		String test = "Player: chris\ngetHand() Size: 1\n1. Jack of Hearts\n";
		Assert.assertTrue(test.equals(chris.toString()));
	}

	@Test
	public void testPlayerScore() {
		Player chris = new Player("chris");
		chris.setScore(25);
		String test = "chris's score is: 25";
		//Assert.assertTrue(test.equals(chris.printScore()));
	}
	
	@Test
	public void testGetRank() {
		Assert.assertTrue(new Card(Suit.Hearts, Rank.Nine).getRank().equals(Rank.Nine));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testCardNotEquals() {
		Player chris = new Player("chris");
		Assert.assertFalse(new Card(Suit.Hearts, Rank.Jack).equals(chris));
	}
}

