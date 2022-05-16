package com.fireninja.lib_tasks.di

import com.fireninja.lib_tasks.domain.use_cases.ValidationUseCases
import com.fireninja.lib_tasks.domain.use_cases.validation.ValidateUsernameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
  @Provides
  @Singleton
  fun provideValidationUseCases(): ValidationUseCases {
    return ValidationUseCases(
      validateUsernameUseCase = ValidateUsernameUseCase()
    )
  }
}