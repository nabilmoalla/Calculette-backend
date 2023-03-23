package fr.canalplus.calculette;

import fr.canalplus.calculette.exception.NullParameterException;
import fr.canalplus.calculette.service.OperationServiceAdder;
import fr.canalplus.calculette.service.OperationServiceSubstracter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceSubstracterTest {

    @InjectMocks
    private OperationServiceSubstracter operationServiceSubstracter;

    @Test
    public void should_add_parameters() {
        BigDecimal result = operationServiceSubstracter.calculate(BigDecimal.valueOf(10), BigDecimal.valueOf(5));
        Assert.assertEquals(result, BigDecimal.valueOf(5));
    }

    @Test(expected = NullParameterException.class)
    public void should_throw_exception_when_param_is_null() {
        BigDecimal param1= null;
        BigDecimal param2= BigDecimal.valueOf(10);
        operationServiceSubstracter.calculate(param1, param2);
    }


}
