package Trivia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostgresSQLJDBC {

    public PostgresSQLJDBC(){}

    public List<TriviaQuestion> getTrivia()  {


        Connection c = null;
        Statement stmt= null;
        List<TriviaQuestion> triviaList = new ArrayList<>();


        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/trivia","postgres", "password");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from questions order by random() limit 10;" );

            while (rs.next()){
                String question = rs.getString("question");
                String answer = rs.getString("answer");
                TriviaQuestion triviaquestion = new TriviaQuestion(question, answer);
                triviaList.add(triviaquestion);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Operation done successfully");

        return triviaList;
    }

}
