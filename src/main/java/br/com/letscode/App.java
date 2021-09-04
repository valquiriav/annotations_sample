package br.com.letscode;

import br.com.letscode.annotations.Default;
import br.com.letscode.entities.Endereco;
import br.com.letscode.entities.Funcionario;
import br.com.letscode.validate.ValidateObject;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Nome");

        Endereco endereco = new Endereco();
        endereco.setBairro("Bairro");
        endereco.setCep("12345-678");
        endereco.setCidade("Cidade");

        try {
            ValidateObject.loadDefaultValues(funcionario, endereco);

            System.out.println(funcionario.getSobreNome());
            System.out.println(endereco.getLogradouro());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<Field> campos = Arrays.asList(funcionario.getClass().getDeclaredFields());
        campos.forEach(campo -> {
            String annotationValue = "";
            boolean annotationPresent = campo.isAnnotationPresent(Default.class);
            if (annotationPresent){
                annotationValue = campo.getAnnotation(Default.class).valor();
            }
            System.out.println(campo.getName()+" - "+ annotationPresent+" - "+ annotationValue);
        });
    }
}
