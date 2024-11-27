package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBody{
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int userStatus;
}
