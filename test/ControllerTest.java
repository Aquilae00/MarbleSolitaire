import java.io.Reader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class ControllerTest {
  @Test
  public void testPlayGame() {
StringBuffer out = new StringBuffer();
Reader in = new StringReader("4 2 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in,out);
controller.playGame(new MarbleSolitaireModelImpl());

  }
}
