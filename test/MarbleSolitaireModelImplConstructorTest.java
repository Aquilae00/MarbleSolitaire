import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplConstructorTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl(3, 6);
  MarbleSolitaireModel m2 = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new MarbleSolitaireModelImpl(5, 3, 6);
  MarbleSolitaireModel m4 = new MarbleSolitaireModelImpl(0, 2);
  MarbleSolitaireModel m5 = new MarbleSolitaireModelImpl("Zero");


  @Test
  public void testMarbleSolitaireModelImplConstructor1() {
    assertEquals(m0.getGameState(), m0.getGameState());
    System.out.println(m0.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor2() {
    assertEquals(m1.getGameState(), m1.getGameState());
    System.out.println(m1.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor3() {
    assertEquals(m2.getGameState(), m2.getGameState());
    System.out.println(m2.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor4() {
    assertEquals(m3.getGameState(), m3.getGameState());
    System.out.println(m3.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor5() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(100, 100));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor6() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor7() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(3, 100, 100));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor8() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4, 3, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor9() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(3, 0, 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor10() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4, 3, 3));
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor11() {
    assertEquals(m4.getGameState(), m4.getGameState());
    System.out.println(m4.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor12() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(-1, 3, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor13() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(0, 0, 0));
  }

  /*
  Empty Board construction
   */
  @Test
  public void testMarbleSolitaireModelImplConstructor14() {
    assertEquals(m5, m5);
    System.out.println(m5.getGameState());
  }
}
