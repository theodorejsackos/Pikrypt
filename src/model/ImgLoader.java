package model;
import java.awt.Image;
import java.awt.Toolkit;

public class ImgLoader {

	static ImgLoader rl = new ImgLoader();
	
	public static Image loadTitle(String fileName){
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("Images/" + fileName));
		
	}
}
