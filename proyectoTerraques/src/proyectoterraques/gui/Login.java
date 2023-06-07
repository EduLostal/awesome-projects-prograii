package proyectoterraques.gui;

import proyectoterraques.source.FileHandler;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {


        Scanner scNumber = new Scanner(System.in);


        int option;
        String path;

        do {

            System.out.println("\n--SANTANDER BANK--");
            System.out.println("1 - Login");
            System.out.println("2 - Exit\n");

            System.out.print("Choose an option: ");
            option=scNumber.nextInt();

            if (option==1){
<<<<<<< HEAD
<<<<<<< HEAD

=======
                clearScreen();
                clearConsole();
>>>>>>> fernando.william
=======
                clearScreen();
                clearConsole();
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4
                //TODO listar bancos
                FileHandler fileHandler = new FileHandler();
                int bankNumber=1;
                String suboption;
                System.out.println("\nOFFICE\t\tOFFICE FULL ADDRESS\t\tCOUNTRY\t\tCODE\tCITY");
<<<<<<< HEAD
<<<<<<< HEAD
=======
                System.out.println("------------------------------------------------------------------");
>>>>>>> fernando.william
=======
                System.out.println("------------------------------------------------------------------");
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4

                path="src/proyectoterraques/files/banks.dat";

                for (String bank: fileHandler.loadFileContent(path)){

                    String [] separarTexto;
                    separarTexto= bank.split(",");

                    String office=separarTexto[0];
                    String address=separarTexto[1];
                    String city=separarTexto[2];
                    String countryName=separarTexto[3];
                    String country=separarTexto[4];


<<<<<<< HEAD
<<<<<<< HEAD
                    System.out.println(office+" - "+address+" - "+countryName+" - "+country+" - "+city);
=======
                    System.out.println(office+"\t\t"+address+"\t\t"+countryName+"\t\t"+country+"\t\t"+city);
>>>>>>> fernando.william
=======
                    System.out.println(office+"\t\t"+address+"\t\t"+countryName+"\t\t"+country+"\t\t"+city);
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4
                    bankNumber++;
                    /*Client tempClient = new Client(name,surName,address,phone);
                    clients.add(tempClient);
                    numeroClientes++;*/
                }

                System.out.print("\nChoose an office number: ");
                suboption=scNumber.next();



            } else if (option==2){
                System.out.println("\nExiting...");
            } else {
                System.out.println("\n¡Invalid option!");
            }

        }while (option!=2);
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

<<<<<<< HEAD
=======
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

=======
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
<<<<<<< HEAD
>>>>>>> fernando.william
=======
>>>>>>> c153372a156d1c07189eaf5d67e1ba6c18417bf4

}
