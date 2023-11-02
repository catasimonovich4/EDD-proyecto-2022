package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Programa.Par;
import Programa.Programa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Auxiliares.Entry;
import Excepciones.*;

public class Frame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLU;
	private JTextField textFieldNota;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
    static Programa program;
    private JTable table;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    
	
	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2(program);
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
	public Frame2(Programa program) {
		this.program = program;
		setBackground(new Color(128, 128, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 30, 216, 159);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"LU", "Nota"
			}
		));
		scrollPane.setViewportView(table);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		JButton btnIngresarDatos = new JButton("Ingresar");
		btnIngresarDatos.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if (textFieldLU.getText().isBlank() | textFieldNota.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Por favor, ingrese los datos correspondientes.");
				else {	if (textFieldLU.getText().length() != 6 || includesChar(textFieldLU.getText()) || includesChar(textFieldNota.getText()) || Integer.parseInt(textFieldNota.getText()) < 1 || Integer.parseInt(textFieldNota.getText()) > 10 )
								JOptionPane.showMessageDialog(null, "Formato erroneo. El LU ingresado debe contener 6 digitos numericos. La nota debe ser un numero entre 1 y 10.");
						else {
								boolean ok = program.setListaPares(Integer.parseInt(textFieldLU.getText()), Integer.parseInt(textFieldNota.getText()));
								if (ok) {
									JOptionPane.showMessageDialog(null, "Se han registrado correctamente los datos.");
									Object[] row = new Object[2];
									row[0] = textFieldLU.getText();
									row[1] = textFieldNota.getText();
									model.addRow(row);
								 	textFieldLU.setText(null);
									textFieldNota.setText(null);
								} else {
									JOptionPane.showMessageDialog(null, "El LU ingresado ya pertenece a la lista.");
									textFieldLU.setText(null);
									textFieldNota.setText(null);
								}
								
						}
				}
			}
		});
		btnIngresarDatos.setBounds(68, 163, 89, 23);
		contentPane.add(btnIngresarDatos);
		
		textFieldLU = new JTextField();
		textFieldLU.setBounds(99, 101, 187, 20);
		contentPane.add(textFieldLU);
		textFieldLU.setColumns(10);
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(99, 132, 187, 20);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
		
		lblNewLabel = new JLabel("LU");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(58, 103, 31, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nota");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(58, 133, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ingrese el LU del alumno y la nota correspondiente:");
		lblNewLabel_2.setBounds(20, 69, 314, 21);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setForeground(new Color(128, 128, 255));
		lblNewLabel_3.setText(program.getMateria());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(82, 27, 225, 31);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(440, 200, 132, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Promedio");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(356, 202, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(440, 231, 132, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nota minima");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(356, 233, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  textField_2.setText(Float.toString(program.promedioTotal()));
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		});
		btnNewButton_1.setBounds(597, 199, 101, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Calcular");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  textField_3.setText(Integer.toString(program.minNota()));
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados");
				}
			}
		});
		btnNewButton_2.setBounds(597, 230, 101, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Todos");
		JButton btnNewButton_4 = new JButton("Aprobados");
		JButton btnNewButton_6 = new JButton("Ordenar");
		btnNewButton_3.setEnabled(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setEnabled(false);
				btnNewButton_6.setEnabled(true);
				btnIngresarDatos.setEnabled(true);
				model.setRowCount(0);
				for (Par<Integer,Integer> entry: program.showAll()) {
					Object[] row = new Object[2];
					row[0] = entry.getLU();
					row[1] = entry.getNota();
					model.addRow(row);
				}
			}
		});
		btnNewButton_3.setBounds(597, 33, 101, 23);
		contentPane.add(btnNewButton_3);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					btnNewButton_3.setEnabled(true);
					btnNewButton_6.setEnabled(false);
					btnIngresarDatos.setEnabled(false);
					model.setRowCount(0);
					for (Par<Integer,Integer> entry: program.showApproved()) {
						Object[] row = new Object[2];
						row[0] = entry.getLU();
						row[1] = entry.getNota();
						model.addRow(row);
					}
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		});
		btnNewButton_4.setBounds(597, 67, 101, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Desaprobados");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					btnNewButton_3.setEnabled(true);
					btnNewButton_6.setEnabled(false);
					btnIngresarDatos.setEnabled(false);
					model.setRowCount(0);
					for (Par<Integer,Integer> entry: program.showNotApproved()) {
						Object[] row = new Object[2];
						row[0] = entry.getLU();
						row[1] = entry.getNota();
						model.addRow(row);
					}
				} catch (EmptyListException error) {		
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		});
		btnNewButton_5.setBounds(597, 100, 101, 23);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {					
					model.setRowCount(0);
					for (Entry<Integer, Integer> entry: program.ordenar()) {
						Object[] row = new Object[2];
						row[0] = entry.getValue();
						row[1] = entry.getKey();
						model.addRow(row);
					}
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		});
		btnNewButton_6.setBounds(597, 131, 101, 23);
		contentPane.add(btnNewButton_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(440, 262, 132, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Ver por nota");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(356, 265, 74, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_7 = new JButton("Mostrar");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().isBlank())
					JOptionPane.showMessageDialog(null, "Por favor, ingrese una nota.");
				else {  
						if (includesChar(textField_4.getText()) || Integer.parseInt(textField_4.getText()) < 1 || Integer.parseInt(textField_4.getText()) > 10)
							JOptionPane.showMessageDialog(null, "Formato erroneo. La nota debe ser un numero entre 1 y 10.");
						else {  
								if (program.isEmpty()) {
									JOptionPane.showMessageDialog(null, "No existen datos registrados.");
									textField_4.setText(null);
								} else {
									btnNewButton_3.setEnabled(true);
									model.setRowCount(0);
									for (Entry<Integer, Integer> entry: program.searchByNota(Integer.parseInt(textField_4.getText()))) {
										Object[] row = new Object[2];
										row[0] = entry.getValue();
										row[1] = entry.getKey();
										model.addRow(row);
									}
								}
						}
				}
			}
		});
		btnNewButton_7.setBounds(597, 261, 101, 23);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ingrese LU del alumno del cual desea obtener su nota:");
		lblNewLabel_2_1.setBounds(20, 200, 314, 21);
		contentPane.add(lblNewLabel_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(36, 230, 151, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton_8 = new JButton("Ingresar");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						if (textField_5.getText().isBlank())
							JOptionPane.showMessageDialog(null, "Por favor, ingrese el LU del alumno.");
						else {  
								if (includesChar(textField_5.getText()) || textField_5.getText().length() != 6)
									JOptionPane.showMessageDialog(null, "Formato erroneo. El LU ingresado debe contener 6 digitos numericos.");
								else {
										Integer nota = program.notaDeLU(Integer.parseInt(textField_5.getText())); 
										if (nota == -1)
											JOptionPane.showMessageDialog(null, "El LU ingresado no es valido.");
										else 
										   textField_6.setText(Integer.toString(nota));
								}	
						}
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		});
		btnNewButton_8.setBounds(197, 229, 89, 23);
		contentPane.add(btnNewButton_8);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(82, 262, 204, 20);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nota");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(36, 265, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
						if (textFieldLU.getText().isBlank())
							JOptionPane.showMessageDialog(null, "Por favor, ingrese el LU del alumno.");
						else {
							int lu = Integer.parseInt(textFieldLU.getText()); 
							boolean ok = program.remove(lu);
							if (ok) {
								for (int i = 0; i < model.getRowCount(); i++) {
									if (model.getValueAt(i, 0) == textFieldLU.getText())
										model.removeRow(i);
								}
								textFieldLU.setText(null);
								btnNewButton_3.setEnabled(true);
								JOptionPane.showMessageDialog(null, "Se han eliminado correctamente los datos.");
								JOptionPane.showMessageDialog(null, "Oprima el boton 'Todos' para actualizar la tabla.");
							} else 
								JOptionPane.showMessageDialog(null, "El LU ingresado no es valido.");
					}
				} catch (EmptyListException error) {
					JOptionPane.showMessageDialog(null, "No existen datos registrados.");
				}
			}
		}); 
		btnEliminar.setBounds(178, 163, 89, 23);
		contentPane.add(btnEliminar);
		
	}
	//--------------------------Metodos privados----------------------------
	private boolean includesChar(String datos) {
		boolean includes = true;
		try {	
				Integer.parseInt(datos);
				includes = false;
		} catch (NumberFormatException e) {
			System.out.println("includesChar: " + e.getMessage());
		}
		return includes;
	}
}
