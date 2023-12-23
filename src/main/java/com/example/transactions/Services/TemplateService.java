package com.example.transactions.Services;

import com.example.transactions.Repository.TransactionRepository;
import com.example.transactions.Repository.TemplateRepository;
import com.example.transactions.entities.GivenRange;
import com.example.transactions.entities.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    private final TemplateRepository templateRepository;


    @Autowired
    public TemplateService(TemplateRepository templateRepository, TransactionRepository transactionRepository) {
        this.templateRepository = templateRepository;
    }


    public void saveTemplate(Template template) {

        List<GivenRange> givenRanges = template.getFeeRanges();

        if (givenRanges != null) {
            for (GivenRange givenRange : givenRanges) {
                givenRange.setTemplate(template);
            }
        }

        templateRepository.save(template);
    }
}

