package com.example.Muebleria.Conf;

import com.example.Muebleria.Servicio.JwtUtilService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    
    @Autowired
    private JwtUtilService jwtUtilService;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
            throws ServletException, IOException {
        
        final String authorizationHeader = request.getHeader("Authorization");
        
        System.out.println("═══════════════════════════════════════════");
        System.out.println("🔐 JWT FILTER - Procesando petición");
        System.out.println("📍 URI: " + request.getRequestURI());
        System.out.println("📍 Método: " + request.getMethod());
        System.out.println("📦 Authorization Header: " + (authorizationHeader != null ? "PRESENTE" : "AUSENTE"));
        
        String username = null;
        String jwt = null;
        
        try {
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                username = jwtUtilService.extractUsername(jwt);
                
                System.out.println("✅ Token extraído correctamente");
                System.out.println("👤 Username: " + username);
                System.out.println("🔑 Token (primeros 30 chars): " + jwt.substring(0, Math.min(30, jwt.length())) + "...");
            } else {
                System.out.println("⚠️ No se encontró Bearer token en el header");
            }
            
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                
                if (jwtUtilService.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken  authenticationToken = 
                        new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                        );
                    
                    authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    
                    System.out.println("✅ Usuario autenticado correctamente: " + username);
                    System.out.println("👥 Roles: " + userDetails.getAuthorities());
                } else {
                    System.out.println("❌ Token inválido para usuario: " + username);
                }
            }
            
            System.out.println("═══════════════════════════════════════════");
            
        } catch (ExpiredJwtException e) {
            System.err.println("❌ JWT Token ha expirado: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(
                "{\"error\":\"Token expirado\",\"message\":\"Tu sesión ha expirado. Por favor, inicia sesión nuevamente.\"}"
            );
            return; 
        } catch (Exception e) {
            System.err.println("❌ Error al procesar JWT: " + e.getMessage());
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(
                "{\"error\":\"Token inválido\",\"message\":\"Token de autenticación inválido.\"}"
            );
            return;
        }
        
        filterChain.doFilter(request, response);
    }
}