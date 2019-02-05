package cs3500.marblesolitaire.controller;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

public interface MarbleSolitaireController {
  /**
   *
   */
  void playGame(MarbleSolitaireModel model) throws IOException;
}
