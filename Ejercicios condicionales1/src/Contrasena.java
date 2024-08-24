import java.util.Scanner;

public class Contrasena {
        public static void main(String[] args){

        try (Scanner scanner = new Scanner(System.in)){

            String contrasena = "contraseña";

        System.out.print("Introduce la contraseña: ");
        String contrasena_ingreso = scanner.nextLine();

        if(contrasena.equals(contrasena_ingreso)){
        System.out.println("Contraseña correcta");
        }else{
            System.out.println("Contraseña incorrecta");
        }
    }
}
}


