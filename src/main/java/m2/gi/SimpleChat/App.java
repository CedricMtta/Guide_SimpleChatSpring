package m2.gi.SimpleChat;

import static java.lang.System.exit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import m2.gi.SimpleChat.model.Message;
import m2.gi.SimpleChat.repository.MessageRepository;
import m2.gi.SimpleChat.service.HelloWorldService;
/**
 * SimpleChat with SpringBoot.
 *
 */
	
@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	HelloWorldService hw;
	
	@Autowired
	MessageRepository msgRep;
	
	public static void main(String[] args) throws Exception {
		// disabled banner, don't want to see the spring logo
		SpringApplication app = new SpringApplication(App.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(hw.getMessage());
		
		saveMessage("Hello I wanna be persisted !");
		
		exit(0);
	}
	
	private void printSavedMessages()
	{
		List<Message> msgs = msgRep.findAll();
		for (Message message : msgs) {
			System.out.println(message);
		}
	}
	private void saveMessage(String msg)
	{
		System.out.println("Persisted messages before save : ");
		this.printSavedMessages();
		
		Message msgPersisted = msgRep.save(new Message(msg));
		System.out.println(msgPersisted + " has been persisted");
		
		System.out.println("Persisted messages after save : ");
		this.printSavedMessages();
	}
}