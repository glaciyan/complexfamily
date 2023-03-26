@FunctionalInterface
public interface BiLogic {
    boolean is(boolean left, boolean right);

    default BiLogic and(BiLogic other) {
        return (left, right) -> is(left, right) && other.is(left, right);
    }

    default BiLogic or(BiLogic other) {
        return (left, right) -> is(left, right) || other.is(left, right);
    }

    default BiLogic not() {
        return (left, right) -> !is(left, right);
    }

    default BiLogic invert() {
        return (left, right) -> is(!left, !right);
    }

    default BiLogic invertFirst() {
        return (left, right) -> is(!left, right);
    }
}
