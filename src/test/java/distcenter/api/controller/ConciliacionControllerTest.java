package distcenter.api.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import admin.api.controller.AdminController;
import admin.api.model.dto.CustomerPostDto;
import admin.api.services.ConciliacionServiceRest;



@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
@ActiveProfiles(profiles = "test")
//@WithMockUser
@ContextConfiguration("application-context-test.xml")
public class ConciliacionControllerTest  {

  @Value("${rest.base-path}")
  private String basePath;
  protected MockMvc mockMvc;

  @MockBean private ConciliacionServiceRest conciliacionServiceRest;

  private CustomerPostDto conciliacionPostDto;

  @BeforeEach
  public void setUp() {
//	 
//		this.conciliacionPostDto = CustomerPostDto.builder()
//				.cuenta(1)
//				.ente(1)
//				.fecha(LocalDate.of(2019, 06, 03))
//				.monto(10)
//				.user("jose perez").build();
			  
  }

  @Test
  public void checkConciliacion() throws Exception {
  //  given(conciliacionServiceRest.check(conciliacionPostDto)).willReturn("OK");

//    
//    given(epecService.add(any())).willReturn(this.obligacionEpec);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(
        new SimpleModule()
            .addSerializer(new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE)));
//
//    String obligacionEpecJson = objectMapper.writeValueAsString(this.obligacionEpec);
    String conciliacionPostDto = objectMapper.writeValueAsString(this.conciliacionPostDto);

    mockMvc
        .perform(
            post(this.basePath)
                .with(csrf()) // Esto es clave para que funcionen los request POST, PUT, PATCH
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
                .content(conciliacionPostDto)
                .characterEncoding("utf-8"));
        //.andExpect("OK")
      //  .andExpect("OK");
  //  mockMvc.perform(get(this.basePath + "/CC-123456789123")).andExpect(status().isOk());
  }

}
