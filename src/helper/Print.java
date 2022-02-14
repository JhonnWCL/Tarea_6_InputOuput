package helper;

public class Print {

    public static void printDescription() {
        System.out.println(Colors.Blue + "PROGRAMA DE REGISTRO PAISES <Natalidad y Mortalidad>\n" + Colors.Green +
                "Presione " + Colors.Red + "0" + Colors.Green + " para salir del programa en cualquier momento\n" +
                "Presione " + Colors.Red + "1" + Colors.Green + " para ver la informacion de un archivo 'X' que contiene el promedio de la taza de\n " +
                "           natalidad y mortalidad de cada continente del mundo, " + Colors.Red + "< " + Colors.Green + "la informacion no es actual" + Colors.Red + " >\n" + Colors.Green +
                "Presione " + Colors.Red + "2" + Colors.Green + " realizar un nuevo registro de paises\n" +
                "Presione " + Colors.Red + "3" + Colors.Green + " para ver la informacion de los paises que registro, incluyendo los datos de crecimento o decremento de las tasas de natalidad y mortalidad por continente\n" +
                "           tomando como informacion para comparar la del archivo 'X'");
        System.out.print(Colors.Blue + "Input -> " + Colors.Default);
    }

    public static void printContinentNames() {
        System.out.println(Colors.Red+"CONTINENTES:"+Colors.Default+"Ingrese el indice del continente  donde se encuentra el o los pais a registrar"+Colors.Green);
        for (int i = 0; i < DefaultData.getContinentsList().size(); i++) {
            System.out.print((i+1)+" -> "+ DefaultData.getContinentsList().get(i)+" |");
        }
        System.out.print(Colors.Blue + "\nInput -> " + Colors.Default);
    }
    public static  void getTilte(){
        System.out.println("---------------------------------REGISTRO DE PAISES, INGRESE -1 COMO NOMBRE PAIS PARA TERMINAR EL REGISTRO---------------------------------");
    }

    public static void printCountriesRegister(String continent) {
        System.out.println(Colors.Green + "Registro de paises del continente: "+Colors.Red+continent+Colors.Default);
    }

    private   static void printExitSubMenu(){
        System.out.println(Colors.Red+"Aun quedan datos por registrar, si realiza esta accion no se registrara el pais con datos faltantes!"+Colors.Default);
        msjConfirm();
    }

    public static void printChangeOfContinent(){
        System.out.println(Colors.Yellow+"DESEA REGISTRAR PAISES EN OTRO CONTINENTE?");
        printExitSubMenu();
    }
    public  static void printSaveRegisterInvalid(){
        System.out.println(Colors.Yellow+"TERMINAR EL REGISTRO PAIS");
        printExitSubMenu();
    }

    public static void printInputMsjNewCountry(){
        System.out.println(Colors.Yellow + "Registro de nuevo pais, puede presionar " + Colors.Red+"'0' "+Colors.Yellow+"para salir del programa " +
                "en cualquier momento, "+Colors.Red+"-1 "+Colors.Yellow+"para\n"+
                "            dirigirse a ingreso nombre pais donde con un -1 podra terminar el registro de paises y "+Colors.Red+"-2"+Colors.Yellow+" para registrar paises en otro continente "+Colors.Default);

    }

    public static void msjConfirm(){
        System.out.print(Colors.Yellow+"Presione 1 para confirmar (si no esta en la op. nombre pais lo dirigira ahi) y la accion y 2 para cancelarla\n"+Colors.Blue + "Input -> " + Colors.Default);
    }

    public  static void printSaveRegister(){
        System.out.println(Colors.Red+"***********************************************************************************************"+Colors.Default);
        System.out.println("REGISTRO TERMINADO Y ALAMACENADO EN EL ARCHIVO                                                            *");
        System.out.println(Colors.Red+"***********************************************************************************************"+Colors.Default);
    }
    public  static void printSaveRInvalid(){
        System.out.println(Colors.Red+"***********************************************************************************************"+Colors.Default);
        System.out.println("REGISTRO VACIO NO SE ALAMACENO EN ARCHIVO                                                                 *");
        System.out.println(Colors.Red+"***********************************************************************************************"+Colors.Default);
    }

    public  static void invalidNameCountry(){
        System.out.println(Colors.Red+"El nombre del pais debe de ser de tamanio mayor o igual a 4 carateres"+Colors.Default);
    }

    public static void printNotNumber(boolean isDouble) {
        if (isDouble)
            System.out.print(Colors.Red + "!Dato ingresado no decimal o numero muy alto!\n" + Colors.Blue + "Input -> " + Colors.Default);
        else
            System.out.print(Colors.Red + " !Dato ingresado no es entero o numero muy alto!\n" + Colors.Blue + "Input -> " + Colors.Default);
    }

    public static void printDataOutOfRange(boolean isDouble) {
        if (isDouble)
            System.out.print(Colors.Red + "!Dato ingresado no esta dentro del rango establecido!\n" + Colors.Blue + "Input -> " + Colors.Default);
        else
            System.out.print(Colors.Red + "!Dato ingresado no esta dentro del rango valido!\n" + Colors.Blue + "Input -> " + Colors.Default);
    }

    public static String printDelimiter(int getLengtRecuadro){
        return (String.format("%0" + getLengtRecuadro + "d", 0).replace("0","_"));
    }
    public  static void printException(String textName){
        System.out.println(Colors.Red+"Error causado por : "+Colors.Yellow+"Archivo "+textName +" de lectura/escritura no encontrado!!\n" +
                "¿Desea salir del programa?:\n" +
                "1:Si\n" +
                "2:No"+Colors.Default);
    }
}