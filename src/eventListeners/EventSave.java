package eventListeners;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*//////////////////////////////
// 	  _____                   //  
//	 / ____|                  //   
//	| (___   __ ___   _____   //    
//	 \___ \ / _` \ \ / / _ \  //   
//	 ____) | (_| |\ V /  __/  //     
//	|_____/ \__,_| \_/ \___|  //      
*///////////////////////////////
	public class EventSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File outputfile = new File("output.png");
			boolean nullSave = false;
			try {
				RenderedImage pikryptedToGo = PikGUI.pikrypture.getImage();
				ImageIO.write(pikryptedToGo, "png", outputfile);
				System.out.println("Your Pikrypture has been saved as: "
						+ outputfile);
			} catch (NullPointerException e2) {
				Container frame = PikGUI.menuBar.getParent();
				JOptionPane.showMessageDialog(frame,
						"You haven't yet generated a Pikrypted Message!");
				nullSave = true;
				// System.out.println("You haven't yet generated a Pikrypted Message!");
			} catch (IOException e1) {
				System.out.println("Save method not valid.");
			}
			Container frame = PikGUI.menuBar.getParent();
			if (!nullSave)
				JOptionPane.showMessageDialog(frame,
						"Your Pikrypture has been saved as: " + outputfile);

		}
	}