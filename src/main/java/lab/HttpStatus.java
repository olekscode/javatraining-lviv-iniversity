package lab;

public enum HttpStatus {
    INFORMATIONAL(100, 199),
    SUCCESS(200, 299),
    REDIRECTION(300, 399),
    CLIENT_ERROR(400, 499),
    SERVER_ERROR(500, 599);

    private final int minHttpCode;
    private final int maxHttpCode;

    HttpStatus(int minHttpCode, int maxHttpCode) {
        this.minHttpCode = minHttpCode;
        this.maxHttpCode = maxHttpCode;
    }

    public static HttpStatus findByHttpCode(int code) {
        HttpStatus[] statuses = values();

        for (HttpStatus status : statuses) {
            if ((code >= status.minHttpCode) && (code <= status.maxHttpCode)) {
                return status;
            }
        }
        throw new RuntimeException(code + " not supported");
    }
}
