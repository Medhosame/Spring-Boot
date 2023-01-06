package ressource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Film;

@RestController
@RequestMapping(path="/movies")
public class FilmRessouce {
	

	@GetMapping(path="/{movieId}")
	public  Film getFilmInfo(@PathVariable("movieId") String movieId) {
		return new Film("1","casanegra","Casanegra est un film marocain de Nour-Eddine Lakhmari, sorti en 2008. Ce long métrage, « noir et dramatique », a été officiellement choisi pour représenter le Maroc pour l'Oscar du meilleur film international lors de la 82ᵉ cérémonie des Oscars.");
		
	}
	
	@GetMapping(path="/kk")
	public  String aa (){
		return "Hello";
		
	}
}
