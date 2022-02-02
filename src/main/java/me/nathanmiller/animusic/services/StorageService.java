package me.nathanmiller.animusic.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

// used as a service for components in application
@Service
public class StorageService {

	private final AmazonS3 space;

	// constructor
	public StorageService() {

		AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
				new BasicAWSCredentials("BRZZLDFHJLHIH6TCP5X5", "Wmw9e4LNwGOwJIMpor37067/QKzqL+ua3jMamkZb7UA"));

		AmazonS3ClientBuilder.standard();
		space = AmazonS3ClientBuilder
				.standard()
				.withCredentials(awsCredentialsProvider)
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration("nyc3.digitaloceanspaces.com", "nyc3"))
				.build();
	}
	// list of strings for song file names
	// call below method through the main class
	public List<String> getSongFileNames() {

		ListObjectsV2Result result = space.listObjectsV2("animusic");
		List<S3ObjectSummary> objects = result.getObjectSummaries();
		// streaming through each s3Object summaries
		// changing each of these into keys
		// represents the filename of the objects and
		// creates a new list and returns it
		return objects.stream()
				.map(S3ObjectSummary::getKey).collect(Collectors.toList());

	}
	
	public void uploadSong(MultipartFile file) throws IOException {
		
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentType(file.getContentType());
			space.putObject(new PutObjectRequest("AniMusicApplication", file.getOriginalFilename(), file.getInputStream(), objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
		
	}

}
