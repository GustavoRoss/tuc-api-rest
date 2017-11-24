//package br.com.fabricadeprogramador.security;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.filter.GenericFilterBean;
//
//import io.jsonwebtoken.Jwts;
//
//public class TokenFilter extends GenericFilterBean  {
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//			HttpServletRequest req = (HttpServletRequest) request;
//
//			String token = req.getHeader("Authorization");
//
//			if (token==null || token.isEmpty() ){
//				throw new ServletException("Token inexiste ou inválido");
//			}
//
//
//			//verificar se o token é valido
//			try{
//				Jws.parser().setSigningKey("tuc-app").parseClaimsJws(token).getBody();
//				chain.doFilter(request, response);
//			}catch(Exception e){
//				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Inválido!");
//				//throw new ServletException("Token Inválido");
//			}
//
//
//	}
//}
