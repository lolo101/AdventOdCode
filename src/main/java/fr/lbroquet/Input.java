package fr.lbroquet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input {
    public static BufferedReader load(Class<?> mainClass) {
        InputStream inputStream = mainClass.getResourceAsStream("input");
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}
