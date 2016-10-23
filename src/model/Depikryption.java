package model;




import java.awt.Color;
import java.awt.image.BufferedImage;

public class Depikryption {
	private BufferedImage encrypted;
	private final int CHARACTERS = PikGUI.NUM_OF_CHAR_CODES;
	private CryptoLetter[] LETTERS = new CryptoLetter[CHARACTERS];
	private boolean[][] isAlreadyVisited;

	private int x;
	private int y;
	private int nextX;
	private int nextY;

	private String message = "";
	private boolean continueDecrypting = true;
	
	public Depikryption(BufferedImage encryptedPicture) {
		this.encrypted = encryptedPicture;
		initializeLetters();
		beginDecrypting();
	}

	private void initializeLetters() {
		isAlreadyVisited = new boolean[encrypted.getHeight()][encrypted.getWidth()];
				
		Color first = getPixel(0, 0);
		nextX = first.getRed();
		nextY = first.getGreen();

		int incriment = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				for (int k = 0; k <= 3; k++) {
					getPointerPixel();
					this.x = nextX;
					this.y = nextY;
					Color tempColor = getCenterPixel();
					//CryptoLetter tempCrypto = new CryptoLetter(tempColor.getRed() % 3,
					//						 				   tempColor.getGreen() % 3,
					//						 				   tempColor.getBlue() % 3);
					CryptoLetter tempCrypto = new CryptoLetter(i, j, k);
					tempColor = getLetterPixel();
					tempCrypto.setMoorseByInt(tempColor.getRGB());
					char tempChar = tempCrypto.getMoorse();
					tempCrypto.setLetter(tempChar);
					//System.out.println("{" + x + ", " + y + "}");
					LETTERS[incriment] = tempCrypto;
					incriment++;
					//System.out.println("{" + x + ", " + y + "}");
					//System.out.println(tempCrypto);
				}
			}
		}
		//testIfItWorked();
	}
	
	@SuppressWarnings("unused")
	private void testIfItWorked(){
		for(int i = 0; i < CHARACTERS; i++){
			System.out.println(LETTERS[i]);
			
		}
	}

	private Color getPixel(int xcoord, int ycoord) {
		int i = encrypted.getRGB(xcoord, ycoord);
		isAlreadyVisited[ycoord][xcoord] = true;
		//System.out.println(new Color(i));
		return new Color(i);
	}
	
	//LEFT PIXEL IN 3 PIXEL LETTER BLOCKS
	private Color getLetterPixel(){
		int i = encrypted.getRGB(x - 1, y);
		isAlreadyVisited[y][x - 1] = true;
		//System.out.println(new Color(i));
		return new Color(i);
	}
	
	//CENTER PIXEL IN 3 PIXEL LETTER BLOCKS
	private Color getCenterPixel(){
		//System.out.println("(" + x + ", " + y + ")");
		int i = encrypted.getRGB(x, y);
		isAlreadyVisited[y][x] = true;
		//System.out.println(new Color(i));
		return new Color(i);
	}
	
	//SETS X/Y ACCORDING TO RIGHT PIXEL IN 3 PIXEL LETTER BLOCKS
	private void getPointerPixel(){
		int i;
		if(x != 0 && y != 0){
			i = encrypted.getRGB(x + 1, y);
			isAlreadyVisited[y][x + 1] = true;
		}else{
			i = encrypted.getRGB(x , y);
			isAlreadyVisited[y][x] = true;
		}
		Color temp = new Color(i);
		if (y % 3 == 0 ){
			nextX = temp.getRed();
			nextY = temp.getGreen();
		}
		else if (y % 3 == 1 ) {
			nextX = temp.getRed();
			nextY = temp.getBlue();
		}
		else if (y % 3 == 2 ) {
			nextX = temp.getGreen();
			nextY = temp.getBlue();
		}
	}
	
	private void beginDecrypting(){
		for(int i = 0; i < encrypted.getWidth(); i++){
			for(int j = 0; j < encrypted.getHeight(); j++){
				if (!isAlreadyVisited[i][j] && continueDecrypting) {
					Color tempColor = new Color(encrypted.getRGB(j,  i));
					int first = tempColor.getRed() % 4;
					int second = tempColor.getGreen() % 4;
					int third = tempColor.getBlue() % 4;
					//System.out.println(first + " " + second + " " + third);
					char toAdd = getCharacter(first, second, third);
					if(toAdd == '\0')
						message += "";
					else message += toAdd;
					
				}
			}
		}
		//System.out.println(message);
	}
	
	private boolean capitalizeNext = false;
	private boolean fullStop = false;
	private char getCharacter(int num1, int num2, int num3){
		CryptoLetter tempCrypt;
		char toReturn;
		for(int i = 0; i < CHARACTERS; i++){
			tempCrypt = LETTERS[i];
			if(		tempCrypt.getFirst()  == num1 && 
					tempCrypt.getSecond() == num2 &&
					tempCrypt.getThird()  == num3){
				toReturn = LETTERS[i].getCharacter();
				if(toReturn == 'U'){
					capitalizeNext = true;
					return '\0';
				}
				if(toReturn == '�' || fullStop){
					fullStop = true;
					return '\0';
				}
					
				if(capitalizeNext){
					capitalizeNext = false;
					return Character.toUpperCase(toReturn);
				}else return toReturn;
			}

		}
		return '*';
	}

	public String returnMessage(){
		return message;
	}
}
