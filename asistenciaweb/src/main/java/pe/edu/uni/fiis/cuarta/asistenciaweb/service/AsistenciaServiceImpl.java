package pe.edu.uni.fiis.cuarta.asistenciaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uni.fiis.cuarta.asistenciaweb.dao.AsistenciaDAO;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.ListaAlumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.Alumno;

@Service
@Transactional
public class AsistenciaServiceImpl implements AsistenciaService {
    @Autowired
    //@Qualifier(value = "citaDaoImpl1")
    private AsistenciaDAO asistenciaDAO;
    public Alumno agregarAsistencia(Alumno dto) {
        return asistenciaDAO.agregarAsistencia(dto);
    }


    public ListaAlumno obtenerAlumnos() {
        return asistenciaDAO.obtenerAlumnos();
    }

    public AsistenciaDAO getAsistenciaDAO() {
        return asistenciaDAO;
    }

    public void setAsistenciaDAO(AsistenciaDAO asistenciaDAO) {
        this.asistenciaDAO = asistenciaDAO;
    }
}
