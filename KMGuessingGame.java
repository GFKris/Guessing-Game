// Author: Kris McFarland
// This program is a guessing game
// The user is able to play the game as many times as they want
// Game stats are shown at the end of game

import java.util.*;

public class KMGuessingGame {
   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      Random randNumber = new Random();
      
      int guessMax = 100;  // random number range maximum
      int gamesPlayed = 1;
      int totalGuesses = 0;
      int fewestGuesses = 0;
      
      gameIntro(guessMax);  
      boolean runGame = true; 
      while (runGame) { // set the while loop to true
         int winNumber = randNumber.nextInt(guessMax);
         int guesses = gamePlay(userInput, winNumber);
         totalGuesses += guesses;
         if (fewestGuesses == 0 || guesses < fewestGuesses) { // set the best game
            fewestGuesses = guesses;  
         }
         System.out.println("Do you want to play again?");
         String playAgain = userInput.next();         
         playAgain = playAgain.toLowerCase();
         if (playAgain.startsWith("n")) {
            runGame = false; // set the while loop to false
         } else if (playAgain.startsWith("y")) {
            gamesPlayed++; // the game only needs to be incremented when player decides to play again
         } else {
            System.out.println("Invalid Response");
         }               
      }
      System.out.println("Overall Results:");
      gameStats(gamesPlayed, totalGuesses, fewestGuesses);     
          
   } // end of Main
   
   public static void gameIntro(int maxNumber) {
      System.out.println("Welcome to the guessing game");
      System.out.println("I will choose a number between 1 and " + maxNumber + ".");
      System.out.println("Every time you guess I will tell you");
      System.out.println("If the number is higher or lower.");
      System.out.println("Lets see how many guesses it takes.");
      System.out.println("for you to get the right answer! \n");
   }
   
   public static int gamePlay(Scanner userInput, int winNumber) {
        int tries = 0;
        int guess = 0;    
         while (winNumber != guess) {
         System.out.print("Your guess?");
          guess = userInput.nextInt();
            if (guess > winNumber) {
                System.out.println("it's lower");
             } else if (guess < winNumber) {
               System.out.println("it's higer");    
             } else {}
            tries++;
         }          
      System.out.println("You got it right in " + tries + " tries");   
      return tries;
   }
   
   public static void gameStats(int games, int guessTotal, int bestGame) {
      double avg = guessTotal / games;  
      System.out.println("total games: " + games);
      System.out.println("total guesses: " + guessTotal);
      System.out.printf("avg guesses a game: %.1f \n", avg);
      System.out.println("best game: " + bestGame);   
   }
} // end of class