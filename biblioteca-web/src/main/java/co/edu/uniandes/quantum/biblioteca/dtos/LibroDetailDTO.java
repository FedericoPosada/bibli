/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.quantum.biblioteca.dtos;

import co.edu.uniandes.quantum.biblioteca.entities.LibroEntity;

/**
 *
 * @author jp.sanmiguel
 */
public class LibroDetailDTO extends LibroDTO {
    public LibroDetailDTO()
    {
        super();
    }

    public LibroDetailDTO(LibroEntity entity) {
        super(entity);
    }

    @Override
    public LibroEntity toEntity() {
        return super.toEntity();
    }
}
