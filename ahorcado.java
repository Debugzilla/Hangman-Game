import java.util.*;

public class ahorcado {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords;
        //definir lista de palabras con varias palabras para el juego
        String palabras[] = {
                "elefante", "computadora", "montaña", "bicicleta", "zapato",
                "solitario", "guitarra", "amistad", "ventana", "plenitud",
                "coche", "avión", "libro", "estrella", "chocolate", "mariposa",
                "flor", "hielo", "reloj", "naranja", "lluvia", "ratón", "tenedor"
        };

        //Numero de palabras aleatorias a generar
        numberOfWords = 1;

        //Lista para almacenar las palabras seleccionadas
        List<String> randomWords = new ArrayList<>();

        //Generador de numeros aleatorios
        Random random = new Random();

        //Seleccionar palabras aleatorias
        for (int i = 0; i < numberOfWords; i++) {
            int randomIndex = random.nextInt(palabras.length); //indice aleatorio
            randomWords.add(palabras[randomIndex]); //Añadir palabra a la lista
        }

        //System.out.println("Palabra secreta: " + randomWords);
        String palabra_secreta = randomWords.get(random.nextInt(randomWords.size()));
        //System.out.println("Palabra secreta: " + palabra_secreta);


        //INICIALIZAR:
        int intentos = 6;
        String letra = "";
        int fin = 0;

        ArrayList<String> letras_adivinadas = new ArrayList<String>();
        StringBuilder palabra_Oculta = new StringBuilder();

        System.out.println("Bienvenido al juego del ahorcado!");
        System.out.println("Adivina la palabra antes de quedarte sin intentos");
        System.out.println("");


        System.out.println("Intentos restantes: " + intentos);
        System.out.println("Letras ya adivinadas: " + letras_adivinadas.toString());

        for (int i = 0; i < palabra_secreta.length(); i++) {
            palabra_Oculta.append("_");
        }
        System.out.println("La palabra oculta: " + palabra_Oculta);

        //Solicitar al jugador que introduzca una letra

        while (intentos > 0 && palabra_Oculta.toString().contains("_")) {
            System.out.println("Introduce una letra: ");
            letra = scanner.nextLine().toLowerCase();

            //validar entrada
            if (letra.length() != 1 || !Character.isLetter(letra.charAt(0))) {
                System.out.println("Por favor, introduce una letra válida.");
                continue;
            }

            //comprobamos si la letra fue adivinada
            if (letras_adivinadas.contains(letra)) {
                System.out.println("Ya adivinaste esta letra. Intenta con otra");
                continue;
            }

            //Añadir la letra a la lista de letras acertadas
            letras_adivinadas.add(letra);

            //verificamos si la letra está en la palabra secreta
            if (palabra_secreta.indexOf(letra) >= 0) {
                System.out.println("Perfecto! la letra está en la palabra");

                for (int i = 0; i < palabra_secreta.length(); i++) {
                    if (palabra_secreta.charAt(i) == letra.charAt(0)) {
                        palabra_Oculta.setCharAt(i, letra.charAt(0));
                    }
                }


            } else {
                intentos--;
                System.out.println("Letra incorrecta. Te quedan " + intentos + " intentos restantes");
            }
            // Actualizar la palabra oculta
            System.out.println("Palabra oculta: " +palabra_Oculta);


        }

        if(palabra_Oculta.toString().equals(palabra_secreta)){
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " +palabra_secreta);
        }else{
            System.out.println("\nTe quedaste sin intentos. La palabra era: " + palabra_secreta);
        }

        scanner.close();


    }

}




        //4.3 VALIDAR entrada:

             //   - SI la entrada no es una letra válida, MOSTRAR mensaje de error y continuar.
        //4.4 AÑADIR la letra a letras_adivinadas.
        //4.5 VERIFICAR:
       // - SI la letra está en palabra_secreta:
       // - ACTUALIZAR palabra_oculta para revelar todas las ocurrencias de la letra en palabra_secreta.
       //         - SI palabra_oculta es igual a palabra_secreta, MOSTRAR mensaje de victoria y SALIR del bucle.
       //         - SI la letra NO está en palabra_secreta:
      //  - RESTAR 1 a intentos_restantes.
     //   - MOSTRAR mensaje indicando que la letra no está en la palabra.
      //  5. FIN DEL BUCLE.

      //  6. SI intentos_restantes == 0:
       // MOSTRAR mensaje de derrota y la palabra_secreta.





















