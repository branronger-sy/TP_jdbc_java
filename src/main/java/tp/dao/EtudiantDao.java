package tp.dao;
import tp.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class EtudiantDao {
    public List<Etudiant> findAll() throws SQLException{
        try(Connection conn=ConnexionBD.getConnection()){
            PreparedStatement pstmt=conn.prepareStatement("SELECT id,nom,email,moyenne FROM etudiants");
            try(ResultSet rs = pstmt.executeQuery()){
                List<Etudiant> list=new ArrayList<>();
                while(rs.next()){
                    int id=rs.getInt("id");
                    String nom=rs.getString("nom");
                    String email=rs.getString("email");
                    Double moyenne=rs.getDouble("moyenne");
                    list.add(new Etudiant(id, nom, email, moyenne));
                }
                return list;
            }
        }
    }
    public Map<Integer,Etudiant> findAllAsMap() throws SQLException{
        try(Connection conn=ConnexionBD.getConnection()){
            PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM etudiants");
            try(ResultSet rs=pstmt.executeQuery()){
                Map<Integer,Etudiant> map=new HashMap<>();
                while(rs.next()){
                    int id=rs.getInt("id");
                    String nom=rs.getString("nom");
                    String email=rs.getString("email");
                    Double moyenne=rs.getDouble("moyenne");
                    map.put(id,new Etudiant(id, nom, email, moyenne));
                }
                return map;
            }
        }
    }
    public List<Etudiant> filtrerParMoyenne(List<Etudiant> source, double seuil) throws SQLException{
        List<Etudiant> list=new ArrayList<>();
        for(Etudiant e:source){
            if(e.getMoyenne()>=seuil){
                list.add(e);
            }
        }
        return list;
    }
    public List<Etudiant> filtrerParMoyenneMin(double seuil) throws SQLException{
        try(Connection conn=ConnexionBD.getConnection()){
            PreparedStatement pstmt=conn.prepareStatement("SELECT * FROM etudiants WHERE moyenne >= ?");
            pstmt.setDouble(1,seuil);
            try(ResultSet rs=pstmt.executeQuery()){
                List<Etudiant> list=new ArrayList<>();
                while(rs.next()){
                int id=rs.getInt("id");
                String nom=rs.getString("nom");
                String email =rs.getString("email");
                Double moyenne=rs.getDouble("moyenne");
                list.add(new Etudiant(id, nom, email, moyenne));
                }
                return list;
            }
        }
    }
    public void insert(Etudiant etu) throws SQLException{
        try(Connection conn=ConnexionBD.getConnection()){
            PreparedStatement pstmt=conn.prepareStatement("INSERT INTO etudiants (nom, email, moyenne) VALUES (?,?,?)");
            pstmt.setString(1,etu.getNom());
            pstmt.setString(2,etu.getEmail());
            pstmt.setDouble(3,etu.getMoyenne());
            int ligne=pstmt.executeUpdate();
            System.out.println(ligne+" etudiant est ajoute avec succes");
        }
    }
    public void updateMoyenne(int id, double nouvelleMoyenne) throws SQLException{
        try(Connection conn=ConnexionBD.getConnection()){
            PreparedStatement pstmt=conn.prepareStatement("UPDATE etudiants SET moyenne = ? WHERE id= ?");
            pstmt.setDouble(1,nouvelleMoyenne);
            pstmt.setInt(2,id);
            int ligne=pstmt.executeUpdate();
            System.out.println(ligne+" etudiant a ete modifier par succes");
        }
    }
}
