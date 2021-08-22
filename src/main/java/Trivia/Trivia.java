package Trivia;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.unbescape.html.HtmlEscape;
import org.unbescape.json.JsonEscape;
import org.unbescape.json.JsonEscapeLevel;
import org.unbescape.json.JsonEscapeType;




public class Trivia {

    public Trivia (){};

    public Questions getTrivia(String category){



        String sciNatCall = "https://opentdb.com/api.php?amount=10&category=17&type=multiple";
        String mythCall = "https://opentdb.com/api.php?amount=10&category=20&type=multiple";
        String genKnowCall = "https://opentdb.com/api.php?amount=10&category=9&type=multiple";
        String apiURL = new String();

        switch (category) {
            case "sciNat":{
                apiURL = sciNatCall;
                break;
            }
            case "myth": {
                apiURL = mythCall;
                break;
            }
            case "genKnow": {
                apiURL = genKnowCall;
                break;
            }
        }

        HttpResponse<String> response = null;
        try {
            response = Unirest.get(apiURL).asString();
        }
        catch (UnirestException e){
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Questions triviaQuestions = gson.fromJson(response.getBody(),Questions.class);

        return triviaQuestions;

    }





}