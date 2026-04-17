import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.learn.WebAppConfig;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class SpringWebInit implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(WebAppConfig.class);
	}

}
