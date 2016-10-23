package eventListeners;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// GUI Is immediately closed. No failsafe! No "Are you sure?" Do I need one!?!?
public class EventQuitClick implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Container frame = PikGUI.menuBar.getParent();
		if (JOptionPane.showConfirmDialog(frame,
				"Are you sure you want to quit?", "Quit?",
				JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
		else {
		}
	}
}