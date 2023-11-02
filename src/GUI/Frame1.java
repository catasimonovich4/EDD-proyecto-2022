package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Programa.*;

public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	static Programa program;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		program = new Programa(); 
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 101);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String materia = textField.getText();
				if (materia.isBlank())
					JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la materia.");
				else {
						program.setMateria(materia);
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente la materia ingresada.");
						frame.dispose();
						Frame2 ingresoLUNota = new Frame2(program);
						ingresoLUNota.setVisible(true); 
				}
			}
		});
		btnNewButton.setBounds(336, 30, 88, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(57, 31, 269, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Materia");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 34, 63, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese el nombre de la materia:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(93, 11, 300, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
