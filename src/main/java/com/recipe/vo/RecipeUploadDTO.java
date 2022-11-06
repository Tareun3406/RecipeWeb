package com.recipe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class RecipeUploadDTO {
    private int post_no;
    private String title;
    private Date regdate;
    private Date updatedate;
    private String thumnail;
    private String ingredient;
    private String post_tag;
    private String tip;
    private String writer;

    // 업로드될 이미지 파일.
    private MultipartFile thumnailImg;
    private List<MultipartFile> recipeImgs;

    private List<String> recipeText;
}
