package com.ezzy.socketstest.di

import android.content.Context
import com.ezzy.socketstest.data.interceptor.AuthInterceptor
import com.ezzy.socketstest.data.remote.SocketApi
import com.ezzy.socketstest.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zerobranch.androidremotedebugger.logging.NetLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSocketApi(
        okHttpClient: OkHttpClient
    ): SocketApi =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
        .create(SocketApi::class.java)


    @Provides
    @Singleton
    fun provideNetLoggingInterceptor(): NetLoggingInterceptor = NetLoggingInterceptor()

    @Provides
    @Singleton
    fun provideOkHttpClient(
        netLoggingInterceptor: NetLoggingInterceptor,
        @ApplicationContext context: Context
    ) =
        OkHttpClient.Builder()
            .addInterceptor(netLoggingInterceptor)
            .addInterceptor(AuthInterceptor(context))
            .build()

}