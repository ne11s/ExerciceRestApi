package org.example.exercicerestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercicerestapi.dto.TodoResponseDto;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private boolean isValidate;
    private LocalDate date;

    public TodoResponseDto entityToDto (){
        return TodoResponseDto.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .isValidate(isValidate())
                .date(getDate())
                .build();
    }
}
