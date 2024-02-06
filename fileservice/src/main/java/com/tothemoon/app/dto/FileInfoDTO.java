package com.tothemoon.app.dto;
import lombok.Data;

@Data
public class FileInfoDTO {
    private Long id;
    private String fileName;
    private String originalName;
    private String fileType;
    private long fileSize;
    private String contentType;
    private String url;
}
