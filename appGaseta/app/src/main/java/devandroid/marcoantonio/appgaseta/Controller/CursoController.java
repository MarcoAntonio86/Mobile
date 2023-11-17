package devandroid.marcoantonio.appgaseta.Controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.marcoantonio.appgaseta.Model.Cursos;

public class CursoController {
    private List listacursos;

    public List getListacursos () {

        listacursos = new ArrayList<Cursos>();

        listacursos.add(new Cursos("Java"));
        listacursos.add(new Cursos("Python"));
        listacursos.add(new Cursos("PHP"));
        listacursos.add(new Cursos("C#"));
        listacursos.add(new Cursos("C++"));

        return listacursos;

    }
    public ArrayList <String> dadosSpinner(){
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListacursos().size(); i++) {
            Cursos objeto = (Cursos) getListacursos().get(i);
            dados.add(objeto.getCursoDesejado());

        }
        return dados;
    }
}
