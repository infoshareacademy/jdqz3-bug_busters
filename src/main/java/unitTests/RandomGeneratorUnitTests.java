package unitTests;

import generators.RandomGenerator;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;
import static org.junit.Assert.assertTrue;

public class RandomGeneratorUnitTests extends RandomGenerator{

    @Test
    public void doesRandomStringReturnsLettersOnly() {
        String regex = "[a-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(RandomGenerator.generateRandomString(10));
        assertTrue(matcher.matches());
    }

    @Test
    public void doesRandomNumberReturnsNumbersOnly() {
        String regex = "[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Integer.toString(RandomGenerator.generateRandomNumber(1,9)));
        assertTrue(matcher.matches());
    }

    @Test
    public void doesCapitalizeReturnFirstLetterCapitalize() {
        String text = "random text";
        char firstLetter = RandomGenerator.capitalize(text).charAt(0);
        assertTrue(isUpperCase(firstLetter));
    }

}
