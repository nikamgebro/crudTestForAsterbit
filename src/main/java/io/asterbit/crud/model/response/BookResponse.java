package io.asterbit.crud.model.response;

public record BookResponse(Long id,
        Long isbn,
        String title,
        String author,
        Integer releaseYear) {
}
