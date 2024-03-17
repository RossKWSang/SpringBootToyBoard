package com.fastcampus.springboottoyboard.interfaces.partner;

import com.fastcampus.springboottoyboard.application.partner.PartnerFacade;
import com.fastcampus.springboottoyboard.common.response.CommonResponse;

import com.fastcampus.springboottoyboard.domain.partner.info.PartnerCacheInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping("/partners")
    public CommonResponse<List<PartnerCacheInfo>> getAllPartners() {
        return CommonResponse.success(partnerFacade.getAllRegisteredPartners());
    }
}
