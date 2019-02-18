package generators;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;


public class RandomGenerator {

    protected static String genrateRandomString(int length){
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();

        return generator.generate(length);
    }

    protected static int generateRandomNumber(int min, int max){
        Random rand = new Random();

        return rand.nextInt(max) + min;
    }

    protected static String capitalize(String text){
        return StringUtils.capitalize(text);
    }
}
