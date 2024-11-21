import java.util.*;

public class ahorcado {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords;
        //definir lista de palabras con varias palabras para el juego
        String palabras[] = {
                "elefante","computadora","montaña","bicicleta","zapato",
                "solitario","guitarra", "amistad", "ventana","plenitud",
                "coche", "avión","libro","estrella","chocolate","mariposa",
                "flor","hielo","reloj","naranja","lluvia","ratón","tenedor"
        };

        //Numero de palabras aleatorias a generar
        numberOfWords = 1;

        //Lista para almacenar las palabras seleccionadas
        List<String> randomWords = new ArrayList<>();

        //Generador de numeros aleatorios
        Random random = new Random();

        //Seleccionar palabras aleatorias
        for (int i=0; i < numberOfWords; i++){
            int randomIndex = random.nextInt(palabras.length); //indice aleatorio
            randomWords.add(palabras[randomIndex]); //Añadir palabra a la lista
            }

        //System.out.println("Palabra secreta: " + randomWords);
        String palabra_secreta = randomWords.get(random.nextInt(randomWords.size()));
        System.out.println("Palabra secreta: " +palabra_secreta);


        //INICIALIZAR:
        int intentos = 6;
        String letra;

        ArrayList<String> letras_adivinadas = new ArrayList<String>();
        StringBuilder palabra_Oculta = new StringBuilder();


        System.out.println("Intentos restantes: "+intentos);

        System.out.println("Letras ya adivinadas: " +letras_adivinadas.toString());

        for(int i=0; i < palabra_secreta.length(); i++){
            palabra_Oculta.append("_");
        }
        System.out.println("La palabra oculta: " +palabra_Oculta);


       // 4.2 SOLICITAR al jugador que introduzca una letra
        do{
            System.out.println("Introduce una letra: ");
             letra = scanner.nextLine();

            // SI la letra ya fue adivinada, MOSTRAR mensaje de advertencia y continuar.
            if (letras_adivinadas.contains(letra)) {
                System.out.println("Esta letra ya ha sido introducida.");
                intentos--;
                continue;

            }

            if(!isString(letra)){
                System.out.println("Error, introduce una letra.");
            }else{
                letras_adivinadas.add(letra);
                System.out.println("Letra introducida: " +letra);
                System.out.println("Letras ya adivinadas: " +letras_adivinadas.toString());
            }
            //SI la letra está en palabra_secreta:
            if(palabra_secreta.contains(letra)){
                for(int i=0; i < palabra_secreta.length(); i++ ){
                    if(palabra_secreta.charAt(i) == letra.charAt(0)){
                        palabra_Oculta.setCharAt(i, letra.charAt(0));
                    }
                }
                System.out.println("Es correcto!");
                System.out.println(palabra_Oculta.toString());

                if(palabra_Oculta.equals(palabra_secreta)){
                    System.out.println("Felicidades has ganado!");
                    break;
                }

            }
            // - ACTUALIZAR palabra_oculta para revelar todas las ocurrencias de la letra en palabra_secreta.






        } while (!isString(letra) || letras_adivinadas.contains(letra) || !palabra_Oculta.equals(palabra_secreta));  // El ciclo continuará hasta que se ingrese una letra válida y no repetida





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


        }

    public static boolean isString(String str) {
        // Verifica si el String tiene un solo carácter y es alfabético
        return str != null && str.length() == 1 && str.matches("[a-zA-Z]");
    }








    }











