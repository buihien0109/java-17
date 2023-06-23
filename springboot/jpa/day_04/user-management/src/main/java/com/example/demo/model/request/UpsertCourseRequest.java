package com.example.demo.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Type không được để trống")
    private String type;

    @Length(min = 50, message = "Mô tả phải có ít nhất 50 ký tự")
    private String description;
    private List<Integer> topicIds;
    private String thumbnail;
    private Integer supporterId;
}
