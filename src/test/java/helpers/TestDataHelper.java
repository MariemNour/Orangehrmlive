package helpers;

import com.github.javafaker.Faker;
import org.apache.commons.text.RandomStringGenerator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestDataHelper {


    final Integer ASCII_UPPER_CASE_START = 65;
    final Integer ASCII_UPPER_CASE_END = 90;
    final Integer ASCII_LOWER_CASE_START = 97;
    final Integer ASCII_LOWER_CASE_END = 122;
    final Integer ASCII_SPECIAL_CHAR_CASE_START = 33;
    final Integer ASCII_SPECIAL_CHAR_CASE_END = 45;
    final Integer ASCII_NUMBER_CHAR_CASE_START = 48;
    final Integer ASCII_NUMBER_CHAR_CASE_END = 57;

    public String generateRandomText(int length){
        Faker faker = new Faker();
        return  faker.expression("#{regexify '[a-zA-Z0-9]{"+ length + "}'}");
    }

    public String generateRandomPassword() {
        Integer Length = 8;
        RandomStringGenerator pwdGeneratorSpecialCharacter = new RandomStringGenerator.Builder().withinRange(ASCII_SPECIAL_CHAR_CASE_START, ASCII_SPECIAL_CHAR_CASE_END)
                .build();
        RandomStringGenerator pwdGeneratorUpperCase = new RandomStringGenerator.Builder().withinRange(ASCII_UPPER_CASE_START, ASCII_UPPER_CASE_END)
                .build();
        RandomStringGenerator pwdGeneratorLowerCase = new RandomStringGenerator.Builder().withinRange(ASCII_LOWER_CASE_START, ASCII_LOWER_CASE_END)
                .build();
        RandomStringGenerator pwdGeneratorNumbers = new RandomStringGenerator.Builder().withinRange(ASCII_NUMBER_CHAR_CASE_START, ASCII_NUMBER_CHAR_CASE_END)
                .build();
        String password = pwdGeneratorSpecialCharacter.generate(Length/4) +
                pwdGeneratorUpperCase.generate(Length/4) +
                pwdGeneratorLowerCase.generate(Length/4) +
                pwdGeneratorNumbers.generate(Length/4);

        return stringShuffle(password);
    }

    private String stringShuffle (String input) {
        List<String> letters = Arrays.asList(input.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled ;
    }
}
