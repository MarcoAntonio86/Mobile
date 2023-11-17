package devandroid.marcoantonio.appgaseta.Model;

public class Pessoa {
        private String primeiroNome;
        private String SobreNome;
        private String matricula;
        private String Cpf;

        public Pessoa() {}

        public String getPrimeiroNome() {
                return primeiroNome;
        }

        public void setPrimeiroNome(String primeiroNome) {
                this.primeiroNome = primeiroNome;
        }

        public String getSobreNome() {
                return SobreNome;
        }

        public void setSobreNome(String sobreNome) {
                SobreNome = sobreNome;
        }

        public String getMatricula() {
                return matricula;
        }

        public void setMatricula(String matricula) {
                this.matricula = matricula;
        }

        public String getCpf() {
                return Cpf;
        }

        public void setCpf(String cpf) {
                Cpf = cpf;
        }

        @Override
        public String toString() {
                return "Pessoa{" +
                        "primeiroNome='" + primeiroNome + '\'' +
                        ", SobreNome='" + SobreNome + '\'' +
                        ", matricula='" + matricula + '\'' +
                        ", Cpf='" + Cpf + '\'' +
                        '}';
        }
}
