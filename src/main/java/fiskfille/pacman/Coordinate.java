package fiskfille.pacman;

import java.io.*;
import java.util.regex.*;

public class Coordinate implements Serializable, Comparable<Coordinate>
{
    private int x;
    private int y;
    private int z;
    private long val;
    String stringRep;
    
    public Coordinate(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.val = x * 89 + y * 47 + z * 97;
    }
    
    public Coordinate() {
    }
    
    @Override
    public int compareTo(final Coordinate coord) {
        return Long.compare(this.val, coord.val);
    }
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
        out.writeUTF(this.toString());
    }
    
    private void readObject(final ObjectInputStream in) throws IOException, ClassCastException {
        fromString(in.readUTF());
    }
    
    private void readObjectNoData() {
    }
    
    @Override
    public String toString() {
        if (this.stringRep == null) {
            this.stringRep = this.x + ":" + this.y + ":" + this.z;
        }
        return this.stringRep;
    }
    
    public static Coordinate fromString(final String string) {
        final String[] str = string.split(Pattern.quote(":"));
        return new Coordinate(Integer.getInteger(str[0]), Integer.getInteger(str[1]), Integer.getInteger(str[2]));
    }
    
    public int distanceToChunk(int chunkX, int chunkZ) {
        chunkX *= 16;
        chunkZ *= 16;
        return (int)Math.floor(Math.abs(this.x - chunkX) + Math.abs(this.z - chunkZ));
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Coordinate && this.equals((Coordinate)obj);
    }
    
    @Override
    public int hashCode() {
        int hash = 41;
        hash = 83 * hash + this.x;
        hash = 151 * hash + this.y;
        hash = 257 * hash + this.z;
        return hash;
    }
    
    public boolean equals(final Coordinate obj) {
        return this.x == obj.getX() && this.y == obj.getY() && this.z == obj.getZ();
    }
}
