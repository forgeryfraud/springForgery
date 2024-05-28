
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
