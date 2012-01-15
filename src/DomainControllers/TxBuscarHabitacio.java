package DomainControllers;

import DataInterfaces.ICtrlPoblacio;
import DomainFactories.CtrlDataFactory;
import DomainModel.Poblacio;
import TupleTypes.DadesHotel;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Controlador transacció per la logica de la funcionalitat buscar habitació
 * @author clara
 */
public class TxBuscarHabitacio {
    private String poblacio;
    private Date dataInici;
    private Date dataFi;
    private int numOc;
    private Set<DadesHotel> result;
    
    /**
     * Creadora per defecte, requereix les dades necessàries per a la transacció
     * @param poblacio
     * @param dataInici
     * @param dataFi
     * @param numOc 
     */
    public TxBuscarHabitacio(String poblacio, Date dataInici, Date dataFi, int numOc){
        this.poblacio = poblacio;
        this.dataInici = dataInici;
        this.dataFi = dataFi;
        this.numOc = numOc;
        this.result = new HashSet<DadesHotel>();
    }
    
    /**
     * Executa la lògica de la transacció
     */
    public void executar() throws Exception{
        CtrlDataFactory cdf = CtrlDataFactory.getInstance();
        ICtrlPoblacio cp = cdf.getCtrlPoblacio();
        Poblacio p = cp.get(poblacio);
        result = p.getDisponibles(dataInici,dataFi,numOc);
    }
    
    /**
     * Obté el resultat de la transacció.
     * @return 
     */
    public Set<DadesHotel> obteResultat(){
        return this.result;
    }
}
