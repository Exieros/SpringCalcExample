package com.example.servingwebcontent;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EnumMap;
import java.util.Map;


@RestController
@ResponseBody
public class MathController {
    @RequestMapping(
            value = "/math/{operation}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> matchCall(
            @PathVariable("operation") EnumOperations operation,
            @RequestParam("num1") Double num1,
            @RequestParam("num2") Double num2
    ) {
        JSONObject response = new JSONObject();
        response.put("success", true);
        response.put("res", new Math().calculate(num1, num2, operation));
        return new ResponseEntity<String>(response.toString(), HttpStatus.CREATED);
    }

}
