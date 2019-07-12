import org.junit.Test;

import java.util.LinkedList;

//import java.util.*;
//import java.security.KeyPair;
//import javax.swing.*;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;

public class testCases {
	
	@Test
	public void cardRank() {
		
		for(Rank rank1 : Rank.values()) {
			Card testCard = new Card(Suit.Diamonds, rank1);
			for(Rank rank2 : Rank.values()) {
				int result = testCard.compareTo(new Card(Suit.Diamonds,rank2));
				if(result < 0 && testCard.getMap().get(rank1) >= testCard.getMap().get(rank2))
					Assert.assertTrue(false);
				if(result > 0 && testCard.getMap().get(rank1) <= testCard.getMap().get(rank2)) 
					Assert.assertTrue(false);
			}
		}
		Assert.assertTrue(true);
	}
	
	@Test
	public void deckOf4() {
		Deck four = new Deck(4);
		Assert.assertEquals(52, four.deck.size());
	}
	
	@Test
	public void deckOf3() {
		Deck three = new Deck(3);
		Assert.assertEquals(51, three.deck.size());
	}
	
	@Test
	public void deckOf5() {
		Deck five = new Deck(5);
		Assert.assertEquals(50, five.deck.size());
	}
	
	@Test
	public void deckOf6() {
		Deck six = new Deck(6);
		Assert.assertEquals(48, six.deck.size());
	}
	
	@Test
	public void testDeckCreation() {
		Deck test = new Deck(4);
		Assert.assertTrue(test.deck instanceof LinkedList);
	}
	
	@Test
	public void empty() {
		Deck test = new Deck(4);
        test.deck.remove(new Card(Suit.Diamonds, Rank.Two));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Three));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Four));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Five));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Six));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Seven));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Eight));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Nine));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Ten));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Jack));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Queen));
        test.deck.remove(new Card(Suit.Diamonds, Rank.King));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Ace));
        test.deck.remove(new Card(Suit.Hearts, Rank.Two));
        test.deck.remove(new Card(Suit.Hearts, Rank.Three));
        test.deck.remove(new Card(Suit.Hearts, Rank.Four));
        test.deck.remove(new Card(Suit.Hearts, Rank.Five));
        test.deck.remove(new Card(Suit.Hearts, Rank.Six));
        test.deck.remove(new Card(Suit.Hearts, Rank.Seven));
        test.deck.remove(new Card(Suit.Hearts, Rank.Eight));
        test.deck.remove(new Card(Suit.Hearts, Rank.Nine));
        test.deck.remove(new Card(Suit.Hearts, Rank.Ten));
        test.deck.remove(new Card(Suit.Hearts, Rank.Jack));
        test.deck.remove(new Card(Suit.Hearts, Rank.Queen));
        test.deck.remove(new Card(Suit.Hearts, Rank.King));
        test.deck.remove(new Card(Suit.Hearts, Rank.Ace));
        test.deck.remove(new Card(Suit.Spades, Rank.Two));
        test.deck.remove(new Card(Suit.Spades, Rank.Three));
        test.deck.remove(new Card(Suit.Spades, Rank.Four));
        test.deck.remove(new Card(Suit.Spades, Rank.Five));
        test.deck.remove(new Card(Suit.Spades, Rank.Six));
        test.deck.remove(new Card(Suit.Spades, Rank.Seven));
        test.deck.remove(new Card(Suit.Spades, Rank.Eight));
        test.deck.remove(new Card(Suit.Spades, Rank.Nine));
        test.deck.remove(new Card(Suit.Spades, Rank.Ten));
        test.deck.remove(new Card(Suit.Spades, Rank.Jack));
        test.deck.remove(new Card(Suit.Spades, Rank.Queen));
        test.deck.remove(new Card(Suit.Spades, Rank.King));
        test.deck.remove(new Card(Suit.Spades, Rank.Ace));
        test.deck.remove(new Card(Suit.Clubs, Rank.Two));
        test.deck.remove(new Card(Suit.Clubs, Rank.Three));
        test.deck.remove(new Card(Suit.Clubs, Rank.Four));
        test.deck.remove(new Card(Suit.Clubs, Rank.Five));
        test.deck.remove(new Card(Suit.Clubs, Rank.Six));
        test.deck.remove(new Card(Suit.Clubs, Rank.Seven));
        test.deck.remove(new Card(Suit.Clubs, Rank.Eight));
        test.deck.remove(new Card(Suit.Clubs, Rank.Nine));
        test.deck.remove(new Card(Suit.Clubs, Rank.Ten));
        test.deck.remove(new Card(Suit.Clubs, Rank.Jack));
        test.deck.remove(new Card(Suit.Clubs, Rank.Queen));
        test.deck.remove(new Card(Suit.Clubs, Rank.King));
        test.deck.remove(new Card(Suit.Clubs, Rank.Ace));
        Assert.assertTrue(test.deck.isEmpty());
	}
	
	LinkedList newPlayers = new LinkedList<Player>();
	
	public void setUpGame() {
		Deck newDeck = new Deck(4);
		Player chris = new Player("chris");
		Player john = new Player("john");		
		Player ben = new Player("ben");
		Player andrew = new Player("andrew");
		newPlayers.add(chris);
		chris.hand.push(new Card(Suit.Diamonds, Rank.Two));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Three));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Four));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Five));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Six));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Seven));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Eight));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Nine));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Ten));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Jack));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Queen));
		chris.hand.push(new Card(Suit.Diamonds, Rank.King));
		chris.hand.push(new Card(Suit.Diamonds, Rank.Ace));
		newPlayers.add(john);
		john.hand.push(new Card(Suit.Hearts, Rank.Two));
		john.hand.push(new Card(Suit.Hearts, Rank.Three));
		john.hand.push(new Card(Suit.Hearts, Rank.Four));
		john.hand.push(new Card(Suit.Hearts, Rank.Five));
		john.hand.push(new Card(Suit.Hearts, Rank.Six));
		john.hand.push(new Card(Suit.Hearts, Rank.Seven));
		john.hand.push(new Card(Suit.Hearts, Rank.Eight));
		john.hand.push(new Card(Suit.Hearts, Rank.Nine));
		john.hand.push(new Card(Suit.Hearts, Rank.Ten));
		john.hand.push(new Card(Suit.Hearts, Rank.Jack));
		john.hand.push(new Card(Suit.Hearts, Rank.Queen));
		john.hand.push(new Card(Suit.Hearts, Rank.King));
		john.hand.push(new Card(Suit.Hearts, Rank.Ace));
		newPlayers.add(ben);
        ben.hand.push(new Card(Suit.Spades, Rank.Two));
        ben.hand.push(new Card(Suit.Spades, Rank.Three));
        ben.hand.push(new Card(Suit.Spades, Rank.Four));
        ben.hand.push(new Card(Suit.Spades, Rank.Five));
        ben.hand.push(new Card(Suit.Spades, Rank.Six));
        ben.hand.push(new Card(Suit.Spades, Rank.Seven));
        ben.hand.push(new Card(Suit.Spades, Rank.Eight));
        ben.hand.push(new Card(Suit.Spades, Rank.Nine));
        ben.hand.push(new Card(Suit.Spades, Rank.Ten));
        ben.hand.push(new Card(Suit.Spades, Rank.Jack));
        ben.hand.push(new Card(Suit.Spades, Rank.Queen));
        ben.hand.push(new Card(Suit.Spades, Rank.King));
        ben.hand.push(new Card(Suit.Spades, Rank.Ace));
		newPlayers.add(andrew);
        andrew.hand.push(new Card(Suit.Clubs, Rank.Two));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Three));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Four));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Five));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Six));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Seven));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Eight));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Nine));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Ten));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Jack));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Queen));
        andrew.hand.push(new Card(Suit.Clubs, Rank.King));
        andrew.hand.push(new Card(Suit.Clubs, Rank.Ace));
		
	}
	
//	@Test
//	public void testCanFollow() {
//		Player one = new Player("one");
//		Player two = new Player("two");		
//		LinkedList players = new LinkedList<Player>();
//		players.add(one);
//		players.add(two);
//		CanadianSaladModel game = new CanadianSaladModel(players);
//		game.playHand();
//		one.emptyHand();
//		two.emptyHand();
//		one.hand.push(new Card(Suit.Clubs, Rank.Ace));
//		two.hand.push(new Card(Suit.Clubs, Rank.King));
//		Assert.assertTrue(game.canFollowSuit() == true);
//	}
	
	@Test
	public void testTaker() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertEquals(t.getTaker(), john);
	}
	
	@Test
	public void testAddAndConstructor() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(t.getTrickList().size() > 0);
	}
	
	@Test
	public void testTrickGetter() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		Assert.assertTrue(t.getTrickList() instanceof LinkedList<?>);
	}
	
	@Test
	public void testTrickToString() {
		Player john = new Player("john");
		Trick t = new Trick(john, new Card(Suit.Clubs, Rank.Ace));
		String test = "Trick{trick=[Ace of Clubs\n], led=Ace of Clubs\n, losing=Ace of Clubs\n, taker=john}";
		Assert.assertTrue(test.contentEquals(t.toString()));
	}
	
	@Test
	public void testDeckToString() {
		Deck test = new Deck(4);
        test.deck.remove(new Card(Suit.Diamonds, Rank.Two));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Three));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Four));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Five));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Six));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Seven));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Eight));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Nine));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Ten));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Jack));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Queen));
        test.deck.remove(new Card(Suit.Diamonds, Rank.King));
        test.deck.remove(new Card(Suit.Diamonds, Rank.Ace));
        test.deck.remove(new Card(Suit.Hearts, Rank.Two));
        test.deck.remove(new Card(Suit.Hearts, Rank.Three));
        test.deck.remove(new Card(Suit.Hearts, Rank.Four));
        test.deck.remove(new Card(Suit.Hearts, Rank.Five));
        test.deck.remove(new Card(Suit.Hearts, Rank.Six));
        test.deck.remove(new Card(Suit.Hearts, Rank.Seven));
        test.deck.remove(new Card(Suit.Hearts, Rank.Eight));
        test.deck.remove(new Card(Suit.Hearts, Rank.Nine));
        test.deck.remove(new Card(Suit.Hearts, Rank.Ten));
        test.deck.remove(new Card(Suit.Hearts, Rank.Jack));
        test.deck.remove(new Card(Suit.Hearts, Rank.Queen));
        test.deck.remove(new Card(Suit.Hearts, Rank.King));
        test.deck.remove(new Card(Suit.Hearts, Rank.Ace));
        test.deck.remove(new Card(Suit.Spades, Rank.Two));
        test.deck.remove(new Card(Suit.Spades, Rank.Three));
        test.deck.remove(new Card(Suit.Spades, Rank.Four));
        test.deck.remove(new Card(Suit.Spades, Rank.Five));
        test.deck.remove(new Card(Suit.Spades, Rank.Six));
        test.deck.remove(new Card(Suit.Spades, Rank.Seven));
        test.deck.remove(new Card(Suit.Spades, Rank.Eight));
        test.deck.remove(new Card(Suit.Spades, Rank.Nine));
        test.deck.remove(new Card(Suit.Spades, Rank.Ten));
        test.deck.remove(new Card(Suit.Spades, Rank.Jack));
        test.deck.remove(new Card(Suit.Spades, Rank.Queen));
        test.deck.remove(new Card(Suit.Spades, Rank.King));
        test.deck.remove(new Card(Suit.Spades, Rank.Ace));
        test.deck.remove(new Card(Suit.Clubs, Rank.Two));
        test.deck.remove(new Card(Suit.Clubs, Rank.Three));
        test.deck.remove(new Card(Suit.Clubs, Rank.Four));
        test.deck.remove(new Card(Suit.Clubs, Rank.Five));
        test.deck.remove(new Card(Suit.Clubs, Rank.Six));
        test.deck.remove(new Card(Suit.Clubs, Rank.Seven));
        test.deck.remove(new Card(Suit.Clubs, Rank.Eight));
        test.deck.remove(new Card(Suit.Clubs, Rank.Nine));
        test.deck.remove(new Card(Suit.Clubs, Rank.Ten));
        test.deck.remove(new Card(Suit.Clubs, Rank.Jack));
        test.deck.remove(new Card(Suit.Clubs, Rank.Queen));
        String string = "Ace of Clubs\nKing of Clubs\n";
        String string2 = "King of Clubs\nAce of Clubs\n";
        Assert.assertTrue(string.equals(test.toString()) || string2.equals(test.toString()));
	}
	
	@Test
	public void testDeal() {
		Player chris = new Player("chris");
		Player john = new Player("john");		
		Player ben = new Player("ben");
		Player andrew = new Player("andrew");
		LinkedList roster = new LinkedList<Player>();
		roster.add(chris);
		roster.add(john);
		roster.add(ben);
		roster.add(andrew);
		CanadianSaladModel game = new CanadianSaladModel(roster);
		Assert.assertFalse(chris.hand.isEmpty());
	}
	
	@Test
	public void testTrickAdd() {
		Player chris = new Player("chris");
		Trick trick = new Trick(chris, new Card(Suit.Clubs, Rank.Queen));
		trick.add(new Card(Suit.Clubs, Rank.Jack), chris);
		Assert.assertTrue(trick.getTrickList().size() == 2);
	}
	
	@Test
	public void testThrowOff() {
		Player chris = new Player("chris");
	}
	
	@Test
	public void testEmptyDeck() {
		Deck deck = new Deck(4);
		deck.emptyDeck();
		Assert.assertTrue(deck.size() == 0);
		
	}
//	@Test
//	public void testModel() {
//		CanadianSaladModel model = new CanadianSaladModel()
//	}
//	
//	@Test
//	public void checksLastCard() {
//		Deck four = new Deck(4);
//		Card top = four.add();
//		Card expect = new Card(Suit.Clubs, Rank.Ace);
//		System.out.println("top: " + top);
//		System.out.println("expect: " + expect);
//		Assert.assertTrue(top.equals(expect));
//	}
//	
}

