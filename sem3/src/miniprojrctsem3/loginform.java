package miniprojrctsem3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class loginform {

	private JFrame frame;
	private JTextField txtid;
	private JPasswordField pswd;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginform window = new loginform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public loginform() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtid = new JTextField();
		txtid.addMouseListener(new MouseAdapter() {
		});
		txtid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		txtid.setBounds(199, 208, 152, 20);
		frame.getContentPane().add(txtid);
		txtid.setColumns(10);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= sqlcon.connect();
					PreparedStatement pst= con.prepareStatement("select * from carlogin where id=? and pswd=?");
					pst.setString(1, txtid.getText());
					pst.setString(2, pswd.getText());
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						dashboard jtb=new dashboard();
						jtb.setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid ID/Password");
						frame.dispose();
					}
				}
				catch (Exception ee) {System.out.print("ERROR: "+ee);}
			}
		});
		btnlogin.setBounds(199, 343, 152, 43);
		frame.getContentPane().add(btnlogin);	
		
		pswd = new JPasswordField();
		pswd.setBounds(199, 264, 152, 20);
		frame.getContentPane().add(pswd);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(225, 239, 86, 14);
		frame.getContentPane().add(lblNewLabel);		
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(199, 177, 152, 20);
		frame.getContentPane().add(lblNewLabel_2);		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\idm\\sharex\\Screenshots\\2020-10\\QuickLook_7A2usxbVkx.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 568, 536);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
