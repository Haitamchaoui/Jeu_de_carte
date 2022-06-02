package cardgame.view;

import cardgame.controller.GameController;

import javax.swing.*;
import java.awt.*;

public class GameSwingPassiveView implements GameViewable {

    GameController controller;
    JTextArea textArea;
    JFrame frame;

    public void createAndShowGUI() {

        // create main frame
        frame = new JFrame("Jeu de carte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // display vertically
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        addControllerCommandTracker(contentPane);

        frame.setVisible(true);
    }

    // a simple place to display what the controller is telling us
    // very similar to our command line version
    private void addControllerCommandTracker(Container contentPane) {
        textArea = new JTextArea("Statut du jeu\n", 100, 1);
        JScrollPane scrollPane = new JScrollPane(textArea);
        addCenteredComponent(scrollPane, contentPane);
        textArea.setSize(500, 500);
    }

    // all controls are added so they are centered horizontally in the area
    private void addCenteredComponent(JComponent component, Container contentPane) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(component);
    }


    private void appendText(String text) {
        textArea.append(text + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }


    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showPlayerName(int playerIndex, String playerName) {
        appendText("[" + playerIndex + "][" + playerName + "]");
    }

    @Override
    public void showCardForPlayer(int playerIndex, String playerName, String cardRank, String cardSuit) {
        appendText("[" + playerName + "][" + cardRank + ":" + cardSuit + "]");
    }

    @Override
    public void showWinner(String winnerName) {
        appendText("Gangant!\n" + winnerName);
    }

    @Override
    public void showFaceDownCardForPlayer(int playerIndex, String name) {
        appendText("[" + name + "][][]");
    }

    @Override
    public void promptForPlayerName() {
        appendText("En attente du nom de juoeur ...");
    }

    @Override
    public void promptForFlip() {
        appendText("En attente de réveler les cartes ...");
    }

    @Override
    public void promptForNewGame() {
        appendText("En attente de la prochaine étape ...");
    }

}
