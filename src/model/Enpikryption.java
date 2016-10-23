package model;



import java.awt.Color;
import java.awt.image.BufferedImage;


public class Enpikryption{
	private BufferedImage pikrypted;
	private int nextX = 0;
	private int nextY = 0;
	private int currentX = 0;
	private int currentY = 0;
	private int sideLength;
	private boolean[] isInitialized;
	private final int CHARACTERS = PikGUI.NUM_OF_CHAR_CODES;
	private CryptoLetter[] KEY = new CryptoLetter[CHARACTERS];
	//private char[] KEY_Letter = new char[CHARACTERS];
	private boolean[][] isAlreadyAssigned;
	private String inputToEncrypt;
	private boolean success = true;
	private final char[] lowercase = { 'a' , 'b', 'c', 'd', 'e', 'f', 'g', 'h' , 'i' , 'j' ,
				  	 		   		   'k' , 'l', 'm', 'n', 'o', 'p', 'q', 'r' , 's' , 't' , 'u',
									   'v' , 'w', 'x', 'y', 'z', ' ', 'U', '\n', '\t', '\'',
									   '\"', ',', '.', '?', '!', '<', '>', ';' , ':' , '@' , '#',
									   '$' , '%', '^', '&', '*', '(', ')', '0' , '1' , '2' , '3', 
									   '4' , '5', '6', '7', '8', '9', '+', '=' , '-' , '_' , '�'};
	
	public Enpikryption(String s) {
		inputToEncrypt = s;
		isInitialized = new boolean[CHARACTERS];

		int incriment = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				for (int k = 0; k <= 3; k++) {
					int atIndex = (int) (Math.random() * CHARACTERS);
					while (isInitialized[atIndex]) {
						atIndex++;
						if (atIndex > CHARACTERS - 1)
							atIndex = 0;
					}
					CryptoLetter currentLetter = new CryptoLetter(i, j, k);
					currentLetter.setLetter(lowercase[atIndex]);
					KEY[incriment] = currentLetter;
					//KEY_Letter[incriment] = lowercase[atIndex];
					currentLetter.setColor(getKeyColor(currentLetter));
					
					incriment++;
					isInitialized[atIndex] = true;
				}
			}
		}
		//testIfItWorked();
	}
	
	// BOMB DOT COM
	@SuppressWarnings("unused")
	private void testIfItWorked() {
		for (int i = 0; i < CHARACTERS; i++) {
			System.out.println(KEY[i]);
		}
	} 
	
	// BOMB DOT COM
	protected void beginEncrypting() {
		int stringLength = inputToEncrypt.length() + countExtraCharacters();
		sideLength = ((int) Math.sqrt(stringLength)) + 1;
		
		if(inputToEncrypt.length() <= 60) sideLength = 18;
		
		//System.out.println("Calculated Image Size!");
		
		pikrypted = new BufferedImage(sideLength, sideLength, BufferedImage.TYPE_INT_RGB);
		isAlreadyAssigned = new boolean[sideLength][sideLength];
		System.out.println("Created Image of Size!");
		
		
		impressKey();
		//System.out.println("Impressed Key!");
		impressMessage();
		//System.out.println("Impressed Message!");
	}

	private int countExtraCharacters(){
		int numExtra = 192;
		for(int i = 0; i < inputToEncrypt.length(); i++){
			char character = inputToEncrypt.charAt(i);
			if(Character.isUpperCase(character)){
				numExtra++;
			}
		}
		System.out.println(numExtra);
		return numExtra;
	}
	
/*//////////////////////////////////////////////////////////
//   _                                   _  __            //
//  (_)                                 | |/ /            //   
//   _ _ __ ___  _ __  _ __ ___  ___ ___| ' / ___ _   _   //  
//  | | '_ ` _ \| '_ \| '__/ _ \/ __/ __|  < / _ \ | | |  //    
//  | | | | | | | |_) | | |  __/\__ \__ \ . \  __/ |_| |  //  
//  |_|_| |_| |_| .__/|_|  \___||___/___/_|\_\___|\__, |  //  
//              | |                                __/ |  //    
//              |_|                               |___/   //   
*///////////////////////////////////////////////////////////
//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM        //
//THE FOLLOWING UNTIL impressMessage(), IS THE impressKey() LOGICAL CODE BLOCK: 
//Handles the impression of the 64 characters in blocks of 1(down)x3(across) to the pikrypt image
//  ____________    ___________    _____________          //   
// |LETTER EN-  |  |   THREE   |  | NEXT LETTER |         //
// |CODED IN THE|  | DIGIT LET-|  |BLOCK CENTER |         //     
// |RGB INT(HEX)|  | TER CODE  |  |   LOCATION  |         //    
// *------------*  *-----------*  *-------------*         // 
////////////////////////////////////////////////////////////
	
	// BOMB DOT COM
	private void impressKey() {
		currentX = 0;
		currentY = 0;
		newRandomCoordinate();
		Color pointerPixel = getPointerPixelColor(nextX, nextY);
		drawPixel(currentX, currentY, pointerPixel);
		currentX = nextX;
		currentY = nextY;
		
		for (int i = 0; i < KEY.length; i++) {
			drawPixel(currentX, currentY, KEY[i].getColor());
			char tempChar = KEY[i].getCharacter();
			//System.out.println(tempChar);
			KEY[i].setMoorse(tempChar);
			//System.out.println(KEY[i].getCharacter() + " " + KEY[i].getMoorse());
			int moorseInt = KEY[i].getMoorseInt();
			drawPixel(currentX - 1, currentY, new Color(moorseInt));

			if(i != KEY.length - 1){
				newRandomCoordinate();
				pointerPixel = getPointerPixelColor(nextX, nextY);
				drawPixel(currentX + 1, currentY, pointerPixel);
			}
			currentX = nextX;
			currentY = nextY;
		}
	}
	
	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private void newRandomCoordinate() {
		do {
			nextX = (int) (Math.random() * (sideLength - 2)) + 1;
			nextY = (int) (Math.random() * (sideLength - 2)) + 1;
		} while (	isAlreadyAssigned[nextY][nextX - 1]
				 || isAlreadyAssigned[nextY][nextX]
				 || isAlreadyAssigned[nextY][nextX + 1]);
	}
	
	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	@SuppressWarnings("unused")
	private void printisAlreadyAssigned() {
		for (int i = 0; i < sideLength; i++) {
			for (int j = 0; j < sideLength; j++) {
				if (isAlreadyAssigned[i][j])
					System.out.print("X ");
				if (!isAlreadyAssigned[i][j])
					System.out.print("O ");
			}
			System.out.println();
		}
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private boolean drawPixel(int xcoord, int ycoord, Color c) {
		if ((xcoord < sideLength && xcoord >= 0)
				&& (ycoord < sideLength && ycoord >= 0)
				&& !isAlreadyAssigned[ycoord][xcoord]) {
			isAlreadyAssigned[ycoord][xcoord] = true;
			pikrypted.setRGB(xcoord, ycoord, c.getRGB());
			return true;
		} else
			return false;
	}
	
	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	public String getHexString(int rgb){
		return ("0x" + Long.toHexString(rgb));
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private Color getKeyColor(CryptoLetter letter) {
		int r = 0;
		int g = 0;
		int b = 0;
		if (letter.getFirst() == 0)  { r = create0(); }
		if (letter.getFirst() == 1)  { r = create1(); }
		if (letter.getFirst() == 2)  { r = create2(); }
		if (letter.getFirst() == 3)  { r = create3(); }

		if (letter.getSecond() == 0) { g = create0(); }
		if (letter.getSecond() == 1) { g = create1(); }
		if (letter.getSecond() == 2) { g = create2(); }
		if (letter.getSecond() == 3) { g = create3(); }
		
		if (letter.getThird() == 0)  { b = create0(); }
		if (letter.getThird() == 1)  { b = create1(); }
		if (letter.getThird() == 2)  { b = create2(); }
		if (letter.getThird() == 3)  { b = create3(); }
		
		return new Color(r, g, b);
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private Color getPointerPixelColor(int xCoord, int yCoord) {
		Color pointerColor = null;
		int RANDOM = (int) (Math.random() * 200) + 55;
		if (currentY % 3 == 0 ){//){|| (currentX == 0 && currentY == 0)) {
			pointerColor = new Color(xCoord, yCoord, RANDOM);
			//System.out.println(yCoord % 3 + " and This is case 1" + "{" + xCoord + ", " + yCoord + "}");
		}
		if (currentY % 3 == 1 ){//)&& (currentX != 0 && currentY != 0)) {
			pointerColor = new Color(xCoord, RANDOM, yCoord);
			//System.out.println(yCoord % 3 + " and This is case 2" + "{" + xCoord + ", " + yCoord + "}");
		}
		if (currentY % 3 == 2 ){//&& (currentX != 0 && currentY != 0)) {
			pointerColor = new Color(RANDOM, xCoord, yCoord);
			//System.out.println(yCoord % 3 + " and This is case 3" + "{" + xCoord + ", " + yCoord + "}");
		}
		return pointerColor;
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private int create0() {
		int temp;
		do {
			temp = (int) (Math.random() * 256);
		} while (temp % 4 != 0);
		return temp;
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private int create1() {
		int temp;
		do {
			temp = (int) (Math.random() * 256);
		} while (temp % 4 != 1);
		return temp;
	}

	//THIS CODE TO THE BEST OF MY KNOWLEGE IS BOMB.COM
	private int create2() {
		int temp;
		do {
			temp = (int) (Math.random() * 256);
		} while (temp % 4 != 2);
		return temp;
	}
	
	private int create3() {
		int temp;
		do {
			temp = (int) (Math.random() * 256);
		} while (temp % 4 != 3);
		return temp;
	}
	
	
/*
 _                                   __  __                                
(_)                                 |  \/  |                               
 _ _ __ ___  _ __  _ __ ___  ___ ___| \  / | ___  ___ ___  __ _  __ _  ___ 
| | '_ ` _ \| '_ \| '__/ _ \/ __/ __| |\/| |/ _ \/ __/ __|/ _` |/ _` |/ _ \
| | | | | | | |_) | | |  __/\__ \__ \ |  | |  __/\__ \__ \ (_| | (_| |  __/
|_|_| |_| |_| .__/|_|  \___||___/___/_|  |_|\___||___/___/\__,_|\__, |\___|
            | |                                                  __/ |     
            |_|                                                 |___/ 
 */
	
	private void impressMessage() {
		char tempChar;
		int characterIndex = 0;
		boolean makeLowerCase = false;
		boolean endMessage    = true;
		for (int i = 0; i < sideLength; i++) {
			for (int j = 0; j < sideLength; j++) {
				try {
					printNonUpperCases:
					if (!isAlreadyAssigned[i][j]) {
						tempChar = inputToEncrypt.charAt(characterIndex);
						if(makeLowerCase){
							tempChar = Character.toLowerCase(tempChar);
							makeLowerCase = false;
						}
						CryptoLetter tempCryptLetter;
						if(Character.isUpperCase(tempChar)){
							tempCryptLetter = new CryptoLetter('U');
                            tempCryptLetter = matchLetterCode(tempCryptLetter);
                            Color c = getKeyColor(tempCryptLetter);
                            if(!drawPixel(j, i, c))
                            	success = false;
                            makeLowerCase = true;
							break printNonUpperCases;
						}else{
							tempCryptLetter = new CryptoLetter(tempChar);
                            tempCryptLetter = matchLetterCode(tempCryptLetter);
                            Color c = getKeyColor(tempCryptLetter);
                            if(!drawPixel(j, i, c))
                            	success = false;
                            characterIndex++;
						}

					}//end if already assigned
					
				} catch (IndexOutOfBoundsException e) {
					if(endMessage){
						CryptoLetter tempCryptLetter = new CryptoLetter('�');
                        tempCryptLetter = matchLetterCode(tempCryptLetter);
                        Color c = getKeyColor(tempCryptLetter);
                        if(!drawPixel(j, i, c))
                        	success = false;
						endMessage = false;
					}else
						if(!drawPixel(j, i, getRandomColor()))
							success = false;;
					
					
				}//end catch block
				
			}//end inner for loop
		}//end outer for loop
		
		
		
		System.out.println("Pikryption: SUCCESSFUL");
	}
	
	private Color getRandomColor(){
		Color c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		return c;
	}

	private CryptoLetter matchLetterCode(CryptoLetter temp) {
		for(int i = 0; i < CHARACTERS; i++){
			if(KEY[i].getCharacter() == temp.getCharacter()){
				temp.setFirst (KEY[i].getFirst());
				temp.setSecond(KEY[i].getSecond());
				temp.setThird (KEY[i].getThird());
				//System.out.println(KEY[i].getFirst() + " " + KEY[i].getSecond() + " " + KEY[i].getThird());
				//System.out.println(temp.getFirst() + " " + temp.getSecond() + " " + temp.getThird());
			}
		}
		return temp;
	}
	
	public boolean getSuccess(){
		return this.success;
	}
	
	public BufferedImage getImage(){
		return pikrypted;
	}
}
