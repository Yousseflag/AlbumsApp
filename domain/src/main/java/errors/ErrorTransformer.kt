package errors

interface ErrorTransformer {

    suspend fun transform(incoming: Throwable): Throwable
}
