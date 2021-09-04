package br.com.letscode.entities;

public class Endereco {
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public boolean getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(boolean logradouro) {
        this.logradouro = logradouro;
    }
}
