package com.example.english.dto;

import lombok.Value;

//@Value
public class ValidationResult {
   private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public ValidationResult(boolean success) {
        this.success = success;
    }

    public ValidationResult() {
    }
}
