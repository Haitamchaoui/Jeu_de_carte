package cardgame;

import cardgame.controller.GameController;
import cardgame.model.Deck;
import cardgame.view.GameSwingPassiveView;
import cardgame.view.GameSwingView;
import cardgame.view.GameViewables;
import cardgame.view.View;
import games.HighCardGameEvaluator;

public class Games {
    public static void main(String args[]) {
        GameViewables views = new GameViewables();

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        views.addViewable(gsv);

        for(int i = 0; i< 3; i++) {
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            passiveView.createAndShowGUI();

            views.addViewable(passiveView);

            // sleep to move new Swing frame on window
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        GameController gc = new GameController(DeckFactory.makeDeck(DeckFactory.DeckType.Normal), views, new HighCardGameEvaluator());

        gc.run();
    }
}
