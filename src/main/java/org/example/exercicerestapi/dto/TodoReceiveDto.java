package org.example.exercicerestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercicerestapi.entity.Todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoReceiveDto {

    private long id;
    private String title;
    private String description;
    private boolean isValidate;
    private String date;

    public Todo dtoToEntity() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return Todo.builder()
                .title(getTitle())
                .description(getDescription())
                .date(LocalDate.parse(getDate(), formatter))
                .isValidate(isValidate())
                .build();
    }

}
