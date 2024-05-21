import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la declaración de variable en C++ y el código en C++ (puedes usar varias líneas).");
        System.out.println("Presiona Enter en una línea vacía para finalizar:");

        StringBuilder inputBuilder = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).isEmpty()) {
            inputBuilder.append(line).append("\n");
        }
        String input = inputBuilder.toString();

        LinkedHashMap<String, String> tokenTable = new LinkedHashMap<>();

        String[] lines = input.split("\n");
        int row = 0;

        for (String currentLine : lines) {
            String[] tokens = currentLine.split("(?<=;)|(?=;)|\\s+");

            int column = 0;

            for (String token : tokens) {
                if (!token.isEmpty()) {
                    if(token.charAt(token.length() - 1) == ';'){
                        column -= 1;
                    }
                    String position = String.format("%d%d", row, column);
                    tokenTable.put(position, token);
                    column += token.length() + 1;
                }
            }

            row++;
        }

        System.out.println("\nTabla de Palabras y Tokens:");
        System.out.printf("%-10s%-10s%n", "Clave", "Token");
        for (Map.Entry<String, String> entry : tokenTable.entrySet()) {
            System.out.printf("%-10s%-10s%n", entry.getKey(), entry.getValue());
        }

    }
}
