package Trivia;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.BufferedReader;


public class Trivia {

    public Trivia (){};

//https://opentdb.com/api.php?amount=10&category=20&type=multiple

    public Questions getTrivia(){

        HttpResponse<String> response = null;
        try {


            response = Unirest.get("https://opentdb.com/api.php?amount=10&category=20&type=multiple").asString();
        }
        catch (UnirestException e){
            e.printStackTrace();
        }

        Gson gson = new Gson();
        Questions triviaQuestions = gson.fromJson(response.getBody(),Questions.class);

        return triviaQuestions;

    }





}