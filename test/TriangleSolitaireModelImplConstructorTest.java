import org.junit.Assert;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

public class TriangleSolitaireModelImplConstructorTest {
  TriangleSolitaireModelImpl t1 = new TriangleSolitaireModelImpl();
  TriangleSolitaireModelImpl t2 = new TriangleSolitaireModelImpl(2,0);

  @Test
  public void testConstructor1 () {
    Assert.assertEquals(
            "      _\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O O O O",
            t1.getGameState()
    );
  }

  @Test
  public void testMove1() {
    t1.move(2,0,0,0);
    Assert.assertEquals(
            "      O\n" +
                    "     _ O\n" +
                    "    _ O O\n" +
                    "   O O O O\n" +
                    "  O O O O O",
            t1.getGameState()
    );
  }

  @Test
  public void testConstructor2() {
    System.out.println(t2.getGameState());
  }
}
