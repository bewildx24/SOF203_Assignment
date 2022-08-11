package poly.edu.utility;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class DialogHelper {

    ImageIcon icon = new ImageIcon("src/icon/fpt.png");
    ImageIcon iconError = new ImageIcon("src/icon/Stop.png");

    public void alert(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 0, icon);
    }

    public void error(Component component, String message) {
        JOptionPane.showMessageDialog(component, message, "Thông báo", 0, iconError);
    }

    public void errorNull(Component component, String name) {
        JOptionPane.showMessageDialog(component, name + " không được để trống!", "Thông báo", 0, iconError);
    }

    public boolean question(Component component, String message) {
        int choice = JOptionPane.showConfirmDialog(component, message, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
