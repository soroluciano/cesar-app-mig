package admin.api.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConciliacionDto {

	@NotNull private String respuesta;
	@NotNull private Integer id;
	
	
	

}

