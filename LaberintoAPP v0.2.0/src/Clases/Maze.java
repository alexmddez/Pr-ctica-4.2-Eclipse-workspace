package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Maze {

    private char[][] map;
    private String filename;
    private boolean loaded;

    private int startI;
    private int startJ;
    private int endI;
    private int endJ;

    private boolean startEndSet;

    public Maze() {
        clear();
    }

    public void clear() {
        map = null;
        filename = "";
        loaded = false;

        startI = -1;
        startJ = -1;
        endI = -1;
        endJ = -1;

        startEndSet = false;
    }
    public void loadMaze() {

        File folder = new File("mazes");
        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No hay laberintos para cargar.");
            return;
        }

        File[] txtFiles = new File[files.length];
        int count = 0;

        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            if (name.contains(".txt")) {
                txtFiles[count] = files[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No hay laberintos para cargar.");
            return;
        }

        System.out.println("\n--- Cargar laberinto ---");
        System.out.println("0 - Volver");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + " - " + txtFiles[i].getName());
        }

        int option = Input.getInt("Opción: ", true);

        if (option == 0) {
            return;
        }

        if (option < 1 || option > count) {
            System.out.println("Opción incorrecta.");
            return;
        }

        File selected = txtFiles[option - 1];

        char[][] newMap = readMaze(selected);

        if (newMap == null) {
            System.out.println("No se ha podido cargar el laberinto.");
            return;
        }

        map = newMap;
        filename = selected.getName();
        loaded = true;
        startEndSet = false;
        startI = -1;
        startJ = -1;
        endI = -1;
        endJ = -1;

        System.out.println("Laberinto cargado.");
    }
    public void showMaze() {

        if (!loaded) {
            System.out.println("Primero tienes que cargar un laberinto.");
            return;
        }

        int rows = map.length;
        int cols = map[0].length;

        System.out.println("\n--- Laberinto actual ---");
        System.out.println("Archivo: " + filename + "\n");
        System.out.print("   ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j / 10);
        }
        System.out.println();

        System.out.print("   ");
        for (int j = 0; j < cols; j++) {
            System.out.print(j % 10);
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {

            if (i < 10) {
                System.out.print(" " + i + " ");
            } else {
                System.out.print(i + " ");
            }

            for (int j = 0; j < cols; j++) {

                if (startEndSet && i == startI && j == startJ) {
                    System.out.print('I');
                } else if (startEndSet && i == endI && j == endJ) {
                    System.out.print('F');
                } else {
                    System.out.print(map[i][j]);
                }
            }

            System.out.println();
        }
    }
    public void setStartEnd() {

        if (!loaded) {
            System.out.println("Primero tienes que cargar un laberinto.");
            return;
        }

        int rows = map.length;
        int cols = map[0].length;

        System.out.println("\n--- Inicio y fin ---");
        System.out.println("Filas: 0 a " + (rows - 1) + " | Columnas: 0 a " + (cols - 1));

        int si = Input.getInt("Fila inicio: ", true);
        int sj = Input.getInt("Columna inicio: ", true);

        int ei = Input.getInt("Fila fin: ", true);
        int ej = Input.getInt("Columna fin: ", true);

        if (!inside(si, sj, rows, cols) || !inside(ei, ej, rows, cols)) {
            System.out.println("Coordenadas fuera del laberinto.");
            startEndSet = false;
            return;
        }
        startI = si;
        startJ = sj;
        endI = ei;
        endJ = ej;
        startEndSet = true;
        System.out.println("Inicio y fin guardados.");
    }

    private boolean inside(int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows) {
            return false;
        }
        if (j < 0 || j >= cols) {
            return false;
        }
        return true;
    }
    private char[][] readMaze(File file) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String[] lines = new String[300];
            int count = 0;

            String line = br.readLine();
            while (line != null) {
                lines[count] = line;
                count++;
                line = br.readLine();
            }
            br.close();
            if (count == 0) {
                return null;
            }
            int cols = lines[0].length();
            for (int i = 0; i < count; i++) {
                if (lines[i].length() != cols) {
                    return null;
                }
            }

            char[][] result = new char[count][cols];

            for (int i = 0; i < count; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = lines[i].charAt(j);
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}