package pe.edu.uni.fiis.cuarta.asistenciaweb.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AsistenciaWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext  annotationContext = new AnnotationConfigWebApplicationContext();
		annotationContext.register(AsistenciaWebConfiguration.class);
		annotationContext.setServletContext(context);
		ServletRegistration.Dynamic registro =
				context.addServlet("dispatcher",
						new DispatcherServlet(annotationContext));
		registro.setLoadOnStartup(1);
		registro.addMapping("/servicios/*");
		
	}

}
