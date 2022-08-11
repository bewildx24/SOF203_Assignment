package poly.edu.utility;

import java.awt.Image;

/**
 *
 * @author Vũ Nguyên Hướng
 */
public class ImageHelper {

    public static Image resize(Image orignalImage, int width, int height) {
        Image result = orignalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return result;
    }
    
}
