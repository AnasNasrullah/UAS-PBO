package uas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class regis extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection konek = null;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtNama;
	private JTextField txtAlamat;
	private JTextField txtTelepon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regis frame = new regis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public regis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 380, 71, 14);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(98, 380, 192, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 410, 71, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(98, 410, 192, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setBounds(10, 440, 71, 14);
		contentPane.add(lblLevel);
		
		final JComboBox cmbLevel = new JComboBox();
		cmbLevel.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		cmbLevel.setBounds(98, 440, 101, 20);
		contentPane.add(cmbLevel);
		
		JLabel lblNama = new JLabel("Nama");
		lblNama.setBounds(10, 470, 71, 14);
		contentPane.add(lblNama);
		
		txtNama = new JTextField();
		txtNama.setBounds(98, 470, 192, 20);
		contentPane.add(txtNama);
		txtNama.setColumns(10);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setBounds(10, 500, 71, 14);
		contentPane.add(lblAlamat);
		
		txtAlamat = new JTextField();
		txtAlamat.setHorizontalAlignment(SwingConstants.LEFT);
		txtAlamat.setBounds(98, 500, 192, 46);
		contentPane.add(txtAlamat);
		txtAlamat.setColumns(10);
		
		JLabel lblTelepon = new JLabel("Telepon");
		lblTelepon.setBounds(10, 550, 71, 14);
		contentPane.add(lblTelepon);
		
		txtTelepon = new JTextField();
		txtTelepon.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelepon.setBounds(98, 550, 192, 20);
		contentPane.add(txtTelepon);
		txtTelepon.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			private String level;

			public void actionPerformed(ActionEvent arg0) {
				if(cmbLevel.getSelectedItem().equals("admin"))
				{
					level="admin";
				}
				else
				{
					level="user";
				}
				
				try 
				{
					Class.forName(koneksi.DATABASE_DRIVER);
					konek=DriverManager.getConnection(koneksi.URL, koneksi.USERNAME, koneksi.PASSWORD);
					String query="insert into users values(UNIQUEKEY('users'),'"+txtNama.getText()+"','"+txtUsername.getText()+"','"+txtPassword.getText()+"','"+level+"','"+txtAlamat.getText()+"','"+txtTelepon.getText()+"',0) ";
					PreparedStatement pst=konek.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "data saved");
					pst.close();

				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(100, 580, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblFormRegistrasi = new JLabel("Form Registrasi ");
		lblFormRegistrasi.setFont(new Font("Calibri", Font.PLAIN, 25));
		lblFormRegistrasi.setBounds(120, 11, 246, 23);
		contentPane.add(lblFormRegistrasi);
		
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("img/logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(100, 11, 300, 257);
		contentPane.add(label);
		
		JLabel lblFormRegistrasi1 = new JLabel("Silahkan Mendaftarkan Diri Anda");
		lblFormRegistrasi1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFormRegistrasi1.setBounds(30, 270, 400, 23);
		contentPane.add(lblFormRegistrasi1);
		
		JLabel lblFormRegistrasi2 = new JLabel("Untuk Memasuki Aplikasi Kami");
		lblFormRegistrasi2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblFormRegistrasi2.setBounds(40, 300, 400, 23);
		contentPane.add(lblFormRegistrasi2);
		
		JButton btnKembali = new JButton("Kembali");
		btnKembali.setBounds(200, 580, 89, 23);
		contentPane.add(btnKembali);
		
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new MenuDepan().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
}
