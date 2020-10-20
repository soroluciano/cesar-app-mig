package admin.api.model;

import javax.persistence.Column;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document(collection = "user")
public class User {
	
	@Column(nullable = false, unique = true)
	private String email;
	private String password;
	
//	@Autowired
//	PasswordEncoder passEncoder;
	
	public User(String email, String password) throws InstantiationException, IllegalAccessException
	{
		
		this.email = email.trim();

		this.password = password.trim();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//	public String getPrincipal() {
//		return principal;
//	}
//	public void setPrincipal(String principal) {
//		this.principal = principal;
//	}
//	public String getCredential() {
//		return credential;
//	}
//	public void setCredential(String credential) {
//		this.credential = credential;
//	}

//	private String fullname;
//	private boolean enabled;
//	@DBRef
//	private Set<Role> roles;
//	
//	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public String getFullname() {
//		return fullname;
//	}
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//	public boolean isEnabled() {
//		return enabled;
//	}
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//	public Set<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

}
