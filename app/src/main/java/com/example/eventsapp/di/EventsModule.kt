package com.example.eventsapp.di

import com.example.eventsapp.data.local.LocalEventRepositoryImpl
import com.example.eventsapp.data.remote.RemoteEventRepositoryImpl
import com.example.eventsapp.domain.repository.ILocalEventRepository
import com.example.eventsapp.domain.repository.IRemoteRepository
import com.example.eventsapp.domain.usecases.EventUseCaseImpl
import com.example.eventsapp.domain.usecases.IEventUseCase
import com.example.eventsapp.eventdetail.viewmodel.EventDetailViewModel
import com.example.eventsapp.listevents.viewmodel.ListEventsViewModel
import com.example.rockstars.common.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 9/19/19.
 */

val eventsModule = module {
    factory<ILocalEventRepository> { LocalEventRepositoryImpl(get()) }

    factory<IRemoteRepository> { RemoteEventRepositoryImpl() }

    factory<IEventUseCase> { EventUseCaseImpl(get(), get()) }

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    viewModel { EventDetailViewModel(get(), get()) }

    viewModel { ListEventsViewModel(get(), get()) }
}