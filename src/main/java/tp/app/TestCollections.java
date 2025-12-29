package tp.app;

import java.util.*;
import tp.model.*;

public class TestCollections {
    public static void main(String[] args){
    List<Etudiant> list = new ArrayList<>();
    Etudiant e1=new Etudiant(1,"issam","issamafjdghighabcd@gmail.com",19.00);
    Etudiant e2=new Etudiant(2,"Imrane","imraneafjdghigh@gmail.com",15.00);
    Etudiant e3 = new Etudiant(3,"Adnane", "adnaneafjdghigh@gmail.com", 11.00);
    Etudiant e4 = new Etudiant(3,"Adnane", "adnaneafjdghigh@gmail.com", 11.00);
    list.add(e1);
    list.add(e2);
    list.add(e3);
    list.add(e4);
    System.out.println("before trie:\n");
    for(Etudiant e:list){
        System.out.println(e);
    }
    Collections.sort(list);
    System.out.println("apres trie par nom:\n");
    for(Etudiant e:list){
        System.out.println(e);
    }
    Collections.sort(list,new PerMoy());
    System.out.println("apres trie par moyenne:\n");
    for(Etudiant e:list){
        System.out.println(e);
    }

    Set<Etudiant> set = new HashSet<>(list);
    System.out.println("set:\n");
    for(Etudiant e:set){
        System.out.println(e);
    }
    Map<Integer,Etudiant> map=new HashMap<>();
    for(Etudiant e: list){
        map.put(e.getId(), e);
    }
    Set<Integer> key=map.keySet();
    Iterator it=key.iterator();
    System.out.println("map:\n");
    while(it.hasNext()){
        System.out.println(map.get(it.next()));
    }
    }
}