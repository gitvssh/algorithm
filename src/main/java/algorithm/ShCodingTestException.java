package algorithm;

public class ShCodingTestException extends RuntimeException {
    public ShCodingTestException() {
        super();
    }

    public ShCodingTestException(String message) {
        super(message);
    }

    public ShCodingTestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShCodingTestException(Throwable cause) {
        super(cause);
    }

    protected ShCodingTestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
