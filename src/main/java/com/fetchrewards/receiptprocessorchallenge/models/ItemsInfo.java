package com.fetchrewards.receiptprocessorchallenge.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemsInfo {
    @NotBlank
    @NotNull
    private String shortDescription;
    @NotBlank
    @NotNull
    private Double price;
}
