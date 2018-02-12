package BlackAndWhite;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Window extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	
	private ImagePanel imagePanel = new ImagePanel();
	
	
	
	public Window() {
		this.setSize(1200,800);
		this.setTitle("Black And White");
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //imagePanel.setBackground(Color.BLACK);
		//construct the menuBar
		menuBar = new JMenuBar();
		//First Menu
		menu = new JMenu("File");
		menu.setMnemonic('F');
		menu.getAccessibleContext().setAccessibleDescription("Open and Save image");
		menuBar.add(menu);
		
		//Menu Item in the first Menu
		menuItem = new JMenuItem("Open");
		menuItem.getAccessibleContext().setAccessibleDescription("Open an Image");
		menuItem.addActionListener(new OpenListener());
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Save");
		menuItem.getAccessibleContext().setAccessibleDescription("Save the Image");
		menuItem.addActionListener(new SaveListener());
		menu.add(menuItem);	
		
		menu.addSeparator();
		
		menuItem = new JMenuItem("Close");
		menuItem.getAccessibleContext().setAccessibleDescription("Save the Image");
		menuItem.addActionListener(new CloseListener());
		menu.add(menuItem);
		
		this.setJMenuBar(menuBar);
		this.setContentPane(imagePanel);
		this.setVisible(true);
	}
	
	//Listener for Open Menu
	class OpenListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			imagePanel.setImage();	
		}
		
	}
	//Listener for Save Menu
	class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
	//Listener for Close Menu
		class CloseListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		}

}
