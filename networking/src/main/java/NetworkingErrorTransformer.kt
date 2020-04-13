package lbc.testech.albumsapp.networking

import errors.ErrorTransformer
import errors.NetworkingError
import java.io.IOException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

object NetworkingErrorTransformer : ErrorTransformer {

    override suspend fun transform(incoming: Throwable) =
        when {
            (!isNetworkingError(incoming)) -> incoming
            isConnectionTimeout(incoming) -> NetworkingError.OperationTimeout
            cannotReachHost(incoming) -> NetworkingError.HostUnreachable
            isSSLError(incoming) -> NetworkingError.SecureConnectionFailure
            else -> NetworkingError.ConnectionSpike
        }

    private fun isNetworkingError(error: Throwable) =
        isConnectionTimeout(error) ||
                cannotReachHost(error) ||
                isRequestCanceled(error) ||
                isSSLError(error)

    private fun isRequestCanceled(throwable: Throwable) =
        throwable is IOException &&
                throwable.message?.contentEquals("Canceled") ?: false

    private fun cannotReachHost(error: Throwable) =
        error is UnknownHostException ||
                error is ConnectException ||
                error is NoRouteToHostException

    private fun isConnectionTimeout(error: Throwable) =
        error is SocketTimeoutException

    private fun isSSLError(error: Throwable) =
        error is SSLException
}
