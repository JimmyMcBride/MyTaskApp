package com.fireninja.lib_tasks.domain.models

data class ValidationResult(
  val isSuccessful: Boolean,
  val errorMessage: String? = null
)
