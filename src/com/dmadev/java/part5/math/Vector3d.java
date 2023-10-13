package com.dmadev.java.part5.math;

public class Vector3d {
    public double x;
    public double y;
    public double z;
    
    public Vector3d() {
        this(0.0);
    }
    
    public Vector3d(double val) {
        this(val, val, val);
    }
    
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3d mul(Vector3d other) {
        return new Vector3d(x * other.x, y * other.y, z * other.z);
    }
    public Vector3d smul(Vector3d other) {
        this.x *= other.x;
        this.y *= other.y;
        this.z *= other.z;
        return this;
    }
    
    public Vector3d mul(double val) {
        return new Vector3d(x * val, y * val, z * val);
    }
    public Vector3d smul(double val) {
        this.x *= val;
        this.y *= val;
        this.z *= val;
        return this;
    }
    
    public Vector3d div(double val) {
        return mul(1.0 / val);
    }
    public Vector3d sdiv(double val) {
        return smul(1.0 / val);
    }
    
    public Vector3d add(Vector3d other) {
        return new Vector3d(x + other.x, y + other.y, z + other.z);
    }
    public Vector3d sadd(Vector3d other) {
        x += other.x;
        y += other.y;
        z += other.z;
        return this;
    }
    public Vector3d sub(Vector3d other) {
        return new Vector3d(x - other.x, y - other.y, z - other.z);
    }
    public Vector3d ssub(Vector3d other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
        return this;
    }
    
    public Vector3d neg() {
        return new Vector3d(-x, -y, -z);
    }
    public Vector3d sneg() {
        x = -x;
        y = -y;
        z = -z;
        return this;
    }
    
    public double dot(Vector3d other) {
        return x * other.x + y * other.y + z * other.z;
    }
    public double length() {
        return Math.sqrt(dot(this));
    }
    
    @Override
    public String toString()
    {
        return String.format("(%e, %e, %e)", x, y, z);
    }
}
