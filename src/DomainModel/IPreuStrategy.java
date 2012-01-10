package DomainModel;

/**
 * Interficie comuna per les estrategies de preus<br />
 * Les estratègies s'identifiquen pel PreuTipusHabitació al que acompanyen, ja 
 * que en la tercera entrega vam canviar la multiplicitat entre el 
 * PreuTipusHabitacio i IPreuStrategy a 1, indicant que cada estratègia 
 * correspon a només un PreuTipusHabitació.
 * @author clara
 */
public interface IPreuStrategy {
    
    /**
     * Getter de l'identificador de l'estratègia
     * @return 
     */
    public PreuTipusHabitacioId getId();
    
    /**
     * Setter de l'identificador de l'estratègia
     * @param id 
     */
    public void setId(PreuTipusHabitacioId id);
    
    /**
     * Funcio que calcula el preu dun preutipushabitacio aplicant l'estrategia 
     * de preus pertinent
     * @param p
     * @return El preu final duna nit per un preutipushabitacio
     */
    public float calculaPreu(PreuTipusHabitacio p);
    
}
