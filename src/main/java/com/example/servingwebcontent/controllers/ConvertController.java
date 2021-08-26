package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.enums.EnumConvertOperations;
import com.example.servingwebcontent.Calculator;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class ConvertController {
    @RequestMapping(
            value = "/convert/{operation}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> convertCall(
            @PathVariable("operation") EnumConvertOperations operation,
            @RequestParam("num1") Double num1
    ) {
        JSONObject response = new JSONObject();
        response.put("success", true);
        response.put("res", new Calculator().convert(num1, operation));
        return new ResponseEntity<String>(response.toString(), HttpStatus.CREATED);
    }

}