import java.util.Scanner;

public class Alumnos{
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)){

            System.out.println("Ingrese su nombre: ");
            String nombre = scanner.nextLine();
            char letraNombre = nombre.charAt(0);

            System.out.println("Ingrese su sexo como F si es femenino o como M si es masculino : ");
            char sexo = scanner.next().charAt(0);
            
            String grupo;

            if (sexo == 'F'){
                if (letraNombre < 'M'){
                    grupo = "Grupo A";
                }else{
                    grupo = "Grupo B";
                }
            }else if (sexo == 'M'){
                if (letraNombre > 'N'){
                    grupo = "Grupo A";
                }else{
                    grupo = "Grupo B";
                }
            } else {
            grupo = "Sexo invalido";
            }
            System.out.println("Perteneces al grupo: " +grupo);
                }

            }
}




