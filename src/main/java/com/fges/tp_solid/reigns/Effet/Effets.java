package com.fges.tp_solid.reigns.Effet;

import com.fges.tp_solid.reigns.Personnage.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Effets {
    public List<Effet> effets;
    public boolean effetsDoubles = false;
    public Effets(List<Effet> _effets){
        this.effets = _effets;
    }

    public Effets(){
        this.effets = new ArrayList<Effet>();
    }

    public void Appliquer_Effets(Personnage personnage){
        for(int i = 0; i < effets.size(); i++){
            effets.get(i).AppliquerEffet(personnage, effetsDoubles);
        }
    }
    public void changeEffetsDoubles(boolean newBool){
        this.effetsDoubles = newBool;
    }

    public void Ajouter_Effet(Effet _effet){
        this.effets.add(_effet);
    }

    public String Afficher_Effets(){
        String affichage_effets = "";

        for(int i = 0; i < this.effets.size(); i++){
            affichage_effets += "Jauge " + this.effets.get(i).typeJauge.name() + " ";
            if(this.effets.get(i).getValue() > 0) affichage_effets += "+";
            affichage_effets += this.effets.get(i).getValue();
        }

        return affichage_effets;
    }
}
