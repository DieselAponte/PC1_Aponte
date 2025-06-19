package view;

import model.ServicioBancario;
import repository.*;

import javax.swing.*;
import java.security.Provider;
import java.sql.*;

public class BancoHomeView extends JFrame {
    private final ServicioBancario servicio;

    public BancoHomeView() {
        ServicioBancario tempServicio = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            CuentaRepository cuentaRepo = new ConcreteCuentaRepository(conn);
            MovimientoRepository movimientoRepo = new ConcreteMovimientoRepository(conn);
            tempServicio = new ServicioBancario(cuentaRepo, movimientoRepo);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error de conexion a la base de datos" + e.getMessage());
            System.exit(1);
        }
        this.servicio = tempServicio;

        setTitle("Sistema de Bancario");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Cuenta", new CrearCuentaView(servicio));
        tabbedPane.addTab("RealizarTransferencia", new RealizarTransferenciaView(servicio));
        tabbedPane.addTab("Movimientos", new MovimientosView(servicio));

        add(tabbedPane);
        setVisible(true);
    }


}
