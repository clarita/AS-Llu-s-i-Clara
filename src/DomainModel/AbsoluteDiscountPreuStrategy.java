package DomainModel;

/**
 *
 * @author clara
 */
public class AbsoluteDiscountPreuStrategy implements IPreuStrategy {

    private PreuTipusHabitacioId id;
    private float descompte;
    
    /**
     * Creadora per defecte
     */
    public AbsoluteDiscountPreuStrategy() {
        this.descompte = 0;
    }
    
    /**
     * Creadora amb parametre de descompte
     * @param descompte 
     */
    public AbsoluteDiscountPreuStrategy(PreuTipusHabitacioId id, float descompte){
        this.id = id;
        this.descompte = descompte;
    }
    
    /**
     * Setter de l'identificador del preutipushabitacio associat
     * @param id 
     */
    public void setId(PreuTipusHabitacioId id){
        this.id = id;
    }
    
    /**
     * Getter de l'identificador del preutipushabitacio associat
     * @return 
     */
    public PreuTipusHabitacioId getId() {
        return this.id;
    }
    
    /**
     * Getter de l'atribut descompte
     * @return 
     */
    public float getDescompte() {
        return this.descompte;
    }
    
    /**
     * Setter de l'atribut descompte
     * @param descompte 
     */
    public void setDescompte(float descompte){
        this.descompte = descompte;
    }
    
    /**
     * Implementacio propia del calculaPreu, on es resta el descompte absolut 
     * al preu base
     * @param p
     * @return 
     */
    @Override
    public float calculaPreu(PreuTipusHabitacio p) {
        return p.getPreu() - this.descompte;
    }
    
}
