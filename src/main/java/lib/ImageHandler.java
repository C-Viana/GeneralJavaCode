package lib;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageHandler {
	
	BufferedImage getImageFile(String refImgFilePath) throws IOException {
		return ImageIO.read(new File(refImgFilePath));
	} // END OF METHOD
	
	double compareImages(BufferedImage img1, BufferedImage img2) {
		int w1 = img1.getWidth();
		int w2 = img2.getWidth();
		int h1 = img1.getHeight();
		int h2 = img2.getHeight();
		
		if ((w1!=w2)||(h1!=h2)) {
			return 100;
		}
		else {
			long difference = 0;
			int pixel1;
			int pixel2;
			Color color1;
			Color color2;
			
			for (int j = 0; j < h1; j++) {
				for (int i = 0; i < w1; i++) {
					color1 = new Color(img1.getRGB(i, j), false);
					color2 = new Color(img2.getRGB(i, j), false);
					
					pixel1 = color1.getRed()+color1.getGreen()+color1.getBlue();
					pixel2 = color2.getRed()+color2.getGreen()+color2.getBlue();
					
					difference += (pixel1 == pixel2) ? 0 : 1;
				}
			}
			double avg = difference/(double)(w1*h1);
			
			return avg*100;
		}
	} // END OF METHOD
	
}
