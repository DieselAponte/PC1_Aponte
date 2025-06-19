package controller;

import model.Cuenta;
import model.ServicioBancario;

import java.util.List;

public class BancoHomeController {
    private ServicioBancario servicioBancario;

    public BancoHomeController(ServicioBancario servicioBancario) {
        this.servicioBancario = servicioBancario;
    }

    public List<Cuenta> ObtenerCuentas(){
        return servicioBancario.getCuentas();
    }
}
