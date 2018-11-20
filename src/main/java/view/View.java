
package view;

/**
 *
 * @author kanderson
 */
public interface View {
    
    
    /**
     * Control this view's display/prompt/action loop until the user
     * chooses and action that causes this view to close.
     */
    public void displayView();
}
