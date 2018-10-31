import java.awt.Color;
    

    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.ArrayList;



public class Image {
	private static  int height=0;
	private static  int width=0;
	public byte[] data;

	private static ArrayList pic;
	private static String matrix="";
	
	private static Color color;
	private final static String fileName="Assignment1.ppm";
	
	
	/*public static void main(String[] args) throws IOException {
		
		image(200,200);
	    writeImage(fileName);	
	
		
	}*/
	
	public Image(int height, int width) {
		
		this.height = height;
		this.width = width;
		this.data = new byte [height*width*3];
		
	}
	
	public static void Image(int width, int height){
		pic=new ArrayList();
		byte [] image=new byte[3];
		matrix +="P3\n" + width + "\n" + height + "\n255\n";
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				 setPixels(width,height,j,i);
				
				if(color==Color.red) {
					image[0]=(byte)(255*factor(width,height,j,i));
					image[1]=0;
					image[2]=0;		
				}else if (color==Color.green) {
					image[0]=0;
					image[1]=(byte)(255*factor(width,height,j,i));
					image[2]=0;	
				}else if (color==Color.blue) {
					image[0]=0;
					image[1]=0;
					image[2]=(byte)(255*factor(width,height,j,i));
					
				}
				matrix += ""+ image[0] + " " + image[1] + " " + image[2] + "  " ;
				
				
			}
			matrix += "\n";
		}
		
		
		
	}
	
	public static void setPixels(int width,int height, int a,int b ) {
			
		double d1 = ((double) width / height) * a;
        double d2 = (((double) -width / height) * a + height);
        if(d1 > b && d2 > b) 
        	{
        	color= Color.green;
        	}
        else if(d1 > b && d2 < b)
        {
        	color= Color.blue;
        	}
        else {
       
        color= Color.red;
        }
	}
	
	
	public static double  factor(int width, int height, int a, int b){
        double factorX = (double) Math.min(a, width - a) / width * 2;
        double factorY = (double) Math.min(b, height - b) / height * 2;

       
        return Math.min(factorX, factorY);
    }
	
	public static void write( String fn) throws FileNotFoundException, IOException{
		FileOutputStream fos = new FileOutputStream(fn);
        fos.write(new String(matrix).getBytes());
        
        fos.close();
	}
	


	
	

}
