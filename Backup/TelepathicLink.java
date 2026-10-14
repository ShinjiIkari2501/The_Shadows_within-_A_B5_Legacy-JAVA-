public interface TelepathicLink {
    // 1. Constructual Method: Must be implemented by psychic characters
    void initialMentalSync(String target);

    // 2. Default method: A standard behavior that can shared or overwritten
    default void shieldMind() {
        System.out.println("\n[PSI_SHIELD] Neural blockades deployed. Scanning blocked.");
    }
}