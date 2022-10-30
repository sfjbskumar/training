package com.practice.miniproject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.CrudRepository;
import com.practice.miniproject.model.PensionModel;
import org.springframework.data.repository.query.Param;

import java.util.List;
    public interface PensionRepository extends CrudRepository<PensionModel, Integer>
    {

    }


