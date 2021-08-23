package Trivia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainInterface {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GameInterface gameinterface = new GameInterface();

        System.out.println("Hello, would you like to play with database questions or web API questions?");
        System.out.println("1. Database");
        System.out.println("2. Web API");


        int input = scanner.nextInt();
        while (input < 1 || input > 2) {
            System.out.print("Improper input, please enter 1 or 2\n");
            input = scanner.nextInt();
        }


        if (input == 1) {
            PostgresSQLJDBC db = new PostgresSQLJDBC();
            List<TriviaQuestion> triviaquestions = db.getTrivia();
            gameinterface.playGameDB(triviaquestions);

        }
        else {
            TriviaSource trivia = new TriviaSource();
            APIQuestions questionsObject = new APIQuestions();
            System.out.println("What Category would you like to try?");
            System.out.println("1. Science and Nature \n2. General Knowledge\n3. Mythology");


            input = scanner.nextInt();
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

            List<APIQuestion> triviaQuestions = questionsObject.getQuestions();

            gameinterface.playGame(triviaQuestions);
        }







    }













}
