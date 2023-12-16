package fr.lbroquet.adventofcode2023.day14;

public record Slider(int upperRow, long roundRocksCount) {

    public Slider(String column, int endRow) {
        this(
                endRow - column.length(),
                column.chars().filter(cell -> cell == 'O').count()
        );
    }

    public long load() {
        long load = 0;
        for (int count = 0; count < roundRocksCount; count++) {
            load += 100 - upperRow - count;
        }
        return load;
    }
}
