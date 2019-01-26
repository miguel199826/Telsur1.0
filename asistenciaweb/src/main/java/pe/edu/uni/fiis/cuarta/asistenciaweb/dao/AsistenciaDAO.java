package pe.edu.uni.fiis.cuarta.asistenciaweb.dao;

import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.Alumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.ListaAlumno;

public interface AsistenciaDAO {
    public Alumno agregarAsistencia(Alumno dto);
    public ListaAlumno obtenerAlumnos();
}
