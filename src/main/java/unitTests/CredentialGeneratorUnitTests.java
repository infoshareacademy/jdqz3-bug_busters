package unitTests;

import generators.CredentialsGenerator;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isUpperCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CredentialGeneratorUnitTests {

    @Test
    public void isUserNameLengthEqualTo8() {
        Integer length = 8;
        Integer name = CredentialsGenerator.generateFirstname().length();
        assertEquals("Length of the name is not equal to 8", length, name);
    }

    @Test
    public void isUserLastNameLengthEqualTo14() {
        Integer length = 14;
        Integer lastName = CredentialsGenerator.generateLastname().length();
        assertEquals("Length of the name is not equal to 14", length, lastName);
    }

    @Test
    public void isUserNameFirstLetterCapitalized() {
        char firstNameLetter = CredentialsGenerator.generateFirstname().charAt(0);
        assertTrue(isUpperCase(firstNameLetter));
    }

    @Test
    public void isUserLastNameFirstLetterCapitalized() {
        char lastNameLetter = CredentialsGenerator.generateLastname().charAt(0);
        assertTrue(isUpperCase(lastNameLetter));
    }

    @Test
    public void isEmailAddressValid() {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(CredentialsGenerator.generateEmail());
        assertTrue(matcher.matches());
    }

    @Test
    public void isPhoneNumberLengthEqualTo9() {
        Integer length = 9;
        Integer phoneNumber = Integer.toString(CredentialsGenerator.generatePhone()).length();
        assertEquals("Length of the name is not equal to 9", length, phoneNumber);
    }

    @Test
    public void isCompanyNameLengthEqualTo15() {
        Integer length = 15;
        Integer companyName = CredentialsGenerator.generateCompanyName().length();
        assertEquals("Length of the name is not equal to 15", length, companyName);
    }

    @Test
    public void isCompanyNameFirstLetterCapitalized() {
        char companyNameLetter = CredentialsGenerator.generateCompanyName().charAt(0);
        assertTrue(isUpperCase(companyNameLetter));
    }

}
