package io.asterbit.crud.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateBookRequest(
        @NotNull(message = "isbn is required !") Long isbn,
        @NotEmpty(message = "title is required !") String title,
        @NotEmpty(message = "author is required !") String author,
        @NotNull(message = "releaseYear is required !") Integer releaseYear) {
}
