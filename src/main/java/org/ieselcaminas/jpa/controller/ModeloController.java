package org.ieselcaminas.jpa.controller;

import org.ieselcaminas.jpa.entity.Coche;
import org.ieselcaminas.jpa.entity.Modelo;
import org.ieselcaminas.jpa.repository.CocheRepository;
import org.ieselcaminas.jpa.repository.ModeloRepository;
import org.ieselcaminas.jpa.services.CocheService;
import org.ieselcaminas.jpa.services.Color;
import org.ieselcaminas.jpa.services.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private static ModeloService modeloService;
    private static CocheService cocheService;
    ModeloController(ModeloService modeloService, CocheService cocheService) {
        ModeloController.modeloService = modeloService;
        this.cocheService = cocheService;
    }

    @GetMapping
    public static List<Modelo> listar() {
        return modeloService.listarModelos();
    }

    @PostMapping
    public static void agregar(@RequestBody Modelo modelo) {
        modeloService.agregarModelo(modelo);
    }

    @DeleteMapping("/{id}")
    public static void eliminar(@PathVariable Long id) {
        modeloService.eliminarModelo(id);
    }

    @GetMapping("/{id}")
    public static Modelo buscarPorId(@PathVariable Long id) {
        return modeloService.encontrarModelo(id);
    }

    public static void menuModelo() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != -1) {
            System.out.println(Color.AMARILLO.getColor());
            System.out.println("-- MENÚ DE MODELOS --");
            System.out.print(Color.RESET.getColor());
            System.out.println("1. Agregar modelo");
            System.out.println("2. Listar modelos");
            System.out.println("3. Eliminar modelo");
            System.out.println("4. Asignar modelo");
            System.out.println("-1. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();
                agregar(new Modelo(nombre));
            } else if (opcion == 2) {
                listar().forEach(System.out::println);
            } else if (opcion == 3) {
                System.out.println("ID de modelo a eliminar: ");
                Long idCoche = scanner.nextLong();
                eliminar(idCoche);
            } else if (opcion == 4) {
                CocheController.listar().forEach(System.out::println);
                System.out.println("Seleccione ID del coche:");
                Long idCoche = scanner.nextLong();

                listar().forEach(System.out::println);
                System.out.println("Seleccione ID de modelo:");
                Long idModelo = scanner.nextLong();

                Coche coche = cocheService.encontrarCoche(idCoche);
                Modelo modelo = buscarPorId(idModelo);

                coche.setModelo(modelo);
                cocheService.agregarCoche(coche);
            }
        }
    }
}