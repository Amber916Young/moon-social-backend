package com.tothemoon.app.service;

import com.tothemoon.common.config.S3FileManager;
import com.tothemoon.common.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    private static final List<String> allowedImageContentTypes = Arrays.asList("image/jpeg", "image/png", "image/gjf");
    private final S3FileManager s3FileManager;





}