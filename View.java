package Album;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class View extends javax.swing.JFrame {
	String f;
	Album a;
	String title;
	String desc;
	JLabel jlab = new JLabel();
	javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();

	public View(String f, String title, String desc, Album a) {
		this.f = f;
		this.a = a;
		this.title = title;
		this.desc = desc;
		initialize();
	}

	public void initialize() {
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jScrollPane4.setViewportView(jTextArea2);
		this.setTitle(title);
		jTextArea2.setText(desc);
		jTextArea2.setEditable(false);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						new ImageIcon(f).getIconWidth() + 20, Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane4).addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										new ImageIcon(f).getIconHeight() + 20,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										68,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 11, Short.MAX_VALUE)));

		pack();
		jlab.setIcon(new ImageIcon(f));
		jlab.setHorizontalAlignment(JLabel.CENTER);
		jScrollPane2.getViewport().add(jlab);

	}

	public void close() {
		a.setVisible(true);
		this.dispose();
	}

	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JTextArea jTextArea2;
}
