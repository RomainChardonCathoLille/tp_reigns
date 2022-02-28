/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns.Jauges;

/**
 *
 * @author julie.jacques
 */
public class Jauge {
    
    protected TypeJauge type;
    protected String nom;
    protected int valeur;

    public Jauge(String nom){
        this.nom = nom;
        this.valeur = (int) (15 + Math.random() * ( 35 - 15 ));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public TypeJauge getType() {
        return type;
    }

    public void setType(TypeJauge type) {
        this.type = type;
    }

    public void afficher_jauge(){
        String resultat = "[";
        for(int i = 0; i < this.getValeur(); i++){
            resultat += "#";
        }
        for(int i = 0; i < 50-(this.getValeur()>0?this.getValeur():0); i++){
            resultat += "_";
        }
        resultat += "]";
        resultat += this.getNom();
        System.out.println(resultat);
    }
    public boolean jauge_remplie_ou_finie(){
        if(this.getValeur() >= 50 || this.getValeur() <= 0) return true;
        return false;
    }
    public void appliquer_effet(int effet){
        this.setValeur(this.getValeur() - effet);
    }
}
