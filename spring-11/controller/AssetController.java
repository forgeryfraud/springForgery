
package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Asset;
import com.examly.springapp.service.AssetService;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        Asset createdAsset = assetService.saveAsset(asset);
        return new ResponseEntity<>(createdAsset, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable int id) {
        Asset asset = assetService.getAssetById(id);
        if (asset == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asset, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asset> updateAsset(@PathVariable int id, @RequestBody Asset asset) {
        Asset existingAsset = assetService.getAssetById(id);
        if (existingAsset == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update fields
        existingAsset.setName(asset.getName());
        existingAsset.setDescription(asset.getDescription());
        existingAsset.setValue(asset.getValue());

        Asset updatedAsset = assetService.saveAsset(existingAsset);
        return new ResponseEntity<>(updatedAsset, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable int id) {
        Asset asset = assetService.getAssetById(id);
        if (asset == null) {
            return new ResponseEntity<>("Asset not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        assetService.deleteAssetById(id);
        return new ResponseEntity<>("Asset deleted successfully", HttpStatus.OK);
    }
}