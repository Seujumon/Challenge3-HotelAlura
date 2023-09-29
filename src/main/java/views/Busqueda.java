package views;

import Controllers.HuespedController;
import Controllers.ReservaController;
import Entidades.FormaDePago;
import Entidades.Huesped;
import Entidades.Reserva;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);




		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();

		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");


		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		cargarTablaReservas();
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");


		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		cargarTablaHuespedes();

		JTable tbBusqueda = new JTable();
		tbBusqueda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbBusqueda.setFont(new Font("Roboto", Font.PLAIN, 16));
		DefaultTableModel modeloBusqueda = (DefaultTableModel) tbBusqueda.getModel();
		modeloBusqueda.addColumn("Numero de Huesped");
		modeloBusqueda.addColumn("Nombre");
		modeloBusqueda.addColumn("Apellido");
		modeloBusqueda.addColumn("Número de Reserva");
		JScrollPane scroll_tableBusqueda = new JScrollPane(tbBusqueda);
		panel.addTab("Busqueda", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableBusqueda, null);
		scroll_tableBusqueda.setVisible(true);



		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modeloBusqueda.setRowCount(0);


				List <Huesped> resultado;
				try{
					Long reserva = Long.parseLong(txtBuscar.getText());
					resultado = new HuespedController().buscarPorReservaId(reserva);

				}catch (Exception ex){
					System.out.println(ex);
					resultado = new HuespedController().buscarPorApellido(txtBuscar.getText());
				}
				try {

					resultado.forEach(huesped -> modeloBusqueda.addRow(new Object[] {
							huesped.getId(),
							huesped.getNombre(),
							huesped.getApellido(),
							huesped.getReserva().get(0).getId()}));
				} catch (Exception exception) {

				}


			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comprobarSeleccion()){
					System.out.println("No seleccionó nada");
					return;
				}
				if(comprobarSeleccionReserva()){
					System.out.println("Selecciono una reserva");
					Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
							.ifPresentOrElse(fila -> {

								Long id = Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
								LocalDate fechaEntrada = LocalDate.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
								LocalDate  fechaSalida= LocalDate.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
								Double  valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
								FormaDePago formaDePago = FormaDePago.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString());
								ReservaController reservaController = new ReservaController();
								Reserva reserva = new Reserva(fechaEntrada, fechaSalida, valor, formaDePago);
								reserva.setId(id);
								reservaController.modificar(reserva);
							}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));


					tbReservas.clearSelection();
				}
				if(comprobarSeleccionHuesped()){
					System.out.println("Selecciono un huesped");

					Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
							.ifPresentOrElse(fila -> {
								HuespedController huespedController = new HuespedController();

								Long id = Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
								String nombre = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1).toString();
								String apellido= modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2).toString();;
								LocalDate fechaDeNacimiento = LocalDate.parse(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
								String nacionalidad= modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4).toString();;
								String telefono= modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString();;
								List <Reserva> reservas = huespedController.buscarHuespedPorId(id).getReserva();

								Huesped huesped = new Huesped(id, nombre, apellido, fechaDeNacimiento, nacionalidad, telefono, reservas);

								huespedController.modificar(huesped);
							}, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));

					tbHuespedes.clearSelection();
				}

			}
		});
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comprobarSeleccion()){
					System.out.println("No seleccionó nada");
					return;
				}
				if(comprobarSeleccionReserva()){
					System.out.println("Selecciono una reserva");
					Long id =Long.parseLong(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					System.out.println(id);
					ReservaController reservaController = new ReservaController();
					Reserva reserva = reservaController.buscarReservaPorId(id);
					HuespedController huespedController = new HuespedController();
					List<Huesped> lista = huespedController.buscarPorReservaId(id);
					//Eliminar la conexion entre el hueped y la reserva
					for (Huesped huesped : lista){
						System.out.println("Reservas del huesped: " + huesped.getReserva().size());
						huesped.getReserva().remove(0);

						huespedController.actualizarHuesped(huesped);
					}
					reservaController.eliminarReserva(reserva);
					tbReservas.clearSelection();
				}
				if(comprobarSeleccionHuesped()){
					System.out.println("Selecciono un huesped");
					Long id =Long.parseLong(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
					HuespedController huespedController = new HuespedController();
					Huesped huesped = huespedController.buscarHuespedPorId(id);
					//eliminar
					huespedController.eliminarHuesped(huesped);
					tbHuespedes.clearSelection();
				}

				modelo.setRowCount(0);
				modeloHuesped.setRowCount(0);
				cargarTablaReservas();
				cargarTablaHuespedes();

			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	private void cargarTablaHuespedes() {
		try {
			List<Huesped> huespedes = new HuespedController().buscarHuespedes();
			System.out.println("Tamaño lista huespedes " + huespedes.size());
			huespedes.forEach(huesped -> modeloHuesped.addRow(new Object[] {
					huesped.getId(),
					huesped.getNombre(),
					huesped.getApellido(),
					huesped.getFecha_de_nacimiento(),
					huesped.getNacionalidad(),
					huesped.getTelefono(),
					huesped.getReserva().size()}));
		} catch (Exception e) {

		}
	}
	private void cargarTablaReservas() {
		try {
			List<Reserva> reservas = new ReservaController().buscarReservas();
			reservas.forEach(reserva -> modelo.addRow(new Object[] {
					reserva.getId(),
					reserva.getFecha_entrada(),
					reserva.getFecha_salida(),
					reserva.getValor(),
					reserva.getFormaDePago()
					}));
		} catch (Exception e) {

		}
	}
	private Boolean comprobarSeleccion(){
		return (tbReservas.getSelectedRowCount() ==0 ||
				tbReservas.getSelectedColumnCount() == 0) && (
						tbHuespedes.getSelectedRowCount()== 0 ||
				tbHuespedes.getSelectedColumnCount() == 0);
	}
	private Boolean comprobarSeleccionHuesped(){
		return tbHuespedes.getSelectedRowCount()== 1 ||
				tbHuespedes.getSelectedColumnCount() == 1;
	}
	private Boolean comprobarSeleccionReserva(){

		return tbReservas.getSelectedRowCount() ==1 ||
				tbReservas.getSelectedColumnCount() == 1;
	}

	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}

}

