package io.khasang.orgmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@ComponentScan()
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    /*  @Autowired
    //it was left here for testing. if you want the programm not rely to database authentication comment the implementation bellow (customUserDetailsService)
    //this code uses roles rest of the programm use authorities so this code need to be changed to support rest of this app
      public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
          auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
          auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
          auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
      }*/
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);

        http.authorizeRequests()
                .antMatchers("/reference/**").access("hasAuthority('USER')")
                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false)
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error=true");
    }
}
