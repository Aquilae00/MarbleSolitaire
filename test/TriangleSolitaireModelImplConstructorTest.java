import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

public class TriangleSolitaireModelImplConstructorTest {
  TriangleSolitaireModelImpl t1 = new TriangleSolitaireModelImpl();
  TriangleSolitaireModelImpl t2 = new TriangleSolitaireModelImpl(2, 0);
  TriangleSolitaireModelImpl t3 = new TriangleSolitaireModelImpl(7);
  TriangleSolitaireModelImpl t4 = new TriangleSolitaireModelImpl(5, 2, 1);

  @Test
  public void testConstructor1() {
    Assert.assertEquals(
            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t1.getGameState()
    );
    System.out.println(t1.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorInvalidPosition() {
    TriangleSolitaireModelImpl t = new TriangleSolitaireModelImpl(3, 3, 3);
  }

  @Test
  public void testConstructor2() {
    Assert.assertEquals(
            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t2.getGameState()
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2InvalidPosns() {
    Assert.assertEquals(
            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            new TriangleSolitaireModelImpl(0, 1).getGameState()
    );
  }

  @Test
  public void testConstructor3() {
    Assert.assertEquals(
            "      _\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            t3.getGameState()
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3InvalidDimension() {
    Assert.assertEquals(
            "      _\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O",
            new TriangleSolitaireModelImpl(-1).getGameState()
    );
  }

  @Test
  public void testConstructor4() {
    Assert.assertEquals(
            "    O\n" +
                    "   O O\n" +
                    "  O _ O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t4.getGameState()
    );
  }

  @Test
  public void testMoveUpSameRow() {
    t1.move(2, 0, 0, 0);
    Assert.assertEquals(
            "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t1.getGameState()
    );
  }

  @Test
  public void testMoveUpDifferentRow() {
    t1.move(2, 2, 0, 0);
    Assert.assertEquals(
            "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O",
            t1.getGameState()
    );
  }

  @Test
  public void testMoveDown() {
    TriangleSolitaireModelImpl t = new TriangleSolitaireModelImpl(3, 1);
    t.move(1, 1, 3, 1);
    Assert.assertEquals(
            "    O\n" +
                    "   O _\n" +
                    "  O _ O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t.getGameState()
    );
  }

  @Test
  public void testMoveUp() {
    TriangleSolitaireModelImpl t = new TriangleSolitaireModelImpl(2, 1);
    t.move(4, 1, 2, 1);
    Assert.assertEquals(
            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O _ O O\n" +
                    "O _ O O O",
            t.getGameState()
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBound() {
    t1.move(2, 0, 100, 100);
    Assert.assertEquals(
            "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t1.getGameState()
    );

    t1.move(2, 0, -100, -100);
    Assert.assertEquals(
            "    O\n" +
                    "   _ O\n" +
                    "  _ O O\n" +
                    " O O O O\n" +
                    "O O O O O",
            t1.getGameState()
    );
  }
}
