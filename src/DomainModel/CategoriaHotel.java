/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author elena
 */
public class CategoriaHotel {
    
    private String nom;
    
    public CategoriaHotel(){};
    
    /**
     * creadora 
     * @param cat 
     */
    public CategoriaHotel(String cat){
        this.nom = cat;
       
    }
    
    /**
     * 
     * @return el nom de la categoria 
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * 
     * @param n 
     */
    public void setNom(String n){
        this.nom = n;
    }
    
    
}