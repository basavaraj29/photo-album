package Album;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ViewAll extends javax.swing.JFrame {

	SlideShow s;
	Album a;
	ViewAll v;
	int n;
	JLabel jlab = new JLabel();

	public ViewAll(SlideShow s, Album a) {
		this.a = a;
		this.s = s;
		n = 0;
		initialize();
	}

	public ViewAll(ViewAll v, int n, Album a) {
		this.v = v;
		this.a = a;
		this.n = n;
		initialize();
	}

	public void initialize() {
		jButton1 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		jButton1.setText("jButton1");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		this.setTitle(a.pics.get(n).title);
		jButton2.setText("Prev");
		if (n == 0)
			jButton2.setEnabled(false);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("Next");
		if (n == a.pics.size() - 1)
			jButton3.setEnabled(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						new ImageIcon(a.pics.get(n).filename).getIconWidth(),
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(100, 100, 100)
								.addComponent(jButton2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(92, 92, 92)
								.addComponent(jButton3,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(98, 98, 98)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(
										jScrollPane1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										new ImageIcon(a.pics.get(n).filename)
												.getIconHeight(),
										Short.MAX_VALUE)
								.addGap(12, 12, 12)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jButton2,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jButton3,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		jlab.setIcon(new ImageIcon(a.pics.get(n).filename));
		jlab.setHorizontalAlignment(JLabel.CENTER);
		jScrollPane1.getViewport().add(jlab);
		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		ViewAll temp = new ViewAll(this, n - 1, a);
		temp.setVisible(true);
		this.dispose();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		ViewAll temp = new ViewAll(this, n + 1, a);
		temp.setVisible(true);
		this.dispose();
	}

	public void close() {
		a.setVisible(true);
		this.dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JScrollPane jScrollPane1;
}
