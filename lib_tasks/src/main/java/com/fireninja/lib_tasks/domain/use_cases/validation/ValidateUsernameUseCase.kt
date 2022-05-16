package com.fireninja.lib_tasks.domain.use_cases.validation

import com.fireninja.lib_tasks.domain.models.ValidationResult

class ValidateUsernameUseCase {
  operator fun invoke(username: String): ValidationResult {
    if (username.length < 6) {
      return ValidationResult(
        isSuccessful = false,
        errorMessage = "Username is too short. Must be at least 6 characters."
      )
    }
    val containsSpecialCharacters =
      username.any { it.isLetter() || it.isDigit() }
    if (containsSpecialCharacters) {
      return ValidationResult(
        isSuccessful = false,
        errorMessage = "Username can only contain letters and/or numbers."
      )
    }
    return ValidationResult(
      isSuccessful = true,
    )
  }
}