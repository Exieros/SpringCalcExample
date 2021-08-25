package com.example.servingwebcontent.operations;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/minus", method = RequestMethod.GET)
@ResponseBody
public class Minus {
    @GetMapping
    public String minus(@RequestParam("num1") Double num1,
                        @RequestParam("num2") Double num2){

        String response = String.format("{\"successful\": true, \"res\": \"%f\"}", num1 - num2);
        return response;
    }

}
