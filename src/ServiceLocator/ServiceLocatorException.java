/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLocator;

import javax.naming.NamingException;

/**
 *
 * @author elena
 */
class ServiceLocatorException extends Exception {
     private Exception exception;
    
   public ServiceLocatorException(String message, Exception exception) {
    super(message);
    this.exception = exception;
    return;
  }

    ServiceLocatorException(NamingException ne) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public ServiceLocatorException(String message) {
    this(message, null);
    return;
  }
}