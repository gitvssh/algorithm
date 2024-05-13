package algorithm.baek.simulation;

public enum Type {
    WHITE(0), RED(1), BLUE(2);

    private final int value;

    Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Type valueOf(char c) {
        switch (c) {
            case '0':
                return WHITE;
            case '1':
                return RED;
            case '2':
                return BLUE;
            default:
                throw new IllegalArgumentException("Unexpected value: " + c);
        }
    }
}
