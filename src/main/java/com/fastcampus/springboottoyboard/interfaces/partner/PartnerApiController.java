package com.fastcampus.springboottoyboard.interfaces.partner;

import com.fastcampus.springboottoyboard.application.partner.PartnerFacade;
import com.fastcampus.springboottoyboard.common.response.CommonResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(@RequestBody @Valid PartnerCondition.RegisterRequest request) {
        // 1. 외부에서 전달된 파라미터 (DTO) -> Command, Criteria convert
        var command = request.toCommand();

        // 2. facade 호출 .. PartnerInfo
        var partnerInfo = partnerFacade.registerPartner(command);

        // 3. PartnerInfo -> CommonResponse convert AND return
        var response = new PartnerCondition.RegisterResponse(partnerInfo);

        return CommonResponse.success(response);
    }
}
