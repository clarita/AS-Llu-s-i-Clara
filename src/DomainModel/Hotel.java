package DomainModel;

import TupleTypes.DadesHabitacio;
import TupleTypes.DadesHotel;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author elena
 * @author clara
 */
public class Hotel {
    String nom;
    String descripcio;
    Set<PreuTipusHabitacio> preus = new HashSet();
    Set<Comentari> comentaris = new HashSet();
    CategoriaHotel categoria;
    
    //atributs necessaris per Hibernate
    String nomPoblacio;
    
    public Hotel(){};

    /**
     * creadora
     * @param nomH és el nom de l'hotel
     * @param des és la descripció de l'hotel
     * @param pob és el nom de la població a la que pertany l'hotel
     */
    
    public Hotel(String nom, String des, String nomPoblacio, CategoriaHotel categoria){
        this.descripcio = des;
        this.nom = nom;
        this.comentaris = new HashSet();
        this.preus = new  HashSet();
        this.nomPoblacio = nomPoblacio;
        this.categoria = categoria;
    }

    
    /**
     * retorna el nom de l'hotel 
     * @return nom 
     */
    
    public String getNom(){
        return this.nom;
    }
    
    /**
     * retorna la descripcio de l'hotel 
     * @return 
     */
    public String getDescripcio(){
        return this.descripcio;
    }
    
    /**
     * 
     * @return 
     */
    public Set<Comentari> getComentaris() {
        return this.comentaris;
    }
    
    /**
     * 
     * @return 
     */

    public Set<PreuTipusHabitacio> getPreus() {
        return this.preus;
    }
    
    /**
     * 
     * @param n 
     */
    
    public void setNom(String n){
        this.nom = n;
    }
    
    /**
     * 
     * @param d 
     */
    public void setDescripcio(String d){
        this.descripcio = d;
    }
    
    /**
     * 
     * @param comentaris 
     */
    
    public void setComentaris (Set<Comentari> comentaris){
        this.comentaris = comentaris;
    }
    
    /**
     * 
     * @param preus 
     */
    
    public void setPreus(Set<PreuTipusHabitacio> preus){
        this.preus = preus;
    }
    
    /**
     * Setter del string nomPoblacio
     * @param nomPoblacio 
     */
    public void setNomPoblacio(String nomPoblacio) {
        this.nomPoblacio = nomPoblacio;
    }
    
    /**
     * Getter del string nomPoblacio
     * @return 
     */
    public String getNomPoblacio() {
        return this.nomPoblacio;
    }
    
    /**
     * Setter de la categoria
     */
    public void setCategoria(CategoriaHotel categoria){
        this.categoria = categoria;
    }
    
    /**
     * Getter de la categoria
     * @return 
     */
    public CategoriaHotel getCategoria() {
        return this.categoria;
    }
    
    
    /**
     * obte el preu total d'una habitació que és del tipus tipushab, amb l'estrategia corresponent i 
     * en els dies entre datainici i dataFi
     * @param tipushab 
     * @param datainici
     * @param dataFi
     * @return p*dies
     */
    public float obtePreuTotal(String tipushab, Date datainici, Date dataFi){
        Integer TEMPS = 24*60*60*1000;
        float p = 0;
        for(PreuTipusHabitacio pr : preus) {
          if(pr.isOfType(tipushab)){
              p = pr.calculaPreu();
              break;
          }
        }
        Long dies = (dataFi.getTime() - datainici.getTime())/TEMPS;
         
        return p*dies;
    }
    
    /**
     * retorna un booleà que indica si l'hotel està diponible, a més, retona una tupla amb 
     * la informació de les habitacions disponibles que compleixen les condicions, 
     * que estiguin lliures en el periode datainici/dataFi i que hi capiguin el nombre d'ocupnats numoC
     * @param dIni
     * @param dFi
     * @param numOc
     * @param dh
     * @return cert si l'hotel està disponible, false altrament.
     */
    public boolean estaDisp(Date dIni, Date dFi, Integer numOc, DadesHotel dh) {
        Set<DadesHabitacio> habs = new HashSet<DadesHabitacio>();

        for(PreuTipusHabitacio p : preus){
            Integer numDisponibles = p.numDisp(dIni, dFi, nom, numOc);
            if(numDisponibles > 0){
                DadesHabitacio dadesHabitacio = new DadesHabitacio();
                dadesHabitacio.preu = p.calculaPreu();
                dadesHabitacio.tipusHab = p.getNomTipus();
                dadesHabitacio.numeroDisp = numDisponibles; 
                habs.add(dadesHabitacio);
            }
        }
        
        if(!habs.isEmpty()){
            dh.avaluacio = this.mitjaAval();
            dh.categoria = this.categoria.getNom();
            dh.desc = this.descripcio;
            dh.nom = this.nom;
            dh.habs = habs;
        }
        return !habs.isEmpty();
    }
    
    /**
     * fa la mitja de les avalucions dels comentaris que té l'hotel
     * @return 
     */
    
    private float mitjaAval(){
        Integer suma = 0;
        if(!comentaris.isEmpty()){
            for(Comentari c : comentaris){
                suma = suma + c.getAvaluacio();
            }
            return suma/comentaris.size();
        }
        return 0;
    }   
}


