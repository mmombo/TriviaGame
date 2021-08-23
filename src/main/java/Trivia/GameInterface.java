package Trivia;

import org.unbescape.html.HtmlEscape;

import java.util.*;

public class GameInterface {


    public GameInterface() {
    }



    public void playGame(List<APIQuestion> triviaQuestions) {
        List<String> answers;
        String correctAnswer;
        int correctIndex;
        int score = 0;

        for (int i = 0; i < triviaQuestions.size(); i++) {


            answers = shuffleAnswers(triviaQuestions.get(i).getCorrectAnswer(), triviaQuestions.get(i).getIncorrectAnswers());
            correctAnswer = HtmlEscape.unescapeHtml(triviaQuestions.get(i).getCorrectAnswer());
            correctIndex = answers.indexOf(triviaQuestions.get(i).getCorrectAnswer());

            for (int k=0; k<answers.size();k++){
                answers.set(k, HtmlEscape.unescapeHtml(answers.get(k)));
            }



            System.out.println("Question #" + (i + 1) + "\n");
            System.out.println(HtmlEscape.unescapeHtml(triviaQuestions.get(i).getQuestion()));
            for (int x = 0; x < answers.size(); x++) {
                System.out.println((1+x) + ". " + answers.get(x));
            }

            System.out.println("Select an answer above: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            while (input < 1 || input > 4) {
                System.out.print("Improper input, please enter a number 1-4\n");
                input = scanner.nextInt();
            }

            if (input == correctIndex + 1) {
                System.out.println("\nCorrect!\n");
                score++;

            } else {
                System.out.println("\nIncorrect. Correct answer was: " + correctAnswer + "" + "\n");
            }


        }

        System.out.println("\n Your Score was: " + score + "/10\n");
    }


    private List<String> shuffleAnswers(String correct, List<String> incorrect){

        List<String> shuffled = new ArrayList<>();
        shuffled.add(correct);
        for (int x = 0; x < 3; x++) {
            shuffled.add(incorrect.get(x));
        }
        Collections.shuffle(shuffled);
        return shuffled;

    }

    public void playGameDB (List<TriviaQuestion> questionsList){

        int score = 0;

        for (int i=0; i < questionsList.size();i++){

            System.out.println("\nQuestion: " + questionsList.get(i).getQuestion());

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(questionsList.get(i).getAnswer())){
                System.out.println("Correct!");
                score++;
            } else {
                 System.out.println("Incorrect, Correct Answer was: " + questionsList.get(i).getAnswer());
            }

        }

        System.out.println("Your score was: " + score + "/10");


    }


}
