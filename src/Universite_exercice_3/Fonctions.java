package Universite_exercice_3;

import java.util.Map;
import java.util.function.Predicate;

public class Fonctions {

    //Exercice 3 Question 1 prédicat

    static Predicate<Etudiant> NullEtuNonNull = etu1 ->  true;

    //Exercice 3 Question 2 prédicat


    static Predicate<Etudiant> aDEF = etudiant -> {

        for (UE  ue : etudiant.annee().ues() ){

            for (Map.Entry<Matiere, Integer> notes : ue.ects().entrySet()){

                if(!etudiant.notes().containsKey(notes.getKey()) ){

                    return true;
                }

            }

        }
        return  false;
    };

    //Exercice 3 Question 3 prédicat

    static Predicate <Etudiant> aNoteEliminatoire = etudiant -> {

        for (Double note: etudiant.notes().values()) {
            if(note <  6) return  true;
        }

        return false;
    };




    /*---------------------------------------------FONCTIONS-----------------------------------------------------*/

    //Exercice 3 Question 1 fonction
    public static void afficheSi(String EnTete, Predicate<Etudiant> PredicatEtudiant, Annee annee) {
        System.out.println(EnTete);

        for (Etudiant elements : annee.etudiants()) {
            if (PredicatEtudiant.test(elements)) {
                System.out.println(elements.toString());
            }
        }
    }

    //Exercice 3 : question 4

    public static double moyenne (Etudiant numero){
        double tMoyenne =0;
        Integer totalEcts =0;

        if(!aDEF.test(numero)){

            for (UE  ue : numero.annee().ues() ){

                for (Map.Entry<Matiere, Integer> ect : ue.ects().entrySet()){


                        tMoyenne = tMoyenne + numero.notes().get(ect.getKey()) *ect.getValue();
                        totalEcts += ect.getValue();


                }

            }

        }
        System.out.println("tmoyenne " +tMoyenne);
        System.out.println("totalEcts " +totalEcts);
        return  (tMoyenne / totalEcts);



    }



}
