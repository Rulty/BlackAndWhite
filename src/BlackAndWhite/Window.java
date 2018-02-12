package BlackAndWhite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Window extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private ImagePanel imagePanel = new ImagePanel();
	private JButton button = new JButton("Black And White !");
	private JPanel container = new JPanel();
	private JPanel containerButtons = new JPanel();
	
	
	public Window() {
		
		this.setSize(1200,800);
		this.setTitle("Black And White");
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    containerButtons.add(button);
	    
	    container.setBackground(Color.BLACK);
	    container.setLayout(new BorderLayout());
	    container.add(imagePanel);
	    container.add(containerButtons, BorderLayout.SOUTH);
	    button.setVisible(false);
	    button.addActionListener(new BlackAndWhiteListener());
	    
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
		
		//set Menubar, content Pane in the window
		this.setJMenuBar(menuBar);
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	//Listener for Open Menu
	class OpenListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if(imagePanel.setImage()) {
				button.setVisible(true);
			}
			
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
		//listener for Black and White button
	class BlackAndWhiteListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			imagePanel.setImageBlackAndWhite();
		}
	}

}
