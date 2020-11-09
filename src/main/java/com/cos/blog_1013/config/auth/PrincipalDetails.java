package com.cos.blog_1013.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.blog_1013.model.User;

import lombok.Getter;

@Getter
public class PrincipalDetails implements UserDetails,OAuth2User{

	private User user;
	private Map<String,Object> attributes;
	
	public PrincipalDetails(User user,Map<String,Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}
	public PrincipalDetails(User user) { //principalDetails에 넘어오는 user 값을 넣어주기위하여 
		this.user = user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(()->{ return "ROLE_"+user.getRole();});
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return null;
	}

}
