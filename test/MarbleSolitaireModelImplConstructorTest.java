import org.junit.Test;
import static org.junit.Assert.assertEquals;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplConstructorTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl(3,6);
  MarbleSolitaireModel m2 = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new MarbleSolitaireModelImpl(3,3,6);


  @Test
  public void testMarbleSolitaireModelImplConstructor1() {
    assertEquals(m0.getGameState(),m0.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor2() {
    assertEquals(m1.getGameState(),m1.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor3() {
    assertEquals(m2.getGameState(), m2.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplConstructor4() {
    assertEquals(m3.getGameState(), m3.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor5() {
    assertEquals(new IllegalArgumentException(),new MarbleSolitaireModelImpl(100,100));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor6() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor7() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(3,100,100));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor8() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4,3,3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor9() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4,0,0));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor10() {
    assertEquals(new IllegalArgumentException(), new MarbleSolitaireModelImpl(4,3,3));
  }
}
