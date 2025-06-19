import controller.BancoHomeController;
import model.ServicioBancario;
import repository.CuentaRepository;
import repository.DatabaseConnection;
import repository.MovimientoRepository;
import view.BancoHomeView;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BancoHomeView view = new BancoHomeView();
            view.setVisible(true);
        });
    }
}
