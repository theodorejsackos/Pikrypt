import java.awt.Image;
import java.awt.Toolkit;

public class ResourceLoader {

	static ResourceLoader rl = new ResourceLoader();
	
	public static Image loadTitle(String fileName){
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("Images/" + fileName));
		
	}
}
