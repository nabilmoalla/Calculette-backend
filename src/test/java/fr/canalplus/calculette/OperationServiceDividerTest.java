package fr.canalplus.calculette;

import fr.canalplus.calculette.exception.NullParameterException;
import fr.canalplus.calculette.service.OperationServiceAdder;
import fr.canalplus.calculette.service.OperationServiceDivider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceDividerTest {

    @InjectMocks
    private OperationServiceDivider operationServiceDivider;

    @Test
    public void should_add_parameters() {
        BigDecimal result = operationServiceDivider.calculate(BigDecimal.valueOf(10), BigDecimal.valueOf(2));
        Assert.assertEquals(result, BigDecimal.valueOf(5));
    }

    @Test(expected = NullParameterException.class)
    public void should_throw_exception_when_param_is_null() {
        BigDecimal param1= null;
        BigDecimal param2= BigDecimal.valueOf(10);
        operationServiceDivider.calculate(param1, param2);
    }


}
