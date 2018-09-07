package fr.hugoescobar.library.client.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.hugoescobar.library.client.book.repository.BookRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class BookClientApplication implements CommandLineRunner {
	
	@Autowired
	BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BookClientApplication.class, args);
    }
    
	@Override
	public void run(String... arg0) throws Exception {
		// reset database at application startup
		repository.deleteAll();
	}
}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
