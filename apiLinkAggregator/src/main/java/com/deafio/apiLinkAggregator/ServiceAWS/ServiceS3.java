package com.deafio.apiLinkAggregator.ServiceAWS;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.Value;
import org.springframework.boot.autoconfigure.ssl.SslProperties;

public class ServiceS3 {

    private final AmazonS3 s3Client;

    public ServiceS3(String accessKeyId,
                      String secretKey,
                      String region){
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }

    public void uploadFile(String bucketName, String key, SslProperties.Bundles.Watch.File file) {
        s3Client.putObject(new PutObjectRequest(bucketName, key, String.valueOf(file)));
    }
}
