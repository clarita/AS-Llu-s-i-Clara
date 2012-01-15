/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author lluisgh28
 */
public class Client {
    String dni;
    String nom;
    String cognoms;
    String email;

    /**
     * Creadora per defecte. Requerida per Hibernate.
     */
    public Client() {      
    }
    
    /**
     * Creadora senzilla per a tests.
     * @param dni 
     */
    public Client(String dni) {
        this.dni = dni;
    }
    
    /**
     * Creadora amb els paràmetres necessaris per a inicialitzar tots els
     * atributs.
     * @param dni
     * @param nom
     * @param cognoms
     * @param email 
     */
    public Client(String dni, String nom, String cognoms, String email) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
    }

    /**
     * Getter dels cognoms.
     * @return 
     */
    public String getCognoms() {
        return cognoms;
    }

    /**
     * Setter dels cognoms. Requerit per Hibernate.
     * @param cognoms 
     */
    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    /**
     * Getter del dni. Requerit per Hibernate.
     * @return 
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter del dni. Requerit per Hibernate.
     * @param dni 
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Getter de l'email.
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter de l'email. Requerit per Hibernate.
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Getter del nom.
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter del nom. Requerit per Hibernate.
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}
