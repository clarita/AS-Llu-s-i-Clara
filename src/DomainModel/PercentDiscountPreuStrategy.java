/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author clara
 */
public class PercentDiscountPreuStrategy implements IPreuStrategy {

    private PreuTipusHabitacioId id;
    private float perc;
    
    /**
     * Creadora per defecte
     */
    public PercentDiscountPreuStrategy(){
        this.perc = 1;
    }
    
    /**
     * Creadora amb parametre de descompte
     * @param perc 
     */
    public PercentDiscountPreuStrategy(float perc){
        this.perc = perc;
    }
    
    /**
     * Setter de l'identificador del PreuTipusHabitació associat
     * @param id 
     */
    public void setId(PreuTipusHabitacioId id){
        this.id = id;
    }
    
    /**
     * Getter del PreuTipusHabitació associat
     * @return 
     */
    public PreuTipusHabitacioId getId() {
        return this.id;
    }
    
    /**
     * Setter del percentatge
     * @param perc 
     */
    public void setPerc(float perc){
        this.perc = perc;
    }
    
    /**
     * Getter del percentatge
     * @return 
     */
    public float getPerc() {
        return this.perc;
    }
    
    /**
     * Implementacio propia del calculaPreu, on es multiplica el descompte 
     * percentual pel preu base
     * @param p
     * @return 
     */
    @Override
    public float calculaPreu(PreuTipusHabitacio p) {
        return p.getPreu() * this.perc;
    }
    
}
