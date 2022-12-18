public class BaseInvalidaException extends Throwable {
    double base;
    public BaseInvalidaException(double base) {
        this.base = base;
    }
}
