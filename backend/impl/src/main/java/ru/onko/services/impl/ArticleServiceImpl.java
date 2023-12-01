package ru.onko.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.ArticleCreationRequest;
import ru.onko.dto.response.ArticleCreationResponse;
import ru.onko.dto.response.ArticleResponse;
import ru.onko.model.jooq.tables.pojos.ArticleEntity;
import ru.onko.repository.jooq.ArticleRepository;
import ru.onko.services.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    @Override
    public ArticleCreationResponse create(ArticleCreationRequest request, List<MultipartFile> images) {
        ArticleEntity articleEntity = ArticleEntity.builder()
                .content(request.getContent())
                .title(request.getTitle())
                .position(request.getPosition())
                .build();
        // логика по сохр фотографий
        articleEntity.setId(articleRepository.save(articleEntity));
        return ArticleCreationResponse.builder()
                .content(articleEntity.getContent())
                .id(articleEntity.getId())
                .title(articleEntity.getTitle())
                .photosId(new ArrayList<>())
                .position(articleEntity.getPosition())
                .build();
    }

    @Override
    public void delete(UUID id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<ArticleResponse> findByWord(String word) {
        return articleRepository.findAll().stream()
                .filter(entity ->
                        word == null || word.isEmpty() || entity.getTitle().contains(word)
                                || entity.getContent().contains(word))
                .map(entity -> ArticleResponse.builder()
                        .content(entity.getContent())
                        .title(entity.getTitle())
                        .position(entity.getPosition())
                        .id(entity.getId())
                        .photos(new ArrayList<>())
                        .build())
                .toList();
    }
}
