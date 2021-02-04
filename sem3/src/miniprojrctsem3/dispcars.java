package miniprojrctsem3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class dispcars extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JTable cartable;
	private JTextField txtnoplate;
	private JTextField txtbrand;
	private JTextField txtmodel;
	private JTextField txtrent;
	private JTextField txtmilege;
	public static dispcars frame;
	public String qry="";
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new dispcars("");
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("ERROR : "+e);
					e.printStackTrace();
				}
			}
		});
	}
	public dispcars(String str1) {
		final String str=str1;
		
		if(str.equals("bookcar"))
			qry="select * from cardetails where noplate not in (select carnoplate from bookedcardetails where returndate is null)";
		else 
			qry="select * from cardetails";
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
					
						ResultSet rs=stmt.executeQuery(qry);		
				cartable.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex) {System.out.println("ERROR : "+ex);}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1092, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(353, 37, 698, 564);
		contentPane.add(scrollPane);
		
		final JButton btndelete = new JButton("Delete");
		btndelete.setBounds(40, 37, 89, 23);
		contentPane.add(btndelete);
		btndelete.setVisible(false);
		
		final JButton btnbookcar = new JButton("Book Car");
		btnbookcar.setBounds(195, 37, 89, 23);
		contentPane.add(btnbookcar);
				
		txtnoplate = new JTextField();
		txtnoplate.setBounds(195, 76, 86, 20);
		contentPane.add(txtnoplate);
		txtnoplate.setColumns(10);
		txtnoplate.disable();		
		
		txtbrand = new JTextField();
		txtbrand.setBounds(195, 124, 86, 20);
		contentPane.add(txtbrand);
		txtbrand.setColumns(10);
				
		txtmodel = new JTextField();
		txtmodel.setBounds(195, 174, 86, 20);
		contentPane.add(txtmodel);
		txtmodel.setColumns(10);
			
		txtrent = new JTextField();
		txtrent.setBounds(195, 229, 86, 20);
		contentPane.add(txtrent);
		txtrent.setColumns(10);		
		
		final JComboBox cmboxfuel = new JComboBox();
		cmboxfuel.setModel(new DefaultComboBoxModel(new String[] {"Petrol", "Diesel", "CNG", "Electricity"}));
		cmboxfuel.setBounds(195, 278, 86, 22);
		contentPane.add(cmboxfuel);		
		
		txtmilege = new JTextField();
		txtmilege.setBounds(195, 351, 86, 20);
		contentPane.add(txtmilege);		
		
		final JComboBox mboxtype = new JComboBox();
		mboxtype.setModel(new DefaultComboBoxModel(new String[] {"Hatchback", "Sedan","Micro Car", "SUV", "MPV", "Electric Cars"}));
		mboxtype.setBounds(195, 396, 86, 22);
		contentPane.add(mboxtype);
				
		btnbookcar.setVisible(false);
		btnbookcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookcar bk=new bookcar(txtnoplate.getText());
				bk.setVisible(true);
				dispose();
				
			}
		});
		
		final JLabel lblNewLabel = new JLabel("Number Plate");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(50, 79, 135, 14);
		contentPane.add(lblNewLabel);
				
		final JLabel lblNewLabel_1 = new JLabel("Brand");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(50, 127, 46, 14);
		contentPane.add(lblNewLabel_1);		
		
		final JLabel lblNewLabel_2 = new JLabel("Model Type");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(50, 177, 135, 14);
		contentPane.add(lblNewLabel_2);		
		
		final JLabel lblNewLabel_3 = new JLabel("Rent Amount");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(50, 232, 135, 14);
		contentPane.add(lblNewLabel_3);		
		
		final JLabel lblNewLabel_4 = new JLabel("Fuel");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(50, 282, 46, 14);
		contentPane.add(lblNewLabel_4);		
		
		final JLabel lblNewLabel_5 = new JLabel("Mileage");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(50, 354, 135, 14);
		contentPane.add(lblNewLabel_5);		
		
		final JLabel lblNewLabel_6 = new JLabel("Car Type");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(50, 400, 135, 14);
		contentPane.add(lblNewLabel_6);		
		
		final JButton btnupdate = new JButton("Update Car");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnupdate.setBounds(104, 472, 128, 23);
		contentPane.add(btnupdate);		
		
		mboxtype.setVisible(false);
		txtmilege.setVisible(false);
		cmboxfuel.setVisible(false);
		txtrent.setVisible(false);
		txtmodel.setVisible(false);
		txtnoplate.setVisible(false);
		txtbrand.setVisible(false);
		lblNewLabel.setVisible(false);
		btnupdate.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_1.setVisible(false);
				
		JButton btnhome = new JButton("Home");
		btnhome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				dashboard dsh=new dashboard();
				dsh.setVisible(true);
				dispose();
				}
				catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnhome.setBounds(117, 11, 89, 23);
		contentPane.add(btnhome);		
		
		cartable = new JTable();
		cartable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(str.equals("remove")){btndelete.setVisible(true);}
				if(str.equals("update")){
					mboxtype.setVisible(true);
					txtmilege.setVisible(true);
					cmboxfuel.setVisible(true);
					txtrent.setVisible(true);
					txtmodel.setVisible(true);
					txtnoplate.setVisible(true);
					txtbrand.setVisible(true);
					lblNewLabel.setVisible(true);
					btnupdate.setVisible(true);
					lblNewLabel_6.setVisible(true);
					lblNewLabel_5.setVisible(true);
					lblNewLabel_3.setVisible(true);
					lblNewLabel_4.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblNewLabel_1.setVisible(true);
					}
				if(str.equals("bookcar")){btnbookcar.setVisible(true);}				
				DefaultTableModel dtm=(DefaultTableModel)cartable.getModel();								
				txtmilege.setText((String)dtm.getValueAt(cartable.getSelectedRow(), 6));
				txtrent.setText((String)dtm.getValueAt(cartable.getSelectedRow(), 4));
				txtmodel.setText((String)dtm.getValueAt(cartable.getSelectedRow(), 2));
				txtbrand.setText((String)dtm.getValueAt(cartable.getSelectedRow(), 1));
				txtnoplate.setText((String)dtm.getValueAt(cartable.getSelectedRow(), 0));
				int i;
				for( i=0;i<3;i++) {
					if((boolean)dtm.getValueAt(cartable.getSelectedRow(), 5).equals(cmboxfuel.getItemAt(i).toString()))
						cmboxfuel.setSelectedIndex(i);
				}
				for( i=0;i<6;i++) {
					if((boolean)dtm.getValueAt(cartable.getSelectedRow(), 3).equals(mboxtype.getItemAt(i).toString()))
						mboxtype.setSelectedIndex(i);
				}			
			}
		});
		cartable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Plate Number","Brand", "Model", "Car Type", "Rent", "Fuel", "Mileage"
			}
		));		
	
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
					String plateno= txtnoplate.getText().toUpperCase();
					String brand= txtbrand.getText().toUpperCase();
					String model= txtmodel.getText().toUpperCase();
					String type= (String)mboxtype.getItemAt(mboxtype.getSelectedIndex());
					String rent= txtrent.getText().toUpperCase();
					String fuel= (String)cmboxfuel.getItemAt(cmboxfuel.getSelectedIndex());
					String mileage= txtmilege.getText().toUpperCase();
					String qry="Update cardetails set  brand='"+brand+"', modelno='"+model+"', type='"+type +"', rentamt='"+rent +"', fueltype='"+fuel +"', milage='"+ mileage+"' where noplate='"+plateno+"'";
					if(txtnoplate.getText().equals("")||txtbrand.getText().equals("")||txtmodel.getText().equals("")||txtrent.getText().equals("")||txtmilege.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ENTER ALL FIELDS");
					}
					else {
					stmt.executeQuery(qry);
					JOptionPane.showMessageDialog(null, "UPDATED");
					txtmilege.setText("");
					txtrent.setText("");
					txtmodel.setText("");
					txtbrand.setText("");
					txtnoplate.setText("");
					con.commit();
					}
					}
					catch(Exception ex) {System.out.println("ERROR : "+ex);}				
			}
		});
				
		scrollPane.setViewportView(cartable);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-03.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1076, 614);
		contentPane.add(lblNewLabel_7);
			
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= sqlcon.connect();
					PreparedStatement pst=con.prepareStatement("delete from cardetails where noplate=?");
					DefaultTableModel dtm=(DefaultTableModel)cartable.getModel();
					pst.setString(1, txtnoplate.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					btndelete.setVisible(false);
					con.commit();
					}
					catch(Exception ex) {System.out.println("ERROR : "+ex);}	
			}
		});	
	}
}
