package com.that30scoder.spring.soap.api.service;


import com.that30scoder.spring.soap.api.loaneligibility.Acknowledgement;
import com.that30scoder.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request) {

        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();

        if (!(request.getAge() > 30 && request.getAge()< 60)) {
            mismatchCriteriaList.add("Loan Criteria not satisfied");
        }
        if(!(request.getYearlyIncome()>200000)){
            mismatchCriteriaList.add("Minimum income should be more than 200000");
        }
        if(!(request.getCibilScore()>650)){
            mismatchCriteriaList.add("Low Cibil Score");
        }
        if(mismatchCriteriaList.size()>0){
            acknowledgement.setIsEligible(false);
            acknowledgement.setApprovedAmount(0);
        }else{
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
        return acknowledgement;
    }
}
