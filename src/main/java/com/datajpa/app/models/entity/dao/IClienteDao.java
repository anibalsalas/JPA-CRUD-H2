package com.datajpa.app.models.entity.dao;

import com.datajpa.app.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
public interface IClienteDao extends CrudRepository<Cliente, Long > { //se convierte la interface en nuestro CrudRepository agregando extends CrudRepository

}
