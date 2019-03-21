package Controladores.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class NonexistentEntityException.
 */
public class NonexistentEntityException extends Exception {
    
    /**
     * Instantiates a new nonexistent entity exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Instantiates a new nonexistent entity exception.
     *
     * @param message the message
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
