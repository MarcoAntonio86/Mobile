package com.marcoantonio.gerenciadordesenhas.Model;

import java.security.PrivateKey;

public class Senhas {
    private String senhamaster;
    private String senhassalvas;
    public Senhas () {}

    public String getSenhamaster() {
        return senhamaster;
    }

    public void setSenhamaster(String senhamaster) {
        this.senhamaster = senhamaster;
    }

    public String getSenhassalvas() {
        return senhassalvas;
    }

    public void setSenhassalvas(String senhassalvas) {
        this.senhassalvas = senhassalvas;
    }

    @Override
    public String toString() {
        return "Senhas{" +
                "senhamaster='" + senhamaster + '\'' +
                ", senhassalvas='" + senhassalvas + '\'' +
                '}';
    }
}
