package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.services.CocheService;
import org.ieselcaminas.jpa.services.Color;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/coches")
public class CocheController {

    private static CocheService cocheService;
    CocheController(CocheService cocheService) {
        CocheController.cocheService = cocheService;
    }

    //@GetMapping
    public static List<Coche> listar() {
        return cocheService.listarCoches();
    }

    //@PostMapping
    public static void agregar(@RequestBody Coche coche) {
        cocheService.agregarCoche(coche);
    }

    @DeleteMapping("/{id}")
    public static void eliminar(@PathVariable Long id) {
        cocheService.eliminarCoche(id);
    }

    public static String hacerMatricula() {
        return cocheService.generarMatricula();
    }

    public static Coche buscarPorId(@PathVariable Long id) {
        return cocheService.encontrarCoche(id);
    }

    public static void menuCoche() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != -1) {
            System.out.println(Color.AMARILLO.getColor());
            System.out.println("-- MENÚ DE COCHES --");
            System.out.print(Color.RESET.getColor());
            System.out.println("1. Agregar coche");
            System.out.println("2. Listar coches");
            System.out.println("3. Eliminar coche");
            System.out.println("4. Asignar matrícula");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                agregar(new Coche(nombre));
            } else if (opcion == 2) {
                for (Coche coche : cocheService.listarCoches()) {
                    System.out.println(coche);
                    System.out.println("\t"+coche.getModelo());
                }
            } else if (opcion == 3) {
                System.out.println("ID de coche a eliminar: ");
                Long idCoche = scanner.nextLong();
                eliminar(idCoche);
            } else if (opcion == 4) {
                listar().forEach(System.out::println);
                System.out.println("Seleccione ID del coche: ");
                Long idCoche = scanner.nextLong();
                Coche coche = cocheService.encontrarCoche(idCoche);
                coche.setMatricula(hacerMatricula());
                cocheService.agregarCoche(coche);
                System.out.println("Matrícula aleatoria asignada");
            }
        }
    }
}