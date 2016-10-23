package model;




import java.awt.Color;

public class CryptoLetter {
	private int first; // PREVIOUSLY IMPLEMENTED AS A FINAL INT (Changed Feb
						// 28th, 2:15pm)
	private int second; // PREVIOUSLY IMPLEMENTED AS A FINAL INT (Changed Feb
						// 28th, 2:15pm)
	private int third; // PREVIOUSLY IMPLEMENTED AS A FINAL INT (Changed Feb
						// 28th, 2:15pm)
	private char letter;
	private Color c;

	// DOTS ARE EVEN DASHES ARE ODD
	// End (0)
	//  .  (2, 4, 6, 8, A, C, E)
	// --- (1, 3, 5, 7, 9, B, D, F)
	private int moorse1;
	private int moorse2;
	private int moorse3;
	private int moorse4;
	private int moorse5;

	public CryptoLetter(char a) {
		this.letter = a;
		setMoorse(a);
	}

	public CryptoLetter(int fir, int sec, int thrd) {
		this.first = fir;
		this.second = sec;
		this.third = thrd;
	}

	public CryptoLetter(int fir, int sec, int thir, int m1, int m2, int m3,
			int m4) {
		this.first = fir;
		this.second = sec;
		this.third = thir;
		this.moorse1 = m1;
		this.moorse2 = m2;
		this.moorse3 = m3;
		this.moorse4 = m4;
	}

	public void setFirst(int i) {
		this.first = i;
	}

	public void setSecond(int i) {
		this.second = i;
	}

	public void setThird(int i) {
		this.third = i;
	}

	public int getFirst() {
		return this.first;
	}

	public int getSecond() {
		return this.second;
	}

	public int getThird() {
		return this.third;
	}

	public String getCode() {
		return "" + first + second + third;
	}

	public void setColor(Color c) {
		this.c = c;
	}

	public Color getColor() {
		return this.c;
	}

	public void setLetter(char a) {
		letter = a;
	}

	public char getCharacter() {
		return letter;
	}

	public int getMoorse1() {
		return this.moorse1;
	}

	public int getMoorse2() {
		return this.moorse2;
	}

	public int getMoorse3() {
		return this.moorse3;
	}

	public int getMoorse4() {
		return this.moorse4;
	}
	public int getMoorse5() {
		return this.moorse5;
	}


	public void setMoorse1(int i) {
		this.moorse1 = i;
	}

	public void setMoorse2(int i) {
		this.moorse2 = i;
	}

	public void setMoorse3(int i) {
		this.moorse3 = i;
	}

	public void setMoorse4(int i) {
		this.moorse4 = i;
	}
	
	public void setMoorse5(int i) {
		this.moorse5 = i;
	}

	public int getMoorseInt() {// throws java.lang.Exception{
		long myHex = 0x000000;
		
		myHex += moorse5 << 0;
		myHex += moorse4 << 4;
		myHex += moorse3 << 8;
		myHex += moorse2 << 12;
		myHex += moorse1 << 16;
		myHex += ((int) (Math.random() * 14) + 1) << 20;
		
		return (int) myHex;
	}

	public void setMoorseByInt(int i) {
		String temp = Integer.toHexString(i);
		
		moorse1 = Character.getNumericValue(temp.charAt(3));
		moorse2 = Character.getNumericValue(temp.charAt(4));
		moorse3 = Character.getNumericValue(temp.charAt(5));
		moorse4 = Character.getNumericValue(temp.charAt(6));
		moorse5 = Character.getNumericValue(temp.charAt(7));
	}

	public void setMoorse(char a) {
		switch (a) {
		case 'a':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'b':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'c':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'd':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'e':
			moorse1 = createEven();
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'f':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'g':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'h':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'i':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'j':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case 'k':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'l':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'm':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'n':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'o':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'p':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case 'q':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case 'r':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 's':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 't':
			moorse1 = createOdd();
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'u':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'v':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case 'w':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = 0;
			moorse5 = 0;
			break;
		case 'x':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case 'y':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case 'z':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case ' ':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = 0;
			break;
		case '0':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '1':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '2':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '3':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '4':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '5':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createEven();
			break;
		case '6':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createEven();
			break;
		case '7':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createEven();
			break;
		case '8':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = createEven();
			break;
		case '9':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case 'U':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '\n':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '\t':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '\'':
			moorse1 = createEven();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '\"':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case ',':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = createEven();
			break;
		case '.':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '?':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '!':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case ':':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case ';':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '<':
			moorse1 = createOdd();
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '>':
			moorse1 = createEven();
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case '@':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = 0;
			break;
		case '#':
			moorse1 = createOdd();
			moorse2 = createOdd();
			moorse3 = createOdd();
			moorse4 = createEven();
			moorse5 = 0;
			break;
		case '$':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = createOdd();
			break;
		case '%':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '^':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '&':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '*':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '(':
			moorse1 = 0;
			moorse2 = createEven();
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case ')':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '+':
			moorse1 = 0;
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createOdd();
			moorse5 = createOdd();
			break;
		case '=':
			moorse1 = 0;
			moorse2 = createEven();
			moorse3 = createEven();
			moorse4 = createEven();
			moorse5 = createOdd();
			break;
		case '-':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '_':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = createOdd();
			moorse4 = createOdd();
			moorse5 = createEven();
			break;
		case '�':
			moorse1 = 0;
			moorse2 = 0;
			moorse3 = 0;
			moorse4 = 0;
			moorse5 = createEven();
			break;
		}
		// System.out.println("{" + moorse1 + ", " + moorse2 + ", " + moorse3 +
		// ", " + moorse4 + "}");
	}

	public void setMoorse(int unit1, int unit2, int unit3, int unit4, int unit5) {
		moorse1 = unit1;
		moorse2 = unit2;
		moorse3 = unit3;
		moorse4 = unit4;
		moorse5 = unit5;
	}

	public char getMoorse() {
		//System.out.println("0xF(" + moorse1 + moorse2 + moorse3 + moorse4 + moorse5 + ")");
		
		String hexRep = Integer.toHexString(getMoorseInt());
		System.out.println(hexRep);
		
		if((this.moorse1 % 2 == 0 && moorse1 != 0) || (hexRep.charAt(1) == 'A' || hexRep.charAt(1) == 'C' || hexRep.charAt(1) == 'E'))
			this.moorse1 = 2;
		if(this.moorse1 % 2 == 1 || (hexRep.charAt(1) == 'B' || hexRep.charAt(1) == 'D' || hexRep.charAt(1) == 'F'))
			this.moorse1 = 1;
		
		if((this.moorse2 % 2 == 0 && moorse2 != 0) || (hexRep.charAt(2) == 'A' || hexRep.charAt(2) == 'C' || hexRep.charAt(2) == 'E'))
			this.moorse2 = 2;
		if(this.moorse2 % 2 == 1 || (hexRep.charAt(2) == 'B' || hexRep.charAt(2) == 'D' || hexRep.charAt(2) == 'F'))
			this.moorse2 = 1;
		
		if((this.moorse3 % 2 == 0 && moorse3 != 0) || (hexRep.charAt(3) == 'A' || hexRep.charAt(3) == 'C' || hexRep.charAt(3) == 'E'))
			this.moorse3 = 2;
		if(this.moorse3 % 2 == 1 || (hexRep.charAt(3) == 'B' || hexRep.charAt(3) == 'D' || hexRep.charAt(3) == 'F'))
			this.moorse3 = 1;
		
		if((this.moorse4 % 2 == 0 && moorse4 != 0) || (hexRep.charAt(4) == 'A' || hexRep.charAt(4) == 'C' || hexRep.charAt(4) == 'E'))
			this.moorse4 = 2;
		if(this.moorse4 % 2 == 1 || (hexRep.charAt(4) == 'B' || hexRep.charAt(4) == 'D' || hexRep.charAt(4) == 'F'))
			this.moorse4 = 1;
		
		if((this.moorse5 % 2 == 0 && moorse5 != 0) || (hexRep.charAt(5) == 'A' || hexRep.charAt(5) == 'C' || hexRep.charAt(5) == 'E'))
			this.moorse5 = 2;
		if(this.moorse5 % 2 == 1 || (hexRep.charAt(5) == 'B' || hexRep.charAt(5) == 'D' || hexRep.charAt(5) == 'F'))
			this.moorse5 = 1;
		
		//System.out.println("0xF(" + moorse1 + moorse2 + moorse3 + moorse4 + moorse5 + ")");
		//System.out.println();
		
		// Front filled back not *
		if(moorse1 != 0 && moorse5 == 0){
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 0 && moorse3 == 0)
				return 'a';
			if (moorse1 == 2 && moorse2 == 0)
				return 'e';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 1 && moorse4 == 2 && moorse4 != 0 && moorse5 == 0)
				return 'f';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse3 != 0 && moorse4 != 0 && moorse5 == 0)
				return 'h';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 0)
				return 'i';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 1 && moorse4 == 1 && moorse5 == 0)
				return 'j';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 2 && moorse4 == 2 && moorse5 == 0)
				return 'l';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 1 && moorse4 != 0 && moorse5 == 0)
				return 'p';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 2 && moorse4 == 0 && moorse5 == 0)
				return 'r';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 0 && moorse5 == 0)
				return 's';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 1 && !(moorse4 > 0) && moorse5 == 0)
				return 'u';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 0 && !(moorse5 > 0))
				return 'v';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 1 && moorse4 == 0 && moorse5 == 0)
				return 'w';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 0)
				return '>';
		}
		
		// Front filled back not -
		if(moorse1 != 0 && moorse5 == 0){
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse3 != 0 && moorse2 != 0 && moorse4 != 0 && moorse5 == 0)
				return 'b';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 2 && moorse4 != 0 && moorse5 == 0)
				return 'c';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 0 && moorse3 != 0 && moorse5 == 0)
				return 'd';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 0 && moorse3 != 0 && moorse5 == 0)
				return 'g';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 0 && moorse5 == 0)
				return 'k';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 0 && moorse4 == 0 && moorse5 == 0)
				return 'm';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 0 && moorse4 == 0 && moorse2 != 0 && moorse5 == 0)
				return 'n';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 1 && moorse4 == 0 && moorse5 == 0)
				return 'o';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 1 && moorse5 == 0)
				return 'q';
			if (moorse1 == 1 && moorse2     == 0 && moorse3 == 0 && moorse4 == 0 && moorse5 == 0)
				return 't';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 0)
				return 'x';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 0)
				return 'y';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 2 && moorse5 == 0)
				return 'z';
			if (moorse2 == 1 && moorse3 == 1 && moorse4 == 1 && moorse5 == 0)
				return '@';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 1 && moorse4 == 2 && moorse5 == 0)
				return '#';
		}
		
		// all 5 full *
		if(moorse1 != 0 && moorse5 != 0){
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 1 && moorse4 % 2== 0 && moorse5 == 1)
				return 'U';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 2)
				return '\n';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return '\t';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 2 && moorse4 == 1 && moorse5 == 2)
				return '\'';
			if (moorse1 == 2 && moorse2 == 1 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '1';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '2';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return '3';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse5 == 1)
				return '4';
			if (moorse1 == 2 && moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse5 == 2)
				return '5';
		}
		
		// all 5 full -
		if(moorse1 != 0 && moorse5 != 0){
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '\"';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 2 && moorse5 == 2)
				return ',';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 2 && moorse5 == 1)
				return '.';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 1 && moorse5 == 2)
				return '?';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return '!';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 2)
				return ':';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return ';';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 2)
				return '<';
			if (moorse1 == 1 && moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse5 == 2)
				return '6';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 2 && moorse4 == 2 && moorse5 == 2)
				return '7';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 1 && moorse4 == 2 && moorse5 == 2)
				return '8';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 1 && moorse4 == 1 && moorse5 == 2)
				return '9';
			if (moorse1 == 1 && moorse2 == 1 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '0';
		}
		
		// front empty back not *
		if(moorse1 == 0 && moorse5 != 0){
			if (moorse2 == 0 && moorse3 == 0 && moorse4 == 0 && moorse5 == 1)
				return '$';
			if (moorse2 == 0 && moorse3 == 0 && moorse4 == 1 && moorse5 == 1)
				return '%';
			if (moorse2 == 0 && moorse3 == 0 && moorse4 == 2 && moorse5 == 1)
				return '&';
			if (moorse2 == 0 && moorse3 == 0 && moorse4 == 1 && moorse5 == 2)
				return '-';
			if (moorse2 == 0 && moorse3 == 0 && moorse4 == 0 && moorse5 == 2 && moorse5 != 0)
				return '�';
			if (moorse2 == 0 && moorse3 == 1 && moorse4 == 1 && moorse5 == 2)
				return '_';
		}
		
		// front empty back not -
		if(moorse1 == 0 && moorse5 != 0){
			if (moorse2 == 2 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return '+';
			if (moorse2 == 2 && moorse3 == 2 && moorse4 == 2 && moorse5 == 1)
				return '=';
			if (moorse2 == 2 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '(';
			if (moorse2 == 0 && moorse3 == 1 && moorse4 == 1 && moorse5 == 1)
				return '^';
			if (moorse2 == 0 && moorse3 == 2 && moorse4 == 1 && moorse5 == 1)
				return '*';
			if (moorse2 == 0 && moorse3 == 2 && moorse4 == 2 && moorse5 == 1)
				return ')';
		}
		
		if (moorse1 == 0 && moorse2 == 0 && moorse3 == 0 && moorse4 == 0 && moorse5  == 0)
			return ' ';
		
		return '~';
	}

	private int[] hexLetters = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xA, 0xB, 0xC, 0xD, 0xE, 0xF};
	private int createEven() {
		int temp;
		do {
			temp = (int) (Math.random() * 13);
		} while (temp % 2 != 0);
		return hexLetters[temp + 2];

	}
	private int createOdd() {
		int temp;
		do {
			temp = (int) (Math.random() * 15);
		} while (temp % 2 != 0);
		return hexLetters[temp + 1];
	}

	public String toString() {
		return "{" + first + ", " + second + ", " + third + "} " + letter;
	}

	/*
	 * @SuppressWarnings("unused") public static void main(String[] args){
	 * //CryptoLetter test = new CryptoLetter(0, 0, 0, 5, 2, 2, 5);
	 * //System.out.println(test.getMoorse()); //String one = "FF"; //String two
	 * = "2569"; //String three = one + two;
	 * //System.out.println(Integer.parseInt(three, 16)); int temp =
	 * 508408;//Integer.parseInt(three, 16);
	 * System.out.println(test.getMoorseInt());
	 * System.out.println(test.getHexString(test.getMoorseInt()));
	 * 
	 * }
	 */
}