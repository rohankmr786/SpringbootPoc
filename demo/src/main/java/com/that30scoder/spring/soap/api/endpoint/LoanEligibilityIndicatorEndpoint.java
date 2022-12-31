package com.that30scoder.spring.soap.api.endpoint;


import javax.xml.ws.WebEndpoint;

import com.that30scoder.spring.soap.api.loaneligibility.Acknowledgement;
import com.that30scoder.spring.soap.api.loaneligibility.CustomerRequest;
import com.that30scoder.spring.soap.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAMESPACE = "http://www.that30sCoder.com/spring/soap/api/loanEligibility";
    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE,localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus (@RequestPayload CustomerRequest request){
        return service.checkLoanEligibility(request);
    }

}
