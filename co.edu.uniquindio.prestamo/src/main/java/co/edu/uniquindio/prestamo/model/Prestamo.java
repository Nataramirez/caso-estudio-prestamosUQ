package co.edu.uniquindio.prestamo.model;

public class Prestamo
{
    private int numeroPrestamo;
    private String fechaPrestamo;
    private String fechaEntrega;
    private String descripcion;
    PrestamoUq ownedByPrestamoUq;

    public Prestamo() { }

    public Prestamo(int numeroPrestamo, String fechaPrestamo, String fechaEntrega, String descripcion) {
        this.numeroPrestamo = numeroPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.descripcion = descripcion;
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    public int getNumeroPrestamo() { return numeroPrestamo; }
    public void setNumeroPrestamo(int numeroPrestamo) { this.numeroPrestamo = numeroPrestamo; }
    public String getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(String fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }
    public String getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(String fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public PrestamoUq getOwnedByPrestamoUq() { return ownedByPrestamoUq; }
    public void setOwnedByPrestamoUq(PrestamoUq ownedByPrestamoUq) { this.ownedByPrestamoUq = ownedByPrestamoUq; }
    public String toString() {
        return "Prestamo{" +
                "numero prestamo='" + numeroPrestamo + '\'' +
                ", fecha prestamo='" + fechaPrestamo + '\'' +
                ", fecha entrega='" + fechaEntrega + '\'' +
                ", descripcion=" + descripcion +
                '}';
    }
}
