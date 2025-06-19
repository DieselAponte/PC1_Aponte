package builder;



public class CuentaDirector {
    public static CuentaBuilder getBuilder(String tipo){
        return switch (tipo){
            case "Ahorro" -> new CuentaAhorroBuilder();
            case "Corriente" -> new CuentaCorrienteBuilder();
            default -> throw new IllegalArgumentException("Tipo de cuenta inválido: " + tipo);
        };
    }
}
