package lbc.testech.albumsapp.networking

import org.slf4j.LoggerFactory

object NetworkCall {
    private val logger = LoggerFactory.getLogger(this::class.java.simpleName)
    private val transformers = listOf(
        NetworkingErrorTransformer,
        HttpIntegrationErrorTransformer,
        SerializationErrorTransformer
    )

    suspend fun <T : Any> safeApiResult(call: suspend () -> T): T {

        return try {
            call.invoke()
        } catch (incoming: Throwable) {
            logger.error("Received error: ", incoming)
            throw transformers
                .map { it.transform(incoming) }
                .reduce { transformed, another ->
                    when {
                        transformed == another -> transformed
                        another == incoming -> transformed
                        else -> another
                    }
                }
        }
    }

    private fun isHttpSuccessful(code: Int) = code == HttpStatus.OK_NO_CONTENT.code ||
            code == HttpStatus.RESET_CONTENT.code
}
