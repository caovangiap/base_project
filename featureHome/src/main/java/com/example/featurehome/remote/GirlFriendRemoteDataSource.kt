package com.prodigy.feature.girlfriend.remote
import com.prodigy.feature.girlfriend.model.DataRequestEncryptModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GirlFriendRemoteDataSource @Inject constructor (
    private val apiService: GirlFriendApiService
)  {
    suspend fun fetchToken(data: DataRequestEncryptModel): String {
        val token =  apiService.fetchToken(data)
        return token
    }

    suspend fun refreshToken(data: DataRequestEncryptModel): String {
        val token =  apiService.refreshToken(data)
        return token
    }

    suspend fun getPopularList(data: DataRequestEncryptModel) : String{
        val popularList = apiService.getPopularListForYou(data)
        return popularList
    }

    suspend fun getAllCategory(data: DataRequestEncryptModel) : String{
        val allCategory = apiService.getAllCategory(data)
        return allCategory
    }

    suspend fun getAllTag(data : DataRequestEncryptModel) : String{
        return apiService.getAllTag(data)
    }

    suspend fun getListSearch(data : DataRequestEncryptModel): String{
        return apiService.getListSearch(data)
    }


    suspend fun getChatList(data : DataRequestEncryptModel): String{
        return  apiService.getChatList(data)
    }

    suspend fun createChat(data : DataRequestEncryptModel): String{
        return  apiService.createChat(data)
    }

    suspend fun sendChat(data : DataRequestEncryptModel): String{
        return  apiService.sendChat(data)
    }

    suspend fun getHistoryChat(data : DataRequestEncryptModel): String{
        return  apiService.getHistoryChat(data)
    }

    suspend fun getListCharacter(data : DataRequestEncryptModel): String{
        return apiService.getListCharacter(data)
    }

    suspend fun deleteChat(data : DataRequestEncryptModel): String{
        return apiService.deleteChat(data)
    }

    suspend fun createLinkImg(data : DataRequestEncryptModel): String{
        return apiService.createLinkImg(data)
    }

    suspend fun getImageLink(data: DataRequestEncryptModel): String{
        return apiService.getImageLink(data)
    }

    suspend fun uploadImage(url: String, file : RequestBody): Response<ResponseBody>{
        return apiService.uploadImage(url,"application/octet-stream",file)
    }

    suspend fun createCharacter(data: DataRequestEncryptModel): String{
        return apiService.createCharacter(data)
    }

    suspend fun deleteCharacter(data: DataRequestEncryptModel): String{
        return apiService.deleteCharacter(data)
    }

    suspend fun updateCharacter(data: DataRequestEncryptModel): String{
        return apiService.updateCharacter(data)
    }
}