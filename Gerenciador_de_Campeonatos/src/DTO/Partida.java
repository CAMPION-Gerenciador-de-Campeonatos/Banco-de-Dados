package DTO;

import java.util.Date;

public class Partida {
	
	private int id;
	private String local_cidade;
	private Date data_hora;
	private int placar_time1;
	private int placar_time2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocal_cidade() {
		return local_cidade;
	}
	public void setLocal_cidade(String local_cidade) {
		this.local_cidade = local_cidade;
	}
	public Date getData_hora() {
		return data_hora;
	}
	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}
	public int getPlacar_time1() {
		return placar_time1;
	}
	public void setPlacar_time1(int placar_time1) {
		this.placar_time1 = placar_time1;
	}
	public int getPlacar_time2() {
		return placar_time2;
	}
	public void setPlacar_time2(int placar_time2) {
		this.placar_time2 = placar_time2;
	}
}
