import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //clase scanner que permite al usuario ingresar datos
        Scanner scanner = new Scanner(System.in);

        //palabra secreta que el usuario debe adivinar
        String palabrasecreta = "inteligencia";
        int intentosmaximo = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //arreglo
        char[]  letrasAdivinada = new char[palabrasecreta.length()];
        
        //estructura de control que permite inicializar el arreglo con guiones bajos
        for (int i = 0; i < letrasAdivinada.length; i++) {
            letrasAdivinada[i] = '_';
        }
        
        while (!palabraAdivinada && intentos < intentosmaximo) {
            System.out.println("Adivina la palabra secreta: " + String.valueOf(letrasAdivinada) + " ( " + palabrasecreta.length() + " letras )");
            System.out.println("Ingresa una letra: ");

            //leer la letra ingresada por el usuario 
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;

            for (int i = 0; i < palabrasecreta.length(); i++) {
                //estructura de control que permite verificar si la letra ingresada por el usuario es correcta
                if (palabrasecreta.charAt(i) == letra) {
                    letrasAdivinada[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (!letraCorrecta) {
                intentos++;
                System.out.println("Letra Incorrecta! Intentos restantes: " + (intentosmaximo - intentos) + " intentos");             
            }
            if (String.valueOf(letrasAdivinada).equals(palabrasecreta)) {
                palabraAdivinada = true;
                System.out.println(" Felicidades! Has adivinado la palabra secreta: " + palabrasecreta);
                
            }
        }
        if (!palabraAdivinada) {
            System.out.println("Lo siento! Has agotado todos tus intentos. Has perdido!");
            System.out.println("La palabra secreta era: " + palabrasecreta);
        }
        scanner.close();

    }
}
