package com.example.mapsmarkerapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mapsmarkerapp.model.MarkerEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val repository: MapsRepository
): ViewModel() {

    val _markerListLiveData = MutableLiveData<List<MarkerEntity>>()
    val markerListLiveData: LiveData<List<MarkerEntity>> = _markerListLiveData

    fun insertMarkerData(markerEntity: MarkerEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertMarkerInDB(markerEntity)
        }
    }

    fun deleteMarkerData(id : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMarkerFromDB(id)
        }
    }

    fun getAllMarkers() {
        viewModelScope.launch(Dispatchers.IO) {
            _markerListLiveData.postValue(repository.getAllMarkers())
        }
    }

}