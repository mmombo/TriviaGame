package Trivia;

import java.util.List;
import java.util.Scanner;


public class Interface {


    public static void main(String[] args) {



        Trivia trivia = new Trivia();
        Questions questionsCollection = trivia.getTrivia();

        List<Question> triviaQuestions = questionsCollection.getQuestions();
        System.out.println(triviaQuestions.size());
        System.out.println(triviaQuestions.get(0).getQuestion());
        System.out.println(triviaQuestions.get(0).getIncorrectAnswers().get(0));
        System.out.println(triviaQuestions.get(0).getIncorrectAnswers().get(1));
        System.out.println(triviaQuestions.get(0).getIncorrectAnswers().get(2));
        System.out.println(triviaQuestions.get(0).getCorrectAnswer());

        System.out.println("\n\nWelcome to Matt's Trivia Game!");
        System.out.println("What Category would you like to try?");
        System.out.println("1. Science and Nature \n2. Entertainment\n3.Mythology");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 1 || input > 3 ){
            System.out.print("Improper input, please enter 1, 2 or 3\n");
            System.out.println("What Category would you like to try?\n");
            System.out.println("1. Science and Nature \n2. Entertainment\n3.Mythology");
            input = scanner.nextInt();
        }

        switch (input) {

            case 1: {
                System.out.println("You have chosen 1. Science and Nature");
                break;
            }
            case 2: {
                System.out.println("You have chosen 2. Entertainment");
                break;
            }
            case 3: {
                System.out.println("You have chosen 3.Mythology");
                break;
            }
        }






    }




}
