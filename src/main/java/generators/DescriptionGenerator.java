package generators;

public class DescriptionGenerator extends RandomGenerator {
    public static String generateRandomDescription(){
        return capitalize(generateRandomString(100));
    }

}
