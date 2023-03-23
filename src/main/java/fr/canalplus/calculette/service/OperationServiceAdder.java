package fr.canalplus.calculette.service;

import fr.canalplus.calculette.exception.NullParameterException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OperationServiceAdder {

    public BigDecimal calculate(BigDecimal param1, BigDecimal param2) {
        if(param1 == null || param2 == null){
            throw new NullParameterException("params must not be null");
        }
        return param1.add(param2);
    }
}
