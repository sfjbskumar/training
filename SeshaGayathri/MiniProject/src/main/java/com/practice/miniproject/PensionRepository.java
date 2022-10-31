package com.practice.miniproject;

import com.practice.miniproject.model.PensionModel;
import org.springframework.data.repository.CrudRepository;
    public interface PensionRepository extends CrudRepository<PensionModel, Integer>
    {
        PensionModel findByName(String name);

    }


