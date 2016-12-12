/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sfedu.mydiplom.model;

import java.util.ArrayList;
import java.util.List;
import ru.sfedu.mydiplom.model.dto.GenericDto;

/**
 *
 * @author seyran
 */
public class ResultWithValue extends Result{
    private List<GenericDto> value;

    public ResultWithValue() {}    
    
/*
    public ArrayList<GenericDto> getValue() {
        return value;
    }

    public void setValue(ArrayList<GenericDto> value) {
        this.value = value;
    }       */

    public List<GenericDto> getValue() {
        return value;
    }

    public void setValue(List<GenericDto> value) {
        this.value = value;
    }
}
