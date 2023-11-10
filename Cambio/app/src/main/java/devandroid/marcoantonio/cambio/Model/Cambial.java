package devandroid.marcoantonio.cambio.Model;

public class Cambial {
    private String Moeda1;
    private String Moeda2;
    private String Valor;
    private String DiferencaCambial;

    public Cambial() {}

    public String getMoeda1() {
        return Moeda1;
    }

    public void setMoeda1(String moeda1) {
        Moeda1 = moeda1;
    }

    public String getMoeda2() {
        return Moeda2;
    }

    public void setMoeda2(String moeda2) {
        Moeda2 = moeda2;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getDiferencaCambial() {
        return DiferencaCambial;
    }

    public void setDiferencaCambial(String diferencaCambial) {
        DiferencaCambial = diferencaCambial;
    }

    @Override
    public String toString() {
        return "Cambial{" +
                "Moeda1='" + Moeda1 + '\'' +
                ", Moeda2='" + Moeda2 + '\'' +
                ", Valor='" + Valor + '\'' +
                ", DiferencaCambial='" + DiferencaCambial + '\'' +
                '}';
    }
}
