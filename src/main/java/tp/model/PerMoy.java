package tp.model;

import java.util.Comparator;

public class PerMoy implements Comparator<Etudiant>{
    @Override
    public int compare(Etudiant et1, Etudiant et2){
        return Double.compare(et2.getMoyenne(), et1.getMoyenne());
    }
}
