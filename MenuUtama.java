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

public class MenuUtama extends JFrame {

	private JPanel contentPane;
	private JLabel lblcek;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUtama frame = new MenuUtama();
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
	public MenuUtama() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 472);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFormProduct = new JButton("Form Product");
		btnFormProduct.setBounds(100, 250, 258, 48);
		contentPane.add(btnFormProduct);
		
		
		JButton btnFormSupplier = new JButton("Form Supplier");
		btnFormSupplier.setBounds(100, 310, 258, 48);
		contentPane.add(btnFormSupplier);
		
		JButton btnFormStockBarang = new JButton("Form Stock Barang");
		btnFormStockBarang.setBounds(386, 250, 258, 48);
		contentPane.add(btnFormStockBarang);
		
		JLabel lblMenuUtama = new JLabel("Menu Utama");
		lblMenuUtama.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 20));
		lblMenuUtama.setBounds(330, 11, 212, 48);
		contentPane.add(lblMenuUtama);
		
		JButton btnFormMenuUser = new JButton("Form Menu User");
		btnFormMenuUser.setBounds(386, 310, 258, 48);
		contentPane.add(btnFormMenuUser);
		
		JButton btnLaporan = new JButton("Laporan");
		btnLaporan.setBounds(250, 370, 258, 48);
		contentPane.add(btnLaporan);
		
		JButton btnKeluar = new JButton("Keluar");
		btnKeluar.setBounds(650, 5, 100, 20);
		contentPane.add(btnKeluar);
		
	
		JLabel label = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("img/logo.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(300, 11, 300, 257);
		contentPane.add(label);
		
		
		//action
		btnFormProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new Mproduct().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnFormSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new Msuppliers().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnFormStockBarang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new MStok().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		
		btnFormMenuUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new Muser().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnLaporan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					new Laporan().setVisible(true);
					dispose();
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		btnKeluar.addActionListener(new ActionListener() {
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
		
		
	}
}
