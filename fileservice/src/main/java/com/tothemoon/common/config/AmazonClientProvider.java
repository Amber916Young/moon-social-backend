package com.tothemoon.common.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sesv2.SesV2Client;

public class AmazonClientProvider {
    public AmazonS3 getAmazonS3() {
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_1)
                .build();
    }

    public SesV2Client getEmailTemplate() {
        return SesV2Client.builder()
                .region(Region.EU_WEST_1)
                .build();
    }

    public AmazonSimpleEmailService getAmazonSimpleEmailService() {
        return AmazonSimpleEmailServiceClientBuilder
                .standard()
                .withRegion(Regions.EU_WEST_1)
                .build();
    }

}
