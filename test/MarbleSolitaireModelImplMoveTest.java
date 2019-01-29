import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplMoveTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl( 3,6);
  MarbleSolitaireModel m2 = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new MarbleSolitaireModelImpl(3,3,6);

//  MarbleSolitaireModel m4 = new MarbleSolitaireModelImpl(3,6);
  @Test
  public void testMarbleSolitaireModelImplMove1() {
    m0.move(5,6,3,6);
    System.out.println(m0.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplMove2() {
    m0.move(3,2,3,6);
    System.out.println(m0.getGameState());
  }
  @Test
  public void testMarbleSolitaireModelImplMove3() {
    m1.move(5,6,3,6);
    System.out.println(m1.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplMove4() {
    m2.move(6,8, 6,12);
    System.out.println(m2.getGameState());
  }

  @Test
  public void testMarbleSolitaireModelImplMove5() {
    m3.move(3,10,3,6);
    System.out.println(m3.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove6() {
    m0.move(0,0,0,0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove7() {
    m1.move(100,100,100,100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove8() {
    m2.move(3,0,100,100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove9() {
    m3.move(3,4,3,6);
  }
}
