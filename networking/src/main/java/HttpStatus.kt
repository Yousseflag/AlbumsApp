package lbc.testech.albumsapp.networking

@Suppress("MagicNumber")
enum class HttpStatus(val code: Int) {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    OK_NO_CONTENT(204),
    RESET_CONTENT(205),
    NOT_MODIFIED(304),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    UNAVAILABLE(503),
    INTERNAL_SERVER_ERROR(500)
}
