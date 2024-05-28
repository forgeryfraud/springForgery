
package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Asset;
import com.examly.springapp.repository.AssetRepository;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public Asset saveAsset(Asset asset) {
        return assetRepository.save(asset);
    }

    public Asset getAssetById(int id) {
        return assetRepository.findById(id).orElse(null);
    }

    public void deleteAssetById(int id) {
        assetRepository.deleteById(id);
    }
}