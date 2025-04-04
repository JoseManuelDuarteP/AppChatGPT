package org.ieselcaminas.jpa;


import org.ieselcaminas.jpa.controller.CocheController;
import org.ieselcaminas.jpa.controller.ModeloController;
import org.ieselcaminas.jpa.controller.PropietarioController;
import org.ieselcaminas.jpa.entity.Propietario;
import org.ieselcaminas.jpa.services.Color;
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
            System.out.println(Color.AMARILLO.getColor());
            System.out.println("-- GESTOR DE COCHES --");
            System.out.print(Color.RESET.getColor());
            System.out.println("1. Menú propietario");
            System.out.println("2. Menú coches");
            System.out.println("3. Menú modelo");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();


            if (opcion == 1) {
                PropietarioController.menuPropietario();
            } else if (opcion == 2) {
                CocheController.menuCoche();
            } else if (opcion == 3) {
                ModeloController.menuModelo();
            } else if (opcion == -1) {
                System.out.println("Saliendo...");
                scanner.close();
                System.exit(0);
            }
        }
    }
}
