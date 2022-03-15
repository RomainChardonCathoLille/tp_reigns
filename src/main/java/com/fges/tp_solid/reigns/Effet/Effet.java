package com.fges.tp_solid.reigns.Effet;

import com.fges.tp_solid.reigns.Jauges.TypeJauge;
import com.fges.tp_solid.reigns.Personnage.Personnage;

public class Effet {
    public TypeJauge typeJauge;
    public int effet;

    public Effet(TypeJauge _typeJauge, int _effet){
        this.typeJauge = _typeJauge;
        this.effet = _effet;
    }

    public int getValue(){
        return this.effet;
    }

    public void AppliquerEffet(Personnage personnage){
        switch (typeJauge){
            case ARMEE:
                personnage.getJaugeArmee().appliquer_effet(effet);
                break;
            case CLERGE:
                personnage.getJaugeClerge().appliquer_effet(effet);
                break;
            case FINANCE:
                personnage.getJaugeFinance().appliquer_effet(effet);
                break;
            case PEUPLE:
                personnage.getJaugePeuple().appliquer_effet(effet);
                break;
        }
    }
}
