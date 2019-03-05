package com.esliceu.rfidpass.amarillo.gestordedatos.modules;

import com.esliceu.rfidpass.amarillo.gestordedatos.models.ResponseVerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class ProtectedResourceFilter implements Filter {

    @Value("${token.verificator.url}")
    private String urlTokenVerificator;
    private final RestTemplate restTemplate;

    @Autowired
    public ProtectedResourceFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String token = httpServletRequest.getParameter("token");

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        if (token == null) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        ResponseVerificationToken response = restTemplate.postForObject(
                urlTokenVerificator,
                new HttpEntity<Object>("", headers),
                ResponseVerificationToken.class);

        if (!(response != null && response.isSuccess())) {
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
