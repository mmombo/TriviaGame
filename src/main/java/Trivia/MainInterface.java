package Trivia;

import java.util.List;
import java.util.Scanner;


public class MainInterface {


    public static void main(String[] args) {


        TriviaSource trivia = new TriviaSource();
        Questions questionsObject = new Questions();

        System.out.println("\n\nWelcome to Matt's Trivia Game!");
        System.out.println("What Category would you like to try?");
        System.out.println("1. Science and Nature \n2. General Knowledge\n3. Mythology");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 1 || input > 3) {
            System.out.print("Improper input, please enter 1, 2 or 3\n");
            System.out.println("What Category would you like to try?\n");
            System.out.println("1. Science and Nature \n2. General Knowledge\n3. Mythology");
            input = scanner.nextInt();
        }

        switch (input) {

            case 1: {
                System.out.println("You have chosen 1. Science and Nature");
                questionsObject = trivia.getTrivia("sciNat");
                break;
            }
            case 2: {
                System.out.println("You have chosen 2. General Knowledge");
                questionsObject = trivia.getTrivia("genKnow");
                break;
            }
            case 3: {
                System.out.println("You have chosen 3.Mythology");
                questionsObject = trivia.getTrivia("myth");
                break;
            }
        }

        List<Question> triviaQuestions = questionsObject.getQuestions();
        GameInterface gameinterface = new GameInterface();
        gameinterface.playGame(triviaQuestions);

    }













}
