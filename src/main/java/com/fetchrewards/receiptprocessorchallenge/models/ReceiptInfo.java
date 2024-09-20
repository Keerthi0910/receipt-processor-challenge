package com.fetchrewards.receiptprocessorchallenge.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ReceiptInfo {

    @NotBlank
    @NotNull
    private String retailer;

    @NotBlank
    @NotNull
    private String purchaseDate;
    @NotBlank
    @NotNull
    private String purchaseTime;
    private Double total;
    private List<ItemsInfo> items;


}
