package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * An Output enumeration class with two static fields Quit and Over. This class is intended to be
 * states of the game when termination happens. Gives out message in the method {@link
 * MarbleSolitaireControllerImpl#outputCondition(Output, MarbleSolitaireModel)}   }
 */
public enum Output {
  Quit, Over
}
