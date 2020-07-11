package com.paypay.manager.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewRequest {

    private long employeeNo;

    @NotBlank(message = "内容を入力してください。")
    @Length(max = 1000)
    private String contents;
}

