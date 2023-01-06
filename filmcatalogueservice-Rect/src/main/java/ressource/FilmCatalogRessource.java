package ressource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import model.CatalogItem;
import model.Movie;
import model.UserRating;

@RestController
@RequestMapping("/catalog")
public class FilmCatalogRessource {
			// get all rated movie IDs
		
			//for each movie ID, call  movie info service and get details
			
			//Put them all together
		
	    @Autowired
	    // faire appelle 
	    private RestTemplate restTemplate;

	    @Autowired
	    WebClient.Builder webClientBuilder;

	    @RequestMapping("/{userId}")
	    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

	        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);

	        return userRating.getRatings().stream()
	                .map(rating -> {
	                    Movie movie = restTemplate.getForObject("http://localhost:8081/movies/" + rating.getMovieId(), Movie.class);
	                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	                    //pour chaque ranting je remplace rating avec catalogItem=>puis je le transforme en liste
	                })
	                .collect(Collectors.toList());

	    }

}
