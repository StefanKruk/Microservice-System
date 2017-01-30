package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@SpringCloudApplication
@RestController
@EnableResourceServer
public class ResourceApplication {

	@RequestMapping("/")
	public Message home(Principal principal) {
		return new Message(principal);
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	Message() {
	}

	public Message(Principal principal) {
		this.id = principal.getName();
		this.content = "Hello World";
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
