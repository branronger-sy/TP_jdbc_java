package tp.model;

public class Etudiant implements Comparable<Etudiant> {
    private int id;
    private String nom;
    private String email;
    private Double moyenne;
    public Etudiant(String nom,String email,Double moyenne){
        this.nom=nom;
        this.email=email;
        this.moyenne=moyenne;
    }
    public Etudiant(int id,String nom,String email,Double moyenne){
        this.id=id;
        this.nom=nom;
        this.email=email;
        this.moyenne=moyenne;
    }
    public Etudiant(){
    }
    public void setNom(String nom){
        this.nom=nom;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public void setMoyenne(Double moyenne){
        this.moyenne=moyenne;
    }
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getEmail(){
        return this.email;
    }
    public Double getMoyenne(){
        return this.moyenne;
    }

    public String toString(){
        return "Id: "+this.id+"\n"+
        "Nom: "+this.nom+"\n"+
        "Email: "+this.email+"\n"+
        "Moyenne: "+this.moyenne+"\n";
    }
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(!(o instanceof Etudiant))
            return false;
        Etudiant et=(Etudiant)o;
        return this.id==et.id;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }
    public int compareTo(Etudiant et){
        return this.nom.compareTo(et.nom);
    }
}
