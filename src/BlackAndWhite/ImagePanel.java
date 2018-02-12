package BlackAndWhite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
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
		
		
	    
	    
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	
	public boolean setImage() {
		
		//File chooser and opening Image
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		//Check user have chosen a file
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();	
			//open the image
			try{
				image = ImageIO.read(new File(path));
			}catch(IOException e) {
				if(path != "") {
					JOptionPane.showMessageDialog(this, "Error in loading the file", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			this.repaint();
			//reset file chooser for the next time
			fileChooser.setSelectedFile(null);
			return true;
		}else {
			//reset file chooser for the next time
			fileChooser.setSelectedFile(null);
			return false;
		}
	}
	public void saveImage() {
			int returnval = fileChooser.showSaveDialog(null);
			if(returnval == JFileChooser.APPROVE_OPTION) {
				String savePath = fileChooser.getSelectedFile().getPath();
				try {
					ImageIO.write(image, "jpg", new File(savePath));
				}catch(IOException e) {
					JOptionPane.showMessageDialog(this, "Error in Saving the file", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
	}
	
	public void setImageBlackAndWhite() {
		ColorSpace grey = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		ColorConvertOp ccOp = new ColorConvertOp(colorSpace, grey, null);
		ccOp.filter(image, image);
		this.repaint();
	}

}
