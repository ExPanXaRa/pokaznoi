package ru.alliedar.pokaznoi.web.dto.task;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import ru.alliedar.pokaznoi.domain.task.Status;
import ru.alliedar.pokaznoi.web.dto.validation.OnCreate;
import ru.alliedar.pokaznoi.web.dto.validation.OnUpdate;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Title must be not null", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Length(max = 255, message = "Description length must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    private Status status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;

    @JsonProperty(access =  JsonProperty.Access.READ_ONLY) // только чтение картинок
    private List<String> images;

}
