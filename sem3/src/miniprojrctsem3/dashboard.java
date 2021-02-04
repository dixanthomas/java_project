package miniprojrctsem3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class dashboard extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static dashboard frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void closewin() {		
	}
	public dashboard() throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnaddcar = new JButton("Add Car");
		btnaddcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcarr dsp=new addcarr();
				dsp.setVisible(true);	
				dispose();
			}
		});
		btnaddcar.setBounds(10, 165, 126, 45);
		contentPane.add(btnaddcar);
		
		JButton btnremovecar = new JButton("Remove Car");
		btnremovecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispcars dsp=new dispcars("remove");
				dsp.setVisible(true);	
				dispose();
			}
		});
		btnremovecar.setBounds(10, 225, 126, 45);
		contentPane.add(btnremovecar);
		
		JButton btnavailcar = new JButton("Available Cars");
		btnavailcar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispcars dsp=new dispcars("bookcar");
				dsp.setVisible(true);
				dispose();
			}
		});
		btnavailcar.setBounds(10, 281, 126, 49);
		contentPane.add(btnavailcar);
		
		JButton btnupdate = new JButton("Update Cars");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispcars dsp=new dispcars("update");
				dsp.setVisible(true);	
				dispose();
			}
		});
		btnupdate.setBounds(10, 341, 126, 46);
		contentPane.add(btnupdate);
		
		JButton btnbookedcars = new JButton("Booked Cars");
		btnbookedcars.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookedcars bcar=new bookedcars();
				bcar.setVisible(true);
				dispose();				
			}
		});
		btnbookedcars.setBounds(10, 398, 126, 45);
		contentPane.add(btnbookedcars);
		
		JLabel lblNewLabel_3 = new JLabel("DLT CAR RENTING SERVICE");
		lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD, 30));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(199, 139, 602, 115);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\idm\\2020-hyundai-palisade-suv-01.jpg"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 929, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-03.jpg"));
		lblNewLabel_1.setBounds(0, 128, 148, 483);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\idm\\2019-hyundai-veloster-photo-01.jpg"));
		lblNewLabel_2.setBounds(126, 128, 803, 483);
		contentPane.add(lblNewLabel_2);		
	}
}
