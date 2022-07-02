package com.devsuperior.movieflix.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.devsuperior.movieflix.controllers.exceptions.FieldMessage;
import com.devsuperior.movieflix.dto.ReviewDTO;

public class ReviewInsertValidator implements ConstraintValidator<ReviewInsertValid, ReviewDTO> {

    @Override
    public boolean isValid(ReviewDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();
        
        if (dto.getText().isEmpty() ){
            list.add(new FieldMessage("text", "Texto do review não pode estar vazio."));
        }

        if (dto.getText().isBlank() ){
            list.add(new FieldMessage("text", "Texto do review não pode estar em branco."));
        }

        for (FieldMessage fieldMessage : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(fieldMessage.getMessage()).addPropertyNode(fieldMessage.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
    
}
