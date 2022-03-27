/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns.Questions;

import com.fges.tp_solid.reigns.Effet.Effet;
import com.fges.tp_solid.reigns.Effet.Effets;
import com.fges.tp_solid.reigns.Personnage.Personnage;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 *
 * @author julie.jacques
 */
public class Question {
    
    // nom du perso qui pose la question
    protected String nomPersonnage;
    protected String question;
    protected String effetGauche;
    protected String effetDroite;
    //protected Map<TypeJauge,Integer> effetJaugeGauche;
    //protected Map<TypeJauge,Integer> effetJaugeDroite;
    protected Effets effetJaugeGauche;
    protected Effets effetJaugeDroite;
    
    public Question(String nomPersonnage, 
                    String question,
                    String effetGauche,
                    String effetDroite,
                    Effets _effetJaugeGauche,
                    Effets _effetJaugeDroite
                    ){
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effetGauche = effetGauche;
        this.effetDroite = effetDroite;
        //this.effetJaugeGauche = new Effets();
        //this.effetJaugeDroite = new Effets();
        this.effetJaugeGauche = _effetJaugeGauche;
        this.effetJaugeDroite = _effetJaugeDroite;
    }

    
    public void afficheQuestion(){
        String result = "["+nomPersonnage+"] "
                + question
                + "[G: "+effetGauche
                + ",D: "+effetDroite
                + "]";
        System.out.println(result);
        System.out.println("Effet G:" + effetJaugeGauche.Afficher_Effets());
        System.out.println("Effet D:" + effetJaugeDroite.Afficher_Effets());
        System.out.flush();
        
    }

    public void ajouteEffetGauche(Effet _effet){
        this.effetJaugeGauche.Ajouter_Effet(_effet);
    }
    
    public void ajouteEffetDroite(Effet _effet){
        this.effetJaugeDroite.Ajouter_Effet(_effet);
    }

    public String getNomPersonnage() {
        return nomPersonnage;
    }

    public void setNomPersonnage(String nomPersonnage) {
        this.nomPersonnage = nomPersonnage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getEffetGauche() {
        return effetGauche;
    }

    public void setEffetGauche(String effetGauche) {
        this.effetGauche = effetGauche;
    }

    public String getEffetDroite() {
        return effetDroite;
    }

    public void setEffetDroite(String effetDroite) {
        this.effetDroite = effetDroite;
    }

    public Effets getEffetJaugeGauche(){return this.effetJaugeGauche;}
    public Effets getEffetJaugeDroite(){return this.effetJaugeDroite;}
}
