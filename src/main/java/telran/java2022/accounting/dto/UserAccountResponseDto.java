package telran.java2022.accounting.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserAccountResponseDto {
	String login;
	String firstName;
	String lastName;
	@Singular
	Set<String> roles;
}
