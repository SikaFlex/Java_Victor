package com.danielme.blog.gson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hoteles {
    private String empresa;
    private int fundacion;
    private String ciudad_sede;
    private String pais_sede;
    private List<Hotel> hotel;


    public Hoteles (){

    }

    public Hoteles(String empresa, int fundacion, String ciudad_sede, String pais_sede,List<Hotel> hotel) {
        super();
        this.empresa = empresa;
        this.fundacion = fundacion;
        this.ciudad_sede = ciudad_sede;
        this.pais_sede = pais_sede;
        this.hotel = hotel;
    }

    

    public String getEmpresa() {
        return empresa;
    }

    public int getFundacion() {
        return fundacion;
    }

    public String getCiudad_sede() {
        return ciudad_sede;
    }

    public String getPais_sede() {
        return pais_sede;
    }

    public  List<Hotel> getHoteles() {
        return hotel;
    }
    

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

    public void setCiudad_sede(String ciudad_sede) {
        this.ciudad_sede = ciudad_sede;
    }

    public void setPais_sede(String pais_sede) {
        this.pais_sede = pais_sede;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hotel = hoteles;
    }
    private static Hotel[] appendFootballPlayer(Hotel newFootballPlayer, Hotel[] lisFootballPlayers) {
		Hotel[] footballPlayersResArray= null;
		try {
			ArrayList<Hotel> footballPlayersRes = new ArrayList<Hotel>(Arrays.asList(lisFootballPlayers));
	
			int dorsalPosibleNuevo = newFootballPlayer.getDorsal();
			boolean yaExiste = false;
			for (Hotel footballPlayerActual : footballPlayersRes) {
				int dorsalYaExiste = footballPlayerActual.getDorsal();
				if (dorsalYaExiste ==dorsalPosibleNuevo) {
					yaExiste = true;
					break;
				}				
			}	
			if(!yaExiste) {
				footballPlayersRes.add(newFootballPlayer);
			}

		footballPlayersResArray =  new Hotel[footballPlayersRes.size()];
		footballPlayersResArray = footballPlayersRes.toArray(footballPlayersResArray);
	} catch (Exception e) {
		System.err.println(e+"\n"+"Error at appendHotel ");
		// TODO: handle exception
	}
		return footballPlayersResArray;
	}
}

    @Override
    public String toString() {
        return "Hoteles{" +
                "empresa='" + empresa + '\'' +
                ", fundacion=" + fundacion +
                ", ciudad_sede='" + ciudad_sede + '\'' +
                ", pais_sede='" + pais_sede + '\'' +
                ", hoteles=" + hotel +
                '}';
    }
}
