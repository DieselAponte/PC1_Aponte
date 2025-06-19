package controller;
import model.*;
import java.util.List;

public class MovimientosController {
    private ServicioBancario servicio;

    public MovimientosController(ServicioBancario servicio) {
        this.servicio = servicio;
    }

    public List<Movimiento> obtenerMovimientos(int cuentaId) {
        return servicio.getMovimientosPorCuenta(cuentaId);
    }

}