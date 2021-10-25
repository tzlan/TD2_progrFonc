import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        System.out.println("Exercice 1  ");
        Somme<String> string  = (a1, b1) -> a1 + b1;
        System.out.println("*** Somme string ***");
        System.out.println(string.somme("a","b"));

        Somme<Long> longs  = (a1, b1) -> a1 + b1;
        System.out.println("*** Somme longs ***");
        System.out.println(longs.somme(3L,4L));

        Somme<Integer> entier  = (a1, b1) -> a1 + b1;
        System.out.println("*** Somme entiers ***");
        System.out.println(entier.somme(1,2));

        //Question 2 T en String



        ToString<List<String>> l2s  = list -> list.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println("*** ToString list ***");
        System.out.println(l2s.toString(Arrays.asList("Test","Tester","Guillaume")));

        //Question 2 map String → Integer (m2s)
        //Map<String, Integer> ms2 = new HashMap<String, Integer>();





        ToString<Map<String, Integer>> ms2  = mapss -> mapss.keySet().stream()
                .map(key -> key + " : " + mapss.get(key))
                .collect(Collectors.joining(", " ));

        System.out.println("*** ToString Map ***");
        System.out.println(ms2.toString(Map.of("A",5,"B",11, "C",45)));

        //Question 3

        /*
        public interface Function<T,R>

        C'est une interface fonctionnelle qui est utilisé comme affectation a un lambda ou une reference de methode
        Qui accepte un argument et retourne un resulat.

        public interface Predicate<T>

        Un predicate est une interface fonctionnelle qui représente un operateur qui accepte
        un paramètre d'entrée et renvoie une valeur boolean.


        public interface Consumer<T>

        Consumer est une functional interface, représentant une opération qui accepte un paramètre d'entrée
        et ne renvoie rien.
        Sa méthode fonctionnelle est apply(Object).

        public interface Supplier<T>

        Est une  interface fonctionnelle qui représente une opération en fournissant une valeur à chaque appel.
        Supplieret n'a pas de méthode par défaut mais  dispose d'une seule méthode qui est get() .




         */



        System.out.println("--------------------------------------------------------------");


        // Exercice 2

        //Question 1

        System.out.println("Exercice 2");


        Paire<Integer,Double> visiteur = new Paire<Integer,Double>(100,149.00);

        Predicate<Paire> tropGrand = Paire::grandefst;
        Predicate<Paire> tropPetite = Paire::petitefst;
        Predicate<Paire> tropLourd = Paire::surpoids;

        boolean tailleCorrecte = (tropGrand).negate().and((tropPetite.negate())).test(visiteur);
        boolean tailleIncorrecte = (tropGrand.or(tropPetite).test(visiteur));
        boolean poidsCorrect = (tropLourd.negate().test(visiteur));
        boolean poidsIncorrectComposition = !poidsCorrect;
        boolean accesGranted = !tailleIncorrecte && !poidsIncorrectComposition;


        System.out.println("La taille est correcte ?    "+tailleCorrecte);
        System.out.println("La taille est incorrecte ?    "+tailleIncorrecte);
        System.out.println("Le poids est correct  ?    "+poidsCorrect);
        System.out.println("Le poids est incorrect composition  ?    "+poidsIncorrectComposition);
        System.out.println("Granted ?    "+accesGranted);


        System.out.println("----");

        System.out.println("Taille trop grande : "+ tropGrand.test(visiteur));
        System.out.println("Taille trop petite : "+tropPetite.test(visiteur));
        System.out.println("Poids trop élevé : "+tropLourd.test(visiteur));


        //Question 2



        System.out.println("--------------------------------------------------------------");
    }





}
