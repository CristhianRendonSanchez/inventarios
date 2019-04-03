package Controladores.exceptions;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class IllegalOrphanException.
 */
public class IllegalOrphanException extends Exception {

    /** The messages. */
    private List<String> messages;

    /**
     * Instantiates a new illegal orphan exception.
     *
     * @param messages the messages
     */
    public IllegalOrphanException(List<String> messages){
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        }
        else {
            this.messages = messages;
        }
    }

    /**
     * Gets the messages.
     *
     * @return the messages
     */
    public List<String> getMessages() {
        return messages;
    }
}
