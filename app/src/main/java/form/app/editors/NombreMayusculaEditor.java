package form.app.editors;

import org.springframework.beans.PropertyValuesEditor;

public class NombreMayusculaEditor extends PropertyValuesEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
    
}
