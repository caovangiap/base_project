package com.prodigy.feature.girlfriend.repository

import com.example.baseapp.core.data.ApiResult
import com.prodigy.feature.girlfriend.model.character.CharacterListRequest
import com.prodigy.feature.girlfriend.model.character.ListCharacterResponse
import com.prodigy.feature.girlfriend.model.character.createImgLink.CreateLinkImageRequest
import com.prodigy.feature.girlfriend.model.character.createImgLink.CreateLinkImageResponse
import com.prodigy.feature.girlfriend.model.character.uploadAssets.GetImageLinkRequest
import com.prodigy.feature.girlfriend.model.character.uploadAssets.GetImageLinkResponse
import com.prodigy.feature.girlfriend.model.character.uploadAssets.UploadImageRequest
import com.prodigy.feature.girlfriend.model.character.uploadAssets.UploadImageResponse
import com.prodigy.feature.girlfriend.model.character.createCharacter.CreateCharacterRequest
import com.prodigy.feature.girlfriend.model.character.createCharacter.CreateCharacterResponse
import com.prodigy.feature.girlfriend.model.character.deleteCharacter.DeleteCharacterResponse
import com.prodigy.feature.girlfriend.model.character.updateCharacter.UpdateCharacterRequest
import com.prodigy.feature.girlfriend.model.character.updateCharacter.UpdateCharacterResponse
import com.prodigy.feature.girlfriend.model.chat.GetChatListRequestModel
import com.prodigy.feature.girlfriend.model.chat.createChat.RequestChatModel
import com.prodigy.feature.girlfriend.model.chat.createChat.ResponseCreateChatModel
import com.prodigy.feature.girlfriend.model.chat.delete_chat.DeleteChatRequest
import com.prodigy.feature.girlfriend.model.chat.delete_chat.DeleteChatResponse
import com.prodigy.feature.girlfriend.model.chat.historyChat.HistoryChatRequestModel
import com.prodigy.feature.girlfriend.model.chat.historyChat.HistoryChatResponse
import com.prodigy.feature.girlfriend.model.chat.reponseChatList.ChatListResponseModel
import com.prodigy.feature.girlfriend.model.chat.sendChat.SendChatRequestModel
import com.prodigy.feature.girlfriend.model.chat.sendChat.SendChatResponseModel
import com.prodigy.feature.girlfriend.model.discover.category.CategoryModel
import com.prodigy.feature.girlfriend.model.discover.filter.DataTag
import com.prodigy.feature.girlfriend.model.discover.search.ResponseSearchModel
import com.prodigy.feature.girlfriend.model.discover.search.SearchBodyRequest
import com.prodigy.feature.girlfriend.model.getToken.JwtTokenDecodeModel
import com.prodigy.feature.girlfriend.model.popularList.ResponsePopularList
import com.prodigy.feature.girlfriend.model.refreshToken.RefreshTokenDecodeModel
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response

interface UserRepository {
    suspend fun fetchToken(packageName: String, firebaseToken: String, tokenGoogle: String?): Flow<ApiResult<JwtTokenDecodeModel>>
    suspend fun refreshToken(): Flow<ApiResult<RefreshTokenDecodeModel>>
}