package com.example.Muebleria.Controlador;

import com.example.Muebleria.Modelo.ComprobantePago;
import com.example.Muebleria.Servicio.ComprobantePagoServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comprobantepago")
public class ComprobantePagoControlador {
    @Autowired
    private ComprobantePagoServi comprobantePagoService;

    @PostMapping("/generar/{idVenta}")
    public ResponseEntity<ComprobantePago> generarComprobante(@PathVariable Integer idVenta) {
        ComprobantePago comprobante = comprobantePagoService.generarComprobantePorVenta(idVenta);
        return ResponseEntity.ok(comprobante);
    }

}
