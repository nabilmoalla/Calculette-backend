package fr.canalplus.calculette;

import fr.canalplus.calculette.exception.NullParameterException;
import fr.canalplus.calculette.service.OperationServiceAdder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class OperationServiceAdderTest {

    @InjectMocks
    private OperationServiceAdder addOperationService;

    @Test
    public void should_add_parameters() {
        BigDecimal result = addOperationService.calculate(BigDecimal.valueOf(10), BigDecimal.valueOf(25));
        Assert.assertEquals(result, BigDecimal.valueOf(35));
    }

    @Test(expected = NullParameterException.class)
    public void should_throw_exception_when_param_is_null() {
        BigDecimal param1= null;
        BigDecimal param2= BigDecimal.valueOf(10);
        addOperationService.calculate(param1, param2);
    }


}
