/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns.Personnage;

import com.fges.tp_solid.reigns.Jauges.Jauge;
import java.util.List;
import java.util.Map;

/**
 *
 * @author julie.jacques
 */
public class Personnage {
    
    protected String nom;
    protected Genre genre;

    protected List<Jauge> jauges;

    /*
    public Personnage(String nom, Genre genre, Jauge _jaugeClerge, Jauge _jaugePeuple, Jauge _jaugeArmee, Jauge _jaugeFinance){
        this.nom = nom;
        this.genre = genre;

        this.jaugeClerge = _jaugeClerge;
        this.jaugePeuple = _jaugePeuple;
        this.jaugeArmee = _jaugeArmee;
        this.jaugeFinance = _jaugeFinance;
    }*/
    public Personnage(String nom, Genre genre, List<Jauge> _jauges){
        this.nom = nom;
        this.genre = genre;
        this.jauges = _jauges;
    }
    
    /**
     * Affiche les jauges dans la console
     */
    public void AfficheJauges(){
        /*
        this.jaugeClerge.afficher_jauge();
        this.jaugePeuple.afficher_jauge();
        this.jaugeArmee.afficher_jauge();
        this.jaugeFinance.afficher_jauge();*/
        for(int i = 0; i < this.jauges.size(); i++){
            this.jauges.get(i).afficher_jauge();
        }
        System.out.flush();
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
    public List<Jauge> getJauges(){
        return this.jauges;
    }
    /*
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
    }*/

    
}
