package kz.homecredit.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.homecredit.core.navigator.Navigator

@Module
@InstallIn(ActivityComponent::class)
class NavigatorProvider {

    @Provides
    fun provideNavigator(): Navigator {
        return Navigator()
    }

}