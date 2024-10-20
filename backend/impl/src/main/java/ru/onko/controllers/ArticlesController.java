package ru.onko.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.api.ArticlesApi;
import ru.onko.dto.request.ArticleCreationRequest;
import ru.onko.dto.request.ArticleUpdatingRequest;
import ru.onko.dto.response.ArticleCreationResponse;
import ru.onko.dto.response.ArticleFavouriteResponse;
import ru.onko.dto.response.ArticleResponse;
import ru.onko.dto.response.ArticleUpdatingResponse;
import ru.onko.services.ArticleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ArticlesController implements ArticlesApi {

    private final ArticleService articleService;
    @Override
    public ArticleCreationResponse create(ArticleCreationRequest request, List<MultipartFile> images) {
        return articleService.create(request, images);
    }

    @Override
    public ArticleUpdatingResponse update(ArticleUpdatingRequest request, List<MultipartFile> addingImages) {
        return null;
    }

    @Override
    public void delete(UUID id) {
        articleService.delete(id);
    }

    @Override
    public ArticleFavouriteResponse addArticleToFavourite(UUID articleId) {
        return null;
    }

    @Override
    public void removeArticleFromFavourite(UUID articleId) {

    }

    @Override
    public List<ArticleResponse> findByWord(String word) {
        return articleService.findByWord(word);
    }

    @Override
    public List<ArticleResponse> findByPosition(String position) {
        return null;
    }

    @Override
    public List<ArticleResponse> findAll() {
        return null;
    }

    @Override
    public List<ArticleResponse> findFavourites() {
        return null;
    }
}
