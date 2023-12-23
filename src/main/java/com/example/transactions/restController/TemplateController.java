package com.example.transactions.restController;

import com.example.transactions.Services.TemplateService;
import com.example.transactions.entities.Template;
import com.example.transactions.entities.TemplateDataRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/input")
    public ResponseEntity<String> saveTransaction(@RequestBody TemplateDataRequest templateDataRequest) {

        Template template =new Template();

        template.setTemplateName(templateDataRequest.getTemplateName());
        template.setFeeEvent(templateDataRequest.getFeeEvent());
        template.setFeeVariable(templateDataRequest.getFeeVariable());
        template.setFeeFrequency(templateDataRequest.getFeeFrequency());
        template.setFeeSubEvent(templateDataRequest.getFeeSubEvent());
        template.setTemplateType(templateDataRequest.getTemplateType());
        template.setCalculationType(templateDataRequest.getCalculationType());
        template.setGroupingPercent(templateDataRequest.getGroupingPercent());
        template.setFeeValue(templateDataRequest.getFeeValue());
        template.setFeeRanges(templateDataRequest.getFeeRanges());
        template.setGroupingCondition(templateDataRequest.getGroupingCondition());
        template.setGroupingValue(templateDataRequest.getGroupingValue());
        template.setGroupingVariable(templateDataRequest.getGroupingVariable());
        template.setGroupingCalculationType(templateDataRequest.getGroupingCalculationType());
        template.setGstApplicable(templateDataRequest.isGstApplicable());
        template.setGstPercentage(templateDataRequest.getGstPercentage());
        template.setGstInclusive(templateDataRequest.isGstInclusive());
        template.setSurcharge(templateDataRequest.getSurcharge());

        templateService.saveTemplate(template);

        return new ResponseEntity<>("Template Saved with name ="
                +template.getTemplateName()+" and the id is "+template.getId(),HttpStatus.CREATED);
    }
}
