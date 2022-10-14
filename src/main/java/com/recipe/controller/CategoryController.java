package com.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping("/category")
    public String category(){ return "category/category"; }

    @RequestMapping("/ranking")
    public  String ranking(){ return "category/ranking";}


}
