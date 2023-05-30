package proyectoterraques.files;

import java.io.File;

public class prueba {
    public static void main(String[] args) {
        File file = new File("prueba.dat");
        System.out.println(file.getAbsolutePath());
    }
}
