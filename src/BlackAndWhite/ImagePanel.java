package BlackAndWhite;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePanel extends JPanel {
	
	private BufferedImage image;
	final private JFileChooser fileChooser = new JFileChooser();
	private String path;
	
	public ImagePanel() {
		//File chooser and opening Image
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		//Check user have chosen a file
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			
		}
		
		//reset file chooser for the next time
		fileChooser.setSelectedFile(null);
	}
}
