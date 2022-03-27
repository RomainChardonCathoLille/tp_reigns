package com.fges.tp_solid.reigns.Condition;

import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;
import com.fges.tp_solid.reigns.Personnage.Personnage;

import javax.lang.model.type.NullType;
import java.util.List;

public class Condition {
    private TypeJauge typeJauge;
    private List<Jauge> jauges;
    private int valeurCondition;
    private char typeCondition;

    public Condition(TypeJauge _typeJauge, char _typeCondition, int _condition, List<Jauge> _jauges){
        this.jauges = _jauges;
        this.valeurCondition = _condition;
        this.typeCondition = _typeCondition;
        this.typeJauge = _typeJauge;
    }

    public int conditionRespectee(){
        int returnValue = 0;
        Jauge jauge = trouverJauge();
        if(jauge == null){
            return returnValue;
        }
        switch (this.typeCondition){
            case '>':
                if(jauge.getValeur() > this.valeurCondition){
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case '<':
                if(jauge.getValeur() < this.valeurCondition){
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
            case '=':
                if(jauge.getValeur() == this.valeurCondition){
                    returnValue = 1;
                } else {
                    returnValue = 0;
                }
                break;
        }
        return returnValue;
    }
    private Jauge trouverJauge(){
        for(int i = 0; i < this.jauges.size(); i++){
            if(this.jauges.get(i).getType().equals(this.typeJauge)){
                return this.jauges.get(i);
            }
        }
        return null;
    }
}
