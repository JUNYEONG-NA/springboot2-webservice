package org.example.springboot.dto;

import org.example.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void lombok_Test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // assertThat - assertj 라는 검증 라이브러리의 검증 메서드/
        assertThat(dto.getAmount()).isEqualTo(amount);// isEqualsTo - assertj의 동근 비교 메소드
    }
}
