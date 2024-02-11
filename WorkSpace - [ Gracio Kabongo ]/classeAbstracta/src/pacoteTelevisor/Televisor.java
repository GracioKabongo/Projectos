package pacoteTelevisor;
import java.util.*;

import pacoteElectrodomestico.Electrodomestico;
public final class Televisor extends Electrodomestico{
	private double referencia;
	private int canal;
	private double volume;
	
	public Televisor(String marca, boolean estaLigado, Double referencia, int canal, Double volume) {
		super(marca, estaLigado);
		this.referencia = referencia;
		this.canal = canal;
		this.volume = volume;
	}
	public double getReferencia() {
		return referencia;
	}
	public void setReferencia(double referencia) {
		this.referencia = referencia;
	}
	public int getCanal() {
		return canal;
	}
	public void setCanal(int canal) {
		this.canal = canal;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	/*public void ligar () {
		Set EstaLigado(true);
		set.volume(20);
		set.canal(12);
	}
	public void desligar() {
		set.canal(0);
		set.volume(0);
		Set EstaLigado(false);
	}*/
}
