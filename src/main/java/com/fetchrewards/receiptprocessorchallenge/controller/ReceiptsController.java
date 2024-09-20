package com.fetchrewards.receiptprocessorchallenge.controller;

import com.fetchrewards.receiptprocessorchallenge.models.PointsResponse;
import com.fetchrewards.receiptprocessorchallenge.models.ReceiptInfo;
import com.fetchrewards.receiptprocessorchallenge.models.ReceiptsPostResponse;
import com.fetchrewards.receiptprocessorchallenge.service.ReceiptsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/receipts")
public class ReceiptsController {

    @Autowired
    private ReceiptsService receiptsService;

    Logger logger = LoggerFactory.getLogger(ReceiptsController.class);

    public ReceiptsController(ReceiptsService receiptsService) {
        this.receiptsService = receiptsService;
    }

    @PostMapping("/process")
    @ResponseBody
    public ResponseEntity<ReceiptsPostResponse> addReceipt(@RequestBody @Valid ReceiptInfo receipt){
        logger.info("Processing Receipt");
        return ResponseEntity.ok(receiptsService.processReceipts(receipt));
    }

    @GetMapping("/{id}/points")
    @ResponseBody
    public ResponseEntity<PointsResponse> addReceipt(@PathVariable("id") String id){
        try {
            logger.info("Return points for the receipt");
            return ResponseEntity.ok(receiptsService.getScore(id));
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id , no receipt found");
        }
    }
}