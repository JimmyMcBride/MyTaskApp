package com.fireninja.lib_tasks.domain.use_cases

import com.fireninja.lib_tasks.domain.use_cases.validation.ValidateUsernameUseCase

data class ValidationUseCases(
  val validateUsernameUseCase: ValidateUsernameUseCase,
)
