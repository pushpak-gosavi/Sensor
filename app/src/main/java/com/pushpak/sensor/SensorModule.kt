package com.pushpak.sensor

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton

    fun provideLightSensor(app : Application) : MesaurableSensor{
        return LightSensor(app)
    }
}