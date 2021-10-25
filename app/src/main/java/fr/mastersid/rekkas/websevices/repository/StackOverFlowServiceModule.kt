package fr.mastersid.rekkas.websevices.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersid.rekkas.websevices.adapters.QuestionMoshiAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.stackexchange.com/2.3/"

@Module
@InstallIn(SingletonComponent::class)
object StackOverFlowServiceModule {

    @Provides
    @Singleton
    fun moshi (): Moshi {
        return Moshi.Builder ()
            .add(KotlinJsonAdapterFactory ())
            .add(QuestionMoshiAdapter ())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder ()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }


    @Provides
    fun provideStackOverFlowService(retrofit: Retrofit): StackOverFlowService  {
        return retrofit.create(StackOverFlowService:: class.java)
    }

}

