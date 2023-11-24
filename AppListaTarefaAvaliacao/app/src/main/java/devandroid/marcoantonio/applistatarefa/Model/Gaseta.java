package devandroid.marcoantonio.applistatarefa.Model;

public class Gaseta {
    private String Posto;
    private String Gasolina;
    private String Etanol;


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



    @Override
    public String toString() {
        return "Gaseta{" +
                "Posto='" + Posto + '\'' +
                ", Gasolina='" + Gasolina + '\'' +
                ", Etanol='" + Etanol + '\'' +

                '}';
    }


}
