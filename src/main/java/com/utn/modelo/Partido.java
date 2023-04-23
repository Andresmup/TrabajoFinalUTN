package com.utn.modelo;

public class Partido {
    private int id;
    
    private Seleccionado EquipoUno;
    private Seleccionado EquipoDos;
    private int GolesEquipoUno;
    private int GolesEquipoDos;
    private int Ronda;
    private int Fase;
    private String Ganador;   

	public Partido(int id, Seleccionado equipoUno, Seleccionado equipoDos, int golesEquipoUno, int golesEquipoDos,
			int ronda, int fase, String ganador) {
		this.id = id;
		EquipoUno = equipoUno;
		EquipoDos = equipoDos;
		GolesEquipoUno = golesEquipoUno;
		GolesEquipoDos = golesEquipoDos;
		Ronda = ronda;
		Fase = fase;
		Ganador = ganador;
	}



	public Seleccionado getEquipoUno() {
		return EquipoUno;
	}



	public void setEquipoUno(Seleccionado equipoUno) {
		EquipoUno = equipoUno;
	}



	public Seleccionado getEquipoDos() {
		return EquipoDos;
	}



	public void setEquipoDos(Seleccionado equipoDos) {
		EquipoDos = equipoDos;
	}



	public int getGolesEquipoUno() {
		return GolesEquipoUno;
	}


	public void setGolesEquipoUno(int golesEquipoUno) {
		GolesEquipoUno = golesEquipoUno;
	}



	public int getGolesEquipoDos() {
		return GolesEquipoDos;
	}



	public void setGolesEquipoDos(int golesEquipoDos) {
		GolesEquipoDos = golesEquipoDos;
	}



	public int getRonda() {
		return Ronda;
	}



	public void setRonda(int ronda) {
		Ronda = ronda;
	}



	public int getFase() {
		return Fase;
	}



	public void setFase(int fase) {
		Fase = fase;
	}



	public String getGanador() {
		return Ganador;
	}



	public void setGanador(String ganador) {
		Ganador = ganador;
	}



	public int getId() {
		return id;
	}
    
    
    
    
    
    /*		Seleccionado seleccionDePrueba = sc.listarSeleccionado("ARG");
		System.out.println(seleccionDePrueba.getDescripcion());*/
}
