package eventListeners;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//Opens the 'About' dialogue box with program info and � info.
public class EventAboutClick implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Container frame = PikGUI.menuBar.getParent();
		JOptionPane.showMessageDialog(frame,
								  "This is an encryption and decryption client"
								+ "\n"
								+ "\n"
								+ "(c) 2015 Theodore Sackos."
								+ "\n"
								+ "Version: \t" + PikGUI.serialVersionUID);
	}
}