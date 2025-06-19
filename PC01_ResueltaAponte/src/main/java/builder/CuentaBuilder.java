package builder;

import model.Cuenta;
public interface CuentaBuilder {
    CuentaBuilder setId(int id);
//    CuentaBuilder setTipo(String tipo);
    CuentaBuilder setSaldo(double saldoInicial);
    CuentaBuilder setDniTitular(String dni);
    CuentaBuilder setNombreTitular(String nombre);
    Cuenta build();
}
