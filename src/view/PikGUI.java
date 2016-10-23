package view;


/*///////////////////////////////////////////////////////////
//INTELECTUAL PROPERTY OF THEODORE JOHN SACKOS             //
//Pikrypture � Theodore Sackos                           //
//505 264 6817											   //
//FEBRUARY 27th, 2015									   //
//Student of the University of Arizona                     //
///////////////////////////////////////////////////////////*/
/*
 * TO DO:
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PikGUI extends JFrame {
	public static final long serialVersionUID = 800;
	public static final int NUM_OF_CHAR_CODES = 64;
	private String TITLE = "Pikrypt";
	private String inputToEncrypt;

	protected static JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem about, quit, save, saveAs, load;
	private JMenu viewMenu;
	private JMenuItem view;
	private JTextArea input;
	protected static JPanel center;
	private JPanel south;
	private JPanel bottomRightButtonPanel;
	private JButton saveAfterGo;
	private JButton go;
	private JLabel pikrypt;
	private JScrollPane inputPane;

	protected static Enpikryption pikrypture;
	private Depikryption depikcrypt;
	private BufferedImage decrypture;
	protected static JFileChooser chooser;
	
	protected static int viewType = 0;
	private boolean typedInto;
	
	
	public PikGUI() {
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(215, 215, 215));
		
		fileMenu = new JMenu();
		about = new JMenuItem();
		save = new JMenuItem();
		saveAs = new JMenuItem();
		load = new JMenuItem();
		quit = new JMenuItem();
		
		viewMenu = new JMenu();
		view = new JMenuItem();
		
		center = new JPanel();
		south = new JPanel(new BorderLayout());
		setFrameNecesities();
		setComponents();
	}
	
	private void setFrameNecesities(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setHomeSize();
		this.setLayout(new BorderLayout());
		this.setTitle(TITLE);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e){
			e.printStackTrace();
		}
		
		about.setText("About");
		about.addActionListener(new EventAboutClick());
		save.setText("Save");
		save.addActionListener(new EventSave());
		saveAs.setText("Save As...");
		saveAs.addActionListener(new EventSaveAs());
		load.setText("Load From...");
		load.addActionListener(new EventLoad());
		quit.setText("Quit");
		quit.addActionListener(new EventQuitClick());
		
		view.setText("Home");
		view.addActionListener(new EventHome());

		fileMenu.setText("File");
		fileMenu.add(about);
		fileMenu.add(new JSeparator());
		fileMenu.add(save);
		fileMenu.add(saveAs);
		fileMenu.add(new JSeparator());
		fileMenu.add(load);
		fileMenu.add(new JSeparator());
		fileMenu.add(quit);
		
		viewMenu.setText("View");
		viewMenu.add(view);
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		
		this.add(menuBar, BorderLayout.NORTH);
		this.setLocationRelativeTo(null);
	}
	
	private void setComponents(){
		setImage();
		
		bottomRightButtonPanel = new JPanel();
		saveAfterGo = new JButton("Save As");
		saveAfterGo.addActionListener(new EventSaveAs());
		
		go = new JButton("Pikrypt!");
		go.addActionListener(new EventEncrypt());
		if (input == null){
			input = new JTextArea("Input Message To Be Pikrypted:");
		}
			
		input.setEditable(true);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setRows(3);
		input.addFocusListener(new HandleFocusEvent());
		
		inputPane = new JScrollPane(input);
		inputPane.setMinimumSize(new Dimension(400, 200));
		inputPane.setSize(new Dimension(400, 200));
		inputPane.setPreferredSize(new Dimension(400, 200));
		
		bottomRightButtonPanel.setLayout(new BorderLayout());
		bottomRightButtonPanel.add(go, BorderLayout.CENTER);
		bottomRightButtonPanel.add(saveAfterGo, BorderLayout.SOUTH);
		
		south.add(inputPane, BorderLayout.CENTER);
		south.add(bottomRightButtonPanel, BorderLayout.EAST);
		this.add(center, BorderLayout.CENTER);
		this.add(south, BorderLayout.SOUTH);
		center.setFocusable(true);
		center.addMouseListener(new FocusAway());
		this.setFocusable(true);
		this.addMouseListener(new FocusAway());
		this.pack();
		center.requestFocus();
	}

	private void setImage() {
		if (pikrypt == null) {
			
			Image tempImage = new BufferedImage(355, 355, BufferedImage.TYPE_INT_RGB);
			try {
				tempImage = ResourceLoader.loadTitle("Pikrypt_Title.png");
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
			pikrypt = new JLabel(new ImageIcon(tempImage));
		}
		center.add(pikrypt);
	}
	
	private void setImageAndIcon(){
		pikrypt = new JLabel(new ImageIcon(pikrypture.getImage()));
		center.add(pikrypt, BorderLayout.CENTER);
		
		Image temp = pikrypture.getImage().getScaledInstance(350, 350, Image.SCALE_FAST);
		pikrypt = new JLabel(new ImageIcon(temp));
		center.add(pikrypt, BorderLayout.EAST);
	}
	
	private void setDecryptImage(){
		center.removeAll();
		this.remove(center);
		Image tempImage = decrypture.getScaledInstance(350, 350, Image.SCALE_FAST);
		JLabel tempLabel = new JLabel(new ImageIcon(tempImage));
		
		center.add(tempLabel, BorderLayout.CENTER);
		this.add(center, BorderLayout.CENTER);

		center.repaint();
		center.revalidate();
	}
	
	private class HandleFocusEvent implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {
			if (viewType != 2) {
				if (input.getText() != "Input Message To Be Pikrypted:"
						&& !typedInto) {
					input.setText("");
					typedInto = true;
				}
			}
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			if (viewType != 2) {
				if (input.getText().length() <= 1 && typedInto) {
					input.setText("Input Message To Be Pikrypted:");
					typedInto = false;
				}
			}
		}
	}
	
	private class FocusAway implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			center.requestFocus();
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}

	private class EventHome implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setHomeSize();
			center.removeAll();
			pikrypt = null;
			pikrypture = null;
			decrypture = null;
			setImage();
			center.repaint();
			center.revalidate();
			input.setText("Input Message To Be Pikrypted:");
			setHomeView();
		}
	}

	private void setAwaySize() {
		this.setMaximumSize(null);
		this.setPreferredSize(null);
		this.setMinimumSize(null);
		this.repaint();
		this.revalidate();

		this.setSize(new Dimension(550, 625));
		this.setPreferredSize(new Dimension(550, 625));
		this.setMinimumSize(new Dimension(550, 625));
	}

	private void setHomeSize() {
		this.setMaximumSize(null);
		this.setPreferredSize(null);
		this.setMinimumSize(null);
		this.repaint();
		this.revalidate();

		this.setSize(new Dimension(550, 575));
		this.setPreferredSize(new Dimension(550, 575));
		this.setMinimumSize(new Dimension(550, 575));
	}



	/*////////////////////////////////////////////////////////////////
	//   _                     _   ______                           //   
	//  | |                   | | |  ____|                          //    
	//  | |     ___   __ _  __| | | |__ _ __ ___  _ __ ___          //    
	//  | |    / _ \ / _` |/ _` | |  __| '__/ _ \| '_ ` _ \         //    
	//  | |___| (_) | (_| | (_| | | |  | | | (_) | | | | | |_ _ _   // 
	//  |______\___/ \__,_|\__,_| |_|  |_|  \___/|_| |_| |_(_|_|_)  //  
	*/////////////////////////////////////////////////////////////////
	private class EventLoad implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//setAwaySize();
			chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(new File("D:/UA_Programming/Pikrypture"));
			int returnVal = chooser.showOpenDialog(center);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				Container frame = menuBar.getParent();
				JOptionPane.showMessageDialog(frame, "Depikrypting: "
								+ chooser.getSelectedFile().getName() + "  . . .");
				System.out.println("You chose to depikrypt the file: "
						+ chooser.getSelectedFile().getName());
				
				
				//				try{
//					Thread.sleep(1000);
//				}catch(Exception Exc){
//					
//				}
//				JOptionPane.setMessageDialog(frame, "Depikrypting: "
//								+ chooser.getSelectedFile().getName() + ".   . .");
//				System.out.println("You chose to depikrypt the file: "
//						+ chooser.getSelectedFile().getName());
//				try{
//					Thread.sleep(1000);
//				}catch(Exception Exc){
//					
//				}
//				JOptionPane.showMessageDialog(frame, "Depikrypting: "
//								+ chooser.getSelectedFile().getName() + ". .   .");
//				System.out.println("You chose to depikrypt the file: "
//						+ chooser.getSelectedFile().getName());
//				try{
//					Thread.sleep(1000);
//				}catch(Exception Exc){
//					
//				}
//				JOptionPane.showMessageDialog(frame, "Depikrypting: "
//								+ chooser.getSelectedFile().getName() + ". . .  ");
//				System.out.println("You chose to depikrypt the file: "
//						+ chooser.getSelectedFile().getName());
				
				try{
					decrypture = ImageIO.read(chooser.getSelectedFile());
					setDecryptImage();
				}catch(IOException ioException){
					System.out.println("That is not a valid action.");
				}
				depikcrypt = new Depikryption(decrypture);
				input.setText(depikcrypt.returnMessage());
				setDePikryptedView();
			}
		}
	}
	
	/*////////////////////////////////////////////////
	//   ______                             _       //    
	//  |  ____|                           | |      //   
	//  | |__   _ __   ___ _ __ _   _ _ __ | |_     //   
	//  |  __| | '_ \ / __| '__| | | | '_ \| __|    //   
	//  | |____| | | | (__| |  | |_| | |_) | |_     //   
	//  |______|_| |_|\___|_|   \__, | .__/ \__|    // 
	//                           __/ | |            //  
	//                          |___/|_|            //
	*/////////////////////////////////////////////////
	private class EventEncrypt implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			inputToEncrypt = input.getText();
			Container frame = menuBar.getParent();
			beginEncrypting();
			setAwaySize();
			drawPikrypture();
			if (pikrypture.getSuccess()) {
				JOptionPane.showMessageDialog(frame,
						"\tYour Pikryption was successful!");
				setEnPikryptedView();
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private void setEnPikryptedView(){
		this.viewType = 1;
	}
	@SuppressWarnings("static-access")
	private void setDePikryptedView(){
		this.viewType = 2;
	}
	@SuppressWarnings("static-access")
	private void setHomeView(){
		this.viewType = 0;	
	}
	
	
	
 /*///////////////////////////////////////////////////////////////////////////////
 //   _____      __                             __                              //
 //	/\  _ '\  __/\ \  _                        /\ \__  __                       //
 //	\ \ \_\ \/\_\ \ \/'\   _ __   __  __  _____\ \ ,_\/\_\    ____   _____      //
 //	 \ \ ,__/\/\ \ \ , <  /\`'__\/\ \/\ \/\ '__`\ \ \/\/\ \  / __'\ /' _ `\     //
 //	  \ \ \/  \ \ \ \ \\`\\ \ \/ \ \ \_\ \ \ \_\ \ \ \_\ \ \/\ \_\ \/\ \/\ \    //
 //    \ \_\   \ \_\ \_\ \_\ \_\  \/`____ \ \ ,__/\ \__\\ \_\ \____/\ \_\ \_\   // 
 //  	\/_/    \/_/\/_/\/_/\/_/   `/___/> \ \ \/  \/__/ \/_/\/___/  \/_/\/_/   // 
 //                                   /\___/\ \_\                               //
 //                                   \/__/  \/_/                               //
 ///////////////////////////////////////////////////////////////////////////////*/

	Enpikryption a;
	
	private void beginEncrypting() { // 4/6/15 changed
		System.out.println("about to thread");
		Thread t = new Thread(){
			public void run(){
				pikrypture = new Enpikryption(inputToEncrypt);
				pikrypture.beginEncrypting();
			}
		};
		t.start();
		pikrypture = a;
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("Join failed");
		}
	}

	public void drawPikrypture(){
		center.removeAll();
		this.remove(center);
		center = new JPanel(new BorderLayout());
		setImageAndIcon();
		this.add(center, BorderLayout.CENTER);
		center.revalidate();
		center.repaint();
	}                                                                                                                                                                                    //Intellectual Property of Theodore John Sackos
}                                                                                                                                                                                           //                  � 2015 Theodore John Sackos
