package com.demo.test;

import com.demo.entities.Machine;
import com.demo.entities.Salle;
import com.demo.services.MachineService;
import com.demo.services.SalleService;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Scénario 1 : créations séparées
        Salle salleA = new Salle();
        salleA.setCode("S1");
        salleA.setLibelle("Salle d'Informatique");
        salleService.create(salleA);

        Machine machine = new Machine();
        machine.setRef("M-101");
        machine.setMarque("Dell");
        machine.setSalle(salleA);
        machineService.create(machine);

        // Scénario 2 : une seule transaction (salle + machines)
        Salle salleB = new Salle();
        salleB.setCode("S2");
        salleB.setLibelle("Salle de Réseaux");

        List<Machine> machines = new ArrayList<>();

        Machine m1 = new Machine();
        m1.setRef("M-201");
        m1.setMarque("HP");
        machines.add(m1);

        Machine m2 = new Machine();
        m2.setRef("M-202");
        m2.setMarque("Dell");
        machines.add(m2);

        try {
            salleService.createAvecMachines(salleB, machines);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Test HQL
        List<Machine> resultat = machineService.findByMarque("Dell");
        for (Machine m : resultat) {
            System.out.println(m.getRef() + " - " + m.getMarque());
        }

        System.out.println("Données insérées avec succès !");
    }
}