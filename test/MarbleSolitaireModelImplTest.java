import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

public class MarbleSolitaireModelImplTest {
  MarbleSolitaireModelImpl m0 = new MarbleSolitaireModelImpl();

  @Test
  public void testMove() {
    System.out.println(m0.getGameState());
  }
}
