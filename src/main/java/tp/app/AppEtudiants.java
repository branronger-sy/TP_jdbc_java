package tp.app;
import tp.dao.*;
import tp.model.*;
import java.util.*;
public class AppEtudiants {
    public static void main(String[] args){
        System.out.println("1 - Lister tous les etudiants");
        System.out.println("2 - Rechercher un etudiant par id");
        System.out.println("3 - Filtrer les etudiants par moyenne minimale");
        System.out.println("4 - Ajouter un nouvel etudianat");
        System.out.println("5 - Modifier la moyenne d'un etudiant");
        System.out.println("0 - Quitter");
        int choix=1;
        Scanner scan=new Scanner(System.in);
        do{
            System.out.print("Choisissez se que vous voulez faire: ");
            choix=scan.nextInt();
            switch(choix){
                case 1: {
                    System.out.println("Affichage: ");
                    try{
                    List<Etudiant> list=new EtudiantDao().findAll();
                    for(Etudiant e: list){
                        System.out.println(e);
                    }}
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 2: {
                    try{
                    Map<Integer,Etudiant> map=new EtudiantDao().findAllAsMap();
                    System.out.print("Veuillez entrer l'Id d'etudiant: ");
                    int idchoix=scan.nextInt();
                        System.out.println(map.get(idchoix));
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 3: {
                    System.out.print("Veuillez entrez le moyenne minimale: ");
                    double moyMin=scan.nextDouble();
                    try{
                    List<Etudiant> list=new EtudiantDao().filtrerParMoyenneMin(moyMin);
                    System.out.println("Les etudiants valide sont: ");
                    for(Etudiant e: list){
                        System.out.println(e);
                    }}
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 4: {
                    System.out.println("Veuillez entrez les information de l'etudiant que vous voulez entrez: ");
                    scan.nextLine();
                    System.out.print("Nom: ");
                    String Nom=scan.nextLine();
                    System.out.print("Email: ");
                    String Email=scan.nextLine();
                    System.out.print("Moyenne: ");
                    Double moy=scan.nextDouble();
                    scan.nextLine();
                    try{
                        new EtudiantDao().insert(new Etudiant(Nom, Email, moy));
                    }catch(Exception e){
                       System.out.println(e.getMessage());;
                    }
                }
                break;
                case 5:{
                    System.out.print("Veuillez entrez l'id de l'etudiant pour modifier son moyenne: ");
                    int id=scan.nextInt();
                    System.out.print("Veuillez entrez la nouvelle moyenne: ");
                    double moy=scan.nextDouble();
                    try{
                    new EtudiantDao().updateMoyenne(id,moy);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                default:{
                    choix=0;
                    scan.close();
                }
            }
        }while(choix!=0);
    }
}
