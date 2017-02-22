package ru.sfedu.mydiplom.model.container;

import java.util.ArrayList;
import org.simpleframework.xml.*;
import ru.sfedu.mydiplom.model.dto.GenericDto;
@Root(name = "root")
public class ContainerTypeCredits {
    @ElementList(required = false, name = "typecredits")
    ArrayList<GenericDto> container;

    public ArrayList<GenericDto> getContainer() {
        return container;
    }

    public void setContainer(ArrayList<GenericDto> container) {
        this.container = container;
    }

    
    
}