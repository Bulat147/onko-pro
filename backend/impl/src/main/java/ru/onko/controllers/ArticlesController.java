package ru.onko.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.api.ArticlesApi;
import ru.onko.dto.request.ArticleCreationRequest;
import ru.onko.dto.request.ArticleUpdatingRequest;
import ru.onko.dto.response.ArticleCreationResponse;
import ru.onko.dto.response.ArticleFavouriteResponse;
import ru.onko.dto.response.ArticleResponse;
import ru.onko.dto.response.ArticleUpdatingResponse;

import java.util.List;
import java.util.UUID;

@RestController
public class ArticlesController implements ArticlesApi {
    @Override
    public ArticleCreationResponse create(ArticleCreationRequest request, List<MultipartFile> images) {
        return null;
    }

    @Override
    public ArticleUpdatingResponse update(ArticleUpdatingRequest request, List<MultipartFile> addingImages) {
        return null;
    }

    @Override
    public void delete(UUID id) {

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
        return null;
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
