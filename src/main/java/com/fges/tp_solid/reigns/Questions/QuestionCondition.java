package com.fges.tp_solid.reigns.Questions;

import com.fges.tp_solid.reigns.Condition.Condition;
import com.fges.tp_solid.reigns.Effet.Effets;

import java.util.List;

public class QuestionCondition extends Question {
    private List<Condition> conditions;

    public QuestionCondition(String nomPersonnage,
                             String question,
                             String effetGauche,
                             String effetDroite,
                             Effets _effetJaugeGauche,
                             Effets _effetJaugeDroite,
                             List<Condition> _conditions){
        super(nomPersonnage, question, effetGauche, effetDroite, _effetJaugeGauche, _effetJaugeDroite);
        this.conditions = _conditions;
    }

    public int peutAfficherQuestion(){
        for(int i = 0; i < this.conditions.size(); i++){
            if(this.conditions.get(i).conditionRespectee() == 0){
                return 0;
            }
        }
        return 1;
    }
}
