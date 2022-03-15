package com.example.pagingcourse.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pagingcourse.models.singlecharacter.SingleCharacter
import com.example.pagingcourse.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel  @Inject constructor(private val repository: Repository) :
    ViewModel(){

    private val _detail: MutableLiveData<SingleCharacter> = MutableLiveData()
    val detail: LiveData<SingleCharacter> = _detail


    fun detail(id: Int) = viewModelScope.launch {
        var response = repository.Details(id)

        if (response.isSuccessful) {
            _detail.value = response.body()
            Log.d("testiwng", "id ${response.body()}")
        }

    }
}