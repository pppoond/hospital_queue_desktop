package page;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class Er extends javax.swing.JFrame {

	
	/**
	 * Creates new form user
	 */
	public Er() {
		initComponents();
	}
	
	String depcode = "";
	ArrayList<HosqDepartmentModel> hosqArrList = new ArrayList<HosqDepartmentModel>();
	ArrayList<OpdDepQueueModel> opdArrList = new ArrayList<OpdDepQueueModel>();
	Api api = new Api();
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton clearButton;
	private javax.swing.JButton refreshBtn;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel notiLabel;
	private javax.swing.JLabel notiLabel2;
	public javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextFieldSpclty;
	private javax.swing.JTextField jTextFieldDepcode;
	private javax.swing.JTextField jTextFieldDepname;
	
	public javax.swing.JTextField jTextFieldPtname;
	private javax.swing.JComboBox<String> jComboBox1;

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
		jTextFieldSpclty = new javax.swing.JTextField();
		jTextFieldDepcode = new javax.swing.JTextField();
		jTextFieldDepname = new javax.swing.JTextField();
		jTextFieldPtname = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		refreshBtn = new javax.swing.JButton();
		clearButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		notiLabel = new javax.swing.JLabel();
		notiLabel2 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();

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

		
		setTitle("���¡���");
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("doctor.png"));
		setIconImage(logo.getImage());
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setPreferredSize(new java.awt.Dimension(300, 418));
		setSize(new java.awt.Dimension(300, 420));
		getContentPane().setLayout(null);

//		selectCombo();
//		getComboBox();

		// TextField
		jTextField2.setEnabled(false);
		jTextField2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_F1) {
					OvstModel model = api.findByOqueue(jTextField2.getText());
					if (model != null) {
						api.runGet(jTextFieldSpclty.getText(), jTextField2.getText(),
								jTextFieldDepcode.getText());
						jLabel1.setText("���¡��Ƿ�� " + jTextField2.getText() + " ����");
					} else {
						System.out.println("Data Null");
						jLabel1.setText("��辺������");
						JOptionPane.showMessageDialog(null, notiLabel2, "����͹", JOptionPane.INFORMATION_MESSAGE);
					}

				} else if (evt.getKeyCode() == KeyEvent.VK_F2) {
					System.out.println("�����������!");
					removeRow();
					
					OvstModel model = api.findByOqueue(jTextField2.getText());
					
					if (model == null) {
						System.out.println("Data Null");
						jLabel1.setText("��辺������");
					}else {
				    api.updateStatus(model.getOqueue());
					jLabel1.setText("������Ƿ�� " + jTextField2.getText() + " ����");
					jTextField2.setText(null);
					}
				}
			}
		});

		getContentPane().add(jTextField2);
		jTextField2.setBounds(20, 30, 80, 30);

		// Button

		jButton1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton1.setText("���¡���");
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("���¡������� !");

				OvstModel model = api.findByOqueue(jTextField2.getText());
				if (model != null) {
					api.runGet(jTextFieldSpclty.getText(), jTextField2.getText(),
							jTextFieldDepcode.getText());
					jLabel1.setText("���¡��Ƿ�� " + jTextField2.getText() + " ����");
				} else {
					System.out.println("Data Null");
					jLabel1.setText("��辺������");
				}

//				Connection connect = null;
//
//				try {
//					Class.forName("com.mysql.jdbc.Driver");
//
//					connect =  DriverManager.getConnection("jdbc:mysql://180.180.216.192/db_ud12418" +
//							"?user=ud12418&password=192168100250");
//
//					if(connect != null){
//						System.out.println("Database Connected.");
//					} else {
//						System.out.println("Database Connect Failed.");
//					}
//					
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}
//
//				try {
//					connect.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					System.out.println(e.getMessage());
//					e.printStackTrace();
//				}

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
		jButton1.setBounds(20, 100, 110, 30);

		clearButton.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		clearButton.setText("��ǶѴ�");
		clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clean.png"))); // NOI18N
		getContentPane().add(clearButton);
		clearButton.setBounds(135, 100, 115, 30);
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				
				System.out.println("�����������!");
				removeRow();
				
				
				OvstModel model = api.findByOqueue(jTextField2.getText());
				
				api.updateStatus(model.getOqueue());
				
				if (model == null) {
					System.out.println("Data Null");
					jLabel1.setText("��辺������");
				}else {
				jLabel1.setText("������Ƿ�� " + jTextField2.getText() + " ����");
				jTextField2.setText(null);
				jTextField2.requestFocusInWindow();
				refreshData(depcode);
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
//				jLabel1.setText("������Ƿ�� " + data + " ����");
//				jTextField2.setText(null);
//				removeRow();
//			}
//		});
		

		refreshBtn.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		refreshBtn.setText("���ê��¡��");
		refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh.png"))); // NOI18N
		getContentPane().add(refreshBtn);
		refreshBtn.setBounds(17, 150, 230, 25);
		refreshBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("Refresh");
				 int n = JOptionPane.showOptionDialog(new JFrame(), "Do you want to refresh ?", 
					        "Refresh Check", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, 
					        null, new Object[] {"Yes", "No"}, JOptionPane.YES_OPTION);
				
					        if (n == JOptionPane.YES_OPTION) {
					            System.out.println("Yes");
					            refreshData(depcode);
					        } else if (n == JOptionPane.NO_OPTION) {
					            System.out.println("No");
					        }
					       
			}
		});

		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jScrollPane1);
		jScrollPane1.setBounds(17, 170, 230, 160);

		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = jTable1.rowAtPoint(evt.getPoint());
				int col = jTable1.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					getData();

				}
			}
		});
		jTable1.setFont(new java.awt.Font("Kanit", 0, 12));
		jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {

				if (evt.getKeyCode() == KeyEvent.VK_F1) {
					int row2 = jTable1.getSelectedRow();
					String data = jTable1.getModel().getValueAt(row2, 0).toString();
					System.out.println("���¡��Ƿ�� " + data + " ����");
					jTextField2.setText(data);
					jLabel1.setText("���¡��Ƿ�� " + jTextField2.getText() + " ����");

					
					OvstModel model = api.findByOqueue(jTextField2.getText());
					
					if (model != null) {
						api.runGet(jTextFieldSpclty.getText(), jTextField2.getText(),
								jTextFieldDepcode.getText());
						jLabel1.setText("���¡��Ƿ�� " + jTextField2.getText() + " ����");
						
					} else {
						System.out.println("Data Null");
						jLabel1.setText("��辺������");
					}

				} else if (evt.getKeyCode() == KeyEvent.VK_F2) {
					int row2 = jTable1.getSelectedRow();
					OvstModel model = api.findByOqueue(jTextField2.getText());
					api.updateStatus(model.getOqueue());
					String data = jTable1.getModel().getValueAt(row2, 0).toString();
					removeRow();
					jLabel1.setText("������Ƿ�� " + data + " ����");
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
		jLabel1.setBounds(20, 60, 80, 16);

		jLabel2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jLabel2.setText("�����Ţ");
		getContentPane().add(jLabel2);
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setBounds(20, 10, 80, 19);

		jLabel3.setForeground(new java.awt.Color(102, 102, 102));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("F2");
		getContentPane().add(jLabel3);
		jLabel3.setBounds(150, 81, 90, 16);

		jLabel4.setForeground(new java.awt.Color(102, 102, 102));
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("F1");
		getContentPane().add(jLabel4);
		jLabel4.setBounds(35, 81, 90, 16);

		notiLabel.setText("����������Ţ���س���͡");
		notiLabel.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

		notiLabel2.setText("��辺������");
		notiLabel2.setFont(new java.awt.Font("Kanit", 0, 16)); // NOI18N

		
		
		
		
		// Menu
				jMenu1.setText("Ἱ�");
				jMenu1.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N
				
				jMenu2.setText("��¡�ä��");
				jMenu2.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N

				jMenuItem1.setText("�����¹͡");
				jMenuItem1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opd.png")));
//				jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("�����¹͡");
//						Setting settingPage = new Setting();
//						settingPage.setVisible(true);
					}
				});
		 
				jMenuItem2.setText("�غѵ��˵ةء�Թ");
				jMenuItem2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emergency.png")));
//				jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("�غѵ��˵ةء�Թ");
//						Setting settingPage = new Setting();
//						settingPage.setVisible(true);
					}
				});
				
				jMenuItem3.setText("����Թ�����");
				jMenuItem3.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drug.png")));
//				jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("����Թ�����");
					}
				});
				
				jMenuItem5.setText("෤�Ԥ���ᾷ��");
				jMenuItem5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab.png")));
//				jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("෤�Ԥ���ᾷ��");
						
					}
				});
				
				jMenuItem6.setText("�ѹ�����");
				jMenuItem6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toothss.png")));
//				jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("�ѹ�����");
					}
				});
				
				jMenuItem7.setText("��鹿�");
				jMenuItem7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heal.png")));
//				jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
				jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("��鹿�");
					}
				});
				
				
				jMenuItem8.setText("��¡�ä�Ƿ�����¡�����");
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
				
				
				jMenuItem9.setText("���䫵�");
				jMenuItem9.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
				jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/web2.png")));
//				jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
				jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						System.out.println("���䫵�");
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

		getComboBox();
//		refreshData();
//		dataTable();

		// ComboBox
//		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "��ͧ�ѹ�����", "��ͧ����á���", "��ͧ����Ҿ�ӺѴ", "��ͧ�" }));
//		jComboBox1.setFont(new java.awt.Font("THSarabun", 0, 12));
		jComboBox1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
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
				jTextField2.requestFocusInWindow();
				int index = jComboBox1.getSelectedIndex();
				if (index <= 0) {
					System.out.println("No Select");
//					jButton1.setEnabled(false);
					jTextField2.setEnabled(false);
					DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
					model.setNumRows(0);
				} else {
					HosqDepartmentModel model = hosqArrList.get(index - 1);
					System.out.println(model.getDepartment());
					System.out.println(model.getSpclty());
					jTextFieldDepcode.setText(model.getDepcode());
					jTextFieldSpclty.setText(model.getSpclty());
					jTextFieldDepname.setText(model.getDepartment());
//					jButton1.setEnabled(true);
//					jButton1.setBackground(Color.GREEN);
					jTextField2.setEnabled(true);
					depcode = model.getDepcode();
					refreshData(depcode);
				}

			}
		});
		getContentPane().add(jComboBox1);
		jComboBox1.setBounds(120, 0, 140, 22);
		pack();

	}// </editor-fold>

	private void getComboBox() {
		
		Api api = new Api();
		System.err.println("Getcombo");
		try {
			jComboBox1.removeAllItems();
			hosqArrList = api.getHosqAll();
			int i = 1;
			for (Iterator<HosqDepartmentModel> iterator = hosqArrList.iterator(); iterator.hasNext();) {
				HosqDepartmentModel hosqDepartmentModel = (HosqDepartmentModel) iterator.next();
				if (i == 1) {
					jComboBox1.addItem("--���͡��ͧ--");
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

//	public void dataTable() {
//			
//jTable1.setModel(new DefaultTableModel());
//		
//		DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//		model.addColumn("Number");
////		model.addColumn("VN");
////		
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
//			connect = DriverManager
//					.getConnection("jdbc:mysql://180.180.216.192:3306/db_ud12418"
//							+ "?user=ud12418&password=192168100250");
//    	   
//            String sql = "select vstdate,oqueue from ovst where vstdate = curdate() order by vsttime asc" ;
//            s=connect.prepareStatement(sql);
//            rs = s.executeQuery();
//            
//            int row=0;
//            while((rs!=null)&& (rs.next())) {
//            	model.addRow(new Object[0]);
//            	model.setValueAt(rs.getString("oqueue").toString(), row, 0);
////            	model.setValueAt(rs.getString("hn"), row, 1);
//            	row++;
//            }
//            
//           
//    
//    } catch (SQLException e ) {
//        JOptionPane.showMessageDialog(null, e);
//    }
//  
//    }

	public void getData() {
		int row2 = jTable1.getSelectedRow();
		String data = jTable1.getModel().getValueAt(row2, 0).toString();
		System.out.println(data);
		jTextField2.setText(data);

	}

	public void removeRow() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
		if (jTable1.getSelectedRowCount() == 1) {
			tableModel.removeRow(jTable1.getSelectedRow());
			
		} else {
			String name = jTextField2.getText();
		    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
		    for (int i = 0; i < model.getRowCount(); i++) {
		        if (((String)model.getValueAt(i, 0)).equals(name)) {
		            model.removeRow(i);
		            break;
		        }
//		        else if(((String)model.getValueAt(i, 0))!=(name)){
//		        	JOptionPane.showMessageDialog(null, notiLabel, "����͹", JOptionPane.INFORMATION_MESSAGE);
//		        	break;
//		        }
		    }
//			JOptionPane.showMessageDialog(null, notiLabel, "����͹", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void refreshData(String depcode) {
		opdArrList.clear();
		jTable1.setModel(new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setNumRows(0);
		model.addColumn("Number");
		model.addColumn("Name");
		opdArrList = api.opdDepQueueByDepcode(depcode);
		int row = 0;

		for (Iterator<OpdDepQueueModel> iterator = opdArrList.iterator(); iterator.hasNext();) {
			OpdDepQueueModel hosqDepartmentModel = (OpdDepQueueModel) iterator.next();
			model.addRow(new Object[0]);
			model.setValueAt(hosqDepartmentModel.getOqueue(), row, 0);
			model.setValueAt(hosqDepartmentModel.getPtname(), row, 1);
			System.out.println(hosqDepartmentModel.getPtname());
			row++;

		}

	}

//		jTable1.setModel(new DefaultTableModel());
//		
//		DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
//		model.addColumn("Number");
////		model.addColumn("VN");
////		
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
//			connect = DriverManager
//					.getConnection("jdbc:mysql://180.180.216.192:3306/db_ud12418"
//							+ "?user=ud12418&password=192168100250");
//    	   
//            String sql = "select vstdate,oqueue from ovst where vstdate = curdate() order by vsttime asc" ;
//            s=connect.prepareStatement(sql);
//            rs = s.executeQuery();
//            
//            int row=0;
//            while((rs!=null)&& (rs.next())) {
//            	model.addRow(new Object[0]);
//            	model.setValueAt(rs.getString("oqueue").toString(), row, 0);
////            	model.setValueAt(rs.getString("hn"), row, 1);
//            	row++;
//            }
//            
//           
//    
//    } catch (SQLException e ) {
//        JOptionPane.showMessageDialog(null, e);
//    }
//  
//    }

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
			Logger.getLogger(HomeMain.class.getName()).log(Level.SEVERE,null,ex);
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
			java.util.logging.Logger.getLogger(Userqueue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Userqueue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Userqueue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Userqueue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
