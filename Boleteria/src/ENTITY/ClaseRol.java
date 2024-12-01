package ENTITY;

import Controller.BuyTicketFacade;
import Controller.ClienteDAO;
import ENTITY.Cliente;
import javax.swing.JOptionPane;
import main.Admin;
import ENTITY.ClaseUsuario;
import Controller.UsuarioDAO;
import Views.Loggin;
import Views.TicketSales;
import java.sql.SQLException;

/**
 * @author Manuel
 */

public class ClaseRol {
    public static final int ADMINISTRADOR = 1;
    public static final int OPERADOR = 2;
    public static final int CLIENTEV2 = 3;
    private Admin formularioAdministrador;
    private UsuarioDAO gestionUsuarios;
    private ClienteDAO clienteCrud;
    private TicketSales ticketSales;
    

    public ClaseRol(BuyTicketFacade buyTicketController, ClaseUsuario usuarioActual) {
    this.clienteCrud = new ClienteDAO();
    this.formularioAdministrador = new Admin(buyTicketController, usuarioActual); // Pasa los argumentos necesarios
    this.gestionUsuarios = new UsuarioDAO(clienteCrud);
}

    private void abrirLogin() {
        Loggin login = new Loggin();
        login.setVisible(true);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
    }

    private void abrirFormularioAdministrador() {
        formularioAdministrador.setResizable(false);
        formularioAdministrador.setLocationRelativeTo(null);
        formularioAdministrador.setVisible(true);
    }
    
    
    
    public void iniciarSesion(String correo, String contraseña, Cliente cliente) throws SQLException {
    boolean loggedIn = false;
    for (ClaseUsuario usuario : gestionUsuarios.obtenerUsuarios()) {
        if (usuario.getCorreo().equalsIgnoreCase(correo) && usuario.getContrasena().equals(contraseña)) {
            switch (usuario.getRolId()) {
                case ADMINISTRADOR:
                    abrirFormularioAdministrador();
                    loggedIn = true;
                    break;
                case OPERADOR:
                    loggedIn = true;
                    break;
                case CLIENTEV2:
                    if (cliente != null) {
                        System.out.println("Formulario Cliente Abierto");
                        loggedIn = true;
                        
                        
                    } else {
                        System.out.println("Cliente no encontrado.");
                        abrirLogin();
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Rol no reconocido.");
                    abrirLogin();
                    break;
            }
            if (loggedIn) {
                return;
            }
        }
    }
    JOptionPane.showMessageDialog(null, "Correo electrónico o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    abrirLogin();
  }
    
}
