package Album;

import javax.swing.JOptionPane;

public class SlideShow extends javax.swing.JFrame {
	Album a;

	public SlideShow(Album a) {
		this.a = a;
		try {
			if (a.pics.size() == 0)
				throw new NoPicsException();
			else {
				ViewAll viewAll = new ViewAll(this, a);
				viewAll.setVisible(true);
				this.dispose();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			a.setVisible(true);
			this.dispose();
		}
	}
}

class NoPicsException extends Exception {
	public NoPicsException() {
		super("There are no pictures in your Gallery to display");
	}
}