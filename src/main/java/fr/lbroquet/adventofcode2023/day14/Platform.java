package fr.lbroquet.adventofcode2023.day14;

import java.util.ArrayList;
import java.util.List;

public class Platform {
    private final char[][] platformArray;

    public Platform(char[][] platformArray) {
        this.platformArray = platformArray;
    }

    public List<Slider> tilt() {
        List<Slider> sliders = new ArrayList<>();
        for (int column = 0; column < platformArray[0].length; column++) {
            sliders.addAll(tilt(column));
        }
        return sliders;
    }

    private List<Slider> tilt(int column) {
        List<Slider> sliders = new ArrayList<>();
        StringBuilder slider = new StringBuilder();
        for (int row = 0; row < platformArray.length; row++) {
            char cell = platformArray[row][column];
            if (cell == '#') {
                sliders.add(new Slider(slider.toString(), row));
                slider.setLength(0);
            } else {
                slider.append(cell);
            }
        }
        sliders.add(new Slider(slider.toString(), platformArray.length));
        return sliders;
    }
}
