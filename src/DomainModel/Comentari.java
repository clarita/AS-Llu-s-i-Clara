/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author elena
 */
public class Comentari {
    private Integer avaluacio;
    private String descripcio;
    
    //atribut reqerit per l'hibernate
    private ComentariId id;
    
    public Comentari(){};
    
    /**
     * creadora
     * @param aval és el valor de l'avaluació
     * @param desc és el valor que pren la descripció del comentari 
     * @param data és el valor de la data en que es crea el comentari
     * @param h és le nom de l'hotel del qual s'ha fet el comentari
     */
    
    public Comentari(ComentariId id, Integer aval, String desc){
        this.avaluacio = aval;
        this.descripcio = desc;
        this.id = id;
    }
    
    /**
     * 
     * @return 
     */
    public Integer getAvaluacio() {
        return avaluacio;
    }
    
    /**
     * 
     * @param avaluacio 
     */

    public void setAvaluacio(Integer avaluacio) {
        this.avaluacio = avaluacio;
    }
    
    /**
     * 
     * @return 
     */
    public String getDescripcio() {
        return descripcio;
    }
    
    /**
     * 
     * @param descripcio 
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    
    /**
     * 
     * @return 
     */
    public ComentariId getId() {
        return id;
    }
    
    
    /**
     * 
     * @param id 
     */
    public void setId(ComentariId id) {
        this.id = id;
    }
    
}
