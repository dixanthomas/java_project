package miniprojrctsem3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class printing extends JFrame {

	public static  JPanel contentPane;
	public static printing frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					System.out.print("2 ");
					frame = new printing();
					frame.setLayout(new FlowLayout());
					JProgressBar progressBar = new JProgressBar();
					progressBar.setStringPainted(true);
					progressBar.setBounds(31, 94, 373, 23);
					frame.add(progressBar);
					System.out.print("1 ");
					frame.setVisible(true);
//					frame.setVisible(true);
					try {
					for(int i=0;i<=100;i++) {
						progressBar.setValue(i);
						Thread.sleep(50);
//						System.out.print("3 ");
						}
					}
					catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public printing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Printing....");
		lblNewLabel.setBounds(147, 150, 86, 23);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
