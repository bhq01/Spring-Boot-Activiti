package sample;

import org.activiti.engine.RepositoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@ComponentScan
@ImportResource({ "activiti-context.xml" })
public class ActivitiApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplication(
				ActivitiApplication.class).run(args);

		RepositoryService repositoryService = (RepositoryService) applicationContext
				.getBean("repositoryService");
		String id = repositoryService.createDeployment()
				.addClasspathResource("SampleProcess.bpmn").deploy().getId();
		System.out.println("Process deployed: " + id);

	}
}
