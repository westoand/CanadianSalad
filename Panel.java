//import javafx.geometry.VerticalDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;


public class Panel extends JPanel {

    private CanadianSaladModel model;
    private ImageIcon wRook;
    private JLabel turnLabel;
    private Listener listener;
    private JButton[] handButtons;
    private int FULL_HAND = 10;
    private HashMap<Card, ImageIcon> cardToImage;
    private JPanel handPanel;
    private JPanel scorePanel;

    private ImageIcon C2;
    private ImageIcon C3;
    private ImageIcon C4;
    private ImageIcon C5;
    private ImageIcon C6;
    private ImageIcon C7;
    private ImageIcon C8;
    private ImageIcon C9;
    private ImageIcon C10;
    private ImageIcon CJ;
    private ImageIcon CQ;
    private ImageIcon CK;
    private ImageIcon CA;
    private ImageIcon D2;
    private ImageIcon D3;
    private ImageIcon D4;
    private ImageIcon D5;
    private ImageIcon D6;
    private ImageIcon D7;
    private ImageIcon D8;
    private ImageIcon D9;
    private ImageIcon D10;
    private ImageIcon DJ;
    private ImageIcon DQ;
    private ImageIcon DK;
    private ImageIcon DA;
    private ImageIcon H2;
    private ImageIcon H3;
    private ImageIcon H4;
    private ImageIcon H5;
    private ImageIcon H6;
    private ImageIcon H7;
    private ImageIcon H8;
    private ImageIcon H9;
    private ImageIcon H10;
    private ImageIcon HJ;
    private ImageIcon HQ;
    private ImageIcon HK;
    private ImageIcon HA;
    private ImageIcon S2;
    private ImageIcon S3;
    private ImageIcon S4;
    private ImageIcon S5;
    private ImageIcon S6;
    private ImageIcon S7;
    private ImageIcon S8;
    private ImageIcon S9;
    private ImageIcon S10;
    private ImageIcon SJ;
    private ImageIcon SQ;
    private ImageIcon SK;
    private ImageIcon SA;


    public Panel(CanadianSaladModel theGame) {
        this.setLayout(new GridLayout(3,12));
        model = theGame;

        handButtons = new JButton[FULL_HAND];
        listener = new Listener();


        setupImages();
        setupMap();

        setupHandPanel(theGame.getUsersHand());
        setupScorePanel(theGame.players);

        this.add(scorePanel);
        this.add(handPanel);

    }

    private void setupHandPanel(LinkedList<Card> theHand) {
        handPanel = new JPanel();
        handPanel.setLayout(new BoxLayout(handPanel, BoxLayout.X_AXIS));
        for (int i = 0; i < theHand.size(); i++) {
            handButtons[i] = new JButton(null, cardToImage.get(theHand.get(i)));
            handButtons[i].setBackground(Color.GREEN);
            handPanel.add(handButtons[i]);
        }
    }

    private void setupScorePanel(LinkedList<Player> players) {
        scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        for(int i =0; i< players.size(); i++){
            JLabel player = new JLabel("Player " + (i+1) + ": " +players.get(i).name + " " + players.get(i).score);
            scorePanel.add(player);
        }

    }

    public void setupMap() {
        cardToImage = new HashMap<>();

        cardToImage.put(new Card(Suit.Clubs, Rank.Two), C2);
        cardToImage.put(new Card(Suit.Clubs, Rank.Three), C3);
        cardToImage.put(new Card(Suit.Clubs, Rank.Four), C4);
        cardToImage.put(new Card(Suit.Clubs, Rank.Five), C5);
        cardToImage.put(new Card(Suit.Clubs, Rank.Six), C6);
        cardToImage.put(new Card(Suit.Clubs, Rank.Seven), C7);
        cardToImage.put(new Card(Suit.Clubs, Rank.Eight), C8);
        cardToImage.put(new Card(Suit.Clubs, Rank.Nine), C9);
        cardToImage.put(new Card(Suit.Clubs, Rank.Ten), C10);
        cardToImage.put(new Card(Suit.Clubs, Rank.Jack), CJ);
        cardToImage.put(new Card(Suit.Clubs, Rank.Queen), CQ);
        cardToImage.put(new Card(Suit.Clubs, Rank.King), CK);
        cardToImage.put(new Card(Suit.Clubs, Rank.Ace), CA);

        cardToImage.put(new Card(Suit.Diamonds, Rank.Two), D2);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Three), D3);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Four), D4);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Five), D5);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Six), D6);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Seven), D7);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Eight), D8);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Nine), D9);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Ten), D10);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Jack), DJ);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Queen), DQ);
        cardToImage.put(new Card(Suit.Diamonds, Rank.King), DK);
        cardToImage.put(new Card(Suit.Diamonds, Rank.Ace), DA);

        cardToImage.put(new Card(Suit.Hearts, Rank.Two), H2);
        cardToImage.put(new Card(Suit.Hearts, Rank.Three), H3);
        cardToImage.put(new Card(Suit.Hearts, Rank.Four), H4);
        cardToImage.put(new Card(Suit.Hearts, Rank.Five), H5);
        cardToImage.put(new Card(Suit.Hearts, Rank.Six), H6);
        cardToImage.put(new Card(Suit.Hearts, Rank.Seven), H7);
        cardToImage.put(new Card(Suit.Hearts, Rank.Eight), H8);
        cardToImage.put(new Card(Suit.Hearts, Rank.Nine), H9);
        cardToImage.put(new Card(Suit.Hearts, Rank.Ten), H10);
        cardToImage.put(new Card(Suit.Hearts, Rank.Jack), HJ);
        cardToImage.put(new Card(Suit.Hearts, Rank.Queen), HQ);
        cardToImage.put(new Card(Suit.Hearts, Rank.King), HK);
        cardToImage.put(new Card(Suit.Hearts, Rank.Ace), HA);

        cardToImage.put(new Card(Suit.Spades, Rank.Two), S2);
        cardToImage.put(new Card(Suit.Spades, Rank.Three), S3);
        cardToImage.put(new Card(Suit.Spades, Rank.Four), S4);
        cardToImage.put(new Card(Suit.Spades, Rank.Five), S5);
        cardToImage.put(new Card(Suit.Spades, Rank.Six), S6);
        cardToImage.put(new Card(Suit.Spades, Rank.Seven), S7);
        cardToImage.put(new Card(Suit.Spades, Rank.Eight), S8);
        cardToImage.put(new Card(Suit.Spades, Rank.Nine), S9);
        cardToImage.put(new Card(Suit.Spades, Rank.Ten), S10);
        cardToImage.put(new Card(Suit.Spades, Rank.Jack), SJ);
        cardToImage.put(new Card(Suit.Spades, Rank.Queen), SQ);
        cardToImage.put(new Card(Suit.Spades, Rank.King), SK);
        cardToImage.put(new Card(Suit.Spades, Rank.Ace), SA);
    }
    public void setupImages() {
        C2 = new ImageIcon("cardPics\\2C.png");
        C3 = new ImageIcon("cardPics\\3C.png");
        C4 = new ImageIcon("cardPics\\4C.png");
        C5 = new ImageIcon("cardPics\\5C.png");
        C6 = new ImageIcon("cardPics\\6C.png");
        C7 = new ImageIcon("cardPics\\7C.png");
        C8 = new ImageIcon("cardPics\\8C.png");
        C9 = new ImageIcon("cardPics\\9C.png");
        C10 = new ImageIcon("cardPics\\10C.png");
        CJ = new ImageIcon("cardPics\\JC.png");
        CQ = new ImageIcon("cardPics\\QC.png");
        CK = new ImageIcon("cardPics\\KC.png");
        CA = new ImageIcon("cardPics\\AC.png");
        D2 = new ImageIcon("cardPics\\2D.png");
        D3 = new ImageIcon("cardPics\\3D.png");
        D4 = new ImageIcon("cardPics\\4D.png");
        D5 = new ImageIcon("cardPics\\5D.png");
        D6 = new ImageIcon("cardPics\\6D.png");
        D7 = new ImageIcon("cardPics\\7D.png");
        D8 = new ImageIcon("cardPics\\8D.png");
        D9 = new ImageIcon("cardPics\\9D.png");
        D10 = new ImageIcon("cardPics\\10D.png");
        DJ = new ImageIcon("cardPics\\JD.png");
        DQ = new ImageIcon("cardPics\\QD.png");
        DK = new ImageIcon("cardPics\\KD.png");
        DA = new ImageIcon("cardPics\\AD.png");
        H2 = new ImageIcon("cardPics\\2H.png");
        H3 = new ImageIcon("cardPics\\3H.png");
        H4 = new ImageIcon("cardPics\\4H.png");
        H5 = new ImageIcon("cardPics\\5H.png");
        H6 = new ImageIcon("cardPics\\6H.png");
        H7 = new ImageIcon("cardPics\\7H.png");
        H8 = new ImageIcon("cardPics\\8H.png");
        H9 = new ImageIcon("cardPics\\9H.png");
        H10 = new ImageIcon("cardPics\\10H.png");
        HJ = new ImageIcon("cardPics\\JH.png");
        HQ = new ImageIcon("cardPics\\QH.png");
        HK = new ImageIcon("cardPics\\KH.png");
        HA = new ImageIcon("cardPics\\AH.png");
        S2 = new ImageIcon("cardPics\\2S.png");
        S3 = new ImageIcon("cardPics\\3S.png");
        S4 = new ImageIcon("cardPics\\4S.png");
        S5 = new ImageIcon("cardPics\\5S.png");
        S6 = new ImageIcon("cardPics\\6S.png");
        S7 = new ImageIcon("cardPics\\7S.png");
        S8 = new ImageIcon("cardPics\\8S.png");
        S9 = new ImageIcon("cardPics\\9S.png");
        S10 = new ImageIcon("cardPics\\10S.png");
        SJ = new ImageIcon("cardPics\\JS.png");
        SQ = new ImageIcon("cardPics\\QS.png");
        SK = new ImageIcon("cardPics\\KS.png");
        SA = new ImageIcon("cardPics\\AS.png");
    }


    // inner class that represents action Listener for buttons
    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
//            if (event.getSource() == undoButton) {
//                model.undo();
//                model.setNextPlayer();
//                turnLabelHelper();
//                displayBoard();
//            }
//            if (event.getSource() == AIButton) {
//                if (AIOn) {
//                    AIOn = false;
//                    AIButton.setText("Enable AI");
//                } else {
//                    AIOn = true;
//                    AIButton.setText("Disable AI");
//                    if (model.currentPlayer() == BLACK)
//                        enableAI();
//                }
//                displayBoard();
//            }
//
//            for (int r = 0; r < model.numRows(); r++)
//                for (int c = 0; c < model.numColumns(); c++) {
//                    if (board[r][c] == event.getSource()) {
//                        if ((firstTurnFlag == true) &&
//                                (model.pieceAt(r, c) != null)) {
//                            fromRow = r;
//                            fromCol = c;
//                            firstTurnFlag = false;
//                        } else {
//                            toRow = r;
//                            toCol = c;
//                            firstTurnFlag = true;
//                            Move m = new Move
//                                    (fromRow, fromCol, toRow, toCol);
//                            if ((model.isValidMove(m))) {
//                                validMoveHelper(m);
//                            }
//                        }
//                    }
//                }

        }

    }
}