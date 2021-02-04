package miniprojrctsem3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class bookcar extends JFrame {
	private JPanel contentPane;
	private JTextField txtnoplate;
	private JTextField txtcustname;
	private JTextField txtlicenceno;
	public static bookcar frame;
	private JTextField txtmobno;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new bookcar("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public bookcar(String str) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		final JComboBox cmbyear = new JComboBox();
		cmbyear.setBounds(396, 236, 73, 22);
		{
			DateFormat df = new SimpleDateFormat("yyyy");
			Calendar calobj = Calendar.getInstance();
	        int year=Integer.parseInt(df.format(calobj.getTime()));
	        for(int i=0;i<=3;i++)	cmbyear.addItem(year+i);
			}
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(51, 350, 147, 14);
		contentPane.add(lblNewLabel_5);
		
		txtmobno = new JTextField();
		txtmobno.setBounds(254, 347, 115, 20);
		contentPane.add(txtmobno);
		txtmobno.setColumns(10);
		contentPane.add(cmbyear);
		
		final JComboBox cmdmonth = new JComboBox();
		cmdmonth.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		cmdmonth.setBounds(320, 236, 66, 22);
		{
			DateFormat df = new SimpleDateFormat("MM");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmdmonth.setSelectedIndex(Integer.parseInt(mon)-1);
	    }
		contentPane.add(cmdmonth);
				
		final JComboBox cmbday = new JComboBox();
		cmbday.setBounds(254, 236, 56, 22);
		for(int i=1;i<=31;i++)	cmbday.addItem(i);
		{
			DateFormat df = new SimpleDateFormat("dd");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmbday.setSelectedIndex(Integer.parseInt(mon)-1);
		}	        
		contentPane.add(cmbday);
		
		final JComboBox cmbrday = new JComboBox();
		cmbrday.setBounds(254, 302, 56, 22);
		for(int i=1;i<=31;i++)	cmbrday.addItem(i);
		{
			DateFormat df = new SimpleDateFormat("dd");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmbrday.setSelectedIndex(Integer.parseInt(mon)-1);
		}
		contentPane.add(cmbrday);
		
		final JComboBox cmbrmonth = new JComboBox();
		cmbrmonth.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		
		cmbrmonth.setBounds(320, 302, 66, 22);
		{
			DateFormat df = new SimpleDateFormat("MM");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        cmbrmonth.setSelectedIndex(Integer.parseInt(mon)-1);
	    }
		contentPane.add(cmbrmonth);
		
		final JComboBox cmbryear = new JComboBox();
		cmbryear.setBounds(396, 302, 73, 22);
		{
			DateFormat df = new SimpleDateFormat("yyyy");
			Calendar calobj = Calendar.getInstance();
	        int year=Integer.parseInt(df.format(calobj.getTime()));
	        for(int i=0;i<=3;i++)	cmbryear.addItem(year+i);
			}
		contentPane.add(cmbryear);		
		
		cmbrday.setVisible(false);
		cmbrmonth.setVisible(false);
		cmbryear.setVisible(false);		
		
		txtnoplate = new JTextField();
		txtnoplate.setBounds(254, 58, 115, 20);
		contentPane.add(txtnoplate);
		txtnoplate.setColumns(10);
		txtnoplate.setText(str);
		txtnoplate.disable();
		
		txtcustname = new JTextField();
		txtcustname.setBounds(254, 118, 115, 20);
		contentPane.add(txtcustname);
		txtcustname.setColumns(10);
		
		txtlicenceno = new JTextField();
		txtlicenceno.setBounds(254, 182, 115, 20);
		contentPane.add(txtlicenceno);
		txtlicenceno.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Number Plate");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(51, 60, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(51, 120, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Driving Licence Number");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(51, 184, 182, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Booking Date");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(51, 239, 108, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Return date");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(51, 305, 94, 14);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		JButton btnbookcar = new JButton("Book Car");
		btnbookcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from bookedcardetails");
					String bdate="";
					String rdate="";
					int n=0;
					while(rs.next())
					{ n=(rs.getRow());}
					n++;
					PreparedStatement pst=con.prepareStatement("insert into bookedcardetails ( cid,custname,custlicenceno,carnoplate,bookdate,mobno) values(?,?,?,?,?,?)");
					if(txtcustname.getText().equals("")||txtlicenceno.getText().equals("")||txtmobno.getText().equals("")){
						JOptionPane.showMessageDialog(null, "ENTER ALL FIELDS");
					}
					else if(txtmobno.getText().length()!=10) {
						JOptionPane.showMessageDialog(null, "ENTER VALID MOBILE NNUMBER");
					}
					else {
						bdate=cmbday.getSelectedItem().toString()+'-'+cmdmonth.getSelectedItem().toString()+"-"+cmbyear.getSelectedItem().toString();
					pst.setString(1, Integer.toString(n));
					pst.setString(2, txtcustname.getText().toUpperCase());
					pst.setString(3, txtlicenceno.getText().toUpperCase());
					pst.setString(4, txtnoplate.getText().toUpperCase());
					pst.setString(5, (bdate));
					pst.setString(6, txtmobno.getText().toString());						
					pst.executeQuery();
					JOptionPane.showMessageDialog(null, "BOOKED");
					dispcars dsp=new dispcars("bookcar");
					dsp.setVisible(true);
					dispose();
					}
				}
					catch(Exception ex) {System.out.println("ERROR : "+ex);}	
			}
		});
		btnbookcar.setBounds(254, 405, 89, 23);
		contentPane.add(btnbookcar);		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-06.jpg"));
		lblNewLabel_7.setBounds(0, 0, 557, 439);
		contentPane.add(lblNewLabel_7);
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-06.jpg"));
		lblNewLabel_7.setBounds(0, 0, 557, 439);
		contentPane.add(lblNewLabel_7);
	}
}
