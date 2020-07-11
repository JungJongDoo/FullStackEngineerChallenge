package com.paypay.manager.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeRequest {

    @NotBlank(message = "emailを入力してください。")
    @Length(max = 100)
    private String email;

    @NotBlank(message = "お名前を入力してください。")
    @Length(max = 110)
    private String name;

    @NotBlank(message = "電話番号を入力してください。")
    @Length(max = 50)
    private String mobileNo;

    @NotBlank(message = "性別を入力してください。")
    @Length(max = 1)
    private String sex;
}

