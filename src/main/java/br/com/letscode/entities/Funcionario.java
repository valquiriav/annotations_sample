package br.com.letscode.entities;

import br.com.letscode.annotations.Default;
import lombok.Data;

@Data
public class Funcionario {
    private String nome;
    @Default(value = "Não informado")
    private String sobreNome;
}
