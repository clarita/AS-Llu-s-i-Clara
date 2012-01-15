/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TupleTypes;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe de tipus objecte per a encapsular les dades referents a un hotel i
 * així poder-les passar a la capa de presentació.
 * @author lluisgh28
 */
public class DadesHotel {
    public String nom;
    public String desc;
    public String categoria;
    public Float avaluacio;
    public Set<DadesHabitacio> habs = new HashSet();   
}