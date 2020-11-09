package com.cos.blog_1013.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog_1013.config.auth.PrincipalDetails;
import com.cos.blog_1013.model.User;
import com.cos.blog_1013.repository.UserRepository;

@Service
public class PrincipalOauth2Service extends DefaultOAuth2UserService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("userReqeuset : " + userRequest.getAccessToken());
		System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
		System.out.println("loadUser : " + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		String provider = userRequest.getClientRegistration().getClientName();
		String providerId = oAuth2User.getAttribute("sub");
		String username = provider +"_"+providerId;
		String password = bCryptPasswordEncoder.encode("kimschool");
		String email = oAuth2User.getAttribute("email");
		String role = "ROLE_USER";
		User userEntity = (User) userRepository.findByUsername(username);
		if(userEntity == null) {
			userEntity = User.builder()
					.username(username)
					.password(password)
					.email(email)
					.provider(provider)
					.providerId(providerId)
					.build();
			userRepository.save(userEntity);
		}
		return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
	}
}
