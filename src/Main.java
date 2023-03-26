public class Main {

    private static final int FIRST_BIT = 0b1;
    private static final int SECOND_BIT = 0b10;
    private static final int THIRD_BIT = 0b100;
    private static final int FOURTH_BIT = 0b1000;
    private static final int FIFTH_BIT = 0b10000;

    private static boolean isBitSet(int n, int mask) {
        return (n & mask) != 0;
    }

    private static final BiLogic and = (left, right) -> left && right;
    private static final BiLogic or = (left, right) -> left || right;
    private static final BiLogic xor = or.invert().and(or);
    private static final BiLogic imply = or.invertFirst();
    private static final BiLogic eq = (left, right) -> left == right;

    public static void main(String[] args) {
        System.out.println("E\t\tF\t\tG\t\tH\t\tI\t\tres");
        for (int i = 0; i <= 31; i++) {
            boolean E = isBitSet(i, FIFTH_BIT);
            boolean F = isBitSet(i, FOURTH_BIT);
            boolean G = isBitSet(i, THIRD_BIT);
            boolean H = isBitSet(i, SECOND_BIT);
            boolean I = isBitSet(i, FIRST_BIT);

            boolean allGood = imply.is(H,F) && or.is(I, G) && xor.is(F, E) && eq.is(E, G) && imply.is(I, and.is(G, H));

            System.out.printf("%b\t%b\t%b\t%b\t%b\t%B%n", E, F, G, H, I, allGood);

        }
    }
}