/**
 * 
 */
package BlackAndWhite;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author victor
 *
 */
public class Utils {
	private static JFileChooser fileChooser = new JFileChooser();
	
	public static void initFileChooser(String description, String...extension) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(description, extension);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setFileFilter(filter);
	}
	
	public static BufferedImage openImage(JPanel panel) throws IOException {
				int returnVal = fileChooser.showOpenDialog(null);
				//Check user have chosen a file
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String path = fileChooser.getSelectedFile().getPath();	
					try {
					//open the image
						return ImageIO.read(new File(path));
					}catch(IOException e) {
						throw e;
					}finally {
						//reset file chooser for the next time
						fileChooser.setSelectedFile(null);
					}
					}else {
						//reset file chooser for the next time
						fileChooser.setSelectedFile(null);
						throw new IOException();
					}
					

	}
	public static void saveImage(JPanel panel ,BufferedImage image) {
		int returnval = fileChooser.showSaveDialog(null);
		if(returnval == JFileChooser.APPROVE_OPTION) {
			String savePath = fileChooser.getSelectedFile().getPath();
			try {
				ImageIO.write(image, "jpg", new File(savePath));
			}catch(IOException e) {
				JOptionPane.showMessageDialog(panel, "Error in Saving the file", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	public static void imageToBlackAndWhite(BufferedImage image) {
		
		ColorSpace grey = ColorSpace.getInstance(ColorSpace.CS_GRAY);
		ColorSpace colorSpace = ColorSpace.getInstance(ColorSpace.CS_sRGB);
		ColorConvertOp ccOp = new ColorConvertOp(colorSpace, grey, null);
		ccOp.filter(image, image);
	}
}
