package com.fges.tp_solid.reigns.Questions;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<Question> liste_questions;

    public Questions(){
        liste_questions = new ArrayList<Question>();
    }

    public Question getQuestion(){
        int numQuestion = (int) (Math.random()*this.liste_questions.size());
        return this.liste_questions.get(numQuestion);
    }

    public void ajouterQuestion(Question _question){
        this.liste_questions.add(_question);
    }
}
