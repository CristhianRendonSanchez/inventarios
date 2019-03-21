package Controladores.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class PreexistingEntityException.
 */
public class PreexistingEntityException extends Exception {
    
    /**
     * Instantiates a new preexisting entity exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Instantiates a new preexisting entity exception.
     *
     * @param message the message
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
