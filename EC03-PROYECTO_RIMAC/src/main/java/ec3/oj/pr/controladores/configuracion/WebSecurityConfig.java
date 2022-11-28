package ec3.oj.pr.controladores.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure (HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers(HttpMethod.GET).permitAll()
        .antMatchers(HttpMethod.POST).permitAll()
        .antMatchers(HttpMethod.PUT).permitAll()
        .antMatchers(HttpMethod.DELETE).permitAll()
		.antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", 
				     "/inicio", "/logeo", "/login", "/rest/**").permitAll()
		             .antMatchers("/Tipo_empleado/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR", "DEPURADOR")
		             .antMatchers("/Tipo_empleado/nuevo").hasAnyRole("ADMIN","CREADOR")
		             .antMatchers("/Tipo_empleado/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		             .antMatchers("/Tipo_empleado/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		             .antMatchers("/Tipo_empleado/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		             
		             .anyRequest().authenticated()
		             .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
		             .and().logout()
		             .permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("oscar").password(encoder.encode("oscar")).roles("LECTOR").and()
		.withUser("miguel").password(encoder.encode("miguel")).roles("CREADOR").and()
		.withUser("sebastian").password(encoder.encode("sebastian")).roles("LECTOR", "DEPURADOR").and()
		.withUser("abel").password(encoder.encode("abel")).roles("LECTOR").and();
		
		
	}

}