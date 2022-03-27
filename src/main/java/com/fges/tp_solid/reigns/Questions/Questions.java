package com.fges.tp_solid.reigns.Questions;

import com.fges.tp_solid.reigns.Condition.Condition;
import com.fges.tp_solid.reigns.Effet.Effet;
import com.fges.tp_solid.reigns.Effet.Effets;
import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<Question> questions;

    public void initialiserQuestions(List<Jauge> jauges){
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

        List<Condition> conditionsQuestion6 = new ArrayList<Condition>();
        conditionsQuestion6.add(new Condition(TypeJauge.FINANCE, '<', 10, jauges));
        QuestionCondition question6 = new QuestionCondition("Main du roi", "Les caisses sont vides...", "Augmenter les taxes", "Emprunter", new Effets(), new Effets(), conditionsQuestion6);
        question6.ajouteEffetGauche(new Effet(TypeJauge.FINANCE, 10));
        question6.ajouteEffetGauche(new Effet(TypeJauge.PEUPLE, -5));
        question6.ajouteEffetDroite(new Effet(TypeJauge.FINANCE, 7));
        question6.ajouteEffetDroite(new Effet(TypeJauge.PEUPLE, -3));
        this.ajouterQuestion(question6);

        List<Condition> conditionsQuestion7 = new ArrayList<Condition>();
        conditionsQuestion7.add(new Condition(TypeJauge.CLERGE, '<', 10, jauges));
        conditionsQuestion7.add(new Condition(TypeJauge.FINANCE, '>', 30, jauges));
        QuestionCondition question7 = new QuestionCondition("Prêtre", "J'aimerai qu'on nous considère en tant que tel", "Construire un monastère", "Ecouter sans rien faire", new Effets(), new Effets(), conditionsQuestion7);
        question7.ajouteEffetGauche(new Effet(TypeJauge.CLERGE, 5));
        question7.ajouteEffetGauche(new Effet(TypeJauge.FINANCE, -5));
        question7.ajouteEffetDroite(new Effet(TypeJauge.CLERGE, -5));
        this.ajouterQuestion(question7);
    }


    public Question getQuestion(){
        int numQuestion = (int) (Math.random()*this.questions.size());
        if(this.questions.get(numQuestion) instanceof QuestionCondition){
            if(((QuestionCondition) this.questions.get(numQuestion)).peutAfficherQuestion() == 1){
                return this.questions.get(numQuestion);
            } else {
                return getQuestion();
            }
        }
        return this.questions.get(numQuestion);
    }

    public void ajouterQuestion(Question _question){
        this.questions.add(_question);
    }
}
