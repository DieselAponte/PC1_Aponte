package repository;

import model.Movimiento;
import java.util.List;

public interface MovimientoRepository {
    public void guardarMovimiento(Movimiento movimiento);
    List<Movimiento> mostrarMovimientos(int cuentaID);
}
