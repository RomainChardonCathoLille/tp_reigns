package com.fges.tp_solid.reigns.Questions;

import com.fges.tp_solid.reigns.Effet.Effet;
import com.fges.tp_solid.reigns.Effet.Effets;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<Question> questions;

    public Questions(){
        this.questions = new ArrayList<Question>();

        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non",
                new Effets(),
                new Effets()
        );
        question1.ajouteEffetGauche(new Effet(TypeJauge.ARMEE, -5));
        question1.ajouteEffetGauche(new Effet(TypeJauge.PEUPLE, +5));
        question1.ajouteEffetDroite(new Effet(TypeJauge.PEUPLE, -7));
        this.ajouterQuestion(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire", new Effets(), new Effets());
        question2.ajouteEffetGauche(new Effet(TypeJauge.FINANCE,-5));
        question2.ajouteEffetGauche(new Effet(TypeJauge.PEUPLE, +5));
        question2.ajouteEffetDroite(new Effet(TypeJauge.PEUPLE, -5));
        this.ajouterQuestion(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire", new Effets(), new Effets());
        question3.ajouteEffetGauche(new Effet(TypeJauge.CLERGE, +5));
        question3.ajouteEffetGauche(new Effet(TypeJauge.PEUPLE, -3));
        question3.ajouteEffetDroite(new Effet(TypeJauge.CLERGE, -5));
        this.ajouterQuestion(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre", new Effets(), new Effets());
        question4.ajouteEffetGauche(new Effet(TypeJauge.ARMEE, +3));
        question4.ajouteEffetGauche(new Effet(TypeJauge.FINANCE, -3));
        question4.ajouteEffetGauche(new Effet(TypeJauge.CLERGE, -3));
        question4.ajouteEffetDroite(new Effet(TypeJauge.PEUPLE, +3));
        this.ajouterQuestion(question4);
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
                "Taxer énormément",
                "Taxer un tout petit peu", new Effets(), new Effets());
        question5.ajouteEffetGauche(new Effet(TypeJauge.FINANCE, +10));
        question5.ajouteEffetGauche(new Effet(TypeJauge.PEUPLE, -5));
        question5.ajouteEffetDroite(new Effet(TypeJauge.FINANCE, +1));
        question5.ajouteEffetDroite(new Effet(TypeJauge.PEUPLE, -3));
        this.ajouterQuestion(question5);
    }


    public Question getQuestion(){
        int numQuestion = (int) (Math.random()*this.questions.size());
        return this.questions.get(numQuestion);
    }

    public void ajouterQuestion(Question _question){
        this.questions.add(_question);
    }
}
