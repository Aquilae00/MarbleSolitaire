import org.junit.Test;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplMoveTest {
  MarbleSolitaireModel m0 = new MarbleSolitaireModelImpl();
  MarbleSolitaireModel m1 = new MarbleSolitaireModelImpl(0, 2);
  MarbleSolitaireModel m2 = new MarbleSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new MarbleSolitaireModelImpl(5, 3, 6);
  MarbleSolitaireModel m4 = new MarbleSolitaireModelImpl(0, 4);
  MarbleSolitaireModel m5 = new MarbleSolitaireModelImpl(0, 2);

  /*
  Moving down from (0,4)
   */
  @Test
  public void testMarbleSolitaireModelImplMove0() {
    assertEquals(m0.getGameState(), m0.getGameState());
    m5.move(0, 4, 0, 2);
    System.out.println(m5.getGameState());
  }

  /*
  Moving up
   */
  @Test
  public void testMarbleSolitaireModelImplMove1() {
    assertEquals(m1.getGameState(), m1.getGameState());
    m0.move(3, 5, 3, 3);
    System.out.println(m0.getGameState());
  }

  /*
  Moving two times
   */
  @Test
  public void testMarbleSolitaireModelImplMove2() {
    assertEquals(m0.getGameState(), m0.getGameState());
    System.out.println(m0.getScore());
    m0.move(3, 1, 3, 3);
    System.out.println(m0.getGameState());
    System.out.println(m0.getScore());
    m0.move(3, 4, 3, 2);
    System.out.println(m0.getGameState());
    System.out.println(m0.getScore());
  }

  /*
  Moving down
   */
  @Test
  public void testMarbleSolitaireModelImplMove3() {
    assertEquals(m1.getGameState(), m1.getGameState());
    m1.move(2, 2, 0, 2);
    System.out.println(m1.getGameState());
  }

  /*
  Moving to the right
   */
  @Test
  public void testMarbleSolitaireModelImplMove4() {
    assertEquals(m2.getGameState(), m2.getGameState());
    m2.move(6, 4, 6, 6);
    System.out.println(m2.getGameState());
  }

  /*
  Moving backwards / to the left
   */
  @Test
  public void testMarbleSolitaireModelImplMove5() {
    assertEquals(m3.getGameState(), m3.getGameState());
    m3.move(3, 8, 3, 6);
    System.out.println(m3.getGameState());
  }



  /*
  Invalid positions move
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove6() {
    m0.move(0, 0, 0, 0);
  }

  /*
  Moving to and from out of bound positions
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove7() {
    m1.move(100, 100, 100, 100);
  }

  /*
  Moving to out of bound positions
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove8() {
    m2.move(3, 0, 100, 100);
  }

  /*
  Moving to 3 tiles away
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove9() {
    m3.move(3, 4, 3, 7);
  }

  /*
  Moving from initial (0,2) position
   */
  @Test
  public void testMarbleSolitaireModelImplConstructor12() {
    assertEquals(m4.getGameState(), m4.getGameState());
    System.out.println(m4.getGameState());
    m4.move(0, 2, 0, 4);
    System.out.println(m4.getGameState());
  }

  /*
  Moving to negative row
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor13() {
    System.out.println(m4.getGameState());
    m4.move(0, 2, -1, 4);
    System.out.println(m4.getGameState());
  }

  /*
  Moving from out of bound row
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplConstructor14() {
    m4.move(7, 2, 0, 4);
    System.out.println(m4.getGameState());
  }

  /*
  Diagonal Move
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMarbleSolitaireModelImplMove() {
    m0.move(2, 2, 3, 3);
  }
}
