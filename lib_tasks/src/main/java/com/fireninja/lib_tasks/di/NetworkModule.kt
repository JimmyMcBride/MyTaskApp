package com.fireninja.lib_tasks.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  @Singleton
  fun provideHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .readTimeout(15, TimeUnit.SECONDS)
      .connectTimeout(15, TimeUnit.SECONDS)
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
    val contentType = MediaType.get("application/json")
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(okHttpClient)
      .addConverterFactory(Json.asConverterFactory(contentType))
      .build()
  }

//  @Provides
//  @Singleton
//  fun provideBorutoApi(retrofit: Retrofit): BorutoApi {
//    return retrofit.create(BorutoApi::class.java)
//  }
//
//  @Provides
//  @Singleton
//  fun provideRemoteDataSource(
//    borutoApi: BorutoApi,
//    borutoDatabase: BorutoDatabase
//  ): RemoteDataSource {
//    return RemoteDataSourceImpl(
//      borutoApi = borutoApi,
//      borutoDatabase = borutoDatabase
//    )
//  }
}