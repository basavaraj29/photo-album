package Album;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Album extends javax.swing.JFrame {
	ArrayList<Pics> pics = new ArrayList<>();
	String[][] data;
	boolean var = false;

	public Album() {
		try (FileInputStream fi = new FileInputStream("album.dat")) { // tries
																		// to
																		// load
																		// the
																		// previous
																		// data
			ObjectInputStream oi = new ObjectInputStream(fi);
			pics = (ArrayList<Pics>) (oi.readObject());
			oi.close();
			fi.close();
			JOptionPane.showMessageDialog(null,
					"Successfully loaded previous data\n");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Not able to load previous data\n");
		}
		data = new String[pics.size()][1];
		for (int z = 0; z < pics.size(); z++)
			data[z][0] = pics.get(z).title;
		initialize();
	}

	public void initialize() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		this.setFont(new java.awt.Font("Tahoma", 1, 18));
		this.setTitle("GALLERY");
		setResizable(false);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(data,
				new String[] { "Picture Title" }) {
			boolean[] canEdit = new boolean[] { false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable1.setColumnSelectionAllowed(true);
		jTable1.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jTable1);
		jTable1.getColumnModel()
				.getSelectionModel()
				.setSelectionMode(
						javax.swing.ListSelectionModel.SINGLE_SELECTION);
		if (jTable1.getColumnModel().getColumnCount() > 0) {
			jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
		}

		jButton1.setText("View");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setText("Select on a row");

		jLabel2.setText("and press view to");

		jLabel3.setText("view image");

		jMenu1.setText("File");
		jMenu1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu1ActionPerformed(evt);
			}
		});

		jMenuItem1.setText("Add");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText("Slideshow");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setText("Save");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem3);

		jMenuItem4.setText("Exit");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem4);

		jMenuBar1.add(jMenu1);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										324,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						jLabel2)
																				.addComponent(
																						jButton1))
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addComponent(
														jLabel1,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE, 279,
						Short.MAX_VALUE)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(50, 50, 50)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel2)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1)
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();

	}

	private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(jMenuItem1) == JFileChooser.APPROVE_OPTION) {
			java.io.File f = fc.getSelectedFile();
			AskDetails askDetails = new AskDetails(this, f.toString());
			askDetails.setVisible(true);
			this.setVisible(false);

		} else {

		}
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		SlideShow slideShow = new SlideShow(this);
		this.setVisible(false);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			FileOutputStream fo = new FileOutputStream("album.dat");
			ObjectOutputStream ou = new ObjectOutputStream(fo);
			ou.writeObject(pics);
			ou.close();
			fo.close();
			JOptionPane.showMessageDialog(null, "Successfully saved");
			var = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		if (var) {
			int stat = JOptionPane.showConfirmDialog(null,
					"Do you want to save the data");
			if (stat == JOptionPane.OK_OPTION) {
				try {
					FileOutputStream fo = new FileOutputStream("album.dat");
					ObjectOutputStream ou = new ObjectOutputStream(fo);
					ou.writeObject(pics);
					ou.close();
					fo.close();
					JOptionPane.showMessageDialog(null, "Successfully saved");
					var = false;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				this.dispose();
			} else if (stat == JOptionPane.NO_OPTION) {
				this.dispose();
			}
		} else
			this.dispose();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (jTable1.getSelectedRow() == -1)
				throw new NoSelectionException();
			System.out.println(pics.get(jTable1.getSelectedRow()).filename);
			View view = new View(pics.get(jTable1.getSelectedRow()).filename,
					pics.get(jTable1.getSelectedRow()).title, pics.get(jTable1
							.getSelectedRow()).descreption, this);
			view.setVisible(true);
			this.setVisible(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Album frame = new Album();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		if (var) {
			int stat = JOptionPane.showConfirmDialog(null,
					"Do you want to save the data");
			if (stat == JOptionPane.OK_OPTION) {
				try {
					FileOutputStream fo = new FileOutputStream("album.dat");
					ObjectOutputStream ou = new ObjectOutputStream(fo);
					ou.writeObject(pics);
					ou.close();
					fo.close();
					JOptionPane.showMessageDialog(null, "Successfully saved");
					var = false;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				this.dispose();
			} else if (stat == JOptionPane.NO_OPTION) {
				this.dispose();
			}
		}
		this.dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JScrollPane jScrollPane1;
	public javax.swing.JTable jTable1;

}

class Pics implements Serializable {
	String title;
	String descreption;
	String filename;

	public Pics(String filename, String title, String descreption) {
		this.filename = filename;
		this.title = title;
		this.descreption = descreption;
	}
}

class NoSelectionException extends Exception {
	public NoSelectionException() {
		super("No image selected");
	}
}