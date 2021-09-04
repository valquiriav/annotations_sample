package br.com.letscode.validate;

import br.com.letscode.annotations.Default;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@UtilityClass
public class ValidateObject {

    public void loadDefaultValues(Object... objects) throws IllegalAccessException{
        for (Object object: objects){
            List<Field> fields = Arrays.asList(object.getClass().getDeclaredFields());

            for (Field field: fields) {
                if(field.isAnnotationPresent(Default.class)){
                    Default aDefault = field.getAnnotation(Default.class);
                    String value = aDefault.value();

                    field.setAccessible(true);

                    Object objectValue = field.get(object);
                    if(Objects.isNull(objectValue)){
                        field.set(object, value);
                    }
                }
            }
        }
    }
}
