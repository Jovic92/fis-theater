package com.fis.theatre.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fis.theatre.utils.TokenUtils;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private TokenUtils tokenUtils;

	private UserDetailsService userDetailsService;

	public TokenAuthenticationFilter(TokenUtils tokenUtils, UserDetailsService userDetailsService) {
		this.tokenUtils = tokenUtils;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("AAAAAAAAAAAAAa");
		String authToken = tokenUtils.getToken(request);
		System.out.println(authToken);
		if (authToken != null) {
			String email = tokenUtils.getEmailFromToken(authToken);
			System.out.println(email);
			if (email != null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(email);

				if (tokenUtils.validateToken(authToken, userDetails)) {
					TokenBasedAuthentication auth = new TokenBasedAuthentication(userDetails);
					auth.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
		}

		filterChain.doFilter(request, response);
	}

}
