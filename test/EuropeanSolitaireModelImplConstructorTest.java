import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

public class EuropeanSolitaireModelImplConstructorTest {
  MarbleSolitaireModel m1 = new EuropeanSolitaireModelImpl();
  MarbleSolitaireModel m2 = new EuropeanSolitaireModelImpl(5);
  MarbleSolitaireModel m3 = new EuropeanSolitaireModelImpl(1, 5);
  MarbleSolitaireModel m4 = new EuropeanSolitaireModelImpl(3, 3, 3);


  @Test
  public void testConstructorEdge() {

    EuropeanSolitaireModelImpl e = new EuropeanSolitaireModelImpl(5, 1);
    e.move(5, 3, 5, 1);
    Assert.assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O _ _ O O\n" +
                    "    O O O", e.getGameState()
    );
  }

  @Test
  public void testConstructorEdge2() {

    EuropeanSolitaireModelImpl e = new EuropeanSolitaireModelImpl(1, 1);
    e.move(1, 3, 1, 1);
    Assert.assertEquals(
            "    O O O\n" +
                    "  O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", e.getGameState()
    );
  }

  @Test
  public void testConstructorEdge3() {

    EuropeanSolitaireModelImpl e = new EuropeanSolitaireModelImpl(1, 5);
    e.move(1, 3, 1, 5);
    Assert.assertEquals(
            "    O O O\n" +
                    "  O O _ _ O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", e.getGameState()
    );
  }

  @Test
  public void testConstructorEdge4() {

    EuropeanSolitaireModelImpl e = new EuropeanSolitaireModelImpl(5, 5);
    e.move(5, 3, 5, 5);
    Assert.assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O O O O O\n" +
                    "  O O _ _ O\n" +
                    "    O O O", e.getGameState()
    );
  }

  @Test
  public void testConstructor533() {

    EuropeanSolitaireModelImpl e = new EuropeanSolitaireModelImpl(5, 3, 3);
    e.move(3, 5, 3, 3);
    Assert.assertEquals(
            "        O O O O O\n" +
                    "      O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "  O O O _ _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "  O O O O O O O O O O O\n" +
                    "    O O O O O O O O O\n" +
                    "      O O O O O O O\n" +
                    "        O O O O O", e.getGameState()
    );
  }

  @Test
  public void testConstructor1() {

    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", m1.getGameState());
  }

  @Test
  public void testConstructor2() {
    Assert.assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O _ O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", m2.getGameState());
  }

  @Test
  public void testConstructor3() {
    Assert.assertEquals("    O O O\n" +
            "  O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", m3.getGameState());
  }

  @Test
  public void testConstructor4() {
    Assert.assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", m4.getGameState());
  }


}
