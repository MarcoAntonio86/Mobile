package devandroid.marcoantonio.jogoforca.Model;

public class Jogo {

        private String InsiraPalvra;
        private String Tentativas;

        public Jogo () {}

    public String getInsiraPalvra() {
        return InsiraPalvra;
    }

    public void setInsiraPalvra(String insiraPalvra) {
        InsiraPalvra = insiraPalvra;
    }

    public String getTentativas() {
        return Tentativas;
    }

    public void setTentativas(String tentativas) {
        Tentativas = tentativas;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "InsiraPalvra='" + InsiraPalvra + '\'' +
                ", Tentativas='" + Tentativas + '\'' +
                '}';
    }
}
