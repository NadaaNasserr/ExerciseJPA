package com.example.exercisejpa.Controller;


import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/merchantStock")
public class MerchantStockController {


    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getAllMerchantStock(){

        return ResponseEntity.status(HttpStatus.OK).body(merchantStockService.getAllMerchantStock());
    }


    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("Merchant Stock added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer id , @RequestBody @Valid  MerchantStock merchantStock , Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = merchantStockService.updateMerchantStock(id, merchantStock);
        if (isUpdated) {
            return ResponseEntity.status(200).body("Merchant Stock updated");
        }
        return ResponseEntity.status(400).body("Invalid id");

    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id) {
        Boolean isDeletes = merchantStockService.deleteMerchantStock(id);
        if(isDeletes){
            return ResponseEntity.status(200).body("Merchant Stock deleted");
        }
        return ResponseEntity.status(400).body("Invalid id");
    }
}








