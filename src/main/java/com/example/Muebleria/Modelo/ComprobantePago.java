package com.example.Muebleria.Modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comprobante_pago")
@Data
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @Column(name = "fecha_pago", nullable = false)
    private Date fechaPago;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", nullable = false)
    private MetodoPago metodoPago;

    @Column(name = "estado_pago", nullable = false)
    private Boolean estadoPago;

    @OneToMany(mappedBy = "comprobantePago", cascade = CascadeType.ALL)
    private List<DetalleComprobantePago> detallesCompra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public List<DetalleComprobantePago> getDetallesCompra() {
        return detallesCompra;
    }

    public void setDetallesCompra(List<DetalleComprobantePago> detallesCompra) {
        this.detallesCompra = detallesCompra;
    }
}
