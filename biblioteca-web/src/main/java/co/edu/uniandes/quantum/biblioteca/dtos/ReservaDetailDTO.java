/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.quantum.biblioteca.dtos;

import co.edu.uniandes.quantum.biblioteca.entities.LibroEntity;
import co.edu.uniandes.quantum.biblioteca.entities.ReservaEntity;
import co.edu.uniandes.quantum.biblioteca.entities.VideoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author f.posada
 */
@XmlRootElement
public class ReservaDetailDTO extends ReservaDTO 
{
    private List<LibroDTO> libros;
    private List<VideoDTO> videos;

    
    
    public ReservaDetailDTO ()
    {
        super();
    }
    
    public ReservaDetailDTO(ReservaEntity entity) {
        super(entity);
        if (entity != null) {
            videos = new ArrayList<>();
            for (VideoEntity entityVideo : entity.getVideos()) {
                videos.add(new VideoDTO(entityVideo));
            }

            libros = new ArrayList<>();
            for (LibroEntity entityLibro : entity.getLibros()) {
                libros.add(new LibroDTO(entityLibro));
            }
        }
    }

    public List<LibroDTO> getLibros() {
        return libros;
    }

    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    public List<VideoDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDTO> videos) {
        this.videos = videos;
    }
    
    public ReservaEntity toEntity()
    {       
        ReservaEntity preEnt=super.toEntity();

        if (getVideos() != null) {
            List<VideoEntity> multasEntity = new ArrayList<>();
            for (VideoDTO dtoVideo : getVideos()) {
                multasEntity.add(dtoVideo.toEntity());
            }
            preEnt.setVideos(multasEntity);
        }
        
        if (getLibros() != null) {
            List<LibroEntity> multasEntity = new ArrayList<>();
            for (LibroDTO dtoLibro : getLibros()) {
                multasEntity.add(dtoLibro.toEntity());
            }
            preEnt.setLibros(multasEntity);
        }
        return preEnt;   
        
    }
    
}
