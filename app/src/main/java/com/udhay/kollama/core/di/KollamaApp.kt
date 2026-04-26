package com.udhay.kollama.core.di
import com.udhay.kollama.feature.settings.presentation.viewmodel.UserSettingsViewModel
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.Module

@Module(includes = [DatabaseModule::class])
@KoinApplication
@ComponentScan("com.udhay.kollama")
class KollamaApp