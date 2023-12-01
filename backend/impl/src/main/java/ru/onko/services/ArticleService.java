package ru.onko.services;

import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.ArticleCreationRequest;
import ru.onko.dto.response.ArticleCreationResponse;
import ru.onko.dto.response.ArticleResponse;

import java.util.List;
import java.util.UUID;

public interface ArticleService {

    ArticleCreationResponse create(ArticleCreationRequest request, List<MultipartFile> images);
    void delete(UUID id);

    List<ArticleResponse> findByWord(String word);
}
