package br.com.dissemine.desafio.bonus;

public class Professor extends Funcionario {
	private int horasAula;

	@Override
	public double calcularBonus() {
		double bonusHoras = horasAula * 10;
		return super.calcularBonus() + bonusHoras;
	}
	
	public int getHorasAula() {
		return horasAula;
	}

	public void setHorasAula(int horasAula) {
		this.horasAula = horasAula;
	}
}
