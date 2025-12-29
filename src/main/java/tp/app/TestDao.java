package tp.app;
import java.util.*;
import tp.dao.*;
import tp.model.*;
public class TestDao {
    public static void main(String[] args){
        try {
            List<Etudiant> list = new EtudiantDao().findAll();
            System.out.println("La liste d'apres base donnes");
            for (Etudiant e : list) {
                System.out.println(e);
            }
            new EtudiantDao().updateMoyenne(1, 20);
            System.out.println("La liste apres modification");
            list = new EtudiantDao().findAll();
            for(Etudiant e: list){
                System.out.println(e);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
