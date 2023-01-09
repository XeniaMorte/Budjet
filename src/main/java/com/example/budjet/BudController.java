package com.example.budjet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BudController {

    @GetMapping("/")
    public static String appRunning() {
        return "«Приложение запущено»";
    }

    @GetMapping("/info")
    public static String info() {
        return "Ксеня Новикова\n9.01.23\nРецепт\nСоздание рецептов";
    }

}




