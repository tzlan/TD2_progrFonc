package Universite_exercice_3;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static Universite_exercice_3.Fonctions.*;

public class Main <T>{


    public static void main(String[] args) {

        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");

        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 15.0);
        e1.noter(m3, 10.0);
        System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

/*------------------------------------------Exercice 3------------------------------------------*/

        //Question 1 appel
        afficheSi("TOUS LES ETUDIANTS",NullEtuNonNull , a1);

        //Question 2 appel
        afficheSi("TOUS LES ETUDIANTS",aDEF, a1);

        //Question 3 appel
        afficheSi("ETUDIANTS AVEC NOTE ELIMINATOIRE",aNoteEliminatoire, a1);

        //Question 4 appel

        //afficheSi("Moyenne etudiant", );

        double r = moyenne(e1);
        System.out.println("La moyenne de l'etudiant(e) " + e1.nom() +" "+ e1.prenom() + " est de " + r);
    }
}




