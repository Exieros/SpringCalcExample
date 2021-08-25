package com.example.servingwebcontent.operations;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/multiplication", method = RequestMethod.GET)
@ResponseBody
public class Multiplication {
    @GetMapping
    public String multiplication(@RequestParam("num1") Double num1,
                                 @RequestParam("num2") Double num2){

        String response = String.format("{\"successful\": true, \"res\": \"%f\"}", num1 * num2);
        return response;
    }

}
