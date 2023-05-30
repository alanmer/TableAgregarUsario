package com.bolsadeideas.spring.boot.app.dao;

import com.bolsadeideas.spring.boot.app.models.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteDaoLmpl implements IClienteDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    //@Transactional(readOnly = true)
    @Override
    public List<Cliente> findAll() {

        return em.createQuery("from Cliente").getResultList();

    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        em.persist(cliente);
    }
}
