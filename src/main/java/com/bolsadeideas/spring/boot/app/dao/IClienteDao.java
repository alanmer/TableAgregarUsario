package com.bolsadeideas.spring.boot.app.dao;

import com.bolsadeideas.spring.boot.app.models.entity.Cliente;

import java.util.List;

public interface IClienteDao {
    public List<Cliente>findAll();

    public void save(Cliente cliente);
}
