package com.demo.services;

import com.demo.dao.IDao;
import com.demo.dao.SalleDao;
import com.demo.entities.Machine;
import com.demo.entities.Salle;
import java.util.List;

public class SalleService implements IDao<Salle> {
    private SalleDao dao = new SalleDao();

    @Override
    public boolean create(Salle o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(Salle o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(Salle o) {
        return dao.update(o);
    }

    @Override
    public Salle getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Salle> getAll() {
        return dao.getAll();
    }

    public boolean createAvecMachines(Salle salle, List<Machine> machines) {
        return dao.createAvecMachines(salle, machines);
    }
}