import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelGetScoreTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m2 = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new MarbleSolitaireModelImpl("Zero");

  @Test
  public void testGetScore1() {
    assertEquals(32, m0.getScore());
  }

  @Test
  public void testGetScore2() {
    assertEquals(32, m0.getScore());
    m0.move(3, 1, 3, 3);
    assertEquals(31, m0.getScore());
    m0.move(3, 4, 3, 2);
    assertEquals(30, m0.getScore());
  }

  @Test
  public void testGetScore3() {
    assertEquals(104, m2.getScore());
  }

  /*
  Get score of empty board
   */
  @Test
  public void testGetScore4() {
    assertEquals(0, m3.getScore());
  }
}
