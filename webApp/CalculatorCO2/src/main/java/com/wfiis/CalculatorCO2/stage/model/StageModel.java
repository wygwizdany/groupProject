package com.wfiis.CalculatorCO2.stage.model;


import com.wfiis.CalculatorCO2.module.metadata.entity.Module;
import com.wfiis.CalculatorCO2.vegetable.metadata.entity.Vegetable;
import lombok.Getter;

import java.util.List;

@Getter
public class StageModel extends StageCreateModel {
    private Long id;

    public StageModel(String name, List<Vegetable> vegetables, List<Module> modules, Long id) {
        super(name, vegetables, modules);
        this.id = id;
    }
}