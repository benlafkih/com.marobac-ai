package com.marobac.ai.core.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.storage.FirebaseStorage
import com.marobac.ai.data.repository.*
import com.marobac.ai.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirestore() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFunctions() = FirebaseFunctions.getInstance()

    @Provides
    @Singleton
    fun provideStorage() = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideAuthRepository(auth: FirebaseAuth, db: FirebaseFirestore): AuthRepository =
        AuthRepositoryImpl(auth, db)

    @Provides
    @Singleton
    fun provideContentRepository(db: FirebaseFirestore): ContentRepository =
        ContentRepositoryImpl(db)

    @Provides
    @Singleton
    fun provideAiRepository(functions: FirebaseFunctions): AiRepository =
        AiRepositoryImpl(functions)
}
