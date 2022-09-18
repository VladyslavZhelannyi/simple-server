package com.example.simpleback.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class SimpleController {
    @GetMapping(value = "/exp")
    public String exp(@RequestBody HashMap<String, Object> map) {
        String[] strs = ((String) map.get("exp")).split(" ");
        int first = Integer.parseInt(strs[0]);
        int second = Integer.parseInt(strs[2]);
        String result = null;
        switch(strs[1]) {
            case "+":
                result = String.valueOf(first + second);
                break;
            case "-":
                result = String.valueOf(first - second);
                break;
            case "*":
                result = String.valueOf(first * second);
                break;
            case "/":
                result = String.valueOf(first / second);
                break;
        }
        return "{\"result\":" + result + "}";
    }

    @PostMapping(value = "/postuser")
    public String postuser(@RequestBody HashMap<String, Object> map) {
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
        return "{\"name\":\"Vlad\",\"age\":\"24\"}";
    }

    @GetMapping(value = "/sum")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        System.out.println(num1);
        System.out.println(num2);
        return "{\"result\":" + String.valueOf(num1 + num2) + "}";
    }

    @PostMapping(value = "/eval")
    public String eval(@RequestBody HashMap<String, Object> map) {
        System.out.println(map.get("calculatorType"));
        System.out.println(map.get("var1"));
        System.out.println(map.get("var2"));
        System.out.println(map.get("operation"));
        return "{\"result\":\"" + (Integer.parseInt((String) map.get("var1")) +
                Integer.parseInt((String) map.get("var2"))) + "\"}";
    }
}
