package controller;

import builder.CuentaBuilder;
import builder.CuentaDirector;
import model.Cuenta;
import model.ServicioBancario;

public class CrearCuentaController {
    private final ServicioBancario servicio;

    public CrearCuentaController(ServicioBancario servicio) {
        this.servicio = servicio;
    }

    public void crearCuenta(String tipo, double saldoInicial, String dniTitular, String nombreTitular) {
        // Validaciones...
        if (dniTitular == null || dniTitular.isBlank() ||
                nombreTitular == null || nombreTitular.isBlank()) {
            throw new IllegalArgumentException("DNI y Nombre son obligatorios");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        }

        // 1) Obtenemos el builder
        CuentaBuilder builder = CuentaDirector.getBuilder(tipo)
                .setId(servicio.getCuentas().size() + 1)
                .setSaldo(saldoInicial)
                .setDniTitular(dniTitular)
                .setNombreTitular(nombreTitular);

        if (builder instanceof builder.CuentaCorrienteBuilder ccBuilder) {
            ccBuilder.setLimite(1500);
        }

        // 3) Construir y persistir
        Cuenta cuenta = builder.build();
        servicio.agregarCuenta(cuenta);
    }
}
