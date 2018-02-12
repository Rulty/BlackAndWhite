package BlackAndWhite;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePanel extends JPanel {
	
	final private JFileChooser fileChooser = new JFileChooser();
	private String path = "";
	private BufferedImage image;
	private JOptionPane jop;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try{
			image = ImageIO.read(new File(path));
			
		}catch(IOException e) {
			if(path != "") {
				jop.showMessageDialog(this, "Error in loading the file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
	public void setImage() {
		
		//File chooser and opening Image
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		//Check user have chosen a file
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();	
			this.repaint();
		}
		
		//reset file chooser for the next time
		fileChooser.setSelectedFile(null);
	}
}
