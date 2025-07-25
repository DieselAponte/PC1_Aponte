package builder;

import model.CuentaAhorro;
import model.Cuenta;
public class CuentaAhorroBuilder implements CuentaBuilder {
    private int id;
    private double saldo;
    private String dniTitular;
    private String nombreTitular;

    @Override
    public CuentaAhorroBuilder setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public CuentaAhorroBuilder setSaldo(double saldoInicial) {
        this.saldo = saldoInicial;
        return this;
    }

    @Override
    public CuentaAhorroBuilder setDniTitular(String dni) {
        this.dniTitular = dni;
        return this;
    }

    @Override
    public CuentaAhorroBuilder setNombreTitular(String nombre) {
        this.nombreTitular = nombre;
        return this;
    }

    @Override
    public Cuenta build() {
        if(saldo < 0){
            throw new RuntimeException("Saldo negativo");
        }
        return new CuentaAhorro(id, saldo, dniTitular, nombreTitular);
    }
}
