package com.prodigy.feature.girlfriend.remote

import com.prodigy.feature.girlfriend.model.DataRequestEncryptModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Url

interface GirlFriendApiService {

    @POST("v5/account/get-token-social")
    suspend fun fetchToken(
        @Body data: DataRequestEncryptModel,
    ): String

    @POST("v5/tools/account/refresh-token")
    suspend fun refreshToken(
        @Body data: DataRequestEncryptModel,
    ): String

    @POST("v5/tools/ai-girlfriend/popular/list")
    suspend fun getPopularListForYou(
        @Body data: DataRequestEncryptModel,
    ): String

    @POST("v5/tools/ai-girlfriend/categories")
    suspend fun getAllCategory(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/tags")
    suspend fun getAllTag(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/search")
    suspend fun getListSearch(
        @Body data: DataRequestEncryptModel
    ): String


    @POST("v5/tools/ai-girlfriend/chat/list")
    suspend fun getChatList(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/chat/create")
    suspend fun createChat(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/chat/send")
    suspend fun sendChat(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/chat/list-messages")
    suspend fun getHistoryChat(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/character/created-list")
    suspend fun getListCharacter(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/chat/delete")
    suspend fun deleteChat(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/character/image-create-pro")
    suspend fun createLinkImg(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/upload-assets")
    suspend fun getImageLink(
        @Body data: DataRequestEncryptModel
    ): String

    @PUT
    suspend fun uploadImage(
        @Url url: String,
        @Header("Content-Type") contentType: String = "application/octet-stream",
        @Body body: RequestBody
    ): Response<ResponseBody>

    @POST("v5/tools/ai-girlfriend/character/delete")
    suspend fun deleteCharacter(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("/v5/tools/ai-girlfriend/character/create")
    suspend fun createCharacter(
        @Body data: DataRequestEncryptModel
    ): String

    @POST("v5/tools/ai-girlfriend/character/update")
    suspend fun updateCharacter(
        @Body data: DataRequestEncryptModel
    ): String
}