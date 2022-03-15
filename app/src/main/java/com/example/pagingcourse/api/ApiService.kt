package com.example.pagingcourse.api

import com.example.pagingcourse.models.allCharacters.ResponseApi
import com.example.pagingcourse.models.singlecharacter.SingleCharacter
import com.example.pagingcourse.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ):Response<ResponseApi>


    @GET(Constants.SINGLE)
    suspend fun getSingleCharacter(
        @Path("id") id : Int
    ): Response<SingleCharacter>

}