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
		 
		 ArrayList<ArrayList<BlockFace>> rotations = new ArrayList<ArrayList<BlockFace>>();
		 
		 /*
		  * BUILD FORMATION
		  * ---------------
		  * EXAMPLE BELOW
		  */
		 formation.add(new BlockFace(0, 0, 0, Side.BOTTOM, 3));
		 formation.add(new BlockFace(1, 0, 0, Side.BOTTOM, 1));
		 formation.add(new BlockFace(2, 0, 0, Side.BOTTOM, 3));
		 
		 formation.add(new BlockFace(0, 0, 1, Side.BOTTOM, 1));
		 formation.add(new BlockFace(1, 0, 1, Side.BOTTOM, 3));
		 formation.add(new BlockFace(2, 0, 1, Side.BOTTOM, 0));
		 
		 formation.add(new BlockFace(0, 0, 2, Side.BOTTOM, 0));
		 formation.add(new BlockFace(1, 0, 2, Side.BOTTOM, 1));
		 formation.add(new BlockFace(2, 0, 2, Side.BOTTOM, 3));
		 
		 formation.add(new BlockFace(0, 0, 3, Side.BOTTOM, 2));
		 formation.add(new BlockFace(1, 0, 3, Side.BOTTOM, 1));
		 formation.add(new BlockFace(2, 0, 3, Side.BOTTOM, 3));
		 
		 formation.add(new BlockFace(0, 0, 4, Side.BOTTOM, 3));
		 formation.add(new BlockFace(1, 0, 4, Side.BOTTOM, 2));
		 formation.add(new BlockFace(2, 0, 4, Side.BOTTOM, 3));
		 
		 
		 boolean useAllRotations = true;//set this to true if you don't know which direction is north
		 
		 rotations.add(formation);
		 
		 if(useAllRotations)
		 {
			 for(int i = 0; i < 3; i++)
			 {
				 rotations.add(rotate90deg(rotations.get(rotations.size()-1)));
			 }
		 }
		 
		 /*for(ArrayList<BlockFace> f : rotations)
		 {
			 for(BlockFace b : f)
			 {
				 System.out.println(b.getX() + " " + b.getY() + " " + b.getZ() + " " + b.getSide().toString() + " " + b.getRotation());
			 }
			 System.out.println();
		 }*/
		 
		 
		 
		 long first=System.currentTimeMillis();
		 
		 /*
		  * SEARCH PARAMETERS
		  * MODIFY THESE
		  */
		 
		 int xmin=-10000, xmax=10000;
		 int zmin=-10000, zmax=10000;
		 int ymin=59, ymax=59;
		 
		 for(int x = xmin; x <= xmax; x++)
			for(int z = zmin; z <= zmax; z++)
				 for(int y = ymin; y <= ymax; y++)
				 {
					 for(ArrayList<BlockFace> f : rotations)
					 {
					 
						 boolean found=true;
						 for(BlockFace b : f)
						 {
						 
							 int texture = getTextureType(x + b.getX(), y+b.getY(), z+b.getZ(), 3/*version selection, 3 == 1.13, 1.14, 2 == 1.12 and before*/);
						 
									 if(!compatibleRotation(texture, b))
									 {
										 found=false;
										 break;
									 }
						 }
						 if(found) System.out.println("X: "+x+ " Y: "+y+ " Z: "+z);
					
					 }
				 }
		 
		
		 System.out.println(((System.currentTimeMillis()-first)/1000) + " seconds");
	 }
	 
	 public static ArrayList<BlockFace> rotate90deg(ArrayList<BlockFace> formation)
	 {
		 ArrayList<BlockFace> result = new ArrayList<BlockFace>();
		 
		 for(BlockFace b : formation)
		 {
			 Side newside = Side.NORTH;
			 int rotation = -1;
			 
			if (b.getSide() == Side.TOP) newside = Side.TOP;
			if (b.getSide() == Side.BOTTOM) newside = Side.BOTTOM;
			if (b.getSide() == Side.WEST) newside = Side.SOUTH;
			if (b.getSide() == Side.EAST) newside = Side.NORTH;
			if (b.getSide() == Side.SOUTH) newside = Side.EAST;
			if (b.getSide() == Side.NORTH) newside = Side.WEST;
			
			if(b.getSide() == Side.TOP)
			{
				rotation = (b.getRotation()+3)%4;
			}
			else if(b.getSide() == Side.BOTTOM)
			{
				rotation = (b.getRotation()+1)%4;
			}
			else
			{
				rotation = b.getRotation();
			}
			 
			 result.add(new BlockFace(b.getZ(), b.getY(), -1*b.getX(), newside, rotation));
		 }
		 
		 return result;
	 }
}
