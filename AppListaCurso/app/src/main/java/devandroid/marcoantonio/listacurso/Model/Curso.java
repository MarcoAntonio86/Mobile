package devandroid.marcoantonio.listacurso.Model;

public class Curso {
    private String Curso;

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "Curso='" + Curso + '\'' +
                '}';
    }
}


