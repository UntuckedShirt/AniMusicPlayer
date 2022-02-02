package me.nathanmiller.animusic.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.nathanmiller.animusic.model.Song;


// provide model and data type of id
public interface AniSongRepository extends MongoRepository<Song, String> {
	
// we need to see if song is existing by title by scanning the collection
	// generate method to see if song exists
//	boolean existsSongByTitle(String title);
	
	
	
}
