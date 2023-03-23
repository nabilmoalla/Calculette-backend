package fr.canalplus.calculette.controller;

import fr.canalplus.calculette.service.OperationServiceAdder;
import fr.canalplus.calculette.service.OperationServiceDivider;
import fr.canalplus.calculette.service.OperationServiceMultiplier;
import fr.canalplus.calculette.service.OperationServiceSubstracter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/operations")
public class OperationController {

    private final OperationServiceAdder operationServiceAdder;

    private final OperationServiceDivider operationServiceDivider;

    private final OperationServiceMultiplier operationServiceMultiplier;

    private final OperationServiceSubstracter operationServiceSubstracter;

    public OperationController(OperationServiceAdder operationServiceAdder,
                               OperationServiceDivider operationServiceDivider,
                               OperationServiceMultiplier operationServiceMultiplier,
                               OperationServiceSubstracter operationServiceSubstracter) {
        this.operationServiceAdder = operationServiceAdder;
        this.operationServiceDivider = operationServiceDivider;
        this.operationServiceMultiplier = operationServiceMultiplier;
        this.operationServiceSubstracter = operationServiceSubstracter;
    }

    @ApiOperation(value = "add operation of two parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add two parameters")
    })
    @GetMapping(value="/add")
    public ResponseEntity<BigDecimal> addOperation(@RequestParam BigDecimal param1, @RequestParam BigDecimal param2) throws Exception {
        BigDecimal result = operationServiceAdder.calculate(param1, param2);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "substract operation of two parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully substract two parameters")
    })
    @GetMapping(value="/substract")
    public ResponseEntity<BigDecimal> substractOperation(@RequestParam BigDecimal param1, @RequestParam BigDecimal param2) throws Exception {
        BigDecimal result = operationServiceSubstracter.calculate(param1, param2);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "multiply operation of two parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully multiply two parameters")
    })
    @GetMapping(value="/multiply")
    public ResponseEntity<BigDecimal> multiplyOperation(@RequestParam BigDecimal param1, @RequestParam BigDecimal param2) throws Exception {
        BigDecimal result = operationServiceMultiplier.calculate(param1, param2);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "divide operation of two parameters")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully divide two parameters")
    })
    @GetMapping(value="/divide")
    public ResponseEntity<BigDecimal> divideOperation(@RequestParam BigDecimal param1, @RequestParam BigDecimal param2) throws Exception {
        BigDecimal result = operationServiceDivider.calculate(param1, param2);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
