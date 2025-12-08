package com.example.jenkins.controller;


import com.example.jenkins.dto.CalculatorDTO;
import com.example.jenkins.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping("/health")
    public String healthCheck() {
        return "I's alive";
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plus(CalculatorDTO calculatroDTO) {
        log.info("핸들러 실행 여부 및 값 확인 : {}", calculatroDTO);

        // service 단게까지
        // test도 만들고
        // build 까지
        int result = calculatorService.plusTwoNumbers(calculatroDTO);
        calculatroDTO.setSum(result);

        return ResponseEntity.ok(calculatroDTO);

    }
}
