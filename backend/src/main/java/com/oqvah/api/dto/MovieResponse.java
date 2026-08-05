package com.oqvah.api.dto;

import java.time.LocalDateTime;

public record MovieResponse(

        Long id,
        String title,
        String genre,
        Integer releaseYear,
        LocalDateTime createdAt

) {
}