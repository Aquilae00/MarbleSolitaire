import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplIsGameOverTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl("Zero");

  @Test
  public void MarbleSolitaireModelImplIsGameOverTest1() {
    assertEquals(false, m0.isGameOver());
  }

  @Test
  public void MarbleSolitaireModelImplIsGameOverTest2() {
    assertEquals(true, m1.isGameOver());
  }
}
