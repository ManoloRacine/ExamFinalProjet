package org.cal.examen;

import java.util.LinkedList;

public abstract class Questions {
    private LinkedList<String> questions = new LinkedList<>() ;

    public LinkedList<String> getQuestions() {
        return questions;
    }

    public void setQuestions(LinkedList<String> questions) {
        this.questions = questions;
    }

    public void createQuestions(String question, int i) {
        for (int j = 0; j < i; j++) {
            questions.addLast(question + " " + i) ;
        }
    }

    public abstract void createQuestions(int i);
}
