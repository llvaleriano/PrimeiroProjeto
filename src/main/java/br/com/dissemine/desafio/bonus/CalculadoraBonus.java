package br.com.dissemine.desafio.bonus;

public class CalculadoraBonus {
	
	public static void main(String[] args) {
		
		Professor prof1 = new Professor();
		prof1.setNome("Leonardo");
		prof1.setCpf("11111111111");
		prof1.setMatricula("123456");
		prof1.setHorasAula(250);		
		prof1.setSalario(5000);

		Funcionario func1 = new Funcionario();
		func1.setNome("Maria");
		func1.setCpf("11111111112");
		func1.setMatricula("234567");
		func1.setSalario(2500);
		
		System.out.println("Bonus do funcionario " + prof1.getNome() + " = " + prof1.calcularBonus());
		System.out.println("Bonus do funcionario " + func1.getNome() + " = " + func1.calcularBonus());
	}
}
