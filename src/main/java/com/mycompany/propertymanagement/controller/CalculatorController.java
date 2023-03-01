package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping of url to a controller class
public class CalculatorController {

    @GetMapping("/add") //method level mapping of a url to a controller function
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2){
        return num1+num2;
    }

    @GetMapping("/sub/{num111}/{num222}") //Map the values of url to java variables by Path variable method
    public Double subtract(@PathVariable( "num111") Double num1,@PathVariable("num222")  Double num2) {
        Double result = null;
        if (num1 > num2) {
            result = num1 - num2;
        } else {
         result=num2-num1;
        }
return result;

    }

    @PostMapping("/mul")
    public ResponseEntity multiply(@RequestBody  CalculatorDTO calculatorDTO){
        Double result=null;
        result=calculatorDTO.getNum1()+calculatorDTO.getNum2()+calculatorDTO.getNum3();
        ResponseEntity<Double> responseEntity=new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
