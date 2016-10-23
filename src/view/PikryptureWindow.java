package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import eventListeners.EventAboutClick;
import eventListeners.EventQuitClick;
import eventListeners.EventSave;
import eventListeners.EventSaveAs;

public class PikryptureWindow extends JFrame{
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

	protected static JFileChooser chooser;
	
	protected static int viewType = 0;
	private boolean typedInto;
	
	
	public PikryptureWindow() {
		setFrameNecesities();
		setComponents();
	}

	
	private void setFrameNecesities(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setHomeSize();
		this.setLayout(new BorderLayout());
		this.setTitle("Pikrypt");
		
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
}
