package com.dam.prova_u1_vcs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dam.prova_u1_vcs.model.FootballPlayer;
import com.dam.prova_u1_vcs.model.Seleccion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;

@SpringBootApplication
public class ProvaU1VcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaU1VcsApplication.class, args);

		System.out.println("Ejecuntando p1");

		GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls().setPrettyPrinting();
		
		Gson gson = gsonBuilder.create();
		
		/**Enunciado 1: dado el fichero "seleccion_array.json" imprimir todos los jugadores con toda la información */

		/**Enunciado 2: dado el fichero "seleccion_class.json" imprimir todos los jugadores con toda la información, 
		 * utilizando las clases oportunas */
		
		/**Enunciado 3: dado el fichero "seleccion_class.json" imprimir todos los jugadores con toda la información,
		 * utilizando el objeto genérico de jsonElement,JsonObject, JsonArray,... de la librería GSON
		 */
		
		 /**Enunciado 4: dado el fichero "seleccion_class.json"  crear una función "altaNouJugador" que lo añada a la lista actual
		  * y lo guarde en un fichero "seleccion_con_nuevo_jugador.json"
		 */

		 /**Para todos estos ejercicios es obligatorio colocar los ficheros json en la ruta "resources" de vuestro proyecto */
		solArrayEj1(gson);

		solClassEj1(gson);

		solObjectGenericEj1();

		List<String> demarcation = Stream.of("one", "two", "three").collect(Collectors.toList());
		FootballPlayer forAdd = new FootballPlayer();
				  forAdd = new FootballPlayer(33,"Gundogan",demarcation,"FC Barcelona");
		solClassEj2(gson,forAdd);
		
	}

	private static void solArrayEj1(Gson gson) {
			try {
				FootballPlayer[] footballPlayers = gson.fromJson(new FileReader("C:\\Users\\vsamp\\Desktop\\QuadernDAM\\ruta_prova_u1\\seleccion_array.json"),
		                FootballPlayer[].class);
		        for (FootballPlayer footballPlayer : footballPlayers) {
		            System.out.println(footballPlayer);
		        }
			} catch (JsonSyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonIOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void solClassEj1(Gson gson) {

			try {
				
				//Gson gson = new Gson();
		        Seleccion seleccion = gson.fromJson(new FileReader("C:\\Users\\vsamp\\Desktop\\QuadernDAM\\ruta_prova_u1\\seleccion_class.json"),
		                Seleccion.class);

				FootballPlayer[] footballPlayers = seleccion.getListaJugadores();	
					System.out.println("******************");
					System.out.println("solClassEj1");
					System.out.println("******************");
		        for (FootballPlayer footballPlayer : footballPlayers) {
		            System.out.println(footballPlayer);
		        }
			}catch (JsonSyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (JsonIOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void saveInfoToFileResult(String resConNuevoHotel,String pathResult) {
		try{    
			FileWriter fw=new FileWriter(pathResult);    
			fw.write(resConNuevoHotel);    
			fw.close();    
		}catch(IOException ioe){System.out.println(ioe);    
		}catch(Exception e){System.out.println(e);}    
		   System.out.println("Success...");
	}

	private static void solObjectGenericEj1() {
		System.out.println("Ejecuntando p1");
		try {
			JsonParser parser = new JsonParser();
			JsonElement jElementSelecion = parser.parse(new FileReader("C:\\\\Users\\\\vsamp\\\\Desktop\\\\QuadernDAM\\\\ruta_prova_u1\\\\seleccion_class.json"));
			
			JsonObject jObjectSelecion = jElementSelecion.getAsJsonObject();

				for (JsonElement obj : jObjectSelecion.getAsJsonArray("listaJugadores")){
					try{
					JsonObject gsonObj = obj.getAsJsonObject();
			
					String name = gsonObj.get("name").getAsString();
					int dorsal = gsonObj.get("dorsal").getAsInt();
					JsonArray demarcacion= gsonObj.get("demarcation").getAsJsonArray();
						
					System.out.println(" name "+name+" dorsal "+dorsal+" dem"+demarcacion);
					} catch (JsonSyntaxException e) {
						e.printStackTrace();
					} catch (JsonIOException e) {
						e.printStackTrace();
					} catch (Exception e){
						e.printStackTrace();
					}

				}

				System.out.println("Fin p1");

			} catch (JsonSyntaxException e) {
				e.printStackTrace();
			} catch (JsonIOException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
	}

	private static void solClassEj2(Gson gson,FootballPlayer newFootballPlayer) {
		try {	
			String resAddNew= null;
			resAddNew = altaNouJugador(gson, newFootballPlayer); 
			saveInfoToFileResult(resAddNew,"C:\\Users\\vsamp\\Desktop\\QuadernDAM\\ruta_prova_u1\\selecion_nuevo_jugador.json");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static String altaNouJugador(Gson gson, FootballPlayer newFootballPlayer) {
		String resAddHotel = null;
		Seleccion objectCompany = null;
		try {
			
			Selecccion objectCompany = gson.fromJson(new FileReader("C:\\Users\\vsamp\\Desktop\\QuadernDAM\\ruta_prova_u1\\seleccion_class.json"), Seleccion.class);
			FootballPlayer[] jugadores = objectCompany.getListaJugadores();
			FootballPlayer[] jugadoresResultadoFinal = appendFootballPlayer(newFootballPlayer, jugadores);
			objectCompany.setListaJugadores(jugadoresResultadoFinal);
			resAddHotel =gson.toJson(objectCompany);	
			
		} catch (JsonSyntaxException eJSyntax) {
			System.err.println(eJSyntax+"\n"+"Error eJSyntax at altaNouHotel ");
		} catch (JsonIOException eJIO) {
			System.err.println(eJIO+"\n"+"Error eJIO at altaNouHotel ");
		} catch (FileNotFoundException eFileNotFoundException) {
			System.err.println(eFileNotFoundException+"\n"+"Error eFileNotFoundException");
		} catch (Exception e) {
			System.err.println(e+"\n"+"Error e at altaNouHotel ");
		}
		return resAddHotel;
	}


	private static FootballPlayer[] appendFootballPlayer(FootballPlayer newFootballPlayer, FootballPlayer[] lisFootballPlayers) {
		FootballPlayer[] footballPlayersResArray= null;
		try {
			ArrayList<FootballPlayer> footballPlayersRes = new ArrayList<FootballPlayer>(Arrays.asList(lisFootballPlayers));
	
			int dorsalPosibleNuevo = newFootballPlayer.getDorsal();
			boolean yaExiste = false;
			for (FootballPlayer footballPlayerActual : footballPlayersRes) {
				int dorsalYaExiste = footballPlayerActual.getDorsal();
				if (dorsalYaExiste ==dorsalPosibleNuevo) {
					yaExiste = true;
					break;
				}				
			}	
			if(!yaExiste) {
				footballPlayersRes.add(newFootballPlayer);
			}

		footballPlayersResArray =  new FootballPlayer[footballPlayersRes.size()];
		footballPlayersResArray = footballPlayersRes.toArray(footballPlayersResArray);
	} catch (Exception e) {
		System.err.println(e+"\n"+"Error at appendHotel ");
		// TODO: handle exception
	}
		return footballPlayersResArray;
	}
}
