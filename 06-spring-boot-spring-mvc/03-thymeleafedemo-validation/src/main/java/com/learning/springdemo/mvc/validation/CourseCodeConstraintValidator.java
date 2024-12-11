package com.learning.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCourseCode, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(theCourseCode != null){

            result = theCourseCode.startsWith(coursePrefix);

        } else {
            return true;
        }

        return result;
    }
}
