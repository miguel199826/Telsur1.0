package pe.edu.uni.fiis.cuarta.asistenciaweb.dao;

import org.springframework.stereotype.Repository;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.Alumno;
import pe.edu.uni.fiis.cuarta.asistenciaweb.domain.ListaAlumno;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Repository
public class AsistenciaDaoImpl implements AsistenciaDAO {
    /**
     * CREATE TABLE paciente(
     nombre VARCHAR2(100),
     DNI VARCHAR2(9),
     TELEFONO VARCHAR2(13),
     CORREO VARCHAR2(100)
     );
     * @param dto
     * @return
     */
    public Alumno agregarAsistencia(Alumno dto) {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(" INSERT INTO ASISTENCIA" +
                " (CODIGO, FECHA)" +
                " VALUES (?, SYSDATE)");
        DataSource ds = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = AsistenciaDatasource.getConection();
            ps = connection.prepareStatement(sbSQL.toString());
            ps.setString(1,dto.getIdentificador());
            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
    public ListaAlumno obtenerAlumnos() {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(" SELECT CODIGO, APELLIDOS ||' ' || NOMBRES NOMBRE_COMPLETO FROM ALUMNO");
        ListaAlumno respuesta = new ListaAlumno();
        respuesta.setLista(new ArrayList<Alumno>());
        DataSource ds = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = AsistenciaDatasource.getConection();
            //Preparar sentencia SQL
            ps = connection.prepareStatement(sbSQL.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdentificador(rs.getString("CODIGO"));
                alumno.setNombre(rs.getString("NOMBRE_COMPLETO"));
                respuesta.getLista().add(alumno);
            }
            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }
}
