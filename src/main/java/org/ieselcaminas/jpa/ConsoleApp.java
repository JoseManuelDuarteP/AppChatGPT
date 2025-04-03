package org.ieselcaminas.jpa;


import org.ieselcaminas.jpa.controller.PropietarioController;
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
        int opcion;

        while (true) {
            System.out.println("1. Menú propietario");
            System.out.println("2. Listar propietarios");
            System.out.println("3. Eliminar propietario");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();


            if (opcion == 1) {
                PropietarioController.menuPropietario();
            } else if (opcion == 2) {

            } else if (opcion == 3) {

            } else if (opcion == -1) {
                System.out.println("Saliendo...");
                scanner.close();
                System.exit(0);
            }
        }
    }
}
