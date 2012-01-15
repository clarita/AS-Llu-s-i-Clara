package asg3;

import Presentation.ReservarHabitacioController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author clara
 */
public class ASG3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (UnsupportedLookAndFeelException e) {
        }
    
        javax.swing.SwingUtilities.invokeLater (
            new Runnable() {
                public void run() {
                    ReservarHabitacioController.getInstance();
                }
        });
    }
}
