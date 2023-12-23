package com.example.transactions.restController;


import com.example.transactions.Repository.*;
import com.example.transactions.Services.TransactionService;
import com.example.transactions.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    private final CardRepository cardRepository;
    private final TemplateRepository templateRepository;
    private final AccountRepository accountRepository;

    private final CardProgramRepository cardProgramRepository;
    private final TemplateCardProgramRepository templateCardProgramRepository;
    private final TransactionService transactionService;

    public CardController(CardRepository cardRepository, TemplateRepository templateRepository,
                          AccountRepository accountRepository, CardProgramRepository cardProgramRepository, TemplateCardProgramRepository templateCardProgramRepository, TransactionService transactionService) {
        this.cardRepository = cardRepository;
        this.templateRepository = templateRepository;
        this.accountRepository = accountRepository;
        this.cardProgramRepository = cardProgramRepository;
        this.templateCardProgramRepository = templateCardProgramRepository;
        this.transactionService = transactionService;
    }

    @PostMapping("/cardInput")
    public ResponseEntity<String> cardInput(@RequestBody CardDataRequest cardDataRequest) {

        Template template = new Template();

        if(cardRepository.findByCardId(cardDataRequest.getCardId())==null) {
            Card card = new Card();
            card.setCardId(cardDataRequest.getCardId());
            card.setProgramName(cardDataRequest.getProgramName());
            card.setCardProgram(cardProgramRepository.findByProgramName(card.getProgramName()));
            card.setAccount(accountRepository.findAccountByAccountNo(2001));
            cardRepository.save(card);
        }



        CardProgram cardProgram = cardProgramRepository.findByProgramName(cardDataRequest.getProgramName());


        for(MappingData mappingData : templateCardProgramRepository.findAllByCardProgramId(cardProgram.getId())){
            long templateID = mappingData.getTemplateId();
           if (templateRepository.findTemplateById(templateID).getFeeEvent().equals(cardDataRequest.getEventType())){
                       template = templateRepository.findTemplateById(templateID);
                       break;
           }
        }
        transactionService.checkCharges(template, cardDataRequest);
        return new ResponseEntity<>("Card is Saved with id ="
                +cardDataRequest.getCardId()+" and the type of card is "
                +cardDataRequest.getProgramName(), HttpStatus.CREATED);

    }
    @PostMapping("/mapping")
    public ResponseEntity<String> mappingCardProgramAndTemplate(@RequestBody MappingDataRequest mappingDataRequest){



        List<Long> templateIds = mappingDataRequest.getTemplateId();

        for(long templateId : templateIds){
            MappingData mappingData =new MappingData();
            mappingData.setCardProgramId(mappingDataRequest.getCardProgramId());
            mappingData.setTemplateId(templateId);
            templateCardProgramRepository.save(mappingData);
        }




        return new ResponseEntity<>("Mapping has been saved",HttpStatus.CREATED);


    }
}
