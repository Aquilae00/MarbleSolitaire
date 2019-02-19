package cs3500.marblesolitaire;

import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

public final class MarbleSolitaire {
  public static void main(String[] args) {
      new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out).playGame(new TriangleSolitaireModelImpl());
  }
}