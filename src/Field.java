public class Field {

    private final int size;
    private final char[][] field;
    private int x;
    private int y;

    public Field(int size) {
        this.size = size;
        field = new char[size][size];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '.';
            }
        }

        x = size / 2;
        y = size / 2;
    }

    public void move(String command, int steps) {

        if (command.equalsIgnoreCase("u")) {
            for (int i = y; i >= y - steps; i--) {
                field[i][x] = '*';
            }
            y -= steps;

        } else if (command.equalsIgnoreCase("ru")) {
            for (int i = y; i >= y - steps; i--) {
                field[i][x] = '*';
                x++;
            }
            y -= steps;
            x--;

        } else if (command.equalsIgnoreCase("r")) {
            for (int i = x; i <= x + steps; i++) {
                field[y][i] = '*';
            }
            x += steps;

        } else if (command.equalsIgnoreCase("rd")) {
            for (int i = y; i <= y + steps; i++) {
                field[i][x] = '*';
                x++;
            }
            y += steps;
            x--;

        } else if (command.equalsIgnoreCase("d")) {
            for (int i = y; i <= y + steps; i++) {
                field[i][x] = '*';
            }
            y += steps;

        } else if (command.equalsIgnoreCase("ld")) {
            for (int i = y; i <= y + steps; i++) {
                field[i][x] = '*';
                x--;
            }
            y += steps;
            x++;

        } else if (command.equalsIgnoreCase("l")) {
            for (int i = x; i >= x - steps; i--) {
                field[y][i] = '*';
            }
            x -= steps;

        } else if (command.equalsIgnoreCase("lu")) {
            for (int i = y; i >= y - steps; i--) {
                field[i][x] = '*';
                x--;
            }
            y -= steps;
            x++;

        } else {
            System.out.println("Unknown command!");
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                result.append(field[i][j]).append(" ");
            }
            result = new StringBuilder(result.append(System.lineSeparator()));
        }

        return result.toString();
    }
}
