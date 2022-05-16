package com.fireninja.mytaskapp.presentation.auth.register

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fireninja.lib_tasks.domain.use_cases.validation.ValidateUsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
  private val validateUsernameUseCase: ValidateUsernameUseCase
) : ViewModel() {
  init {
    val thing = validateUsernameUseCase("asd")
    Log.d(TAG, "validation result: ${thing.errorMessage}")
  }
  companion object {
    const val TAG = "RegisterScreenViewModel"
  }
}