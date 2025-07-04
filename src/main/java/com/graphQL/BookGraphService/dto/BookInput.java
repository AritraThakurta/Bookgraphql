package com.graphQL.BookGraphService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

    private String name;
    private String author;
    private int pages;
}
