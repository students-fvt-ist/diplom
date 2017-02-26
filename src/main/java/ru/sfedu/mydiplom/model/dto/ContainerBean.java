package ru.sfedu.mydiplom.model.dto;

import java.util.List;
import org.simpleframework.xml.*;
import ru.sfedu.mydiplom.model.dto.GenericDto;
@Root(name = "root")
public class ContainerBean {
    @ElementList(required = false, name = "beans")
    List<GenericDto> container;

    public List<GenericDto> getContainer() {
        return container;
    }

    public void setContainer(List<GenericDto> container) {
        this.container = container;
    }
    
}
