package ch.jsch.lyl.backend;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ch.jsch.lyl.backend.jpa.domain.*;
import ch.jsch.lyl.backend.jpa.repository.UserRepository;

@ComponentScan("ch.jsch.lyl.backend.*")
@SpringBootApplication
public class LylBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LylBackendApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			
			User u1 = new User("Jessy", "token23455");

			Set<LuckyBoard> luckyBoards = new LinkedHashSet<LuckyBoard>();
			LuckyBoard lb1 = new LuckyBoard("Maldives vacation", "Paradise.......", "2017-10-09");
			Set<Lucky> luckies = new LinkedHashSet<Lucky>();
			Lucky lucky1 = new Lucky("resort1", "hideaway...", "http://cdni.condenast.co.uk/639x426/a_c/ayada-maldives-conde-nast-traveller-1april14-pr_639x426.jpg");
			Lucky lucky2 = new Lucky("resort2", "hideaway2...", "http://www.alux.com/wp-content/uploads/2015/09/Best-Hotel-in-2015-According-to-TripAdvisor-is-this-Marvelous-Maldives-Resort-40.jpg");
			luckies.add(lucky1);
			luckies.add(lucky2);
			
			lb1.setLuckies(luckies);
			
			LuckyBoard lb2 = new LuckyBoard("Bali vacation", "Paradise.......", "2018-10-09");
			Set<Lucky> luckies2 = new LinkedHashSet<Lucky>();
			Lucky lucky3 = new Lucky("resort12", "hideaway12...", "https://www.bali.com/media/image/655/sunset-danu-bratan-temple.jpg");
			Lucky lucky4 = new Lucky("resort22", "hideaway22...", "https://putubalidriverdotcom.files.wordpress.com/2014/09/kintamani.jpg");
			luckies2.add(lucky3);
			luckies2.add(lucky4);
			luckies2.add(lucky1);
			
			lb2.setLuckies(luckies2);
			
			luckyBoards.add(lb1);
			luckyBoards.add(lb2);
			
			u1.setLuckyBoards(luckyBoards);
			repository.save(u1);
		};
	}
}
