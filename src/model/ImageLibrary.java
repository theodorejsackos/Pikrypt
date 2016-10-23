package model;

import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLibrary extends Observable{

	// Privates
	private BufferedImage cipherText;
	private String        plainText;
	
	// Publics
	private static ImageLibrary instance = null;
	
	// Constants
	private static final int SUPPORTED_CHARACTERS = 64;
	
	
	// Singleton constructor
	private ImageLibrary(){
		plainText  = null;
		cipherText = null;
	}
	
	/*
	 * Singleton Instance Constructor / Getter
	 */
	public static ImageLibrary getInstance(){
		if(instance == null)
			instance = new ImageLibrary();
		return instance;
	}
	
	/*
	 * Access methods
	 */
	public void setPlainText(String input){
		plainText = input;
		setChanged();
		notifyObservers();
	}
	
	public void setCipherText(BufferedImage pikrypture){
		cipherText = pikrypture;
		setChanged();
		notifyObservers();
	}
	
	public String getPlainText(){
		return plainText;
	}
	
	public BufferedImage getCipherText(){
		return cipherText;
	}
	
	public JLabel getCipherLabel(){
		return new JLabel(new ImageIcon(cipherText));
	}
	
	public int getNumberOfSupportedCharacters(){
		return SUPPORTED_CHARACTERS;
	}
}
