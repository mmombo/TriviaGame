package Trivia;

public class TriviaQuestion {

    private String question;
    private String answer;

    public TriviaQuestion (String question, String answer){

        this.question = question;
        this.answer = answer;

    }
    public TriviaQuestion (){
    }


    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}



