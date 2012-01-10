/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TupleTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lluisgh28
 */
public class DadesHotel {
    public String nom;
    public String desc;
    public String categoria;
    public Float avaluacio;
    public Set<DadesHabitacio> habs = new HashSet();
    
}  
  /*  
    public DadesHotel() {
        ArrayList<DadesHabitacio> habs = new ArrayList<DadesHabitacio>();
    }
    
    public DadesHotel(String nom, String desc, String categoria, Float avaluacio, ArrayList<DadesHabitacio> habs) {
        this.nom = nom;
        this.desc = desc;
        this.categoria = categoria;
        this.avaluacio = avaluacio;
        this.habs = habs;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public Float getAvaluacio() {
        return avaluacio;
    }
    
    public ArrayList<DadesHabitacio> getHabs() {
        return habs;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void setAvaluacio(Float avaluacio) {
        this.avaluacio = avaluacio;
    }
    
    public void setHabs(ArrayList<DadesHabitacio> habs) {
        this.habs = habs;
    }
}
     * 
     */
