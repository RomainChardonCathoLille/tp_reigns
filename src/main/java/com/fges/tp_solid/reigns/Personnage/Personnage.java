/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns.Personnage;


import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;

import java.util.Map;

/**
 *
 * @author julie.jacques
 */
public class Personnage {
    
    protected String nom;
    protected Genre genre;
    
    protected Jauge jaugeClerge;
    protected Jauge jaugePeuple;
    protected Jauge jaugeArmee;
    protected Jauge jaugeFinance;
    
    public Personnage(String nom, Genre genre){
        this.nom = nom;
        this.genre = genre;
        
        jaugeClerge = new Jauge("Clergé");
        jaugePeuple = new Jauge("Peuple");
        jaugeArmee = new Jauge("Armée");
        jaugeFinance = new Jauge("Finance");
    }
    
    /**
     * Affiche les jauges dans la console
     */
    public void AfficheJauges(){
        this.jaugeClerge.afficher_jauge();
        this.jaugePeuple.afficher_jauge();
        this.jaugeArmee.afficher_jauge();
        this.jaugeFinance.afficher_jauge();
        System.out.flush();
    }
    
    /**
     * Le jeu s'arrête si une des jauges atteint 0 ou 50
     * @return 
     */
    public boolean finDuJeu(){
        if(jaugeClerge.jauge_remplie_ou_finie()
        || jaugePeuple.jauge_remplie_ou_finie()
        || jaugeArmee.jauge_remplie_ou_finie()
        || jaugeFinance.jauge_remplie_ou_finie()){
            return true;
        }else{
            return false;
        }
    }

    public void appliquerEffet(Map<TypeJauge, Integer> effets){
        for(Map.Entry<TypeJauge, Integer> effet : effets.entrySet()){
            switch (effet.getKey()){
                case ARMEE:
                    this.jaugeArmee.appliquer_effet(effet.getValue());
                    break;
                case CLERGE:
                    this.jaugeClerge.appliquer_effet(effet.getValue());
                    break;
                case FINANCE:
                    this.jaugeFinance.appliquer_effet(effet.getValue());
                    break;
                case PEUPLE:
                    this.jaugePeuple.appliquer_effet(effet.getValue());
                    break;
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }

    public Jauge getJaugePeuple() {
        return jaugePeuple;
    }

    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }

    public Jauge getJaugeArmee() {
        return jaugeArmee;
    }

    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    public Jauge getJaugeFinance() {
        return jaugeFinance;
    }

    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }
    
}
