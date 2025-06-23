package org.example.exercicerestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TodoResponseDto {
    private long id;
    private String title;
    private String description;
    private boolean isValidate;
    private LocalDate date;
}
