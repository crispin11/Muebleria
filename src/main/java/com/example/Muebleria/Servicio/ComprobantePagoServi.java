package com.example.Muebleria.Servicio;
import com.example.Muebleria.Modelo.ComprobantePago;
import com.example.Muebleria.Modelo.DetalleComprobantePago;
import com.example.Muebleria.Modelo.DetalleVenta;
import com.example.Muebleria.Modelo.Venta;
import com.example.Muebleria.Repositorio.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ComprobantePagoServi {
    @Autowired
    private VentaRepo vrepo;
    @Autowired
    private ComprobantePagoRepo cprepo;
    @Autowired
    private DetalleVentaRepo dvrepo;
    @Autowired
    private DetalleComprobantePagoRepo dcprepo;

    @Transactional
    public ComprobantePago generarComprobantePorVenta(Integer idVenta) {

        Venta venta = vrepo.findById(idVenta)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        ComprobantePago comprobantePago = new ComprobantePago();
        comprobantePago.setVenta(venta);
        comprobantePago.setFechaPago(new Date());
        comprobantePago.setMonto(venta.getTotal());
        comprobantePago.setMetodoPago(venta.getMetodoPago());
        comprobantePago.setEstadoPago(true);

        comprobantePago = cprepo.save(comprobantePago);


        List<DetalleVenta> detallesVenta = dvrepo.findByVentaId(idVenta);
        for (DetalleVenta detalleVenta : detallesVenta) {
            DetalleComprobantePago detalleComprobante = new DetalleComprobantePago();
            detalleComprobante.setComprobantePago(comprobantePago);
            detalleComprobante.setProducto(detalleVenta.getProducto());
            detalleComprobante.setCantidad(detalleVenta.getCantidad());
            detalleComprobante.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            detalleComprobante.setSubtotal(detalleVenta.getSubtotal());
            dcprepo.save(detalleComprobante);
        }

        return comprobantePago;
    }

}
