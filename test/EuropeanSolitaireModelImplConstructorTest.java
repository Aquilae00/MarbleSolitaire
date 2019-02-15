import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

public class EuropeanSolitaireModelImplConstructorTest {
  MarbleSolitaireModel e = new EuropeanSolitaireModelImpl(3,3,3);

  @Test
  public void testConstructor3() {

    System.out.println(    e.getGameState());
  }

}
