package miniprojrctsem3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class addcarr extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtnoplate;
	private JTextField txtbrand;
	private JTextField txtmodel;
	private JTextField txtrent;
	private JTextField txtmilege;
	public static addcarr frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new addcarr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public addcarr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtnoplate = new JTextField();
		txtnoplate.setBounds(201, 51, 86, 20);
		contentPane.add(txtnoplate);
		txtnoplate.setColumns(10);
		
		txtbrand = new JTextField();
		txtbrand.setBounds(201, 113, 86, 20);
		contentPane.add(txtbrand);
		txtbrand.setColumns(10);
		
		txtmodel = new JTextField();
		txtmodel.setBounds(201, 176, 86, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
		
		txtrent = new JTextField();
		txtrent.setBounds(201, 245, 86, 20);
		contentPane.add(txtrent);
		txtrent.setColumns(10);
		
		txtmilege = new JTextField();
		txtmilege.setBounds(602, 160, 86, 20);
		contentPane.add(txtmilege);
		txtmilege.setColumns(10);
		
		final JComboBox cmboxfuel = new JComboBox();
		cmboxfuel.setModel(new DefaultComboBoxModel(new String[] {"Petrol", "Diesel", "CNG", "Electricity"}));
		cmboxfuel.setBounds(602, 112, 86, 22);
		contentPane.add(cmboxfuel);
		
		final JComboBox cmboxtype = new JComboBox();
		cmboxtype.setModel(new DefaultComboBoxModel(new String[] {"Hatchback", "Sedan", "Micro Car", "SUV", "MPV", "Electric Cars"}));
		cmboxtype.setBounds(602, 50, 77, 22);
		contentPane.add(cmboxtype);
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
					PreparedStatement pst=con.prepareStatement("insert into cardetails values(?,?,?,?,?,?,?)");
					if(txtnoplate.getText().equals("")||txtbrand.getText().equals("")||txtmodel.getText().equals("")||txtrent.getText().equals("")||txtmilege.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ENTER ALL FIELDS");
					}
					else {
					pst.setString(1, txtnoplate.getText().toUpperCase());
					pst.setString(2, txtbrand.getText().toUpperCase());
					pst.setString(3, txtmodel.getText().toUpperCase());
					pst.setString(4, (String)cmboxtype.getItemAt(cmboxtype.getSelectedIndex()));
					pst.setString(5, (txtrent.getText()));
					pst.setString(6, (String)cmboxfuel.getItemAt(cmboxfuel.getSelectedIndex()));
					pst.setString(7, (txtmilege.getText()));	
					pst.executeQuery();
					JOptionPane.showMessageDialog(null, "ADDED");
					txtmilege.setText("");
					txtrent.setText("");
					txtmodel.setText("");
					txtbrand.setText("");
					txtnoplate.setText("");
					}
					}
					catch(Exception ex) {System.out.println("ERROR : "+ex);}				
			}
		});
		btnadd.setBounds(476, 244, 89, 23);
		contentPane.add(btnadd);
		
		JLabel lblNewLabel = new JLabel("NUMBER PLATE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(46, 54, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BRAND");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(46, 54, 115, 14);
		lblNewLabel_1.setBounds(46, 116, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MODEL NUMBER");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(46, 54, 115, 14);
		lblNewLabel_2.setBounds(46, 179, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RENT AMOUNT");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(46, 54, 115, 14);
		lblNewLabel_3.setBounds(46, 248, 145, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("FUEL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(46, 54, 115, 14);
		lblNewLabel_4.setBounds(476, 116, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MILEGE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(46, 54, 115, 14);
		lblNewLabel_5.setBounds(476, 163, 116, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CAR TYPE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(46, 54, 115, 14);
		lblNewLabel_6.setBounds(476, 54, 116, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnhome = new JButton("Home");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dashboard dsh=new dashboard();
					dsh.setVisible(true);
					dispose();					
				} 
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnhome.setBounds(602, 244, 89, 23);
		contentPane.add(btnhome);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-06.jpg"));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 0, 729, 309);
		contentPane.add(lblNewLabel_7);
	}
}
