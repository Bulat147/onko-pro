package ru.onko.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.onko.dto.request.ArticleCreationRequest;
import ru.onko.dto.request.ArticleUpdatingRequest;
import ru.onko.dto.response.ArticleCreationResponse;
import ru.onko.dto.response.ArticleFavouriteResponse;
import ru.onko.dto.response.ArticleResponse;
import ru.onko.dto.response.ArticleUpdatingResponse;

import java.util.List;
import java.util.UUID;

@RequestMapping("/article")
public interface ArticlesApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ArticleCreationResponse create(@RequestBody ArticleCreationRequest request,
                                   @RequestParam(required = false) List<MultipartFile> images);
    @PatchMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    ArticleUpdatingResponse update(@RequestBody ArticleUpdatingRequest request,
                                   @RequestParam(required = false) List<MultipartFile> addingImages);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable UUID id);
    @PostMapping("/favourite/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    ArticleFavouriteResponse addArticleToFavourite(@PathVariable UUID articleId);
    @DeleteMapping("/favourite/{articleId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void removeArticleFromFavourite(@PathVariable UUID articleId);
    @GetMapping("/search/{word}")
    @ResponseStatus(HttpStatus.OK)
    List<ArticleResponse> findByWord(@PathVariable String word);
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    List<ArticleResponse> findByPosition(@RequestParam String position);
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<ArticleResponse> findAll();
    @GetMapping("/favourite")
    @ResponseStatus(HttpStatus.OK)
    List<ArticleResponse> findFavourites();
}
