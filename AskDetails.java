package Album;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class AskDetails extends javax.swing.JFrame {

	Album a;
	String file;

	public AskDetails(Album a, String file) {
		this.a = a;
		this.file = file;
		initialize();
	}

	public void initialize() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		jLabel1.setText("Title :");

		jLabel2.setText("Description : ");

		jLabel3.setText("(max 20 chars)");

		jLabel4.setText("(max 100 chars)");

		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jButton1.setText("ADD");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel5.setText("Enter the details of the picture : ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel3)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel1)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						jLabel2))
																.addGap(28, 28,
																		28)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton1)
																								.addGap(0,
																										0,
																										Short.MAX_VALUE))
																				.addComponent(
																						jTextField1)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						265,
																						Short.MAX_VALUE))))
								.addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel5,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										237,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(6, 6, 6)
								.addComponent(jLabel5,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										14,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel3)
								.addGap(25, 25, 25)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jLabel4))
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														78,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (jTextField1.getText().length() > 20)
				throw new CharsExceededException();
			if (jTextField1.getText().isEmpty())
				throw new EmptyException();
			for (int z = 0; z < a.pics.size(); z++) {
				if (jTextField1.getText().toString()
						.equals(a.pics.get(z).title))
					throw new TitleException();
				if (file.equals(a.pics.get(z).filename))
					throw new ImageException();
			}
			if (jTextArea1.getText().length() > 100)
				throw new CharsExceededException();
			Pics temp = new Pics(file, jTextField1.getText(),
					jTextArea1.getText());
			a.pics.add(temp);
			a.data = new String[a.pics.size()][1];
			for (int z = 0; z < a.pics.size(); z++)
				a.data[z][0] = a.pics.get(z).title;
			a.jTable1.setModel(new javax.swing.table.DefaultTableModel(a.data,
					new String[] { "Title" }) {
				boolean[] canEdit = new boolean[] { false };

				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return canEdit[columnIndex];
				}
			});
			JOptionPane.showMessageDialog(null,
					"Successfully added picture to Gallery");
			a.var = true;
			a.setVisible(true);
			this.dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void close() {
		a.setVisible(true);
		this.dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;

}

class CharsExceededException extends Exception {
	public CharsExceededException() {
		super("Charcters Limit Exceeded");
	}
}

class TitleException extends Exception {
	public TitleException() {
		super("A picture with same title already exsists");
	}
}

class ImageException extends Exception {
	public ImageException() {
		super("This picture already exsists");
	}
}

class EmptyException extends Exception {
	public EmptyException() {
		super("Title cannot be left Empty");
	}
}