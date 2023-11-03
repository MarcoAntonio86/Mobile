package com.marcoantonio.jogodaforca.Model;

import kotlin.text.UStringsKt;

public class Jogar {
       private String insirapalavras;
       private String tentativa;

       public Jogar () {}

        public String getInsirapalavras() {
                return insirapalavras;
        }

        public void setInsirapalavras(String insirapalavras) {
                this.insirapalavras = insirapalavras;
        }

        public String getTentativa() {
                return tentativa;
        }

        public void setTentativa(String tentativa) {
                this.tentativa = tentativa;
        }

        @Override
        public String toString() {
                return "Jogar{" +
                        "insirapalavras='" + insirapalavras + '\'' +
                        ", tentativa='" + tentativa + '\'' +
                        '}';
        }
}
