package com.example.transactions.Services;

import com.example.transactions.Repository.AccountRepository;
import com.example.transactions.Repository.AuditLogRepository;
import com.example.transactions.Repository.CardRepository;
import com.example.transactions.Repository.TransactionRepository;
import com.example.transactions.entities.*;
import com.example.transactions.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final CardRepository cardRepository;

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AuditLogRepository auditLogRepository;

    @Autowired
    public TransactionService(CardRepository cardRepository, TransactionRepository transactionRepository, AccountRepository accountRepository, AuditLogRepository auditLogRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.auditLogRepository = auditLogRepository;
    }

    public Double feeFrequency(Template template, Double value) {
        if (template.getFeeFrequency().equals(FeeFrequency.MONTHLY.name()))
            value = value / 12;
        else if (template.getFeeFrequency().equals(FeeFrequency.QUARTERLY.name())) {
            value = value / 4;
        }
        return value;
    }

    public double CalculateFeeWithRange(Template template, double value, double groupingValue, Account account) {
        List<GivenRange> givenRanges = template.getFeeRanges();
        for (GivenRange givenRange : givenRanges) {
            int startRange = givenRange.getStartRange();
            int endRange = givenRange.getEndRange();
            int fee = givenRange.getFee();
            double currentFee = 0;

            if (givenRange.getCalculationType().equals(CalculationType.FIXED.name())) {
                currentFee = groupingValue;
                if (currentFee >= startRange && currentFee <= endRange) {
                    value = fee;
                }

            } else if (givenRange.getCalculationType().equals(CalculationType.PERCENTAGE.name())) {
                if (groupingValue >= startRange && groupingValue <= endRange) {
                    if (givenRange.getFeeVariable().equals(FeeVariable.MAD.name()))
                        currentFee = (double) fee / 100 * account.getMad();
                    else if (givenRange.getFeeVariable().equals(FeeVariable.TAD.name())) {
                        currentFee = (double) fee / 100 * account.getTad();
                    }
                    value = currentFee;
                }
            }
        }

        return value;
    }


    public void checkCharges(Template template, CardDataRequest card) {

        Transactions transactions = new Transactions();
        Account account = accountRepository.findAccountByAccountNo(2001);
        Double value = template.getFeeValue();
        double groupingValue = template.getGroupingValue();


        if (template.getCalculationType().equals(CalculationType.VARIABLE.name())) {
            if (template.getFeeVariable().equals(FeeVariable.TAD.name()))
                value = ((double) template.getGroupingPercent() / 100 * account.getTad());
            else if (template.getFeeVariable().equals(FeeVariable.MAD.name())) {
                value = ((double) template.getGroupingPercent() / 100 * account.getMad());
            }
        }

        if (template.getGroupingCalculationType().equals(GroupingCalculationType.VARIABLE.name())) {
            if (template.getGroupingVariable().equals(FeeVariable.TAD.name())) {
                groupingValue = (double) template.getGroupingPercent() / 100 * account.getTad();
            } else if (template.getGroupingVariable().equals(FeeVariable.MAD.name())) {
                groupingValue = (double) template.getGroupingPercent() / 100 * account.getMad();
            }
        }

        if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CARD_ISSUANCE.getName())) {
            value = feeFrequency(template, value);
        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.PAYMENT_DUE_DATE.getName())) {
            if (template.getCalculationType().equals(CalculationType.RANGE.name())) {
                {
                    value = CalculateFeeWithRange(template, value, groupingValue, account);
                }
            }
        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.EMI_CONVERSION.getName())) {
            value = feeFrequency(template, value);






        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CARD_ACTIVATION.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CARD_CLOSURE.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CARD_BILLING.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CASH_PAYMENT.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.OVER_LIMIT.getName())) {

            if (template.getCalculationType().equals(CalculationType.RANGE.name())) {
                {
                    value = CalculateFeeWithRange(template, value, groupingValue, account);
                }
                value = feeFrequency(template, value);
            }
        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.TRANSACTION.getName())) {

            if (template.getFeeSubEvent().equals(FeeSubEvent.WITHDRAWAL.name()) &&
                    template.getFeeSubEvent().equals(card.getFeeSubEvent())) {
                value =  (double)template.getSurcharge()/100 * value;
            } else if (template.getFeeSubEvent().equals(FeeSubEvent.FUEL.name()) &&
                    template.getFeeSubEvent().equals(card.getFeeSubEvent())) {
                value = (double)template.getSurcharge() / 100 * value;
            }
            value = feeFrequency(template, value);
        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.BALANCE_TRANSFER.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.CREDIT_LIMIT_INCREASE.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.BOUNCE_PAYMENT.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.FIRST_TRANSACTION.getName())) {
            value = feeFrequency(template, value);

        } else if (template.getFeeEvent().equals(card.getEventType()) &&
                template.getFeeEvent().equals(FeeEvent.REWARD_REDEMPTION.getName())) {
            value = feeFrequency(template, value);
        }

        if (template.getGroupingCondition().equals(GroupingCondition.MAXIMUM.name())) {
            value = Math.max(value.intValue(), groupingValue);
        } else if (template.getGroupingCondition().equals(GroupingCondition.MINIMUM.name())) {
            value = Math.min(value.intValue(), groupingValue);
        } else if (template.getGroupingCondition().equals(GroupingCondition.SUM.name())) {
            value = value + groupingValue;
        }

        if (template.isGstApplicable()) {
            int gstPercentage = template.getGstPercentage();
            int gst = (int) (value * gstPercentage / 100);
            if (template.isGstInclusive()) {
                value = value - gst;
            } else {
                value = value + gst;
            }
            transactions.setGst(gst);
        }

        AuditLog auditLog = new AuditLog();

        int balance = account.getBalance();
        int newBalance =0 ;
        if(template.isGstInclusive()) {
             newBalance = (int) (balance - value + transactions.getGst());
        }
        else
            newBalance = (int) (balance-value);
        auditLog.setAccountNo(account.getAccountNo());
        auditLog.setCardId(card.getCardId());
        auditLog.setAmountDeducted(value);
        account.setBalance(newBalance);
        auditLog.setCurrentBalance(newBalance);
        auditLog.setFeeType(template.getFeeEvent());
        if(template.isGstApplicable()) {
            auditLog.setGst(template.getGstPercentage());
        }
        auditLog.setGstInclusive(template.isGstInclusive());

        auditLogRepository.save(auditLog);

        Card card1 = cardRepository.findByCardId(card.getCardId());

        transactions.setCard(card1);
        transactions.setChargeType(template.getTemplateType());
        transactions.setFeeValue(value);

        transactionRepository.save(transactions);
    }
}

