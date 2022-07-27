package org.example.springboot;

import org.example.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 테스트를 진행 할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
// @WebMvcTest(controllers = HelloController.class) // Web에 집중할 수 있는 어노테이션. @Controller, @ControllerAdvice 사용가능
@WebMvcTest
public class HelloControllerTest {

    @Autowired // 스프링을 관리하는 Bean을 주입
    private MockMvc mvc; // 웹 API를 테스트 할 떄 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 기능 요청
                    .andExpect(status().isOk()) // mvc.perform의 결과를 검증 , HTTP Header의 Status를 검증
                        .andExpect(content().string(hello)); // 응답 본문의 내용을 검증
    }

    @Test
    public void helloDto_return() throws Exception{
        String name ="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto").param("name", name).param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메서드
                    .andExpect(jsonPath("$.amount", is(amount)));
    }
}
