package unitTests;

import generators.AddressGenerator;
import org.junit.Test;

import static java.lang.Character.isUpperCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressGeneratorUnitTests {

    @Test
    public void isCityLengthEqualTo7() {
        Integer number = 7;
        Integer city = AddressGenerator.generateCity().length();
        assertEquals("Length of the name is not equal to 7", city, number);
    }

    @Test
    public void isStateLengthEqualTo7() {
        Integer number = 9;
        Integer city = AddressGenerator.generateState().length();
        assertEquals("Length of the name is not equal to 9", city, number);
    }

    @Test
    public void isStateFirstLetterCapitalized() {
        char firstStateLetter = AddressGenerator.generateState().charAt(0);
        assertTrue(isUpperCase(firstStateLetter));
    }

    @Test
    public void isCityFirstLetterCapitalized() {
        char firstCityLetter = AddressGenerator.generateCity().charAt(0);
        assertTrue(isUpperCase(firstCityLetter));
    }

    @Test
    public void isPostalCodeLengthCorrect() {
        String[] postalCode = AddressGenerator.generatePostalCode().split("-");
        int firstHalf = postalCode[0].length();
        int secondHalf = postalCode[1].length();
        assertTrue(firstHalf == 2 && secondHalf == 3);
    }

    @Test
    public void doesPostalCodeContainsTheSeparatorSign (){
        String postalCode = AddressGenerator.generatePostalCode();
        assertTrue(postalCode.contains("-"));
    }
}
