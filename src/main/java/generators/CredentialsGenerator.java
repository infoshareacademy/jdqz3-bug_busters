package generators;

public class CredentialsGenerator extends RandomGenerator{
    private static String emailDomain = "@example.com";

    public static String generateFirstname(){
        return capitalize(generateRandomString(8));
    }

    public static String generateLastname(){
        return capitalize(generateRandomString(14));
    }

    public static String generateEmail(){
        String login = generateRandomString(22);
        return login + emailDomain;
    }

    public static String generatePassword(){
        return generateRandomNumber(0, 9) + generateRandomString(12);
    }

    public static Integer generatePhone() { return generateRandomNumber(000000000, 999999999); }

    public  static String generateComapnyName() { return capitalize(generateRandomString(15));}
}
