package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RecipeContentDTO {
    private int step;
    private String image;
    private String manual;
    private int post_no;
}
