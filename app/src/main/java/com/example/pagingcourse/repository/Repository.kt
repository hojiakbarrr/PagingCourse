package com.example.pagingcourse.repository

import com.example.pagingcourse.api.ApiService
import com.example.pagingcourse.models.singlecharacter.SingleCharacter
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {

    suspend fun Details (id: Int) : Response<SingleCharacter> = api.getSingleCharacter(id)
}