package telran.java2022.accounting.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RolesResponseDto {
	String login;
	@Singular
	Set<String> roles;
}
