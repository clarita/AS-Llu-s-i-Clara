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

    public Client() {
        
    }
    
    public Client(String dni, String nom, String cognoms, String email) {
        this.dni = dni;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
  
}
