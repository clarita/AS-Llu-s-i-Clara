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
    private Date data;
    
    //atribut reqerit per l'hibernate
    //private String nomHotel;
    //private String dniC;
    private ComentariId id;
    
    public Comentari(){};
    
    /**
     * creadora
     * @param aval és el valor de l'avaluació
     * @param desc és el valor que pren la descripció del comentari 
     * @param data és el valor de la data en que es crea el comentari
     * @param h és le nom de l'hotel del qual s'ha fet el comentari
     */
    
    public Comentari(Integer aval, String desc, Date data,ComentariId id){
        this.avaluacio = aval;
        this.descripcio = desc;
        this.data = data;
        //this.nomHotel = h;
        //this.dniC = dni;
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

    public Date getData() {
        return data;
    }
    
    /**
     * 
     * @param data 
     */

    public void setData(Date data) {
        this.data = data;
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
