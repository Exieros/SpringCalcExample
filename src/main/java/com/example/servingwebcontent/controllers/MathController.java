package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.enums.EnumMathOperations;
import com.example.servingwebcontent.Calculator;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class MathController {
    Calculator calculator = new Calculator();
    @RequestMapping(
            value = "/math/{operation}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> matchCall(
            @PathVariable("operation") EnumMathOperations operation,
            @RequestParam("num1") Double num1,
            @RequestParam("num2") Double num2
    ) {
        JSONObject response = new JSONObject();
        try {
            Double result = calculator.math(num1, num2, operation);
            response.put("success", true);
            response.put("res", result);
        }catch(Throwable err){
            response.put("success", false);
            response.put("description", err.getMessage());
        }

        return new ResponseEntity<String>(response.toString(), HttpStatus.CREATED);
    }

}
