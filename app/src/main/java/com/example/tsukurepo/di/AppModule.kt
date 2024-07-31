package com.example.tsukurepo.di

import android.content.Context
import com.example.tsukurepo.data.ReportDatabase
import com.example.tsukurepo.data.dao.ReportDao
import com.example.tsukurepo.data.dao.WorkItemDao
import com.example.tsukurepo.data.repositories.ReportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class AppModule {

    @Provides
    fun provideReportRepository(
        reportDao: ReportDao,workItemDao: WorkItemDao
    ): ReportRepository = ReportRepository(reportDao,workItemDao)

    @Provides
    fun provideReportDao(@ApplicationContext context: Context): ReportDao =
        ReportDatabase.buildDatabase(context).reportDao()

    @Provides
    fun provideWorkItemDao(@ApplicationContext context: Context): WorkItemDao =
        ReportDatabase.buildDatabase(context).workItemDao()
}
