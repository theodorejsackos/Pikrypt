package eventListeners;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*//////////////////////////////////////////////
//    _____                                   //      
//   / ____|                     /\           //    
//  | (___   __ ___   _____     /  \   ___    //     
//   \___ \ / _` \ \ / / _ \   / /\ \ / __|   //     
//   ____) | (_| |\ V /  __/  / ____ \\__ \   //     
//  |_____/ \__,_| \_/ \___| /_/    \_\___/   //     
 *///////////////////////////////////////////////
public class EventSaveAs implements ActionListener {
	
	private JFileChooser chooser = PikGUI.chooser;
	
	public void actionPerformed(ActionEvent arg0) {
		if (PikGUI.viewType != 0) {
			chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"PNG Images", "png");
			chooser.setFileFilter(filter);
			chooser.setCurrentDirectory(null);
			chooser.setApproveButtonText("Save");
			int returnVal = chooser.showOpenDialog(PikGUI.center);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File outputfile = chooser.getSelectedFile();
				if (!outputfile.getName().contains(".png"))
					outputfile = new File("" + outputfile.toString() + ".png");
				try {
					RenderedImage pikryptedToGo = PikGUI.pikrypture.getImage();
					ImageIO.write(pikryptedToGo, "png", outputfile);
					Container frame = PikGUI.menuBar.getParent();
					JOptionPane.showMessageDialog(
							frame,
							"Your Pikrypture has been saved as: "
									+ outputfile.getName() + "\n In: "
									+ outputfile);
					System.out.println("Your Pikrypture has been saved as: "
							+ outputfile);
				} catch (IOException e1) {
					System.out.println("Save method not valid.");
				} catch (NullPointerException e2) {
					Container frame = PikGUI.menuBar.getParent();
					JOptionPane.showMessageDialog(frame,
							"You haven't yet generated a Pikrypted Message!");
					System.out
							.println("You haven't yet generated a Pikrypted Message!");
				}
			}
		} else {
			Container frame = PikGUI.menuBar.getParent();
			JOptionPane.showMessageDialog(frame,
					"You haven't yet generated a Pikrypted Message!");
		}

	}
}