package poly.edu.utility;

import java.awt.Desktop;
import java.net.URL;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class ContactHelper {

    public void contact(String url) {
        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
