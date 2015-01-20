package uas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Event;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuDepan extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblcek;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDepan frame = new MenuDepan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuDepan() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 350);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJudul1= new JLabel("SELAMAT DATANG");
		lblJudul1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblJudul1.setBounds(300, 1, 212, 48);
		contentPane.add(lblJudul1);
		
		JLabel lblJudul= new JLabel("DI TOKO OBAT HERBAL");
		lblJudul.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblJudul.setBounds(280, 25, 212, 48);
		contentPane.add(lblJudul);
		
		
		JButton btnRegistrasi= new JButton("Form Registrasi");
		btnRegistrasi.setBounds(386, 230, 258, 48);
		contentPane.add(btnRegistrasi);
		
		JButton btnLogin= new JButton("Login");
		btnLogin.setBounds(100, 230, 258, 48);
		contentPane.add(btnLogin);
		
		btnRegistrasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new regis().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new Login().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("img/logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(300, 11, 300, 257);
		contentPane.add(label);
		
	}

}
