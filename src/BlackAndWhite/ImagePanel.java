package BlackAndWhite;
/**
 * @author Rulty
 * 
 * 
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;


public class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage image = null;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
	public void setImage() throws IOException {
		try {
			image = Utils.openImage(this);
			this.repaint();
		}catch(IOException e) {
			throw e;
		}
		
	}
	public void saveImage() {
		Utils.saveImage(this, image);
	}
	
	public void setImageBlackAndWhite() {
		Utils.imageToBlackAndWhite(image);
		this.repaint();
	}

}
