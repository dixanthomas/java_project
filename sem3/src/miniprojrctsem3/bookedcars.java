package miniprojrctsem3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class bookedcars extends JFrame {

	private JPanel contentPane;
	private static JTable tblbookedcars;
	private JTextField txtname;
	private JTextField txtlicenceno;
	public String sno;
	public int sn;
	private JTextField txtmobno;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookedcars frame = new bookedcars();
					frame.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public bookedcars() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from bookedcardetails order by cid");		
				tblbookedcars.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex) {System.out.println("ERROR : "+ex);}
			}
		});	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JComboBox cmbyear = new JComboBox();
		cmbyear.setBounds(286, 180, 57, 22);
		{
			DateFormat df = new SimpleDateFormat("yyyy");
			Calendar calobj = Calendar.getInstance();
	        int year=Integer.parseInt(df.format(calobj.getTime()));
	        for(int i=0;i<=3;i++)	cmbyear.addItem(year+i);
			}
		contentPane.add(cmbyear);
		
		final JComboBox cmbryear = new JComboBox();
		{
			DateFormat df = new SimpleDateFormat("yyyy");
			Calendar calobj = Calendar.getInstance();
	        int year=Integer.parseInt(df.format(calobj.getTime()));
	        for(int i=0;i<=3;i++)	cmbryear.addItem(year+i);
			}
		cmbryear.setBounds(286, 241, 57, 22);
		contentPane.add(cmbryear);
		
		final JComboBox cmbrmonth = new JComboBox();
		cmbrmonth.setBounds(216, 241, 57, 22);
		cmbrmonth.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		{
			DateFormat df = new SimpleDateFormat("MM");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        cmbrmonth.setSelectedIndex(Integer.parseInt(mon)-1);
	    }
		contentPane.add(cmbrmonth);
		
		final JComboBox cmbrday = new JComboBox();
		for(int i=1;i<=31;i++)	cmbrday.addItem(i);
		{
			DateFormat df = new SimpleDateFormat("dd");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmbrday.setSelectedIndex(Integer.parseInt(mon)-1);
		}
		cmbrday.setBounds(158, 241, 51, 22);
		contentPane.add(cmbrday);
		
		final JComboBox cmbmonth = new JComboBox();
		cmbmonth.setBounds(216, 180, 57, 22);
		cmbmonth.setModel(new DefaultComboBoxModel(new String[] {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		{
			DateFormat df = new SimpleDateFormat("MM");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmbmonth.setSelectedIndex(Integer.parseInt(mon)-1);
	    }
		contentPane.add(cmbmonth);
		
		final JComboBox cmbday = new JComboBox();
		for(int i=1;i<=31;i++)	cmbday.addItem(i);
		{
			DateFormat df = new SimpleDateFormat("dd");
			Calendar calobj = Calendar.getInstance();
	        String mon=(String)(df.format(calobj.getTime()));
	        		cmbday.setSelectedIndex(Integer.parseInt(mon)-1);
		}
		cmbday.setBounds(158, 180, 51, 22);
		contentPane.add(cmbday);
		
		txtmobno = new JTextField();
		txtmobno.setBounds(197, 314, 86, 20);
		contentPane.add(txtmobno);
		txtmobno.setColumns(10);
		
		final JLabel lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(33, 316, 115, 14);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();		
		scrollPane.setBounds(353, 28, 693, 571);
		contentPane.add(scrollPane);
		
		txtname = new JTextField();
		txtname.setBounds(197, 57, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);		
		
		txtlicenceno = new JTextField();
		txtlicenceno.setBounds(197, 119, 86, 20);
		contentPane.add(txtlicenceno);
		txtlicenceno.setColumns(10);		
		
		final JLabel lblNewLabel = new JLabel("Customer Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 60, 134, 14);
		contentPane.add(lblNewLabel);		
		
		final JLabel lblNewLabel_1 = new JLabel("Licence No.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 122, 134, 14);
		contentPane.add(lblNewLabel_1);		
		
		final JLabel lblNewLabel_2 = new JLabel("Book Date");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 183, 115, 14);
		contentPane.add(lblNewLabel_2);		
		
		final JLabel lblNewLabel_3 = new JLabel("Return Date");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(38, 244, 110, 14);
		contentPane.add(lblNewLabel_3);
		
		final JButton btnupdate = new JButton("Update");
		
		btnupdate.setBounds(120, 371, 115, 23);
		contentPane.add(btnupdate);		
		
		btnupdate.setVisible(false);
		lblNewLabel_3.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel.setVisible(false);
		txtlicenceno.setVisible(false);
		txtname.setVisible(false);
		txtmobno.setVisible(false);
		cmbday.setVisible(false);
		cmbmonth.setVisible(false);
		cmbyear.setVisible(false);
		cmbrday.setVisible(false);
		cmbrmonth.setVisible(false);
		cmbryear.setVisible(false);
		
		tblbookedcars = new JTable();
		tblbookedcars.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				 String date;
				 String dd;
				 String mm;
				 String yyyy;
				 String rdate;
				 String rdd;
				 String rmm;
				 String ryyyy;
				
				btnupdate.setVisible(true);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel.setVisible(true);
				cmbday.setVisible(true);
				cmbmonth.setVisible(true);
				cmbyear.setVisible(true);
				cmbrday.setVisible(true);
				cmbrmonth.setVisible(true);
				cmbryear.setVisible(true);
				lblNewLabel_5.setVisible(true);
				
				txtlicenceno.setVisible(true);
				txtname.setVisible(true);
				txtmobno.setVisible(true);
				
				DefaultTableModel dtm=(DefaultTableModel)tblbookedcars.getModel();
				sno=dtm.getValueAt(tblbookedcars.getSelectedRow(), 0).toString();
				sn=Integer.parseInt(sno);
				txtname.setText((String)dtm.getValueAt(tblbookedcars.getSelectedRow(), 1));
				txtlicenceno.setText((String)dtm.getValueAt(tblbookedcars.getSelectedRow(), 2));
				date=dtm.getValueAt(tblbookedcars.getSelectedRow(), 4).toString();
				dd=date.substring(8, 10);
				mm=date.substring(5, 7);
				yyyy=date.substring(0,4);	
				cmbday.setSelectedIndex(Integer.parseInt(dd)-1);
				cmbmonth.setSelectedIndex(Integer.parseInt(mm)-1);
				for(int i=0;i<3;i++)	{
		        	if(yyyy.equals(cmbyear.getItemAt(i).toString())) {
		        		cmbyear.setSelectedIndex(i);}}
				txtmobno.setText(dtm.getValueAt(tblbookedcars.getSelectedRow(), 6).toString());
			}
		});
		
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con= sqlcon.connect();
					Statement stmt= con.createStatement();
					String name= txtname.getText();
					String rdate= cmbday.getSelectedItem().toString()+'-'+cmbmonth.getSelectedItem().toString()+"-"+cmbyear.getSelectedItem().toString();
					String bdate=cmbrday.getSelectedItem().toString()+'-'+cmbrmonth.getSelectedItem().toString()+"-"+cmbryear.getSelectedItem().toString();
					String lno= txtlicenceno.getText();
					int mobno=Integer.parseInt(txtmobno.getText());
					String qry="Update bookedcardetails set  custname ='"+name+"', custlicenceno ='"+lno+"', bookdate ='"+bdate +"', returndate ='"+rdate +"',mobno="+mobno+"  where cid="+sn+"";
					if(txtlicenceno.getText().equals("")||txtname.getText().equals("")||txtmobno.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "ENTER ALL FIELDS");
					}
					else {
					stmt.executeQuery(qry);
					JOptionPane.showMessageDialog(null, "UPDATED");
					txtmobno.setText("");			
					txtlicenceno.setText("");
					txtname.setText("");					
					con.commit();
					}
					}
					catch(Exception ex) {System.out.println("ERROR1 : "+ex);}		
			}
		});
		
		tblbookedcars.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S No", "Customer Name", "Licence No.", "Car No. Plate", "Book Date", "Return Date", "Mobile No."
			}
		));
		tblbookedcars.getColumnModel().getColumn(1).setPreferredWidth(109);
		tblbookedcars.getColumnModel().getColumn(3).setPreferredWidth(88);
		scrollPane.setViewportView(tblbookedcars);
		
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
		btnhome.setBounds(120, 11, 89, 23);
		contentPane.add(btnhome);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-01.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1072, 624);
		contentPane.add(lblNewLabel_4);
		txtname.setVisible(false);
	}
}
