package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext contex) throws Exception {

		long millis = System.currentTimeMillis();

		Object o = contex.proceed();
		
	    System.out.println("Tempo gasto: " + (System.currentTimeMillis() - millis));

		String nomeClasse = contex.getTarget().getClass().getSimpleName();
		String nomeMetodo = contex.getMethod().getName();

		System.out.println("[INFO] " + nomeClasse + "->" + nomeMetodo);

		return o;

	}

}
