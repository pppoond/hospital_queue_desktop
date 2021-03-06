/*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
// */
package hospital;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

/**
 *
 * @author warun
 */
public class Setting extends javax.swing.JFrame {

    /**
     * Creates new form Setdata
     */
    public Setting() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        HostField = new javax.swing.JTextField();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        DatabaseField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
//        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        
        setTitle("???????????");
        setPreferredSize(new java.awt.Dimension(500, 400));
		setSize(new java.awt.Dimension(500, 700));
		setLocation(new java.awt.Point(350, 10));
        getContentPane().setLayout(null);
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("hos.png"));
		setIconImage(logo.getImage());
		
        
        // *************************TextField *********************************
        
		readRemember();
        HostField.setFont(new java.awt.Font("Kanit", 0, 15)); // NOI18N
        HostField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
			
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("host");
					UsernameField.requestFocusInWindow();
			}
			}
		});
        getContentPane().add(HostField);
        HostField.setBounds(198, 87, 211, 34);
        
        
        
        
        UsernameField.setFont(new java.awt.Font("Kanit", 0, 15)); // NOI18N
        UsernameField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
			
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("user");
					PasswordField.requestFocusInWindow();
			}
			}
		});
        getContentPane().add(UsernameField);
        UsernameField.setBounds(198, 135, 211, 34);
        
        
        
        
        
//        PasswordField.setFont(new java.awt.Font("Kanit", 0, 15)); // NOI18N
//        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyPressed(java.awt.event.KeyEvent evt) {
//			
//				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.println("pass");
//					DatabaseField.requestFocusInWindow();
//			}
//			}
//		});
//        
//        
//        
//        getContentPane().add(PasswordField);
//        PasswordField.setBounds(198,183,211,34);
//        
//        
//        
//
//        DatabaseField.setFont(new java.awt.Font("Kanit", 0, 15)); // NOI18N
//        DatabaseField.addKeyListener(new java.awt.event.KeyAdapter() {
//			public void keyPressed(java.awt.event.KeyEvent evt) {
//			
//				if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.println("db");
//					jButton2.requestFocusInWindow();
//			}
//			}
//		});
//        
//        getContentPane().add(DatabaseField);
//        DatabaseField.setBounds(198, 227, 211, 34);

        
        
        
        
        
        
        
        
        
        
        
        jButton2.setFont(new java.awt.Font("Kanit", 0, 18)); // NOI18N
        jButton2.setText("??????");
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 295, 110, 37);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/11.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
					
				JOptionPane.showMessageDialog(null,jLabel6,"?????????",JOptionPane.INFORMATION_MESSAGE);
				
				if(jCheckBox1.isSelected()) {
					System.out.println("Check");
					
					deleteRemember();
					addRemember();
						
//					deletefile();
//					writefile();
			
				}else {
					System.out.println("Not Check");
				}
				
			}
		});
        
        
        
        
        jLabel1.setFont(new java.awt.Font("Kanit", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("????????????????");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(136, 13, 223, 38);

        jLabel2.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        jLabel2.setText("Server Host");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(87, 88, 93, 34);

//        jLabel3.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
//        jLabel3.setText("Password");
//        getContentPane().add(jLabel3);
//        jLabel3.setBounds(87, 184, 106, 34);

        jLabel4.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        jLabel4.setText("Client Host");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(87, 136, 106, 34);
//
//        jLabel5.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
//        jLabel5.setText("Database");
//        getContentPane().add(jLabel5);
//        jLabel5.setBounds(87, 228, 80, 34);
//        
        jLabel6.setFont(new java.awt.Font("Kanit", 0, 14)); // NOI18N
        jLabel6.setText("?????????????????????");
//        getContentPane().add(jLabel5);
//        
        
        
        
        jCheckBox1.setFont(new java.awt.Font("Kanit", 2, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox1.setText("Remember");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
               
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(200, 180, 110, 25);

        pack();
    }// </editor-fold>                        

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Setting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Setting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField HostField;
    private javax.swing.JTextField UsernameField;
    private javax.swing.JPasswordField  PasswordField;
    private javax.swing.JTextField DatabaseField;
    private javax.swing.JCheckBox jCheckBox1;
    // End of variables declaration              
    
    
    public void writefile() {
    	String path = "D:\\\\thaicreate.txt";
		File file = new File(path);
		
		FileWriter writer;
		try {
			
			writer = new FileWriter(file, true);  //True = Append to file, false = Overwrite
			writer.write(HostField.getText()+"\n");
			writer.write(UsernameField.getText()+"\n");
//			writer.write(PasswordField.getText()+"\n");
//			writer.write(DatabaseField.getText()+"\n");
			writer.close();
			
			System.out.println("Write success!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
    
    public void deletefile() {
    	PrintWriter writer;
		try {
			writer = new PrintWriter("D:\\thaicreate.txt");
			writer.print("");
			// other operations
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    
    
    
    public void addRemember() {
    	
    	Connection conn = null;
	    PreparedStatement stmt = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        String url = "jdbc:mysql://180.180.216.192:3306/db_ud12418";
	        String mysqlUserName = "ud12418";
	        String mysqlPassword = "192168100250";
	        conn = DriverManager.getConnection(url,mysqlUserName,mysqlPassword);
	        String sql = "INSERT INTO remember(host_name,username) VALUES ('"+ HostField.getText() +"' ,"
	        		+ "'"+ UsernameField.getText() +"')";
	        stmt = conn.prepareStatement(sql);  
	        stmt.executeUpdate();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally {
	        try {
	            if (conn!=null)
	                conn.close();
	        }catch (SQLException e){

	        }
	        try {
	            if (stmt!=null)
	                stmt.close();
	        }catch (SQLException e){

	        }
	    }
    }
    
    
    public void deleteRemember() {
    	Connection connect = null;
		PreparedStatement s = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://180.180.216.192:3306/db_ud12418"
							+ "?user=ud12418&password=192168100250");


			s = connect.prepareStatement("delete from remember");
			s.executeUpdate();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
    }
    
    
    public void readRemember() {
    	Connection connect = null;
		PreparedStatement s = null;
		ResultSet rs = null;

		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			connect = DriverManager
					.getConnection("jdbc:mysql://180.180.216.192:3306/db_ud12418"
							+ "?user=ud12418&password=192168100250");
    	   
            String sql = "SELECT * from remember";
            s=connect.prepareStatement(sql);
            rs = s.executeQuery();
            
            if(rs.next()) { 
                String ID = rs.getString("host_name");
                HostField.setText(ID);
                String FN = rs.getString("username");
                UsernameField.setText(FN);
//                String LN = rs.getString("password");
//                PasswordField.setText(LN);
//                String Des = rs.getString("db_name");
//                DatabaseField.setText(Des);
              

            }
    
    } catch (SQLException e ) {
        JOptionPane.showMessageDialog(null, e);
    }
  
    }
    
    
    
   
    
    
}


