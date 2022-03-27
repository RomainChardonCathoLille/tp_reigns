package com.fges.tp_solid.reigns;

import com.fges.tp_solid.reigns.Jauges.Jauge;
import com.fges.tp_solid.reigns.Jauges.TypeJauge;
import com.fges.tp_solid.reigns.Personnage.Genre;
import com.fges.tp_solid.reigns.Personnage.Personnage;
import com.fges.tp_solid.reigns.Questions.Question;
import com.fges.tp_solid.reigns.Questions.Questions;

import javax.swing.*;

import static com.fges.tp_solid.reigns.Personnage.Genre.REINE;
import static com.fges.tp_solid.reigns.Personnage.Genre.ROI;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class JeuGOT extends Jeu {

    private static Personnage personnage;
    private static Questions questions = new Questions();

    public static void main(String args[]){

        // début du jeu
        System.out.println("Bienvenue sur Reigns");
        System.out.println("Création du personnage...");

        initPersonnage();
        questions.initialiserQuestions(personnage.getJauges());

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        personnage.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        boolean finDuJeu = false;
        boolean hiver = false;
        int compteurHiver = 10;
        int dureeHiver = 5;

        while(finDuJeu == false){
            nbTours++;
            if(compteurHiver == 1){
                System.out.println("L'hiver arrive...");
            } else if(compteurHiver == 0 && !hiver){
                System.out.println("L'hiver est là... (tous les effets seront doublés)");
                hiver = true;
            } else if(compteurHiver == 10 && hiver){
                System.out.println("L'hiver est terminé...");
            }
            Question question = questions.getQuestion();
            reponseQuestion(question, hiver);
            personnage.AfficheJauges();
            if(hiver) {
                if(dureeHiver == 0){
                    compteurHiver = 10;
                    dureeHiver = 5;
                    hiver = false;
                } else {
                    dureeHiver--;
                }
            } else {
                compteurHiver--;
            }
            finDuJeu = finDuJeu();
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");
    }

    private static void reponseQuestion(Question question, boolean hiver){
        question.afficheQuestion();
        // récupère la réponse
        Scanner scanner = new Scanner(System.in);
        String reponse = "";
        while(!reponse.equals("G") && !reponse.equals("D")){
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }
        if(hiver){
            question.getEffetJaugeGauche().changeEffetsDoubles(true);
        } else {
            question.getEffetJaugeGauche().changeEffetsDoubles(false);
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

        /*Jeu.personnage = new Personnage(nom,roiReine,
                new Jauge("Clergé"),
                new Jauge("Peuple"),
                new Jauge("Armée"),
                new Jauge("Finance")
                );*/
        List<Jauge> jauges = Arrays.asList(new Jauge("Clergé", TypeJauge.CLERGE), new Jauge("Peuple", TypeJauge.PEUPLE), new Jauge("Armée", TypeJauge.ARMEE), new Jauge("Finances", TypeJauge.FINANCE));
        JeuGOT.personnage = new Personnage(nom, roiReine, jauges);
    }
    public static boolean finDuJeu(){
        List<Jauge> jauges = personnage.getJauges();
        for(int i = 0; i < jauges.size(); i++){
            if(jauges.get(i).getValeur() <= 0 || jauges.get(i).getValeur() >= 50){
                return true;
            }
        }
        return false;
    }

}
