package org.sang.backendecommerce.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sang.backendecommerce.model.UserRole;

@Data
@AllArgsConstructor
public class SigninResponseDTO {

	private final String token;
	private final UserRole role;
}
