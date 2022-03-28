package games.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    private static Console console;
    private BufferedReader bufferedReader;

    public static Console instance() {
        if (console == null) {
            console = new Console();
        }

        return console;
    }

    public Console() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readString(String string) {
        String input = null;
        boolean ok = false;

        do {
            this.write(string);

            try {
                input = this.bufferedReader.readLine();
                ok = true;
            } catch (Exception var5) {
                this.writeError("string");
            }
        } while(!ok);

        return input;
    }

    public int readInt(String string) {
        int input = 0;
        boolean ok = false;

        do {
            try {
                input = Integer.parseInt(this.readString(string));
                ok = true;
            } catch (Exception var5) {
                this.writeError("integer");
            }
        } while(!ok);

        return input;
    }

    public char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;

        do {
            String input = this.readString(title);
            if (input.length() != 1) {
                this.writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while(!ok);

        return charValue;
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String string) {
        System.out.println(string);
    }

    public void write(String string) {
        System.out.print(string);
    }

    private void writeError(String format) {
        System.out.println("FORMAT ERROR! Enter a value in " + format + " formatted value.");
    }
}
