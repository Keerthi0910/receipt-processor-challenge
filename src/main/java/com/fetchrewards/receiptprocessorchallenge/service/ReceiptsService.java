package com.fetchrewards.receiptprocessorchallenge.service;

import com.fetchrewards.receiptprocessorchallenge.models.PointsResponse;
import com.fetchrewards.receiptprocessorchallenge.models.ReceiptInfo;
import com.fetchrewards.receiptprocessorchallenge.models.ReceiptsPostResponse;


public interface ReceiptsService {

     ReceiptsPostResponse processReceipts (ReceiptInfo receipt);

     PointsResponse getScore(String id);
}
