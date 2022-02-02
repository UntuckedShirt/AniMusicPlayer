package me.nathanmiller.animusic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
//use @Document to mark it as a document
// will be storing files from storage
@Data
// helps populate song model at runtime with lombok
public class Song {
	//@id for a unique identifier for song model
		@Id
		private String id;
	//every song needs filename, helps with song data on spring backend
		private String fileName;
	// every song needs title, artist,favorited
		private String title;
		private String artist;
		private boolean isFavorited;
}
