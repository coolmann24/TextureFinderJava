package main;

import java.util.ArrayList;
import java.util.Random;

public class TextureFinder
{
	private static Random rand = new Random();
	
	 public static long getCoordinateRandom(int x, int y, int z)
	    {
	        long i = (long)(x * 3129871) ^ (long)z * 116129781L ^ (long)y;
	        i = i * i * 42317861L + i * 11L;
	        return i;
	    }
	 public static int getTextureType(int x, int y, int z, int version/*version selection, 3 == 1.13, 1.14, 2 == 1.12 and before*/)
	    {
		 	if(version==2)
		 		return Math.abs((int)getCoordinateRandom(x, y, z) >> 16)%16;
		 	else
		 	{
		 		rand.setSeed(getCoordinateRandom(x, y, z)>>16);
		 		return (int)(Math.abs((int)((int)rand.nextLong())) % 16);
		 	}
	    }
	 
	 public static boolean compatibleRotation(int generatedType, BlockFace bface)
	 {
		 if(generatedType == 0)
		 {
			 return bface.getRotation()==3;
		 }
		 if(generatedType == 1)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.TOP||bface.getSide()==Side.SOUTH))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.BOTTOM||bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.EAST));
		 }
		 if(generatedType == 2)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM))||
					 (bface.getRotation()==1 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM));
		 }
		 if(generatedType == 3)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.BOTTOM||bface.getSide()==Side.SOUTH))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.TOP||bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.WEST));
		 }
		 if(generatedType == 4)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.BOTTOM))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.TOP));
		 }
		 if(generatedType == 5)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM||bface.getSide()==Side.SOUTH));
		 }
		 if(generatedType == 6)
		 {
			 return (bface.getRotation()==1 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.BOTTOM))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.TOP));
		 }
		 if(generatedType == 7)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.SOUTH||bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.NORTH));
		 }
		 if(generatedType == 8)
		 {
			 return (bface.getRotation()==1 && (bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM))||
					 (bface.getRotation()==3 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM));
		 }
		 if(generatedType == 9)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.BOTTOM||bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.TOP||bface.getSide()==Side.SOUTH))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.WEST));
		 }
		 if(generatedType == 10)
		 {
			 return bface.getRotation()==1;
		 }
		 if(generatedType == 11)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.TOP||bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.BOTTOM||bface.getSide()==Side.SOUTH))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.EAST));
		 }
		 if(generatedType == 12)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.TOP))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.BOTTOM));
		 }
		 if(generatedType == 13)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM||bface.getSide()==Side.SOUTH))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.NORTH));
		 }
		 if(generatedType == 14)
		 {
			 return (bface.getRotation()==1 && (bface.getSide()!=Side.TOP&&bface.getSide()!=Side.BOTTOM))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.TOP))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.BOTTOM));
		 }
		 if(generatedType == 15)
		 {
			 return (bface.getRotation()==3 && (bface.getSide()==Side.EAST))||
					 (bface.getRotation()==2 && (bface.getSide()==Side.NORTH))||
					 (bface.getRotation()==1 && (bface.getSide()==Side.WEST))||
					 (bface.getRotation()==0 && (bface.getSide()==Side.SOUTH||bface.getSide()==Side.TOP||bface.getSide()==Side.BOTTOM));
		 }
		 return false;
	 }
	 
	 public static void main(String[] args)
	 {
		 ArrayList<BlockFace> formation = new ArrayList<BlockFace>();
		 
		 /*
		  * BUILD FORMATION
		  */
		 formation.add(new BlockFace(0, 0, 0, Side.SOUTH, 3));
		 formation.add(new BlockFace(1, 0, 0, Side.SOUTH, 1));
		 formation.add(new BlockFace(2, 0, 0, Side.SOUTH, 1));
		 
		 formation.add(new BlockFace(0, 1, 0, Side.SOUTH, 3));
		 formation.add(new BlockFace(1, 1, 0, Side.SOUTH, 3));
		 formation.add(new BlockFace(2, 1, 0, Side.SOUTH, 3));
		 
		 formation.add(new BlockFace(0, 2, 0, Side.SOUTH, 0));
		 formation.add(new BlockFace(1, 2, 0, Side.SOUTH, 3));
		 formation.add(new BlockFace(2, 2, 0, Side.SOUTH, 3));
		 
		 formation.add(new BlockFace(0, 3, 0, Side.SOUTH, 1));
		 formation.add(new BlockFace(1, 3, 0, Side.SOUTH, 3));
		 formation.add(new BlockFace(2, 3, 0, Side.SOUTH, 3));
		 
		 formation.add(new BlockFace(0, 4, 0, Side.SOUTH, 1));
		 formation.add(new BlockFace(1, 4, 0, Side.SOUTH, 2));
		 formation.add(new BlockFace(2, 4, 0, Side.SOUTH, 3));
		 
		 
		 
		 long first=System.currentTimeMillis();
		 
		 int xmin=-10000, xmax=10000;
		 int zmin=-10000, zmax=10000;
		 int ymin=56, ymax=56;
		 
		 for(int x = xmin; x <= xmax; x++)
			for(int z = zmin; z <= zmax; z++)
				 for(int y = ymin; y <= ymax; y++)
				 {
					 boolean found=true;
					 for(BlockFace b : formation)
					 {
						 
						 int texture = TextureFinder.getTextureType(x + b.getX(), y+b.getY(), z+b.getZ(), 3/*version selection, 3 == 1.13, 1.14, 2 == 1.12 and before*/);
						 
						 if(!compatibleRotation(texture, b))
						 {
							 found=false;
							 break;
						 }
					 }
					 if(found) System.out.println("X: "+x+ " Y: "+y+ " Z: "+z);
					 
				 }
		 
		
		 System.out.println(((System.currentTimeMillis()-first)/1000) + " seconds");
	 }
}
