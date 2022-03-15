/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;
import com.fges.tp_solid.reigns.Personnage.Genre;
import com.fges.tp_solid.reigns.Personnage.Personnage;
import com.fges.tp_solid.reigns.Questions.Question;
import com.fges.tp_solid.reigns.Questions.Questions;

import static com.fges.tp_solid.reigns.Personnage.Genre.REINE;
import static com.fges.tp_solid.reigns.Personnage.Genre.ROI;

import java.util.Scanner;


/**
 *
 * @author julie.jacques
 */
public class Jeu {
    
    private static Personnage personnage;
    private static Questions questions = new Questions();
    
    public static void main(String args[]){
        
        // début du jeu 
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création du personnage...");
        
        initPersonnage();
        
        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());
        
        personnage.AfficheJauges();
        
        // tirage des questions
        int nbTours = 0;
        boolean finDuJeu = false;
        while(finDuJeu == false){
            nbTours++;
            Question question = questions.getQuestion();
            reponseQuestion(question);
            personnage.AfficheJauges();
            finDuJeu = finDuJeu();
        }
        
        // fin du jeu
        System.out.println(
            personnage.getNom() 
            + " a perdu ! Son règne a duré "
            +nbTours
            + " tours");
    }
    
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        // applique les malus
        if(reponse.equals("G")){
            //question.appliqueEffetsGauche(personnage);
            question.getEffetJaugeGauche().Appliquer_Effets(personnage);
            //personnage.appliquerEffet(personnage);
        }else{
            //personnage.appliquerEffet(question.getEffetJaugeDroite());
            question.getEffetJaugeDroite().Appliquer_Effets(personnage);
        }
    }
    private static void initPersonnage(){        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
            "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        int genre = scanner.nextInt();
        Genre roiReine;
        if(genre==1){
            roiReine = ROI;
        }else{
            roiReine = REINE;
        }
        
        Jeu.personnage = new Personnage(nom,roiReine,
                new Jauge("Clergé"),
                new Jauge("Peuple"),
                new Jauge("Armée"),
                new Jauge("Finance")
                );
    }
    public static boolean finDuJeu(){
        if(personnage.getJaugeClerge().jauge_remplie_ou_finie()
                || personnage.getJaugePeuple().jauge_remplie_ou_finie()
                || personnage.getJaugeArmee().jauge_remplie_ou_finie()
                || personnage.getJaugeFinance().jauge_remplie_ou_finie()){
            return true;
        }else{
            return false;
        }
    }

}
