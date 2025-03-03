package com.rafaelmissio.bookstoremagener.author.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private long id;

    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;

    @Max(120)
    private Integer age;
}
