import java.io.FileOutputStream;
import java.io.IOException;

public class Image
{
	// byte array to hold the raw image data

	public static int width;
	public static int height;
	public static byte  [] data;
	static int index;
	static String hexVal = "0x";

//constructor to create image object with specified height and width	
	public Image(int width, int height) {
		Image.width = width;
		Image.height = height;
		data = new byte[3*height*width];
			
	}
//sets method to set the rgb values to single pixel
public static void set(int x, int y, int val) {
		String st = hexVal + Integer.toHexString(val) ;
		System.out.println(st);
		//3 bytes per pixel throughout the width
		index = (y*width+x)*3;
		int count=0; 
		int sub1=2; 
		int sub2=4;
		//setting up the pixel position
				while (count <= 2 )
				 {
					String substr = st.substring(sub1, sub2);
					data [index + count] = (byte) Integer.parseInt(substr, 16);			//https://www.javamex.com/tutorials/conversion/decimal_hexadecimal.shtml
					count++;
					sub1 = sub2;
					sub2 +=2;
				}
	
}
//writes image data into file
// throws IOException for handling file writing errors
public void write(String filename) throws IOException {
	
	FileOutputStream out = new FileOutputStream(filename);
	//writes header file for the image with specified height and width
	byte[] header = ("P3\n" + width + "\n" + height + "\n255\n").getBytes();
	out.write(header);
	//Writes throughout the image for pixel value
	for(int i=0; i<data.length; i++)
			{
				out.write(data[i]);
			}
	out.close();
}
}
