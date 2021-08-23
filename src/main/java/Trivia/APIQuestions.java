package Trivia;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class APIQuestions {

    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("results")
    @Expose
    private List<APIQuestion> questions = null;

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<APIQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<APIQuestion> questions) {
        this.questions = questions;
    }

}