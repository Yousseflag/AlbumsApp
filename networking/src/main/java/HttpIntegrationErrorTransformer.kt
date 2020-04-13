package lbc.testech.albumsapp.networking

import errors.ErrorTransformer
import errors.RemoteServiceIntegrationError
import retrofit2.HttpException

object HttpIntegrationErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable) =

        when (incoming) {
            is HttpException -> translateUsingStatusCode(incoming.code())
            else -> incoming
        }

    private fun translateUsingStatusCode(code: Int) =
        when (code) {
            in 400..499 -> RemoteServiceIntegrationError.ClientOrigin
            else -> RemoteServiceIntegrationError.RemoteSystem
        }
}