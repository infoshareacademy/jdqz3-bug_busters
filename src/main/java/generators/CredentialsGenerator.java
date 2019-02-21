package generators;


public class CredentialsGenerator extends RandomGenerator{
    private static String emailDomain = "@example.com";

    public static String generateFirstname(){
        return capitalize(genrateRandomString(8));
    }

    public static String generateLastname(){
        return capitalize(genrateRandomString(14));
    }

    public static String generateEmail(){
        String login = genrateRandomString(22);
        return login + emailDomain;
    }

    public static String generatePassword(){
        return generateRandomNumber(0, 9) + genrateRandomString(12);
    }

    public static Integer generatePhone() { return generateRandomNumber(000000000, 999999999); }

    public  static String generateComapnyName() { return capitalize(genrateRandomString(15));}
}
