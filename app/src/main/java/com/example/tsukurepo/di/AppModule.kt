package com.example.tsukurepo.di

import android.content.Context
import com.example.tsukurepo.Data.repositories.ReportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    @Provides
    fun provideReportRepository(@ApplicationContext context: Context): ReportRepository = ReportRepository(context)
}
