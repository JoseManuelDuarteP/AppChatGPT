package org.ieselcaminas.jpa;


import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private PropietarioService propietarioService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Agregar propietario");
            System.out.println("2. Listar propietarios");
            System.out.println("3. Eliminar propietario");
            System.out.println("-1. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    propietarioService.agregarPropietario(new Propietario(nombre));
                    break;
                case 2:
                    propietarioService.listarPropietarios().forEach(p ->
                            System.out.println("ID: " + p.getId() + " - Nombre: " + p.getNombre())
                    );
                    break;
                case 3:
                    System.out.println("ID de usuario a eliminar: ");
                    Long idUsuario = scanner.nextLong();
                    propietarioService.eliminarPropietario(idUsuario);
                    break;
                case -1:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
