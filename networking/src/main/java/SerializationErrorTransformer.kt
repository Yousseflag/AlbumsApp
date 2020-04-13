package lbc.testech.albumsapp.networking

import errors.ErrorTransformer
import errors.RemoteServiceIntegrationError
import kotlinx.serialization.MissingFieldException
import kotlinx.serialization.SerializationException
import kotlinx.serialization.UnknownFieldException

object SerializationErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable) =
        when (incoming) {
            is MissingFieldException,
            is UnknownFieldException,
            is SerializationException -> RemoteServiceIntegrationError.UnexpectedResponse
            else -> incoming
        }

}