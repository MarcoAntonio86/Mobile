package devandroid.marcoantonio.listatarefa.Model;

public class Listada {
    private String insiratarefa;

        public Listada () {}

    public String getInsiratarefa() {
        return insiratarefa;
    }

    public void setInsiratarefa(String insiratarefa) {
        this.insiratarefa = insiratarefa;
    }

    @Override
    public String toString() {
        return "Listada{" +
                "insiratarefa='" + insiratarefa + '\'' +
                '}';
    }
}
