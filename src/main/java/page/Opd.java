package page;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import custom.font.CustomFont;
import hospital.Api;
import hospital.HomeMain;
import hospital.HosqDepartmentModel;
import hospital.OpdDepQueueModel;
import hospital.OvstModel;
import hospital.Table;
import hospital.Userqueue;

/**
 *
 * @author warun
 */
public class Opd extends javax.swing.JFrame {

	/**
	 * Creates new form user
	 */
	public Opd() {
		initComponents();
	}

	int tablestatus = 1;
	String depcode1 = "";
	String depcode2 = "";
	ArrayList<HosqDepartmentModel> hosqArrList1 = new ArrayList<HosqDepartmentModel>();
	ArrayList<OpdDepQueueModel> opdArrList1 = new ArrayList<OpdDepQueueModel>();

	ArrayList<HosqDepartmentModel> hosqArrList2 = new ArrayList<HosqDepartmentModel>();
	ArrayList<OpdDepQueueModel> opdArrList2 = new ArrayList<OpdDepQueueModel>();

	HosqDepartmentModel model1 = new HosqDepartmentModel();
	HosqDepartmentModel model2 = new HosqDepartmentModel();

	Api api = new Api();
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1; // ปุ้มเรียก 1
	private javax.swing.JButton jButton2; // ปุ่มข้าม 1
	private javax.swing.JButton jButton3; // ปุ่มเรียก 2
	private javax.swing.JButton jButton4; // ปุ่มเรียก 2

	private javax.swing.JButton clearButton;

	private javax.swing.JButton refreshBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel notiLabel;
	private javax.swing.JLabel notiLabel2;

	public javax.swing.JTextField jTextField2;
	public javax.swing.JTextField jTextField3;

	private javax.swing.JTextField jTextFieldSpclty1;
	private javax.swing.JTextField jTextFieldDepcode1;

	private javax.swing.JTextField jTextFieldSpclty2;
	private javax.swing.JTextField jTextFieldDepcode2;

	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;

	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;

	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jMenuItem8;
	private javax.swing.JMenuItem jMenuItem9;

	private javax.swing.JTable jTable1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration

	@SuppressWarnings("unchecked")
	private void initComponents() {

		Api api = new Api();
		new CustomFont();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();

		jTextFieldSpclty1 = new javax.swing.JTextField();
		jTextFieldDepcode1 = new javax.swing.JTextField();

		jTextFieldSpclty2 = new javax.swing.JTextField();
		jTextFieldDepcode2 = new javax.swing.JTextField();

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();

		refreshBtn = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		notiLabel = new javax.swing.JLabel();
		notiLabel2 = new javax.swing.JLabel();

		jComboBox1 = new javax.swing.JComboBox<>();
		jComboBox2 = new javax.swing.JComboBox<>();

		jTable1 = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();

		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();
		jMenuItem8 = new javax.swing.JMenuItem();
		jMenuItem9 = new javax.swing.JMenuItem();

		setTitle("เรียกคิว");
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("doctor.png"));
		setIconImage(logo.getImage());
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setPreferredSize(new java.awt.Dimension(300, 400));
		setSize(new java.awt.Dimension(300, 420));
		getContentPane().setLayout(null);

//		selectCombo();
//		getComboBox();

		// TextField
		jTextField2.setEnabled(false);
		jTextField2.setFont(new java.awt.Font("Kanit", 0, 15)); // NOI18N
		jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

		jTextField2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked JT2");

				int index = jComboBox1.getSelectedIndex();
				if (index <= 0) {
					System.out.println("No Select");
//					jButton1.setEnabled(false);
					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					model.setNumRows(0);
				} else {
					model1 = hosqArrList1.get(index - 1);
					System.out.println(model1.getDepartment());
					System.out.println(model1.getSpclty());
					jTextFieldDepcode1.setText(model1.getDepcode());
					jTextFieldSpclty1.setText(model1.getSpclty());
//					jButton1.setEnabled(true);
//					jButton1.setBackground(Color.GREEN);
					jTextField2.setEnabled(true);
					depcode1 = model1.getDepcode();
					refreshData(depcode1);
					tablestatus = 1;
				}

			}
		});

		jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

					System.out.println("เรียกคิวแล้ว !");

					OvstModel model = api.findByOqueue(jTextField2.getText());
					if (model != null) {
						api.runGet(jTextFieldSpclty1.getText(), jTextField2.getText(), jTextFieldDepcode1.getText());
						jLabel1.setText("เรียกคิวที่ " + jTextField2.getText() + " แล้ว");
					} else {
						System.out.println("Data Null");
						jLabel1.setText("ไม่พบข้อมูล");
					}

///////////////////////////// คีย์ลัดปุ่มข้าม ///////////////////////////////////
				} else if (evt.getKeyCode() == KeyEvent.VK_SHIFT) {
					System.out.println("ข้ามคิวแล้ว!");
					removeRow();

					if (jTextField2.getText() == "") {

						OvstModel model = api.findByOqueue(jTextField2.getText());

						api.updateStatus(model.getOqueue());
						System.out.println("Data Null");
						jLabel1.setText("ไม่พบข้อมูล");
					} else {
						jLabel1.setText("ข้ามคิวที่ " + jTextField2.getText() + " แล้ว");
						jTextField2.setText(null);
						jTextField2.requestFocusInWindow();
						refreshData(depcode1);
					}
				}
			}
		});
		jTextField2.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (jTextField2.getText().length() > 0) {
					System.out.println("Holll");
					jButton1.setEnabled(true);
					jButton2.setEnabled(true);
				} else {
					jButton1.setEnabled(false);
					jButton2.setEnabled(false);
				}
			}
		});

		getContentPane().add(jTextField2);
		jTextField2.setBounds(14, 25, 60, 30);

		jTextField3.setEnabled(false);
		jTextField3.setFont(new java.awt.Font("Kanit", 0, 15));
		jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		getContentPane().add(jTextField3);
		jTextField3.setBounds(14, 102, 60, 30);

		// MouseListener
		jTextField3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablestatus = 2;
				System.out.println("Clicked JT3");
				int index = jComboBox2.getSelectedIndex();
				if (index <= 0) {
					System.out.println("No Select");
//					jButton1.setEnabled(false);
					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					model.setNumRows(0);
				} else {
					model1 = hosqArrList2.get(index - 1);
					System.out.println(model1.getDepartment());
					System.out.println(model1.getSpclty());
					jTextFieldDepcode2.setText(model1.getDepcode());
					jTextFieldSpclty2.setText(model1.getSpclty());
//					jButton1.setEnabled(true);
//					jButton1.setBackground(Color.GREEN);
//					jTextField2.setEnabled(true);
					depcode2 = model2.getDepcode();
					refreshData(depcode2);

				}

			}
		});

		// Key Listener
		jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

					System.out.println("เรียกคิวแล้ว !");

					OvstModel model = api.findByOqueue(jTextField3.getText());
					if (model != null) {
						api.runGet(jTextFieldSpclty2.getText(), jTextField3.getText(), jTextFieldDepcode2.getText());
						jLabel2.setText("เรียกคิวที่ " + jTextField3.getText() + " แล้ว");
					} else {
						System.out.println("Data Null");
						jLabel2.setText("ไม่พบข้อมูล");
					}

				}
			}
		});
		jTextField3.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
				warn();
			}

			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (jTextField3.getText().length() > 0) {
					System.out.println("Holll");
					jButton3.setEnabled(true);
					jButton4.setEnabled(true);
				} else {
					jButton3.setEnabled(false);
					jButton4.setEnabled(false);
				}
			}
		});

//		

		// Button
		jButton1.setEnabled(false);
		jButton1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton1.setBounds(80, 25, 95, 30);
		jButton1.setText("เรียก");
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("เรียกคิวแล้ว !");

				OvstModel model = api.findByOqueue(jTextField2.getText());
				if (model != null) {
					api.runGet(jTextFieldSpclty1.getText(), jTextField2.getText(), jTextFieldDepcode1.getText());
					jLabel1.setText("เรียกคิวที่ " + jTextField2.getText() + " แล้ว");
				} else {
					System.out.println("Data Null");
					jLabel1.setText("ไม่พบข้อมูล");
				}
			}
		});

		jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_F2) {
					System.out.println("Clear");
					jTextField2.setText("");
					jTextField2.setEnabled(true);
					jTextField2.requestFocusInWindow();
					jLabel1.setText(null);
					removeRow();

				}
			}
		});

		getContentPane().add(jButton1);

		jButton2.setEnabled(false);
		jButton2.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton2.setBounds(180, 25, 95, 30);
		jButton2.setText("ถัดไป");
		jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
		getContentPane().add(jButton2);
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

				System.out.println("ข้ามคิวแล้ว!");
				removeRow();

				if (jTextField2.getText() == "") {

					System.out.println("Data Null");
					jLabel1.setText("ไม่พบข้อมูล");
				} else {
					OvstModel model = api.findByOqueue(jTextField2.getText());
					api.updateStatus(model.getOqueue());
					jLabel1.setText("ข้ามคิวที่ " + jTextField2.getText() + " แล้ว");
					jTextField2.setText(null);
					jTextField2.requestFocusInWindow();
					refreshData(depcode1);
				}

			}
		});

		// Button เรียก 2
		jButton3.setEnabled(false);
		jButton3.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton3.setBounds(80, 102, 95, 30);
		jButton3.setText("เรียก");
		jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
		getContentPane().add(jButton3);

		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("เรียกคิวแล้ว !");

				OvstModel model = api.findByOqueue(jTextField3.getText());
				if (model != null) {
					api.runGet(jTextFieldSpclty2.getText(), jTextField3.getText(), jTextFieldDepcode2.getText());
					jLabel2.setText("เรียกคิวที่ " + jTextField3.getText() + " แล้ว");
				} else {
					System.out.println("Data Null");
					jLabel2.setText("ไม่พบข้อมูล");
				}
			}
		});

		// Button ข้าม 2
		jButton4.setEnabled(false);
		jButton4.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton4.setBounds(180, 102, 95, 30);
		jButton4.setText("ถัดไป");
		jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
		getContentPane().add(jButton4);

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("ข้ามคิวแล้ว!");
				removeRow2();

				if (jTextField3.getText() == "") {
					System.out.println("Data Null");
					jLabel2.setText("ไม่พบข้อมูล");
				} else {
					OvstModel model = api.findByOqueue(jTextField3.getText());
					api.updateStatus(model.getOqueue());
					jLabel2.setText("ข้ามคิวที่ " + jTextField3.getText() + " แล้ว");
					jTextField3.setText(null);
					jTextField3.requestFocusInWindow();
					refreshData(depcode2);
				}
			}
		});

//				String name = jTextField2.getText();
//
//			    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//			    for (int i = 0; i < model.getRowCount(); i++) {
//			        if (((String)model.getValueAt(i, 0)).equals(name)) {
//			            model.removeRow(i);
//			            break;
//			            
//			            
//			        }
//			    }
//				jTextField2.requestFocusInWindow();
//				jTextField2.setEnabled(true);
//				jTextField2.setText(null);
//				jLabel1.setText(null);
//				int row2 = jTable1.getSelectedRow();
//				String data = jTable1.getModel().getValueAt(row2, 0).toString();
//				jLabel1.setText("ข้ามคิวที่ " + data + " แล้ว");
//				jTextField2.setText(null);
//				removeRow();
//			}
//		});

		refreshBtn.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		refreshBtn.setText("รีเฟรชรายการ");
		refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
//		getContentPane().add(refreshBtn);
		refreshBtn.setBounds(17, 150, 230, 25);
		refreshBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("Refresh");
				int n = JOptionPane.showOptionDialog(new JFrame(), "Do you want to refresh ?", "Refresh Check",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Yes", "No" },
						JOptionPane.YES_OPTION);

				if (n == JOptionPane.YES_OPTION) {
					System.out.println("Yes");
					refreshData(depcode1);
				} else if (n == JOptionPane.NO_OPTION) {
					System.out.println("No");
				}

			}
		});

		// *************************** Table *********************************

		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(26, 160, 230, 160);

		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = jTable1.rowAtPoint(evt.getPoint());
				int col = jTable1.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					getData1();

				}
			}
		});
		jTable1.setFont(new java.awt.Font("Kanit", 0, 12));
		jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_F1) {
					int row2 = jTable1.getSelectedRow();
					String data = jTable1.getModel().getValueAt(row2, 0).toString();
					System.out.println("เรียกคิวที่ " + data + " แล้ว");
					jTextField2.setText(data);
					jLabel1.setText("เรียกคิวที่ " + jTextField2.getText() + " แล้ว");

					OvstModel model = api.findByOqueue(jTextField2.getText());

					if (model != null) {
						api.runGet(jTextFieldSpclty1.getText(), jTextField2.getText(), jTextFieldDepcode1.getText());
						jLabel1.setText("เรียกคิวที่ " + jTextField2.getText() + " แล้ว");

					} else {
						System.out.println("Data Null");
						jLabel1.setText("ไม่พบข้อมูล");
					}

				} else if (evt.getKeyCode() == KeyEvent.VK_F2) {
					int row2 = jTable1.getSelectedRow();
					OvstModel model = api.findByOqueue(jTextField2.getText());
					api.updateStatus(model.getOqueue());
					String data = jTable1.getModel().getValueAt(row2, 0).toString();
					removeRow();
					jLabel1.setText("ข้ามคิวที่ " + data + " แล้ว");
					jTextField2.setText(null);

				}
			}
		});

		// Label
		jLabel1.setFont(new java.awt.Font("Kanit", 0, 10)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setForeground(new java.awt.Color(255, 51, 51));
		jLabel1.setText("");
		getContentPane().add(jLabel1);
		jLabel1.setBounds(20, 55, 80, 16);

		jLabel2.setFont(new java.awt.Font("Kanit", 0, 10)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setForeground(new java.awt.Color(255, 51, 51));
		jLabel2.setText("");
		getContentPane().add(jLabel2);
		jLabel2.setBounds(20, 130, 80, 16);

//		jLabel2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
//		jLabel2.setText("หมายเลข");
//		getContentPane().add(jLabel2);
//		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//		jLabel2.setBounds(20, 10, 80, 19);

//		jLabel3.setForeground(new java.awt.Color(102, 102, 102));
//		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//		jLabel3.setText("F2");
//		getContentPane().add(jLabel3);
//		jLabel3.setBounds(150, 81, 90, 16);
//
//		jLabel4.setForeground(new java.awt.Color(102, 102, 102));
//		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//		jLabel4.setText("F1");
//		getContentPane().add(jLabel4);
//		jLabel4.setBounds(35, 81, 90, 16);

		notiLabel.setText("ไม่มีหมายเลขที่คุณเลือก");
		notiLabel.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

		notiLabel2.setText("ไม่พบข้อมูล");
		notiLabel2.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

		// Menu
		jMenu1.setText("แผนก");
		jMenu1.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N

		jMenu2.setText("รายการคิว");
		jMenu2.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N

		jMenuItem1.setText("ผู้ป่วยนอก");
		jMenuItem1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opd.png")));
//				jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ผู้ป่วยนอก");
//						Setting settingPage = new Setting();
//						settingPage.setVisible(true);
			}
		});

		jMenuItem2.setText("อุบัติเหตุฉุกเฉิน");
		jMenuItem2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emergency.png")));
//				jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("อุบัติเหตุฉุกเฉิน");
//						Setting settingPage = new Setting();
//						settingPage.setVisible(true);
			}
		});

		jMenuItem3.setText("การเงินและยา");
		jMenuItem3.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drug.png")));
//				jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("การเงินและยา");
			}
		});

		jMenuItem5.setText("เทคนิคการแพทย์");
		jMenuItem5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab.png")));
//				jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("เทคนิคการแพทย์");

			}
		});

		jMenuItem6.setText("ทันตกรรม");
		jMenuItem6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toothss.png")));
//				jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ทันตกรรม");
			}
		});

		jMenuItem7.setText("ฟื้นฟู");
		jMenuItem7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heal.png")));
//				jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ฟื้นฟู");
			}
		});

		jMenuItem8.setText("รายการคิวที่เรียกไปแล้ว");
		jMenuItem8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/queue2.png")));
//				jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
		jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("CheckQueue");
				Table tablePage = new Table();
				tablePage.setVisible(true);
			}
		});

		jMenuItem9.setText("เว็ปไซต์");
		jMenuItem9.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/web2.png")));
//				jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
		jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("เว็ปไซต์");
				ButtonWeb(evt);
			}
		});

		jMenu1.add(jMenuItem1);
		jMenu1.add(jMenuItem2);
		jMenu1.add(jMenuItem3);
		jMenu1.add(jMenuItem4);
		jMenu1.add(jMenuItem5);
		jMenu1.add(jMenuItem6);
		jMenu1.add(jMenuItem7);

		jMenu2.add(jMenuItem8);
		jMenu2.add(jMenuItem9);

		jMenuBar1.add(jMenu1);
		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

//		jComboBox2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
//		jComboBox2.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				jComboBox1ActionPerformed(evt);
//				
//			}
//		});
//		getContentPane().add(jComboBox1);
//		jComboBox2.setBounds(120, 0, 140, 22);
//		pack();
//	    refreshData(depcode1);
		getComboBox1();
		getComboBox2();
//		dataTable();

		// ComboBox
//		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ห้องทันตกรรม", "ห้องอายุรกรรม", "ห้องกายภาพบำบัด", "ห้องไต" }));
//		jComboBox1.setFont(new java.awt.Font("THSarabun", 0, 12));
		jComboBox1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jComboBox2.setFont(new java.awt.Font("Kanit", 0, 12));
//		jComboBox1.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("clicked");
//				jComboBox1.enable();
//				getComboBox();
//				
//			}
//		});
//		jComboBox1.disable();

//		getComboBox();
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
				tablestatus = 1;
				jTextField2.requestFocusInWindow();
				int index = jComboBox1.getSelectedIndex();
				if (index <= 0) {
					System.out.println("No Select");
//					jButton1.setEnabled(false);
					jTextField2.setText("");
					jTextField2.setEnabled(false);
					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					model.setNumRows(0);
				} else {
					model1 = hosqArrList1.get(index - 1);
					System.out.println(model1.getDepartment());
					System.out.println(model1.getSpclty());
					jTextFieldDepcode1.setText(model1.getDepcode());
					jTextFieldSpclty1.setText(model1.getSpclty());
//					jButton1.setEnabled(true);
//					jButton1.setBackground(Color.GREEN);
					jTextField2.setEnabled(true);
					depcode1 = model1.getDepcode();
					refreshData(depcode1);
				}

			}
		});
		getContentPane().add(jComboBox1);
		jComboBox1.setBounds(14, 2, 265, 22);
		pack();

		jComboBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
				tablestatus = 2;
				jTextField3.requestFocusInWindow();
				int index = jComboBox2.getSelectedIndex();
				if (index <= 0) {
					System.out.println("No Select");
//					jButton1.setEnabled(false);
					jTextField3.setText("");
					jTextField3.setEnabled(false);
					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					model.setNumRows(0);
				} else {
					model2 = hosqArrList2.get(index - 1);
					System.out.println(model2.getDepartment());
					System.out.println(model2.getSpclty());
					jTextFieldDepcode2.setText(model2.getDepcode());
					jTextFieldSpclty2.setText(model2.getSpclty());
//					jButton1.setEnabled(true);
//					jButton1.setBackground(Color.GREEN);
					jTextField3.setEnabled(true);
					depcode2 = model2.getDepcode();
					refreshData(depcode2);
				}

			}
		});
		getContentPane().add(jComboBox2);
		jComboBox2.setBounds(14, 80, 265, 22);
		pack();

	}// </editor-fold>

	private void getComboBox1() {

		Api api = new Api();
		System.err.println("Getcombo");
		try {
			jComboBox1.removeAllItems();
			hosqArrList1 = api.getHosqOPD2();
			int i = 1;
			for (Iterator<HosqDepartmentModel> iterator = hosqArrList1.iterator(); iterator.hasNext();) {
				HosqDepartmentModel hosqDepartmentModel = (HosqDepartmentModel) iterator.next();
				if (i == 1) {
					jComboBox1.addItem("- เลือกห้องซักประวัติ -");
					jTextField2.setText("");
				}
				jComboBox1.addItem(i + ") " + hosqDepartmentModel.getDepartment());
				i++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Getcombo");
	}

	private void getComboBox2() {

		Api api = new Api();
		System.err.println("Getcombo");
		try {
			jComboBox2.removeAllItems();
			hosqArrList2 = api.getHosqOPD();
			int i = 1;
			for (Iterator<HosqDepartmentModel> iterator = hosqArrList2.iterator(); iterator.hasNext();) {
				HosqDepartmentModel hosqDepartmentModel = (HosqDepartmentModel) iterator.next();
				if (i == 1) {
					jComboBox2.addItem("- เลือกห้องตรวจโรค -");
				}
				jComboBox2.addItem(i + ") " + hosqDepartmentModel.getDepartment());
				i++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("Getcombo");
	}

	public void getData1() {
		int row2 = jTable1.getSelectedRow();
		String data = jTable1.getModel().getValueAt(row2, 0).toString();
		System.out.println("Number = " + data);
		System.out.println("Status = " + tablestatus);
		if (tablestatus == 1) {
			jTextField2.setText(data);

		} else {
			jTextField3.setText(data);
		}

	}

	public void removeRow() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		if (jTable1.getSelectedRowCount() == 1) {
			tableModel.removeRow(jTable1.getSelectedRow());
			System.out.println("remove");

		} else {
			String name = jTextField2.getText();
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			for (int i = 0; i < model.getRowCount(); i++) {
				if (((String) model.getValueAt(i, 0)).equals(name)) {
					model.removeRow(i);
					break;
				}
//		        else if(((String)model.getValueAt(i, 0))!=(name)){
//		        	JOptionPane.showMessageDialog(null, notiLabel, "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
//		        	break;
//		        }
			}
//			JOptionPane.showMessageDialog(null, notiLabel, "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void removeRow2() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		if (jTable1.getSelectedRowCount() == 1) {
			tableModel.removeRow(jTable1.getSelectedRow());

		} else {
			String name = jTextField3.getText();
			DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
			for (int i = 0; i < model.getRowCount(); i++) {
				if (((String) model.getValueAt(i, 0)).equals(name)) {
					model.removeRow(i);
					break;
				}
//		        else if(((String)model.getValueAt(i, 0))!=(name)){
//		        	JOptionPane.showMessageDialog(null, notiLabel, "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
//		        	break;
//		        }
			}
//			JOptionPane.showMessageDialog(null, notiLabel, "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Table 1
	public void refreshData(String depcode) {
		opdArrList1.clear();
		jTable1.setModel(new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setNumRows(0);
		model.addColumn("Number");
		model.addColumn("Name");
		opdArrList1 = api.opdDepQueueByDepcode(depcode);
		int row = 0;

		for (Iterator<OpdDepQueueModel> iterator = opdArrList1.iterator(); iterator.hasNext();) {
			OpdDepQueueModel hosqDepartmentModel = (OpdDepQueueModel) iterator.next();
			model.addRow(new Object[0]);
			model.setValueAt(hosqDepartmentModel.getOqueue(), row, 0);
			model.setValueAt(hosqDepartmentModel.getPtname(), row, 1);
//			System.out.println(hosqDepartmentModel.getPtname());
			row++;

		}

	}

//		

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:s\
	}

	private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {

	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void ButtonWeb(java.awt.event.ActionEvent evt) {
		try {
			Desktop.getDesktop().browse(new URL("https://hospital.udoncity.go.th/hos_q/server/").toURI());
		} catch (MalformedURLException ex) {
			Logger.getLogger(HomeMain.class.getName()).log(Level.SEVERE, null, ex);
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Opd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Opd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Opd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Opd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Userqueue().setVisible(true);
			}
		});

	}

//	public void selectCombo() {
//		Connection connect = null;
//		PreparedStatement s = null;
//		ResultSet rs = null;
//
//		try {
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			connect = DriverManager.getConnection(
//					"jdbc:mysql://180.180.216.192:3306/hospital_q" + "?user=ud12418&password=192168100250");
//
//			String sql = "SELECT CONVERT(department USING utf8) as department FROM hosq_department";
//			s = connect.prepareStatement(sql);
//			rs = s.executeQuery();
//
//			while (rs.next()) {
//				String name = rs.getString("department");
//				jComboBox1.addItem(name);
//				System.out.println(name);
//			}
//
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//
//	}

}
