/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

/**
 *
 * @author Bryan
 */
public class ValidacionPersonaNaturalesRUC {
	private  final int NUM_PROVINCIAS = 24;

	public  Boolean personaRUC(String RUC) {
		boolean isValid = false;
		if (RUC == null || RUC.length() != 10) {
			isValid = false;
		}
		final int prov = Integer.parseInt(RUC.substring(0, 2));

		if (!((prov > 0) && (prov <= NUM_PROVINCIAS))) {
			isValid = false;
		}

		int[] d = new int[10];
		for (int i = 0; i < d.length; i++) {
			d[i] = Integer.parseInt(RUC.charAt(i) + "");
		}

		int imp = 0;
		int par = 0;

		for (int i = 0; i < d.length; i += 2) { 			d[i] = ((d[i] * 2) > 9) ? ((d[i] * 2) - 9) : (d[i] * 2);
			imp += d[i];
		}

		for (int i = 1; i < (d.length - 1); i += 2) {
			par += d[i];
		}

		final int suma = imp + par;

		int d10 = Integer.parseInt(String.valueOf(suma + 10).substring(0, 1)
				+ "0")
				- suma;

		d10 = (d10 == 10) ? 0 : d10;

		if (d10 == d[9]) {
			isValid = true;
		} else {
			isValid = false;
		}

		return isValid;
	}
        
        
        //	personaNaturalRUC		

        public boolean personaNaturalRUC(String buscar)
        {
            boolean bandera = false;
            if((personaRUC(buscar.substring(0,10)))==true)
            {
                if(buscar.substring(10,13).equals("001")){
                    bandera = true;
                }
            }
            return bandera;
        }
        
        
        
        
        

}