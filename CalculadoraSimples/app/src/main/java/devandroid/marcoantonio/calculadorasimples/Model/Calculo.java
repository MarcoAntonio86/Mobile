package devandroid.marcoantonio.calculadorasimples.Model;

public class Calculo {
       private String PrimeiroNumero;
       private String SegundoNumero;
       private String SimboloEscolhido;

       public Calculo () {}

       public String getPrimeiroNumero() {
              return PrimeiroNumero;
       }

       public void setPrimeiroNumero(String primeiroNumero) {
              PrimeiroNumero = primeiroNumero;
       }

       public String getSegundoNumero() {
              return SegundoNumero;
       }

       public void setSegundoNumero(String segundoNumero) {
              SegundoNumero = segundoNumero;
       }

       public String getSimboloEscolhido() {
              return SimboloEscolhido;
       }

       public void setSimboloEscolhido(String simboloEscolhido) {
              SimboloEscolhido = simboloEscolhido;
       }

       @Override
       public String toString() {
              return "Calculo{" +
                      "PrimeiroNumero='" + PrimeiroNumero + '\'' +
                      ", SegundoNumero='" + SegundoNumero + '\'' +
                      ", SimboloEscolhido='" + SimboloEscolhido + '\'' +
                      '}';
       }
}
