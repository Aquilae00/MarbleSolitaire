import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

public class EuropeanSolitaireModelImplConstructorTest {
  MarbleSolitaireModel m1 = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel m2 = new EuropeanSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new EuropeanSolitaireModelImpl(1,5);
  MarbleSolitaireModel m4 = new EuropeanSolitaireModelImpl(3,3,3);

  @Test
  public void testConstructor3() {

    System.out.println(    m3.getGameState());
  }

  @Test
  public void testConstructor2() {

    System.out.println(    m2.getGameState());
  }

  @Test
  public void testConstructor1() {

    System.out.println(    m1.getGameState());
  }

}
