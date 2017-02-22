package ru.sfedu.mydiplom.model.container;

import java.util.ArrayList;
import org.simpleframework.xml.*;
import ru.sfedu.mydiplom.model.dto.GenericDto;
@Root(name = "root")
public class ContainerPayments {
    @ElementList(required = false, name = "payments")
    ArrayList<GenericDto> container;

    public ArrayList<GenericDto> getContainer() {
        return container;
    }

    public void setContainer(ArrayList<GenericDto> container) {
        this.container = container;
    }

    
    
}
