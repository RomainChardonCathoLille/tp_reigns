/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fges.tp_solid.reigns;

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
        
        initBanqueQuestions();
        
        System.out.println("Création du personnage...");
        
        initPersonnage();
        
        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());
        
        personnage.AfficheJauges();
        
        // tirage des questions
        int nbTours = 0;
        while(!personnage.finDuJeu()){
            nbTours++;
            Question question = questions.getQuestion();
            reponseQuestion(question);
            personnage.AfficheJauges();
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
            personnage.appliquerEffet(question.getEffetJaugeGauche());
        }else{
            personnage.appliquerEffet(question.getEffetJaugeDroite());
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
        
        Jeu.personnage = new Personnage(nom,roiReine);
    }
    
    private static void initBanqueQuestions(){
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",
                "Oui",
                "Non");
        question1.ajouteEffetGauche(TypeJauge.ARMEE, -5);
        question1.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question1.ajouteEffetDroite(TypeJauge.PEUPLE, -7);
        questions.ajouterQuestion(question1);
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                "Importer de la nourriture",
                "Ne rien faire");
        question2.ajouteEffetGauche(TypeJauge.FINANCE,-5);
        question2.ajouteEffetGauche(TypeJauge.PEUPLE, +5);
        question2.ajouteEffetDroite(TypeJauge.PEUPLE, -5);
        questions.ajouterQuestion(question2);
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                "Faire un sacrifice",
                "Ne rien faire");
        question3.ajouteEffetGauche(TypeJauge.CLERGE, +5);
        question3.ajouteEffetGauche(TypeJauge.PEUPLE, -3);
        question3.ajouteEffetDroite(TypeJauge.CLERGE, -5);
        questions.ajouterQuestion(question3);
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
                "Le soutenir",
                "Rester neutre");
        question4.ajouteEffetGauche(TypeJauge.ARMEE, +3);
        question4.ajouteEffetGauche(TypeJauge.FINANCE, -3);
        question4.ajouteEffetGauche(TypeJauge.CLERGE, -3);
        question4.ajouteEffetDroite(TypeJauge.PEUPLE, +3);
        questions.ajouterQuestion(question4);
        Question question5 = new Question(
                    "Paysan",
                    "Abondance de récoltes cette année",
                    "Taxer énormément",
                    "Taxer un tout petit peu");
        question5.ajouteEffetGauche(TypeJauge.FINANCE, +10);
        question5.ajouteEffetGauche(TypeJauge.PEUPLE, -5);
        question5.ajouteEffetDroite(TypeJauge.FINANCE, +1);
        question5.ajouteEffetDroite(TypeJauge.PEUPLE, -3);
        questions.ajouterQuestion(question5);
    }
}
