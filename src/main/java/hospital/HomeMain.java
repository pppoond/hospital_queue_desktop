package hospital;

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
import page.Er;
import page.Opd;

/**
 *
 * @author warun
 */
public class HomeMain extends javax.swing.JFrame {

	
	/**
	 * Creates new form user
	 */
	public HomeMain() {
		initComponents();
	}
	
	String depcode = "";
	ArrayList<HosqDepartmentModel> hosqArrList = new ArrayList<HosqDepartmentModel>();
	ArrayList<OpdDepQueueModel> opdArrList = new ArrayList<OpdDepQueueModel>();
	Api api = new Api();
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton JButton2;
	private javax.swing.JButton JButton3;
	private javax.swing.JButton JButton4;
	private javax.swing.JButton JButton5;
	private javax.swing.JButton JButton6;
	private javax.swing.JButton JButton7;

	public javax.swing.JTextField jTextField2;
	public javax.swing.JTextField jTextFieldPtname;
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
	
	// End of variables declaration

	@SuppressWarnings("unchecked")
	private void initComponents() {

		Api api = new Api();
		new CustomFont();
		jTextField2 = new javax.swing.JTextField();
		
		jButton1 = new javax.swing.JButton();
		JButton2 = new javax.swing.JButton();
		JButton3 = new javax.swing.JButton();
		JButton4 = new javax.swing.JButton();
		JButton5 = new javax.swing.JButton();
		JButton6 = new javax.swing.JButton();
		JButton7 = new javax.swing.JButton();
		
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

//		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		setTitle("หน้าหลัก");
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("doctor.png"));
		setIconImage(logo.getImage());
		setAlwaysOnTop(true);
		setAutoRequestFocus(false);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setPreferredSize(new java.awt.Dimension(280, 405));
		setSize(new java.awt.Dimension(300, 420));
		getContentPane().setLayout(null);

//		selectCombo();
//		getComboBox();

		
		
		
		
		
		// Button

		jButton1.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		jButton1.setText(" ผู้ป่วยนอก");
		jButton1.setBounds(30, 30, 220, 30);
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opd.png"))); // NOI18N
		getContentPane().add(jButton1);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				dispose();
				Opd OpdPage = new Opd();
				OpdPage.setVisible(true);
				System.out.println("ผู้ป่วยนอก");
				
				
			}
		});

		
		
		

		JButton2.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton2.setText(" อุบัติเหตุฉุกเฉิน");
		JButton2.setBounds(30, 70, 220, 30);
		JButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emergency.png"))); // NOI18N
		getContentPane().add(JButton2);
		JButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				dispose();
				Er ErPage = new Er();
				ErPage.setVisible(true);
				System.out.println("อุบัติเหตุฉุกเฉิน");
			}
		});
		
		
		
		JButton3.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton3.setText(" การเงินและยา");
		JButton3.setBounds(30, 110, 220, 30);
		JButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drug.png"))); // NOI18N
		getContentPane().add(JButton3);
		JButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("การเงินและยา");
			}
		});
		
		
		
		JButton4.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton4.setText(" เทคนิคการแพทย์");
		JButton4.setBounds(30, 150, 220, 30);
		JButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab.png"))); // NOI18N
		getContentPane().add(JButton4);
		JButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("เทคนิคการแพทย์");
			}
		});
		
		
		
		JButton5.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton5.setText(" ทันตกรรม");
		JButton5.setBounds(30, 190, 220, 30);
		JButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toothss.png"))); // NOI18N
		getContentPane().add(JButton5);
		JButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("ทันตกรรม");
			}
		});
		
		
		
		JButton6.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton6.setText(" ฟื้นฟู");
		JButton6.setBounds(30, 230, 220, 30);
		JButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/muscle2.png"))); // NOI18N
		getContentPane().add(JButton6);
		JButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ฟื้นฟู");
			}
		});
		
		
		JButton7.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
		JButton7.setText(" เว็ปไซต์");
		JButton7.setBounds(30, 300, 220, 30);
		JButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/web2.png"))); // NOI18N
		getContentPane().add(JButton7);
		JButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
				System.out.println("เว็ปไซต์");
				ButtonWeb(evt);
			
			}
		});
		
		
		// Menu
		jMenu1.setText("แผนก");
		jMenu1.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N
		
		jMenu2.setText("รายการคิว");
		jMenu2.setFont(new java.awt.Font("Kanit", 0, 13)); // NOI18N

		jMenuItem1.setText("ผู้ป่วยนอก");
		jMenuItem1.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/opd.png")));
//		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ผู้ป่วยนอก");
//				Setting settingPage = new Setting();
//				settingPage.setVisible(true);
			}
		});
 
		jMenuItem2.setText("อุบัติเหตุฉุกเฉิน");
		jMenuItem2.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/emergency.png")));
//		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("อุบัติเหตุฉุกเฉิน");
//				Setting settingPage = new Setting();
//				settingPage.setVisible(true);
			}
		});
		
		jMenuItem3.setText("การเงินและยา");
		jMenuItem3.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drug.png")));
//		jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("การเงินและยา");
			}
		});
		
		jMenuItem5.setText("เทคนิคการแพทย์");
		jMenuItem5.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lab.png")));
//		jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("เทคนิคการแพทย์");
				
			}
		});
		
		jMenuItem6.setText("ทันตกรรม");
		jMenuItem6.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toothss.png")));
//		jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ทันตกรรม");
			}
		});
		
		jMenuItem7.setText("ฟื้นฟู");
		jMenuItem7.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/heal.png")));
//		jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
		jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.out.println("ฟื้นฟู");
			}
		});
		
		
		jMenuItem8.setText("รายการคิวที่เรียกไปแล้ว");
		jMenuItem8.setFont(new java.awt.Font("Kanit", 0, 12)); // NOI18N
		jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/queue2.png")));
//		jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
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
//		jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
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



	}// </editor-fold>

	
	
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
			java.util.logging.Logger.getLogger(HomeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(HomeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(HomeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(HomeMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new HomeMain().setVisible(true);
			}
		});

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
