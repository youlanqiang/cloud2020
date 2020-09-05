package top.youlanqiang.springcloud.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import top.youlanqiang.springcloud.entities.Payment;


/**
 * 单元测试需要的注解
 */
@SpringBootTest
@AutoConfigureMockMvc
@Rollback
@Transactional
public class TestPaymentController {


    @Test
    public void testCreate(@Autowired MockMvc mockMvc) throws Exception {
        Payment payment = new Payment();
        payment.setSerial("200");
        mockMvc.perform(MockMvcRequestBuilders
                .post("/payment/create")//测试接口
                .contentType(MediaType.APPLICATION_JSON)//content的类型
                .content(new ObjectMapper().writeValueAsString(payment))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())//期望值
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(200));

    }


}
