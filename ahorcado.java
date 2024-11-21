import java.util.*;
import java.time.LocalTime;

public class ahorcado {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords;
        int tiempoLimite = 60; //tiempo limite en segundos
        long tiempoActual;
        int tiempoTranscurrido;

        //definir lista de palabras con varias palabras para el juego
        String palabras[] = {
                "elefante", "computadora", "montaña", "bicicleta", "zapato",
                "solitario", "guitarra", "amistad", "ventana", "plenitud",
                "coche", "avión", "libro", "estrella", "chocolate", "mariposa",
                "flor", "hielo", "reloj", "naranja", "lluvia", "ratón", "tenedor"
        };
        long tiempoInicio = System.currentTimeMillis();

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




        for (int i = 0; i < palabra_secreta.length(); i++) {
            palabra_Oculta.append("_");
        }


        //Solicitar al jugador que introduzca una letra

        while (intentos > 0 && palabra_Oculta.toString().contains("_")) {
            tiempoActual = System.currentTimeMillis();
            tiempoTranscurrido = (int) ((tiempoActual - tiempoInicio) / 1000);
            System.out.println("Introduce una letra: ");
            letra = scanner.nextLine().toLowerCase();


            if(tiempoTranscurrido > tiempoLimite){
                System.out.println("Se acabó el tiempo, la palabra oculta era: " +palabra_secreta);
                return;
            }

            //Mostrar estado actual
            System.out.println("Palabra oculta: " + palabra_Oculta);
            System.out.println("Intentos restantes: " + intentos);
            System.out.println("Letras ya adivinadas: " + letras_adivinadas.toString());
            System.out.println("Tiempo restante: " +(tiempoLimite - tiempoTranscurrido));

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























