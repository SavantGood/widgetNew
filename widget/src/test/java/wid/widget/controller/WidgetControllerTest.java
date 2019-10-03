package wid.widget.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static sun.nio.cs.Surrogate.is;

////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(classes = {JpaTestConfig.class, WebAppContext.class})
////public class WidgetControllerTest {
////
////    private MockMvc mockMvc;
////
////    @Test
////    public void getOne() throws Exception{
////        mockMvc.perform(get("/widget/{id}"))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$.id", is(1)));
//
//    }
//}