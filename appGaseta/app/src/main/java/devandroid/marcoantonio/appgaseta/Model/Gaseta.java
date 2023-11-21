package devandroid.marcoantonio.appgaseta.Model;

public class Gaseta {
    private String Posto;
    private String Gasolina;
    private String Etanol;
    private String Litros;

    public String getPosto() {
        return Posto;
    }

    public void setPosto(String posto) {
        Posto = posto;
    }

    public String getGasolina() {
        return Gasolina;
    }

    public void setGasolina(String gasolina) {
        Gasolina = gasolina;
    }

    public String getEtanol() {
        return Etanol;
    }

    public void setEtanol(String etanol) {
        Etanol = etanol;
    }

    public String getLitros() {
        return Litros;
    }

    @Override
    public String toString() {
        return "Gaseta{" +
                "Posto='" + Posto + '\'' +
                ", Gasolina='" + Gasolina + '\'' +
                ", Etanol='" + Etanol + '\'' +
                ", Litros='" + Litros + '\'' +
                '}';
    }

    public void setLitros(String litros) {
        Litros = litros;


    }
}
