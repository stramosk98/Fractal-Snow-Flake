package mat;

	import java.util.Scanner;
	import java.awt.*;

	import javax.swing.*;

	public class fractal extends JFrame 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Scanner entrada = new Scanner(System.in);
		
	    public fractal()
	    {
	    	
	        super("Floco de neve de Koch (fractal recursivo)");
	        setSize(640, 480);
	        setVisible(true);
	    }

	    public void paint(Graphics g)
	    {
	    	  // qu�o fundo a recurs�o procede

	        // esse � um tri�ngulo, que serve de base para o fractal
	        String path = "F--F--F--";
	        // cada aresta do tri�ngulo ser� substituida pelo c�digo que desenha outro tri�ngulo
	        String replacementRule = "F+F--F+F";
	        // �ngulo de rota��o da "pena"; 60 graus
	        double turnAngle = Math.PI / 3;
	      

	        // coordenadas iniciais da "pena"
	        double start_x = 200;
	        double start_y = 200;
	        // rota��o inicial da "pena"
	        double direction = 0;
	        // quantos pixels a "pena" anda
	        double stepLength = 10;

	        // vari�veis internas
	        int r;
	        int i;
	        String sub;

	        // primeiro, cria um "script" com comandos para a "pena"
	        for (r = 1; r <= 3; r++)		// Quantidade de recurs�es
	        {
	            String newPath = "";
	            for (i = 0; i < path.length(); i++)
	            {
	                sub = path.substring(i, i + 1);

	                // conforme descrito acima, cada "F" ser� uma "subrotina"
	                if (sub.equals("F"))
	                    newPath = newPath + replacementRule;
	                else 
	                    newPath = newPath + sub; 
	            }
	            path = newPath;
	        }

	        // inicializa a "pena"
	        super.paint(g);
	        g.setColor(Color.black);

	        // agora, interpreta o "script" e desenha o fractal com a "pena"
	        for (i = 0; i < path.length(); i++)
	        {
	            sub = path.substring(i, i + 1);

	            // desenha
	            if (sub.equals("F"))
	            {
	                double x = start_x + Math.cos(direction) * stepLength;
	                double y = start_y + Math.sin(direction) * stepLength;

	                g.drawLine((int) (start_x), (int) (start_y), (int) (x), (int) (y));

	                start_x = x;
	                start_y = y;
	            }
	            // vira no sentido anti-hor�rio
	            else if (sub.equals("-"))
	                direction += turnAngle;
	            // vira no sentido hor�rio
	            else if (sub.equals("+"))
	                direction -= turnAngle;
	        }
	    }

	    public static void main(String args[]) 
	    {
	        fractal application = new fractal();
	        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	   
	}

