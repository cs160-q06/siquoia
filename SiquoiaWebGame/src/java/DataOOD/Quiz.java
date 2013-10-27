/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataOOD;

import java.util.List;

/**
 *
 * @author mr.nam
 */
public class Quiz {
    private  List<Question> questionList;
    private int currentQuestionIndex;
    public Quiz(List<Question> questionList) {
        this.questionList = questionList;
        currentQuestionIndex = 0;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public boolean hasNext() {
        return currentQuestionIndex<questionList.size()-1;
    }

    public Question getCurrentQuestion() {
        return questionList.get(currentQuestionIndex);
    }

    public void next() {
        currentQuestionIndex++;
    }

    
    public boolean isCurrentCorrect(String answer) {
        return getCurrentQuestion().getCorrectAnswer().toLowerCase().equals(answer.toLowerCase());
    }

    

    
    
    
    
}
