package com.example.demo_spring_data_jap.dto;

import com.example.demo_spring_data_jap.entity.ClassCG;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDto implements Validator {
//    @NotEmpty(message = "Require input data")
//    @Pattern(regexp = s,message = "Not match pattern")
    private String name;
    private boolean gender;
    private ClassCG classCG;

    // khong cần dùng
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
          StudentRequestDto studentRequestDto = (StudentRequestDto) target;
          if (studentRequestDto.getName().isEmpty()){
              errors.rejectValue("name","nhonErrors1","Không được để trống");
          } else if (!studentRequestDto.getName().matches("^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$")) {
              errors.rejectValue("name","vuongErrors1","Không đúng định dạng");
          }
    }
}
