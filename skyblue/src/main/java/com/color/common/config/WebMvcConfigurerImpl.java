package com.color.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.color.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor()) // 인터셉터 연결
//				.order(1) 인터셉트의 호출 순서를 지정. 낮을 수록 먼저 호출
				.addPathPatterns("/*/*/*/*Xdm*") // 인터셉터를 적용할 패턴 지정
				.excludePathPatterns( // 인터셉터에서 제외할 패턴 지정(예외 처리)
						"/resources/**",
						"/xdm/**", // resources 하위 폴더
						"/v1/infra/customer/customerLogIn", // 로그인 페이지 제외 
						"/v1/infra/customer/customerSignUp",
						"/v1/infra/customer/customerLoginProc" // 로그인 처리 페이지 제외
		);
	}
}
