package fr.canalplus.calculette;

import fr.canalplus.calculette.exception.NullParameterException;
import fr.canalplus.calculette.service.OperationServiceAdder;
import fr.canalplus.calculette.service.OperationServiceMultiplier;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceMultiplierTest {

    @InjectMocks
    private OperationServiceMultiplier operationServiceMultiplier;

    @Test
    public void should_add_parameters() {
        BigDecimal result = operationServiceMultiplier.calculate(BigDecimal.valueOf(10), BigDecimal.valueOf(2));
        Assert.assertEquals(result, BigDecimal.valueOf(20));
    }

    @Test(expected = NullParameterException.class)
    public void should_throw_exception_when_param_is_null() {
        BigDecimal param1= null;
        BigDecimal param2= BigDecimal.valueOf(10);
        operationServiceMultiplier.calculate(param1, param2);
    }


}
