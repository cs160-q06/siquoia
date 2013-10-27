/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOOD;

/**
 *
 * @author mr.nam
 */
public class Question {

    private int id;
    private Topic topic;
    private String correctAnswer;
    private String answer1;
    private String answer2;
    private String answer3;
    private int ranking;
    private  String question;

    public Question(int id, Topic topic,String question, String correctAnswer, String answer1, String answer2, String answer3, int ranking) {
        this.id = id;
        this.topic = topic;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.ranking = ranking;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getId() {
        return id;
    }

    
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getRanking() {
        return ranking;
    }

    public void incrementRanking() {
        ranking++;
    }

    @Override
    public String toString() {
        String s = "Question #" + id + " (" + topic.toSimpleString()+"): ";
        s+=question+"\n\tc: "+correctAnswer+"\n\ta1: "+answer1
                +"\n\ta2: " + answer2 +"\n\ta3: " +answer3;
        return s; //To change body of generated methods, choose Tools | Templates.
    }
  
    
}
