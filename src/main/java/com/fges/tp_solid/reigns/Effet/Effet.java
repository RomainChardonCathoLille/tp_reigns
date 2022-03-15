package com.fges.tp_solid.reigns.Effet;

import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;
import com.fges.tp_solid.reigns.Personnage.Personnage;

import java.util.List;

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
        /*    case ARMEE:
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
        }*/
        List<Jauge> jauges = personnage.getJauges();
            switch (typeJauge){
                case ARMEE:
                    for(int i = 0; i < jauges.size(); i++){
                        if(jauges.get(i).getNom().toUpperCase().equals("armée".toUpperCase())){
                            jauges.get(i).appliquer_effet(effet);
                        }
                    }
                    break;
                case CLERGE:
                    for(int i = 0; i < jauges.size(); i++){
                        if(jauges.get(i).getNom().toUpperCase().equals("clergé".toUpperCase())){
                            jauges.get(i).appliquer_effet(effet);
                        }
                    }
                    break;
                case FINANCE:
                    for(int i = 0; i < jauges.size(); i++){
                        if(jauges.get(i).getNom().toUpperCase().equals("finances".toUpperCase())){
                            jauges.get(i).appliquer_effet(effet);
                        }
                    }
                    break;
                case PEUPLE:
                    for(int i = 0; i < jauges.size(); i++){
                        if(jauges.get(i).getNom().toUpperCase().equals("PEUPLE")){
                            jauges.get(i).appliquer_effet(effet);
                        }
                    }
                    break;
            }
    }
}
